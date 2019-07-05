package com.houjue.ddd.domain.dataSource;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MqSourceRepo {
    MqSource findById(MqSourceId mqSourceId);

    List<MqSource> findAll();
}
