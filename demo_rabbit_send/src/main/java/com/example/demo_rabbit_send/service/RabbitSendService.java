package com.example.demo_rabbit_send.service;

import com.example.demo_rabbit_send.Order;
import com.example.demo_rabbit_send.util.RabbitSendHelper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Log4j2
@Service
public class RabbitSendService {
    public Optional<Order> saveOrder(Order order) throws IOException, TimeoutException {
        RabbitSendHelper.Sender(order);
        return Optional.ofNullable(order);
    }
}
