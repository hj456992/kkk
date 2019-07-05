package com.houjue.ddd.domain.task.event;

import com.houjue.ddd.event.BaseDomainEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @description: 任务执行失败事件
 * @author: houjue
 * @create: 2019-07-02 13:52
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TaskExecuteEvent extends BaseDomainEvent {

}