package com.jiaqi.wu.swaggerDemo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ApiModel(value = "SFPushService", description = "推送轨迹实体类")
public class SFPushService {

    @ApiModelProperty(value = "这是一个Body")
    @JsonProperty(value = "Body")
    private SFPushServiceBody body;


    @Data
    public static class SFPushServiceBody {
        @ApiModelProperty(value = "路由轨迹")
        @JsonProperty(value = "WaybillRoute")
        private List<WaybillRouteList> waybillRouteList;
    }

    @Data
    public static class WaybillRouteList {

        @ApiModelProperty(value = "地址")
        private String acceptAddress;

        @ApiModelProperty(value = "运单号")
        @JsonProperty(value = "mailno")
        private String mailNo;

        @ApiModelProperty(value = "订单号")
        @JsonProperty(value = "orderid")
        private String orderId;

        @ApiModelProperty(value = "接收时间")
        private String acceptTime;

        @ApiModelProperty(value = "备注")
        private String remark;

        @ApiModelProperty(value = "状态码")
        private String opCode;

        @ApiModelProperty(value = "时间戳")
        private String id;
    }
}
