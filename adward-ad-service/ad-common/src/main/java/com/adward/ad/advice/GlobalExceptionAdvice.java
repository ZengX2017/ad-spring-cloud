package com.adward.ad.advice;

import com.adward.ad.exception.AdException;
import com.adward.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adward_Z
 * @date 2020/8/9
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    // TODO: 做扩展，后期记得加枚举，详情见：https://coding.imooc.com/learn/questiondetail/101113.html
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request,
                                                     AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
