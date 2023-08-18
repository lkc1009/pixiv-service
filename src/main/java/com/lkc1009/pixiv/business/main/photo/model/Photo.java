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
@Accessors(chain = true)
public class Photo extends BaseEntity {
    /**
     * 图片标题
     */
    private String title;

    /**
     * 图片标签
     */
    private String tag;

    /**
     * 图片描述
     */
    private String description;

    /**
     * 图片作者
     */
    private Long userId;
}
