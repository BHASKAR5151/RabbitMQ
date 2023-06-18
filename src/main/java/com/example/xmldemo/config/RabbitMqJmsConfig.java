
package com.example.xmldemo.config;

import com.example.xmldemo.service.RabbiMqJmsService;
import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;


import javax.jms.ConnectionFactory;

@Configuration
public class RabbitMqJmsConfig {
    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestinationName("rabbitmq_queue");
        return jmsTemplate;
    }

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
    public RabbiMqJmsService messageListener() {
        return new RabbiMqJmsService();
    }

}

