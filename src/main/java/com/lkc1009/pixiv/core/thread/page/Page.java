package com.lkc1009.pixiv.core.thread.page;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Accessors(fluent = true)
public class Page implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer page;
    private Integer pageSize;

    public static final String PAGE_PARAM = "page";
    public static final String PAGE_SIZE_PARAM = "pageSize";
}
