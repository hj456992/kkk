package com.houjue.ddd.infra.mapper;

import com.houjue.ddd.domain.dataSource.DbSource;
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
public interface DbSourceMapper {
    @Results(id = "dbSourceMap", value = {
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "dbSourceId.id", column = "db_source_id"),
            @Result(property = "jdbcUrl", column = "jdbc_url"),
            @Result(property = "userName", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "dateCreate", column = "date_create"),
            @Result(property = "dateUpdate", column = "date_update"),
            @Result(property = "dateDelete", column = "date_delete"),
    })
    @Select("SELECT * FROM db_source WHERE db_source_id = #{dbSourceId}")
    DbSource findById(@Param("dbSourceId")String dbSourceId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into db_source(db_source_id,jdbc_url,username,password,date_create,date_update)"
            + " values(#{dbSourceId.id},#{jdbcUrl},#{userName},#{password},now(),now())")
    void create(DbSource dbSource);

    @ResultMap("dbSourceMap")
    @Select("SELECT * FROM db_source")
    List<DbSource> findAll();
}
