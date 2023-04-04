package com.example.demo_rabbit_send.controller;

import com.example.demo_rabbit_send.Order;
import com.example.demo_rabbit_send.service.RabbitSendService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Log4j2
@RestController
@RequestMapping(path = "api/v1/orders")
public class RabbitSendApi {
    @Autowired
    private RabbitSendService rabbitSendService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Order order) throws IOException, TimeoutException {

        return new ResponseEntity(
                rabbitSendService.saveOrder(order), HttpStatus.OK);
    }
}
