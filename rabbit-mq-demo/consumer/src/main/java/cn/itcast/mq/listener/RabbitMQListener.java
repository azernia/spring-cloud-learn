package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * create date 2022/5/25 09:36
 *
 * @author rui
 */
@Component
public class RabbitMQListener {

    // @RabbitListener(queues = "simple.queue")
    // public void listenSimpleQueueMessage(String msg) {
    //     System.out.println("spring 消费者接收到的消息：【" + msg+ "】");
    // }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage1(String msg) throws InterruptedException {
        System.out.println("消费者[1]接收到的消息：【" + msg+ "】" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage2(String msg) throws InterruptedException {
        System.err.println("消费者[2]接收到的消息：【" + msg+ "】" + LocalTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1Message(String msg) {
        System.out.println("fanout queue 1 接收到的消息：【" + msg+ "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2Message(String msg) {
        System.out.println("fanout queue 2 接收到的消息：【" + msg+ "】");
    }

}
