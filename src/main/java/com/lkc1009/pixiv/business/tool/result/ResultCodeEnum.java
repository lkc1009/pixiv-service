package com.lkc1009.pixiv.business.tool.result;

public enum ResultCodeEnum {

	SUCCESS(200, "success"),
	ERROR(500, "system error"),
    ;

    private final Integer code;
    private final String message;
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
