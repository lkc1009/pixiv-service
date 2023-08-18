package com.lkc1009.pixiv.core.thread.page;

public class PageThreadLocal {
    private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();

    public static Page getPage() {
        return PAGE_THREAD_LOCAL.get();
    }

    public static void setPage(Page page) {
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void removePage() {
        PAGE_THREAD_LOCAL.remove();
    }
}
