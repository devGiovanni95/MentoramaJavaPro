package com.giovanni.trabalhocicd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();

            jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
            jmsListenerContainerFactory.setConcurrency("5-10");
        return jmsListenerContainerFactory;
    }

//    @Value( "${activemq.url}" )
//    private String brokerUrl;
//
//    @Value( "${activemq.user}" )
//    private String user;
//
//    @Value( "${activemq.password}" )
//    private String senha;
//
//    @Bean
//    public ActiveMQConnectionFactory connectionFactory() {
//        if ("".equals(user)) {
//            return new ActiveMQConnectionFactory(brokerUrl);
//        }
//        return new ActiveMQConnectionFactory(user, senha, brokerUrl);
//    }
//
//    @Bean
//    public JmsListenerContainerFactory jmsFactoryTopic(ConnectionFactory connectionFactory,
//                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setPubSubDomain(true);
//        return factory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(connectionFactory());
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplateTopic() {
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
//        jmsTemplate.setPubSubDomain(true);
//        return jmsTemplate;
//    }
}
