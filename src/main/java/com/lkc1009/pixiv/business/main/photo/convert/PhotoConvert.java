package com.lkc1009.pixiv.business.main.photo.convert;

import com.lkc1009.pixiv.business.main.photo.dto.PhotoDto;
import com.lkc1009.pixiv.business.main.photo.model.Photo;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.*;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoConvert extends Converter<Photo, PhotoDto> {
    @Override
    @Mappings({
            @Mapping(target = "id", expression = "java(photo.id())"),
            @Mapping(target = "title", expression = "java(photo.title())")
    })
    PhotoDto convert(@NotNull Photo photo);

    List<PhotoDto> convert(@NotNull List<Photo> photoList);

    @BeforeMapping
    default void beforeConvert(Photo photo, @MappingTarget PhotoDto photoDto) {

    }

    @AfterMapping
    default void afterConvert(Photo photo, @MappingTarget PhotoDto photoDto) {

    }
}
