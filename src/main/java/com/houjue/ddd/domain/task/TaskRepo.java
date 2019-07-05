package com.houjue.ddd.domain.task;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo {
    Task findById(TaskId taskId);

    void create(Task task);

    TaskId nextId();
}
