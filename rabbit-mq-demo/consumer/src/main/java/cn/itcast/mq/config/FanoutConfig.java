package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create date 2022/5/25 10:02
 *
 * @author rui
 */
@Configuration
public class FanoutConfig {
    /**
     * 创建交换机
     *
     * @return {@link FanoutExchange}
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("rui.fanout");
    }

    /**
     * 创建队列1
     *
     * @return {@link Queue}
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    /**
     * 绑定队列1
     *
     * @return {@link Binding}
     */
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
    // public Binding bindingQueue1() {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
        // return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    /**
     * 创建队列2
     *
     * @return {@link Queue}
     */
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    /**
     * 绑定队列2
     *
     * @return {@link Binding}
     */
    @Bean
    // public Binding bindingQueue2() {
    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
        // return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object.queue");
    }
}
