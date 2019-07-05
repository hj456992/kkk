package com.houjue.ddd.domain.field.event;

import com.houjue.ddd.event.BaseDomainEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @description: 字段添加事件
 * @author: houjue
 * @create: 2019-07-03 09:56
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FieldAddEvent extends BaseDomainEvent {
}
