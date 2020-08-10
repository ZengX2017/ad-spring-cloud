package com.adward.ad.constant;

import lombok.Getter;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Getter
public enum CommonStatusEnum {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态"),
    ;

    private Integer code;

    private String message;

    CommonStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
