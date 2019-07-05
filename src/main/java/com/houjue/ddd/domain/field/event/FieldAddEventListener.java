package com.houjue.ddd.domain.field.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 字段添加事件监听器
 * @author: houjue
 * @create: 2019-07-03 10:06
 **/
@Component
@Slf4j
public class FieldAddEventListener {

    @EventListener
    public void addField(FieldAddEvent event) {

    }
}
