package com.houjue.ddd.domain.task;

import com.houjue.ddd.common.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.houjue.ddd.domain.dataSource.MqSource;
import com.houjue.ddd.domain.dataSource.MqSourceId;
import com.houjue.ddd.domain.dataSource.MqSourceRepo;
import com.houjue.ddd.domain.field.Field;
import com.houjue.ddd.domain.field.FieldRepo;
import com.houjue.ddd.registry.DomainRegistry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @description: 执行任务，核心域
 * @author: houjue
 * @create: 2019-06-27 22:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task extends Entity {
    @NotNull(message = "ID不能为空")
    private TaskId taskId;

    @NotNull(message = "脚本不能为空")
    private String express;

    @NotNull(message = "触发器不能为空")
    private MqSourceId sourceId;

    private MqSource triggerSource;

    @NotNull(message = "延迟时间不能为空")
    private Integer delaySecond;

    @Size(max = 10, message = "字段数量最大不能超过10个")
    private List<Field> fieldList;

    /**
     * 任务创建入口
     * @param taskId
     * @param express
     * @param sourceId
     * @param delaySecond
     */
    public Task(TaskId taskId, String express, String sourceId, Integer delaySecond) {
        this.taskId = taskId;
        this.express = express;
        this.sourceId = new MqSourceId(sourceId);
        this.delaySecond = delaySecond;

        // todo 此处可以加入创建事件
    }

    /**
     * 加载触发器
     */
    public Task loadTrigger() {
        if (this.triggerSource != null) {
            return this;
        }
        // todo 调用仓库进行加载
        if (this.sourceId != null) {
            this.triggerSource = DomainRegistry.repo(MqSourceRepo.class).findById(sourceId);
        }
        return this;
    }

    /**
     * 加载字段
     */
    public Task loadFields() {
        if (CollectionUtils.isNotEmpty(fieldList)) {
            return this;
        }
        // todo 调用仓库进行加载
        if (this.taskId != null) {
            this.fieldList = DomainRegistry.repo(FieldRepo.class).findByTaskId(taskId);
        }
        return this;
    }
    /**
     * 执行脚本
     */
    public void executeExpress() {
        // todo 执行脚本
        // todo 调用执行完毕事件
        // todo 失败执行任务调用失败事件
    }
}
