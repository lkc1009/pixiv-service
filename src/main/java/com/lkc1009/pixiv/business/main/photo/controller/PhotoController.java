package com.lkc1009.pixiv.business.main.photo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.main.photo.convert.PhotoConvert;
import com.lkc1009.pixiv.business.main.photo.dto.PhotoDto;
import com.lkc1009.pixiv.business.main.photo.dto.param.PhotoParam;
import com.lkc1009.pixiv.business.main.photo.model.Photo;
import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import com.lkc1009.pixiv.business.tool.convert.PageConvert;
import com.lkc1009.pixiv.business.tool.result.PageData;
import com.lkc1009.pixiv.business.tool.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("photo")
@AllArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
    private final PageConvert<Photo, List<PhotoDto>> pageConvert;
    private final PhotoConvert photoConvert;

    @GetMapping("/listPhoto")
    public Result<List<PhotoDto>> listPhoto(PhotoParam photoParam) {
        return Result.success(photoConvert.convert(photoService.listPhoto(photoParam)));
    }

    @GetMapping("/listPagePhoto")
    public Result<PageData<List<PhotoDto>>> listPagePhoto(PhotoParam photoParam) {
        IPage<Photo> photoIPage = photoService.listPagePhoto(photoParam);
        return Result.success(pageConvert.convert(photoIPage)
                .data(photoConvert.convert(photoIPage.getRecords())));
    }
}
