package com.lkc1009.pixiv.business.main.photo.dto.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(description = "图片参数")
public class PhotoParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "图片标题")
    private String title;

    @Schema(description = "图片作者")
    private Long userId;
}
