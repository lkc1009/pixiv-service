package com.lkc1009.pixiv.business.main.photo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.main.photo.dto.param.PhotoParam;
import com.lkc1009.pixiv.business.main.photo.model.Photo;

import java.util.List;

public interface PhotoService {
    IPage<Photo> listPagePhoto(PhotoParam photoParam);

    List<Photo> listPhoto(PhotoParam photoParam);

    Integer addPhoto(Photo photo);

    Integer deletePhoto(Long id);

    Integer updatePhoto(Photo photo);

}
