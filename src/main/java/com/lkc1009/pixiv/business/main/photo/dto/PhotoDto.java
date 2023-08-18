package com.lkc1009.pixiv.business.main.photo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Accessors(fluent = true)
public class PhotoDto implements Serializable {
    private Long id;
    private String title;
}
