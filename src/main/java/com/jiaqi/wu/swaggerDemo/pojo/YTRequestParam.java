package com.jiaqi.wu.swaggerDemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "YTRequestParam", description = "圆通推送服务表单格式接收对象")
public class YTRequestParam {

    @ApiModelProperty(value = "轨迹", required = true)
    private String logistics_interface;

    @ApiModelProperty(value = "md5签名", required = true, example = "AZYKLeDcTxhgjda8GiS+pQ==")
    private String data_digest;

    @ApiModelProperty(value = "客户id", required = true, example = "BYXXD")
    private String clientId;

    @ApiModelProperty(value = "类型", required = true, example = "online")
    private String type;
}
