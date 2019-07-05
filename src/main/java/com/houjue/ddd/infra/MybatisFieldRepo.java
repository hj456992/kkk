package com.houjue.ddd.infra;

import com.houjue.ddd.domain.field.Field;
import com.houjue.ddd.domain.field.FieldId;
import com.houjue.ddd.domain.field.FieldRepo;
import com.houjue.ddd.domain.task.TaskId;
import com.houjue.ddd.infra.mapper.FieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-07-02 17:03
 **/
@Repository
public class MybatisFieldRepo implements FieldRepo {
    @Autowired
    FieldMapper fieldMapper;

    @Override
    public List<Field> findByTaskId(TaskId taskId) {
        return fieldMapper.findByTaskId(taskId.getId());
    }

    @Override
    public Field findById(FieldId fieldId) {
        return null;
    }
}
