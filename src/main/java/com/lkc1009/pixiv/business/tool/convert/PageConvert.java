package com.lkc1009.pixiv.business.tool.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lkc1009.pixiv.business.tool.result.PageData;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class PageConvert<S, T> {
    public PageData<T> convert(@NotNull IPage<S> iPage) {
        return new PageData<T>()
                .setPage(Math.toIntExact(iPage.getPages()))
                .setPageSize(Math.toIntExact(iPage.getSize()))
                .setTotal(Math.toIntExact(iPage.getTotal()));
    }
}
