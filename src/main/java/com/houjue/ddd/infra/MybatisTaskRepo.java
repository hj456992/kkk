package com.houjue.ddd.infra;

import com.houjue.ddd.domain.task.Task;
import com.houjue.ddd.domain.task.TaskId;
import com.houjue.ddd.domain.task.TaskRepo;
import com.houjue.ddd.infra.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @description: task仓储实现
 * @author: houjue
 * @create: 2019-06-29 18:13
 **/
@Repository
public class MybatisTaskRepo implements TaskRepo {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public Task findById(TaskId taskId) {
        return taskMapper.findById(taskId.getId());
    }

    @Override
    public void create(Task task) {
        taskMapper.create(task);
    }

    @Override
    public TaskId nextId() {
        return new TaskId(UUID.randomUUID().toString());
    }
}
