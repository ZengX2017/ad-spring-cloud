package com.adward.ad.constant;

import lombok.Getter;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Getter
public enum ConstantsEnum {
    REQUEST_PARAM_ERROR("请求参数错误"),
    SAME_NAME_USER_ERROR("存在同名用户"),
    CAN_NOT_FIND_RECORD("找不到数据记录"),
    SAME_NAME_PLAN_ERROR("存在同名的推广计划"),
    SAME_NAME_UNIT_ERROR("存在同名的推广单元"),
    ;

    private String message;

    ConstantsEnum(String message) {
        this.message = message;
    }
}
