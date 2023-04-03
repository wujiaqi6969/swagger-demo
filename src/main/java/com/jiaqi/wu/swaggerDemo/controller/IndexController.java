package com.jiaqi.wu.swaggerDemo.controller;

import com.jiaqi.wu.swaggerDemo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WJQ
 */
@Api(value = "首页控制", tags = "indexController")
@Slf4j
@RestController
@RequestMapping("/indexController")
public class IndexController {

    @GetMapping("index")
    @ApiOperation(value = "index首页访问", notes = "index the notes", httpMethod = "GET", response = Result.class)
    public Result<Void> index() {
        return Result.success();
    }

}
