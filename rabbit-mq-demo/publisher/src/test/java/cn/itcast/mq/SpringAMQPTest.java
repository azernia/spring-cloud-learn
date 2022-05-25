package cn.itcast.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create date 2022/5/25 09:23
 *
 * @author rui
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAMQPTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String queueName = "simple.queue";
        String message = "hello, spring amqp";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello, spring amqp";
        // 发送消息
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message + " " + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendFanoutExchange() {
        String exchangeName = "rui.fanout";
        String message = "hello everyone";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        String exchangeName = "rui.direct";
        String message = "hello blue";
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }
}
