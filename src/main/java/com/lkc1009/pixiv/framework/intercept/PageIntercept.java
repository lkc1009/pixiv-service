package com.lkc1009.pixiv.framework.intercept;

import com.lkc1009.pixiv.core.thread.page.Page;
import com.lkc1009.pixiv.core.thread.page.PageThreadLocal;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class PageIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String page = request.getParameter(Page.PAGE_PARAM);
        String pageSize = request.getParameter(Page.PAGE_SIZE_PARAM);
        if (StringUtils.isNotEmpty(page) &&  StringUtils.isNotEmpty(pageSize)) {
            try {
                PageThreadLocal.setPage(Page.builder()
                        .page(Integer.parseInt(page))
                        .pageSize(Integer.parseInt(pageSize))
                        .build());
            } catch (NumberFormatException e) {
                log.info("page or pageSize is not number");
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        PageThreadLocal.removePage();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
