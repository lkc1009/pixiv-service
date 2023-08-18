package com.lkc1009.pixiv.business.tool.upload;

import cn.hutool.core.io.file.FileNameUtil;

import java.util.List;

public class FileConstant {
    public static final String UPLOAD_FOLDER = "/upload/";
    public static final String URL_SERVER = "http://127.0.0.1:8080/";

    public static final List<String> URL_LIST = List.of(
            "jpg", "jpeg", "png", "gif", "bmp", "webp", "tiff",
            "zip", "rar", "7z", "tar", "gz",
            "wav", "mp3", "ogg", "flac", "aac", "wma", "ape", "mp4", "mkv", "avi", "rmvb", "flv",
            "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt", "md"
    );
}
