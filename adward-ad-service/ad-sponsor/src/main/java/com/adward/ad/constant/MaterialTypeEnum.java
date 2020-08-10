package com.adward.ad.constant;

import lombok.Getter;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Getter
public enum MaterialTypeEnum {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private int code;
    private String message;

    MaterialTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
