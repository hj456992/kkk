package com.houjue.ddd.domain.field;

import com.houjue.ddd.domain.task.TaskId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepo {
    List<Field> findByTaskId(TaskId taskId);

    Field findById(FieldId fieldId);
}
