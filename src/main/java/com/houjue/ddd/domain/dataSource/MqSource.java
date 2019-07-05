package com.houjue.ddd.domain.dataSource;

import com.houjue.ddd.common.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @description: mq数据源
 * @author: houjue
 * @create: 2019-06-28 00:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqSource extends Entity {
    @NotNull(message = "ID不能为空")
    private MqSourceId mqSourceId;

    @NotNull(message = "topic不能为空")
    private String topic;

    @NotNull(message = "tag不能为空")
    private String tag;

    @NotNull(message = "mqType不能为空")
    private String mqType;

    @NotNull(message = "gid不能为空")
    private String gid;

    /**
     * 启动消费者
     */
    public void startConsumer() {
        if (this.mqType == null) {
            return;
        }
        if ("ROCKETMQ".equals(this.mqType)) {
            startRocketConsumer();
        }
        if ("KAFKA".equals(this.mqType)) {
            startKafkaConsumer();
        }
    }

    /**
     * 启动Rocket消费者
     */
    private void startRocketConsumer() {
        // todo 待完善
    }

    /**
     * 启动kafka消费者
     */
    private void startKafkaConsumer() {
        //加载 kafka.properties
        Properties props = new Properties();
        //设置接入点，请通过控制台获取对应 Topic 的接入点
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1");
        //默认值为 30000 ms，可根据自己业务场景调整此值，建议取值不要太小，防止在超时时间内没有发送心跳导致消费者再均衡
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 25000);
        //每次 poll 的最大数量
        //注意该值不要改得太大，如果 poll 太多数据，而不能在下次 poll 之前消费完，则会触发一次负载均衡，产生卡顿
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 30);
        //消息的反序列化方式
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //当前消费实例所属的 Consumer Group，请在控制台创建后填写
        //属于同一个 Consumer Group 的消费实例，会负载消费消息
        props.put(ConsumerConfig.GROUP_ID_CONFIG, this.gid);
        //构造消息对象，即生成一个消费实例
        KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(props);
        //设置  Consumer Group 订阅的 Topic，可订阅多个 Topic。如果 GROUP_ID_CONFIG 相同，那建议订阅的 Topic 设置也相同
        List<String> topics = new ArrayList<>();
        //每个 Topic 需要先在控制台进行创建
        topics.add(this.topic);
        consumer.subscribe(topics);


        // todo 建立线程池，执行消费者任务
//        final String threadName = "KafkaClient-Source-" + this.mqSourceId.getId();
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return new Thread(r, threadName);
//                    }
//                });
//        Runnable runnable =  new AsyncKafkaRunnable(consumer,taskService);
//        scheduledExecutorService.scheduleAtFixedRate(runnable, 2 * 1000L, 2 * 1000L, TimeUnit.MILLISECONDS);

//        KafkaConsumerBo kafkaConsumerBo = new KafkaConsumerBo();
//        kafkaConsumerBo.setConsumer(consumer);
//        kafkaConsumerBo.setScheduledExecutorService(scheduledExecutorService);
    }
}
