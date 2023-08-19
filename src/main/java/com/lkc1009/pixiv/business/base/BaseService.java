package com.lkc1009.pixiv.business.base;

import java.util.Objects;

public class BaseService {
    protected void singleCheck(Integer line, String message) {
        if (line != 1) {
            throw new RuntimeException(message);
        }
    }

    protected void multipleCheck(Integer line, Integer dataNumber, String message) {
        if (!Objects.equals(line, dataNumber)) {
            throw new RuntimeException(message);
        }
    }
}
