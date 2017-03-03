package com.kansal.rabbitmq.message.management.sender;

import com.kansal.rabbitmq.message.management.model.UserInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tarunkansal on 2/17/17.
 */
public class MqSender {

    RabbitTemplate rabbitTemplate;

    @Autowired
    public MqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSimpleMessage(String message) {
        rabbitTemplate.convertSendAndReceive("rabbitQueue", message);
    }

    public void sendObjectMessage(UserInfo userInfo) {
        rabbitTemplate.convertSendAndReceive("rabbitObjectQueue", userInfo);
    }

    public void sendExchangeObjectMessage(UserInfo userInfo) {
        rabbitTemplate.convertSendAndReceive("spring-boot-direct-exchange", userInfo.getCreator(), userInfo);
    }
}
