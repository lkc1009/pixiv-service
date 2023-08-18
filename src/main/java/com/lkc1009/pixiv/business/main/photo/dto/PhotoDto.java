package com.lkc1009.pixiv.business.main.photo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
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
@Schema(description =  "图片DTO")
public class PhotoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "图片ID")
    private Long id;
    @Schema(description = "图片标题")
    private String title;
}
