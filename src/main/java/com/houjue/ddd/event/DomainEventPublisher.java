package com.houjue.ddd.event;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description: 对象发布器
 * @author: houjue
 * @create: 2019-06-30 22:48
 **/
@Slf4j
public class DomainEventPublisher implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(DomainEventPublisher.class);
    private static ApplicationContext applicationContext;

    public DomainEventPublisher() {
    }

    public static <T> void publish(T aDomainEvent) {
        if (applicationContext != null) {
            applicationContext.publishEvent(aDomainEvent);
        } else {
            log.warn("event domain event fail because ApplicationContext null, event={}", aDomainEvent);
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }
}
