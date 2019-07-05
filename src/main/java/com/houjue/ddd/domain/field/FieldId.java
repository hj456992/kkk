package com.houjue.ddd.domain.field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: field唯一标识，值对象
 * @author: houjue
 * @create: 2019-07-01 16:12
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FieldId {
    private String id;
}
