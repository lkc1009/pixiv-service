package com.lkc1009.pixiv.business.tool.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public abstract class AbstractException extends RuntimeException {

    private Integer code;

    private String message;

    AbstractException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
