package com.lkc1009.pixiv.business.main.photo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkc1009.pixiv.business.main.photo.dto.param.PhotoParam;
import com.lkc1009.pixiv.business.main.photo.mapper.PhotoMapper;
import com.lkc1009.pixiv.business.main.photo.model.Photo;
import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import com.lkc1009.pixiv.core.thread.page.PageThreadLocal;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoMapper photoMapper;

    @Override
    public IPage<Photo> listPagePhoto(@NotNull PhotoParam photoParam) {
        return photoMapper.selectPage(new Page<>(PageThreadLocal.getPage().getPage(),  PageThreadLocal.getPage().getPageSize()),
                new LambdaQueryWrapper<Photo>()
                        .like(StringUtils.isNotBlank(photoParam.getTitle()), Photo::getTitle, photoParam.getTitle())
                        .like(Objects.nonNull(photoParam.getUserId()), Photo::getUserId, photoParam.getUserId()));
    }

    @Override
    public List<Photo> listPhoto(@NotNull PhotoParam photoParam) {
        return photoMapper.selectList(new LambdaQueryWrapper<Photo>()
                .like(StringUtils.isNotBlank(photoParam.getTitle()), Photo::getTitle, photoParam.getTitle())
                .like(Objects.nonNull(photoParam.getUserId()), Photo::getUserId, photoParam.getUserId()));
    }

    @Override
    public Integer addPhoto(Photo photo) {
        return photoMapper.insert(photo);
    }

    @Override
    public Integer deletePhoto(Photo photo) {
        return photoMapper.deleteById(photo);
    }

    @Override
    public Integer updatePhoto(Photo photo) {
        return photoMapper.updateById(photo);
    }
}
