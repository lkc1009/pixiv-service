package com.lkc1009.pixiv.business.tool.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.tool.result.PageData;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageConvert<S, T> {
    @Mappings({
            @Mapping(target = "page", expression = "java(iPage.getCurrent())"),
            @Mapping(target = "pageSize", expression = "java(iPage.getSize())"),
            @Mapping(target = "total", expression = "java(iPage.getTotal())"),
            @Mapping(target = "data", ignore = true)
    })
    PageData<T> convert(IPage<S> iPage);

    @BeforeMapping
    default void beforeConvert(IPage<S> iPage, @MappingTarget PageData<T> pageData) {

    }

    @AfterMapping
    default void afterConvert(IPage<S> iPage, @MappingTarget PageData<T> pageData) {

    }
}
