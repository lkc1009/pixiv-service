package com.lkc1009.pixiv.business.main.photo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.main.photo.dto.param.PhotoParam;
import com.lkc1009.pixiv.business.main.photo.mapper.PhotoMapper;
import com.lkc1009.pixiv.business.main.photo.model.Photo;
import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoMapper photoMapper;

    @Override
    public IPage<Photo> listPagePhoto(PhotoParam photoParam) {
        return null;
    }

    @Override
    public List<Photo> listPhoto(PhotoParam photoParam) {
        return null;
    }

    @Override
    public Integer addPhoto(Photo photo) {
        return null;
    }

    @Override
    public Integer deletePhoto(Photo photo) {
        return null;
    }

    @Override
    public Integer updatePhoto(Photo photo) {
        return null;
    }
}
