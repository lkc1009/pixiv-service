package com.lkc1009.pixiv.business.main.photo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.base.BaseController;
import com.lkc1009.pixiv.business.main.photo.convert.PhotoConvert;
import com.lkc1009.pixiv.business.main.photo.dto.PhotoDto;
import com.lkc1009.pixiv.business.main.photo.dto.param.PhotoParam;
import com.lkc1009.pixiv.business.main.photo.model.Photo;
import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import com.lkc1009.pixiv.business.tool.convert.PageConvert;
import com.lkc1009.pixiv.business.tool.result.PageData;
import com.lkc1009.pixiv.business.tool.result.Result;
import com.lkc1009.pixiv.framework.validation.ValidGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/photo")
@AllArgsConstructor
public class PhotoController extends BaseController {
    private final PhotoService photoService;
    private final PageConvert<Photo, List<PhotoDto>> pageConvert;
    private final PhotoConvert photoConvert;

    @GetMapping("/list/photo")
    public Result<List<PhotoDto>> listPhoto(PhotoParam photoParam) {
        return Result.success(photoConvert.convert(photoService.listPhoto(photoParam)));
    }

    @GetMapping("/list/page/photo")
    public Result<PageData<List<PhotoDto>>> listPagePhoto(PhotoParam photoParam) {
        IPage<Photo> photoIPage = photoService.listPagePhoto(photoParam);
        return Result.success(pageConvert.convert(photoIPage)
                .setData(photoConvert.convert(photoIPage.getRecords())));
    }

    @PostMapping("/add/photo")
    public <T> Result <T> addPhoto(@Validated({ ValidGroup.Insert.class }) @RequestBody Photo photo) {
        return single(photoService.addPhoto(photo));
    }

    @DeleteMapping("/delete/photo/{id}")
    public <T> Result <T> deletePhoto(@PathVariable("id") @NotNull(message = "id is not null") Long id) {
        return single(photoService.deletePhoto(id));
    }

    @PutMapping("/update/photo")
    public <T> Result <T> updatePhoto(@Validated({ ValidGroup.Update.class }) @RequestBody Photo photo) {
        return single(photoService.updatePhoto(photo));
    }

}
