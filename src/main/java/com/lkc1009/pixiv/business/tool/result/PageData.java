package com.lkc1009.pixiv.business.tool.result;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class PageData<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer page;
    private Integer pageSize;
    private Integer total;
    private T data;
}
