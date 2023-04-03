package com.jiaqi.wu.swaggerDemo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author WJQ
 */
@Data
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "响应码", example = "0")
    private int code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private Result() {

    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("操作成功");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Result.success());
    }

}
