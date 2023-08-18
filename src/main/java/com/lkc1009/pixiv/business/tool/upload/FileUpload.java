package com.lkc1009.pixiv.business.tool.upload;

import cn.hutool.core.io.file.FileNameUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class FileUpload {
    public Boolean isAllowFile(String fileName) {
        return FileConstant.URL_LIST.contains(FileNameUtil.getSuffix(fileName).toLowerCase());
    }

    public void upload(HttpServletRequest request, MultipartFile file) {

        String webAppFolder = request.getServletContext().getRealPath("/");

        String fileName = file.getOriginalFilename();
        if (isAllowFile(fileName)) {

            String ext = Objects.requireNonNull(FileNameUtil.getSuffix(fileName)).toLowerCase();
            String newFileName = UUID.randomUUID().toString().replace("-", "");

            String targetPath = webAppFolder + "/" + FileConstant.UPLOAD_FOLDER;
            String targetFile = targetPath + "/" + newFileName + "." + ext;

            new File(targetPath).mkdirs();

            try {
                String urlPath = FileConstant.URL_SERVER + "/" + FileConstant.UPLOAD_FOLDER + "/" + newFileName + "." + ext;
                file.transferTo(new File(targetFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            log.error("文件类型不允许");
        }
    }
}
