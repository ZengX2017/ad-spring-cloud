package com.adward.ad.constant;

import lombok.Getter;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Getter
public enum CreativeTypeEnum {
    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本"),
    ;

    private Integer code;

    private String message;

    CreativeTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
