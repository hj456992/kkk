package com.houjue.ddd.infra.mapper;

import com.houjue.ddd.domain.dataSource.MqSource;
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
@Repository
public interface MqSourceMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into mq_source(mq_source_id,topic,tag,mq_type,gid,date_create,date_update)"
            + " values(#{mqSourceId.id},#{topic},#{tag},#{mqType},#{gid},now(),now())")
    void create(MqSource mqSource);

    @Results(id = "mqSourceMap", value = {
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "mqSourceId.id", column = "mq_source_id"),
            @Result(property = "topic", column = "topic"),
            @Result(property = "tag", column = "tag"),
            @Result(property = "mqType", column = "mq_type"),
            @Result(property = "gid", column = "gid"),
            @Result(property = "dateCreate", column = "date_create"),
            @Result(property = "dateUpdate", column = "date_update"),
            @Result(property = "dateDelete", column = "date_delete"),
    })
    @Select("SELECT * FROM mq_source WHERE mq_source_id = #{mqSourceId}")
    MqSource findById(@Param("mqSourceId")String mqSourceId);

    @ResultMap("mqSourceMap")
    @Select("SELECT * FROM mq_source")
    List<MqSource> findAll();
}
