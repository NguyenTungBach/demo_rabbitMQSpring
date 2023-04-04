package com.example.demo_rabbit_received.service;

import com.example.demo_rabbit_received.Entity.Order;
import com.example.demo_rabbit_received.repository.OrderRepository;
import com.google.gson.Gson;
import com.rabbitmq.client.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Log4j2
//@Component
@Service
public class ReceiveService {
    @Autowired
    private OrderRepository orderRepository;
    private final static String QUEUE_NAME = "hello";


    @Bean
    public String testCheck(){
        return "test thu zxzc";
    }

    @Bean
    public boolean received() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,
                false, false,false, null);
        log.info("[!] Waiting for messages. To exit press Ctrl+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                Gson gson = new Gson();

                String message = new String(body, "UTF-8");
                log.info("check Recieved' " + message);
                Order order = gson.fromJson(message,Order.class);
                orderRepository.save(order);
                log.info("Bach Recieved' " + order.getName() + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        return true;
    }

//    public boolean received(String test) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME,
//                false, false,false, null);
//        log.info("[!] Waiting for messages. To exit press Ctrl+C");
//
//        Consumer consumer = new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag,
//                                       Envelope envelope,
//                                       AMQP.BasicProperties properties,
//                                       byte[] body)
//                    throws IOException {
//                Gson gson = new Gson();
//
//                String message = new String(body, "UTF-8");
//                Order order = gson.fromJson(message,Order.class);
//                orderRepository.save(order);
//                log.info("Bach Recieved' " + order.getName() + "'");
//            }
//        };
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//        return true;
//    }
}
