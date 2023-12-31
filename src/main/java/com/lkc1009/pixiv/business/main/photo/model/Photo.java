package com.lkc1009.pixiv.business.main.photo.model;

import com.lkc1009.pixiv.business.base.BaseEntity;
import com.lkc1009.pixiv.framework.validation.ValidGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(description = "图片实体")
public class Photo extends BaseEntity {
    /**
     * 图片标题
     */
    @Size(min = 3, max = 100, message = "标题长度必须介于 3 和 100 之间", groups = { ValidGroup.Insert.class, ValidGroup.Update.class })
    @Schema(description = "图片标题")
    private String title;

    /**
     * 图片标签
     */
    @Schema(description = "图片标签")
    private String tag;

    /**
     * 图片描述
     */
    @Schema(description = "图片描述")
    private String description;

    /**
     * 图片作者
     */

    @NotNull(message = "作者信息加载失败", groups = { ValidGroup.Insert.class, ValidGroup.Update.class })
    @Schema(description = "图片作者")
    private Long userId;
}
