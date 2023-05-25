package com.jiaqi.wu.swaggerDemo.controller;

import com.jiaqi.wu.swaggerDemo.common.Result;
import com.jiaqi.wu.swaggerDemo.pojo.SFPushService;
import com.jiaqi.wu.swaggerDemo.pojo.SysUser;
import com.jiaqi.wu.swaggerDemo.pojo.YTRequestParam;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author wujiaqi
 */
@Api(tags = "otherController api")
@Slf4j
@RestController
@RequestMapping("otherController")
public class OtherController {


    /**
     * {@ApiParam} 格式是get请求会会从接口上拿取请求参数
     * name:是字段名称
     * value:参数说明
     *
     * @param content
     * @return result
     */
    @GetMapping("/otherControllerIndex")
    @ApiOperation(value = "获取otherController", httpMethod = "GET", response = Result.class)
    public Result<Void> otherController(@ApiParam(name = "content", value = "报文内容", required = true) @RequestParam(value = "content") String content) {
        log.info("otherController is running:\n{}", content);
        return Result.success();
    }

    /**
     * 也可以这样格式是get请求会会从接口上拿取请求参数
     *
     * @param content
     * @return result
     */
    @GetMapping("/otherController2")
    @ApiImplicitParam(name = "content", value = "content", required = true, dataType = "String", paramType = "query")
    @ApiOperation(value = "otherController2", httpMethod = "GET", response = Result.class)
    public Result<Void> otherController2(@RequestParam(value = "content") String content) {
        log.info("otherController is running:\n{}", content);
        return Result.success();
    }


    @ApiOperation(value = "postBody接口", httpMethod = "POST", response = Result.class, produces = "application/json", consumes = "application/json")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "body", value = "报文", required = true, dataType = "String")
    )
    @RequestMapping(value = "/postBody", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Void> postBody(@RequestBody String body) {
        log.info("postBody is running:\n{}", body);
        return Result.success();
    }


    @ApiOperation(value = "试一下传一个对象", httpMethod = "POST", response = Result.class, produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/saveSysUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Void> saveSysUser(@RequestBody SysUser sysUser) {
        log.info("postBody is running:\n{}", sysUser);
        return Result.success();
    }


    /**
     * 推送 body, 封装的实体类
     *
     * @param content content
     * @return result
     */
    @ApiOperation(value = "顺丰推送轨迹接口", httpMethod = "POST", response = Result.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "顺丰推送轨迹接口请求参数", dataType = "SFPushService")
    })
    @PostMapping("sfPushService")
    public Result<Void> sfPushService(@RequestBody SFPushService content) {
        log.info("顺丰推送服务接口参数:\n{}", content);
        return Result.success();
    }


    @ApiOperation(value = "圆通推送轨迹接口", httpMethod = "POST", response = Result.class, produces = "application/json")
    @PostMapping(value = "/ytPushService", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<Void> ytPushService(YTRequestParam ytRequestParam) {
        log.info("圆通推送轨迹接口请求参数:\n{}", ytRequestParam.toString());
        return Result.success();
    }


    public static void main(String[] args) {
        String s = " ";
        try {
            String encode = URLEncoder.encode(s, "UTF-8");
            System.out.println("encode = " + encode);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
