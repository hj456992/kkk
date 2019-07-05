package com.houjue.ddd.event;

import lombok.Getter;

import java.util.Date;

/**
 * Created by zhacker.
 * Time 2018/6/30 下午5:09
 */
public abstract class BaseDomainEvent implements DomainEvent {
  
  @Getter
  protected int eventVersion = 1;
  
  @Getter
  protected Date OccurredOn = new Date();
}
