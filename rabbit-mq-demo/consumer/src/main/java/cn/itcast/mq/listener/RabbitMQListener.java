package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * create date 2022/5/25 09:36
 *
 * @author rui
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) {
        System.out.println("spring 消费者接收到的消息：【" + msg+ "】");
    }

}
