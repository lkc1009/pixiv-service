package com.lkc1009.pixiv.business.tool.result;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code = ResultCode.SUCCESS.getCode();
    private String message  = ResultCode.SUCCESS.getMessage();
    private T data;

    @Contract(" -> new")
    public static <T> @NotNull Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setData(data);
    }

    public static <T> Result<T> success(@NotNull ResultCode resultCode) {
        return new Result<T>()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage());
    }

    public static <T> Result<T> success(@NotNull ResultCode resultCode, T data) {
        return new Result<T>()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage())
                .setData(data);
    }

    public static <T> Result<T> error() {
        return new Result<T>()
                .setCode(ResultCode.ERROR.getCode())
                .setMessage(ResultCode.ERROR.getMessage());
    }

    public static <T> Result<T> error(@NotNull ResultCode resultCode) {
        return new Result<T>()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage());
    }

}
