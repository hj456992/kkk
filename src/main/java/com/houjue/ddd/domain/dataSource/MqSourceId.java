package com.houjue.ddd.domain.dataSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: mq数据源值对象
 * @author: houjue
 * @create: 2019-07-01 17:13
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MqSourceId {
    private String id;
}
