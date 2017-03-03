package com.kansal.rabbitmq.message.management.controller;

import com.kansal.rabbitmq.message.management.model.UserInfo;
import com.kansal.rabbitmq.message.management.service.RmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by tarunkansal on 2/16/17.
 */
@RestController
public class RmsController {

    private final RmsService rmsService;

    @Autowired
    public RmsController(RmsService rmsService) {
        this.rmsService = rmsService;
    }

    @RequestMapping(value = "/stringmessage/{message}", method = RequestMethod.GET)
    public String sendMessage(@PathVariable("message") String message) {
        return rmsService.sendMessage(message);
    }

    @RequestMapping(value = "/objectmessage", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody UserInfo sendObjectMessage(@RequestBody UserInfo userInfo) {
        return rmsService.sendObjectMessage(userInfo);
    }

    @RequestMapping(value = "/exchange/objectmessage", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody UserInfo sendExchangeObjectMessage(@RequestBody UserInfo userInfo) {
        return rmsService.sendExchangeObjectMessage(userInfo);
    }
}
