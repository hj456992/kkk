package com.houjue.ddd.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @description: 通用实体属性
 * @author: houjue
 * @create: 2019-06-30 16:39
 **/
@Data
@Getter
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Entity {
    private Integer id;
    protected Timestamp dateCreate;
    protected Timestamp dateUpdate;
    protected Timestamp dateDelete;
}
