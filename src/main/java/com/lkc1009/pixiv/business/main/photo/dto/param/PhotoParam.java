package com.lkc1009.pixiv.business.main.photo.dto.param;

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
public class PhotoParam {
    private String title;
    private Long userId;
}
