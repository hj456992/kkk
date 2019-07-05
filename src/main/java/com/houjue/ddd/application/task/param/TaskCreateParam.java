package com.houjue.ddd.application.task.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @description: 任务创建参数
 * @author: houjue
 * @create: 2019-07-03 15:52
 **/
@Data
@Accessors(chain = true)
public class TaskCreateParam {

    @NotNull(message = "执行脚本不能为空")
    private String express;

    @NotNull(message = "触发器id不能为空")
    private String sourceId;

    @NotNull(message = "延迟时间不能为空")
    @ApiModelProperty("延迟时间，默认延迟0秒，即不延迟")
    private Integer delayTime=0;
}
