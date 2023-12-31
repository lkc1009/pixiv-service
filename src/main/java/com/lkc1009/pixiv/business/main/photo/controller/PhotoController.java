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
import com.lkc1009.pixiv.core.thread.page.Page;
import com.lkc1009.pixiv.framework.validation.ValidGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/photo")
@RequiredArgsConstructor
@Tag(name = "图片", description = "图片相关接口")
public class PhotoController {
    private final PhotoService photoService;
    private final PageConvert<Photo, List<PhotoDto>> pageConvert;
    private final PhotoConvert photoConvert;

    /**
     * 获取图片列表
     * @param photoParam 图片参数
     * @return 图片DTO
     */
    @GetMapping("/list/photo")
    @Operation(summary = "获取图片列表")
    public Result<List<PhotoDto>> listPhoto(PhotoParam photoParam) {
        return Result.success(photoConvert.convert(photoService.listPhoto(photoParam)));
    }

    @GetMapping("/list/page/photo")
    @Operation(summary = "获取图片分页列表")
    public Result<PageData<List<PhotoDto>>> listPagePhoto(PhotoParam photoParam, @Validated ({ ValidGroup.Select.class }) Page page) {
        IPage<Photo> photoIPage = photoService.listPagePhoto(photoParam);
        return Result.success(pageConvert.convert(photoIPage)
                .setData(photoConvert.convert(photoIPage.getRecords())));
    }

    @PostMapping("/add/photo")
    @Operation(summary = "添加图片")
    public <T> Result <T> addPhoto(@Validated({ ValidGroup.Insert.class }) @RequestBody Photo photo) {
        photoService.addPhoto(photo);
        return Result.success();
    }

    @DeleteMapping("/delete/photo/{id}")
    @Operation(summary = "删除图片")
    @Parameter(name = "id", description = "图片id", required = true)
    public <T> Result <T> deletePhoto(@PathVariable("id") @NotNull(message = "id is not null") Long id) {
        photoService.deletePhoto(id);
        return Result.success();
    }

    @PutMapping("/update/photo")
    @Operation(summary = "更新图片")
    public <T> Result <T> updatePhoto(@Validated({ ValidGroup.Update.class }) @RequestBody Photo photo) {
        photoService.updatePhoto(photo);
        return Result.success();
    }

}
