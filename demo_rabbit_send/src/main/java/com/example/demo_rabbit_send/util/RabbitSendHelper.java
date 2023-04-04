package com.example.demo_rabbit_send.util;

import com.example.demo_rabbit_send.Order;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Log4j2
public class RabbitSendHelper {
    private final static String QUEUE_NAME = "hello";

    public static void Sender(Order order) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,
                false,
                false,
                false,
                null);
        Gson gson = new Gson();
        String message = gson.toJson(order);

        channel.basicPublish("",
                QUEUE_NAME,
                null,
                message.getBytes("UTF-8"));
        log.info("[!] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
