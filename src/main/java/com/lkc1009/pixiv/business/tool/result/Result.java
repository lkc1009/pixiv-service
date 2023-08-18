package com.lkc1009.pixiv.business.tool.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(description = "返回结果类")
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "返回码")
    private Integer code = ResultCode.SUCCESS.getCode();
    @Schema(description = "返回信息")
    private String message  = ResultCode.SUCCESS.getMessage();
    @Schema(description = "返回数据")
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
