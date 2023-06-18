package com.example.xmldemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "rabbitmq_queue";
    public static final String EXCHANGE = "rabbitmq_exchange";
    public static final String ROUTING_KEY = "rabbitmq_routingKey";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

  /*  @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
*/
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
