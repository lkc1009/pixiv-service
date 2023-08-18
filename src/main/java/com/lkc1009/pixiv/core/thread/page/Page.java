package com.lkc1009.pixiv.core.thread.page;

import com.lkc1009.pixiv.framework.validation.ValidGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(description = "分页")
public class Page implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "页码不能为空", groups = {ValidGroup.Select.class })
    @Schema(description = "页码")
    private Integer page;

    @NotNull(message = "每页数量不能为空", groups = { ValidGroup.Select.class })
    @Schema(description = "每页数量")
    private Integer pageSize;

    public static final String PAGE_PARAM = "page";
    public static final String PAGE_SIZE_PARAM = "pageSize";
}
