package com.houjue.ddd.infra.mapper;

import com.houjue.ddd.domain.task.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface TaskMapper {
    @Results(id = "taskMap", value = {
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "taskId.id", column = "task_id"),
            @Result(property = "express", column = "express"),
            @Result(property = "sourceId.id", column = "source_id"),
            @Result(property = "delaySecond", column = "delay_second"),
            @Result(property = "dateCreate", column = "date_create"),
            @Result(property = "dateUpdate", column = "date_update"),
            @Result(property = "dateDelete", column = "date_delete"),
    })
    @Select("SELECT * FROM task WHERE task_id = #{taskId}")
    Task findById(@Param("taskId")String taskId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into field(task_id,express,source_id,delay_second,date_create,date_update)"
            + " values(#{taskId.id},#{express},#{sourceId.id},#{delaySecond},now(),now())")
    void create(Task task);
}
