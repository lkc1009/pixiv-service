package com.lkc1009.pixiv.business.tool.result;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@Accessors(chain = true)
public class ResultCode implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;

    private static ResultCode dispose(@NotNull ResultCodeEnum resultCodeEnum) {
        return ResultCode.builder().code(resultCodeEnum.code()).message(resultCodeEnum.message()).build();
    }

    public static final ResultCode SUCCESS = dispose(ResultCodeEnum.SUCCESS);
    public static final ResultCode ERROR = dispose(ResultCodeEnum.ERROR);

}
