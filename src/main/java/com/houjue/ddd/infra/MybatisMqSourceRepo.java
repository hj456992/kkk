package com.houjue.ddd.infra;

import com.houjue.ddd.domain.dataSource.MqSource;
import com.houjue.ddd.domain.dataSource.MqSourceId;
import com.houjue.ddd.domain.dataSource.MqSourceRepo;
import com.houjue.ddd.infra.mapper.MqSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: mqSouce仓库
 * @author: houjue
 * @create: 2019-07-02 16:19
 **/
@Repository
public class MybatisMqSourceRepo implements MqSourceRepo {
    @Autowired
    MqSourceMapper mqSourceMapper;

    @Override
    public MqSource findById(MqSourceId mqSourceId) {
        return mqSourceMapper.findById(mqSourceId.getId());
    }

    @Override
    public List<MqSource> findAll() {
        return mqSourceMapper.findAll();
    }
}
