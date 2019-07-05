package com.houjue.ddd.domain.task.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 任务执行失败事件监听器
 * @author: houjue
 * @create: 2019-07-02 14:15
 **/
@Component
@Slf4j
public class TaskExecuteEventListener {

    @EventListener
    public void taskExecute(TaskExecuteEvent event) {

    }
}
