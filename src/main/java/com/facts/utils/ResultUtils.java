package com.facts.utils;

import com.facts.enums.ResultEnums;
import com.facts.result.Result;
import org.springframework.context.annotation.Configuration;

/**
 * 返回结果
 * @author Administrator
 */
public class ResultUtils {

    public static Result success(Object data){
        Result result = new Result();

        result.setCode(ResultEnums.RESULT_SUCCESS.getCode());
        result.setMsg(ResultEnums.RESULT_SUCCESS.getMsg());
        result.setObject(data);

        return result;
    }

}
