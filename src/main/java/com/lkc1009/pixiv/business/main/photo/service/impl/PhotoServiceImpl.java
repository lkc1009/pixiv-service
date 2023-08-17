package com.lkc1009.pixiv.business.main.photo.service.impl;

import com.lkc1009.pixiv.business.main.photo.mapper.PhotoMapper;
import com.lkc1009.pixiv.business.main.photo.service.PhotoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoMapper photoMapper;
}
