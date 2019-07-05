package com.houjue.ddd.application;

import com.houjue.ddd.domain.task.Task;
import com.houjue.ddd.domain.task.TaskId;
import com.houjue.ddd.domain.task.TaskRepo;
import com.houjue.ddd.application.task.param.TaskCreateParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: task领域服务
 * @author: houjue
 * @create: 2019-07-03 16:45
 **/
@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Transactional
    public Task create(TaskCreateParam param) {
        Task task = new Task(
                taskRepo.nextId(),
                param.getExpress(),
                param.getSourceId(),
                param.getDelayTime()
        );
        taskRepo.create(task);
        return task;
    }

    public Task findById(String taskId) {
        if (StringUtils.isBlank(taskId)) {
            return null;
        }
        return taskRepo.findById(new TaskId(taskId));
    }
}
