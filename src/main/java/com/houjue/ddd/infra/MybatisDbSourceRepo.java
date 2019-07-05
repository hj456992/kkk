package com.houjue.ddd.infra;

import com.houjue.ddd.domain.dataSource.DbSource;
import com.houjue.ddd.domain.dataSource.DbSourceId;
import com.houjue.ddd.domain.dataSource.DbSourceRepo;
import com.houjue.ddd.infra.mapper.DbSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 数据源仓库
 * @author: houjue
 * @create: 2019-07-03 00:27
 **/
public class MybatisDbSourceRepo implements DbSourceRepo {
    @Autowired
    DbSourceMapper dbSourceMapper;

    @Override
    public DbSource findById(DbSourceId dbSourceId) {
        return dbSourceMapper.findById(dbSourceId.getId());
    }

    @Override
    public void create(DbSource dbSource) {
        dbSourceMapper.create(dbSource);
    }

    @Override
    public List<DbSource> findAll() {
        return dbSourceMapper.findAll();
    }
}
