package com.lkc1009.pixiv.business.main.photo.model;

import com.lkc1009.pixiv.business.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Accessors(fluent = true)
public class PhotoInfo extends BaseEntity {

    /**
     * 图片简析
     */
    private Long photoId;

    /**
     * 图片链接
     */
    private String url;

    /**
     * 缩略图
     */
    private String smallUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 宽
     */
    private Integer width;

    /**
     * 高
     */
    private Integer height;

    /**
     * 单位
     */
    private Long unitId;
}
