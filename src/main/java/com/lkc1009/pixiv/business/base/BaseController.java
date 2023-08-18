package com.lkc1009.pixiv.business.base;

import com.lkc1009.pixiv.business.tool.result.Result;

import java.util.Objects;

public class BaseController {
    protected void init() {

    }

    protected <T> Result<T> single(Integer line) {
        return line == 1 ? Result.success() : Result.error();
    }

    protected <T> Result<T> multiple(Integer line, Integer dataNumber) {
        return Objects.equals(line, dataNumber) ? Result.success() : Result.error();
    }
}
