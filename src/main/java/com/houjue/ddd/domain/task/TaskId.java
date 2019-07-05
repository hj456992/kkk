package com.houjue.ddd.domain.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: task值对象
 * @author: houjue
 * @create: 2019-06-29 18:19
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TaskId {
    private String id;
}
