package com.houjue.ddd.domain.dataSource;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbSourceRepo {
    DbSource findById(DbSourceId dbSourceId);

    void create(DbSource dbSource);

    List<DbSource> findAll();
}
