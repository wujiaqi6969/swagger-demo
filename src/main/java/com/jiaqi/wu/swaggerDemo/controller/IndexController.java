package com.jiaqi.wu.swaggerDemo.controller;

import com.jiaqi.wu.swaggerDemo.common.Result;
import com.jiaqi.wu.swaggerDemo.pojo.PsctechVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author WJQ
 */
@Api(value = "首页控制", tags = "indexController")
@Slf4j
@RestController
@RequestMapping("/indexController")
public class IndexController {

    @GetMapping(value = "index", produces = "application/json")
    @ApiOperation(value = "index首页访问", notes = "index the notes", httpMethod = "GET", response = Result.class)
    public Result<Void> index() {
        return Result.success();
    }


    @ApiOperation(value = "从jcforms获取代办列表", httpMethod = "GET")
    @GetMapping("front_getWorkList")
    public Result<Void> getFrontList(@RequestParam(required = false) @ApiParam(name = "pageSize", value = "每页显示的数量，为空时默认显示10条") Integer pageSize,
                                     @RequestParam(required = false) @ApiParam(name = "pageNumber", value = "显示的页数，为空时默认显示第1页") Integer pageNumber,
                                     @RequestParam(required = false) @ApiParam(name = "sysname", value = "系统名称，这里的系统名称只待办事项的名称，即：processChName") String sysname,
                                     @RequestParam(required = false) @ApiParam(name = "type", value = "默认等于0,") Integer type,
                                     @RequestParam(required = false) @ApiParam(name = "state", value = "默认等于-1") Integer state,
                                     @RequestParam(required = false) @ApiParam(name = "sysid", value = "系统id，从front_getWorkCount接口返回的列表中取值") String sysid,
                                     @RequestParam(required = false) @ApiParam(name = "sqr", value = "搜索标题关键字") String sqr,
                                     @RequestParam(required = false) @ApiParam(name = "starttime", value = "开始时间") String starttime,
                                     @RequestParam(required = false) @ApiParam(name = "endtime", value = "结束时间") String endtime,
                                     @RequestParam(required = false) @ApiParam(name = "title", value = "搜索标题关键字") String title) {
        log.info("getFrontList请求参数:pageSize:{}, pageNumber:{}, sysname:{}, type:{}", pageSize, pageNumber, sysname, type);
        return Result.success();
    }


    @ApiOperation(value = "从jcforms获取代办列表Copy", httpMethod = "POST")
    @PostMapping("front_getWorkList2")
    public Result<Void> getFrontListCopy(@RequestBody PsctechVo psctechVo) {
        log.info("getFrontListCopy请求参数:PsctechVo:{}", psctechVo);
        return Result.success();
    }

}
