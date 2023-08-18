package com.lkc1009.pixiv.business.tool.result;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Builder
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Builder.Default
    private Integer code = ResultCode.SUCCESS.getCode();
    @Builder.Default
    private String message  = ResultCode.SUCCESS.getMessage();
    private T data;

    public static <T> Result<T> success() {
        return Result.<T>builder()
                .build();
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .data(data)
                .build();
    }

    public static <T> Result<T> success(@NotNull ResultCode resultCode) {
        return Result.<T>builder()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .build();
    }

    public static <T> Result<T> success(@NotNull ResultCode resultCode, T data) {
        return Result.<T>builder()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .data(data)
                .build();
    }

    public static <T> Result<T> error() {
        return Result.<T>builder()
                .code(ResultCode.ERROR.getCode())
                .message(ResultCode.ERROR.getMessage())
                .build();
    }

    public static <T> Result<T> error(@NotNull ResultCode resultCode) {
        return Result.<T>builder()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .build();
    }

}
