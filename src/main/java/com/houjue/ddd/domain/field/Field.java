package com.houjue.ddd.domain.field;

import com.houjue.ddd.common.Entity;
import com.houjue.ddd.domain.task.Task;
import com.houjue.ddd.domain.task.TaskId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @description: 规则内包含的字段信息
 * @author: houjue
 * @create: 2019-06-28 00:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field extends Entity {

    @NotNull(message = "ID不能为空")
    private FieldId fieldId;

    @NotNull(message = "taskID不能为空")
    private TaskId taskId;

    private Task task;

    @NotNull(message = "valueSource不能为空")
    private String valueSource;

    @NotNull(message = "value不能为空")
    private String value;

    @NotNull(message = "source_id不能为空")
    private String sourceId;

    // 获取字段值
    public String getValue(FieldId fieldId) {
        // todo 从仓库获取field
        // todo 根据valueSource定位具体的field
        // todo 具体field获取值

        return null;
    }
}
