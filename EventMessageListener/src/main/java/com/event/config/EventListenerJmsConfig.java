
package com.rabbitmq.config;


import com.rabbitmq.listener.RabbiMqJmsListener;
import com.rabbitmq.jms.admin.RMQConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.web.client.RestTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@Slf4j
public class RabbitMqJmsConfig {


    @Bean
    public ConnectionFactory jmsConnectionFactory()  {
        RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public DefaultMessageListenerContainer messageListenerContainer()  {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(jmsConnectionFactory());
        container.setDestinationName("rabbitmq_queue");
        container.setMessageListener(messageListener());
        return container;
    }

    @Bean
    public RabbiMqJmsListener messageListener() {
        return new RabbiMqJmsListener();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

