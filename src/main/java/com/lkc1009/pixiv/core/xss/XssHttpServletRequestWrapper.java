package com.lkc1009.pixiv.core.xss;

import cn.hutool.http.HtmlUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.isBlank(value)) {
            return value;
        }

        return HtmlUtil.filter(value);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (StringUtils.isBlank(value)) {
            return value;
        }

        return HtmlUtil.filter(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (Objects.isNull(values)) {
            return null;
        }

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotBlank(values[i])) {
                values[i] = HtmlUtil.filter(values[i]);
            }
        }
        return values;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return servletInputStreamWithXSSFilter();
    }

    public ServletInputStream servletInputStreamWithXSSFilter()
        throws IOException {
        InputStream inputStream = super.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        String str = HtmlUtil.filter(stringBuilder.toString());
        str = str.replaceAll("&quot;", "\"");

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        return new ServletInputStream() {
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }
}
