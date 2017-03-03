package com.kansal.rabbitmq.message.management.service;

import com.kansal.rabbitmq.message.management.model.UserInfo;
import com.kansal.rabbitmq.message.management.sender.MqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tarunkansal on 2/16/17.
 */
@Service
public class RmsService {

    MqSender mqSender;

    @Autowired
    public RmsService(MqSender mqSender) {
        this.mqSender = mqSender;
    }

    public String sendMessage(String message) {
        mqSender.sendSimpleMessage(message);
        return message;
    }

    public UserInfo sendObjectMessage(UserInfo userInfo) {
        mqSender.sendObjectMessage(userInfo);
        return userInfo;
    }

    public UserInfo sendExchangeObjectMessage(UserInfo userInfo) {
        mqSender.sendExchangeObjectMessage(userInfo);
        return userInfo;
    }
}
