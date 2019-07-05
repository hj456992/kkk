package com.houjue.ddd.domain.dataSource;

import com.houjue.ddd.common.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @description: db数据源
 * @author: houjue
 * @create: 2019-06-28 00:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSource extends Entity {
    @NotNull(message = "ID不能为空")
    private DbSourceId dbSourceId;

    @NotNull(message = "jdbcUrl不能为空")
    private String jdbcUrl;

    @NotNull(message = "userName不能为空")
    private String userName;

    @NotNull(message = "password不能为空")
    private String password;

    public void initSqlSession() {
        // todo 初始化sqlSession
    }
}
