package com.lkc1009.pixiv.business.tool.result;

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
@Schema(description = "分页数据")
public class PageData<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "页码")
    private Integer page;
    @Schema(description = "每页数据条数")
    private Integer pageSize;
    @Schema(description = "总数据条数")
    private Integer total;
    @Schema(description = "返回数据")
    private T data;
}
