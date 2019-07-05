package com.houjue.ddd.infra.mapper;

import com.houjue.ddd.domain.field.Field;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface FieldMapper {

    @Results(id = "fieldMap", value = {
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "fieldId.id", column = "field_id"),
            @Result(property = "taskId.id", column = "task_id"),
            @Result(property = "valueSource", column = "value_source"),
            @Result(property = "value", column = "value"),
            @Result(property = "sourceId", column = "source_id"),
            @Result(property = "dateCreate", column = "date_create"),
            @Result(property = "dateUpdate", column = "date_update"),
            @Result(property = "dateDelete", column = "date_delete"),
    })
    @Select("SELECT * FROM field WHERE task_id = #{taskId}")
    List<Field> findByTaskId(@Param("taskId")String taskId);

    @ResultMap("fieldMap")
    @Select("SELECT * FROM field WHERE field_id = #{fieldId}")
    Field findById(@Param("fieldId")String fieldId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into field(field_id,task_id,value_source,value,source_id,date_create,date_update)"
            + " values(#{fieldId.id},#{taskId.id},#{valueSource},#{value},#{sourceId},now(),now())")
    void create(Field field);
}
