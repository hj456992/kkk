package com.houjue.ddd.gate.rest;

import com.houjue.ddd.application.TaskService;
import com.houjue.ddd.application.task.param.TaskCreateParam;
import com.houjue.ddd.domain.task.Task;
import com.houjue.ddd.domain.task.TaskId;
import com.houjue.ddd.domain.task.TaskRepo;
import com.houjue.ddd.gate.rest.response.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: task的http接口
 * @author: houjue
 * @create: 2019-07-03 15:22
 **/
@RestController
@Slf4j
@RequestMapping("/v1/task")
public class TaskApi {

    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepo taskRepo;

    @ApiOperation("创建任务")
    @PostMapping("/create")
    public Result<Task> create(@RequestBody TaskCreateParam param) {
        return Result.ok(taskService.create(param));
    }

    @ApiOperation("任务详情")
    @GetMapping("/detail")
    public Result<Task> findByTaskId(String taskId){
        return Result.ok(taskRepo.findById(new TaskId(taskId)));
    }
}
