package com.houjue.ddd;

import com.houjue.ddd.domain.dataSource.DbSource;
import com.houjue.ddd.domain.dataSource.DbSourceRepo;
import com.houjue.ddd.domain.dataSource.MqSource;
import com.houjue.ddd.domain.dataSource.MqSourceRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 应用启动事件监听器
 * @author: houjue
 * @create: 2019-07-03 10:38
 **/
@Component
@Slf4j
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MqSourceRepo mqSourceRepo;
//    @Autowired
//    private DbSourceRepo dbSourceRepo;

    private static Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("StartupListener.onApplicationEvent  begin!!!");
        if (event.getApplicationContext().getParent() == null) {
            // 启动所有mq消费者
            List<MqSource> mqSourceList = mqSourceRepo.findAll();
            for (MqSource mqSource : mqSourceList) {
                log.info("ConsumerSourceService.startConsumer {}", mqSource);
                mqSource.startConsumer();
            }

            // 启动所有sqlSession
//            List<DbSource> dbSourceList = dbSourceRepo.findAll();
//            for (DbSource dbSource : dbSourceList) {
//                log.info("ApplicationEventListener.onApplicationEvent dbSourceId: {}", dbSource.getDbSourceId());
//                dbSource.initSqlSession();
//            }
        }
    }
}
