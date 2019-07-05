package com.houjue.ddd.domain.dataSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: 数据源id值对象
 * @author: houjue
 * @create: 2019-07-01 18:27
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DbSourceId {
    private String id;
}
