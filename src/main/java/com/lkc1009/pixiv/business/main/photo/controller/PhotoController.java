package com.lkc1009.pixiv.business.main.photo.controller;

import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("photo")
@AllArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
}
