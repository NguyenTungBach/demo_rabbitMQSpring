package com.example.demo_rabbit_send;


import com.example.demo_rabbit_send.util.RabbitSendHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

//@Component
public class OrderList {

//    @Bean
    public void check() throws IOException, TimeoutException {
        List<Order> list = new ArrayList<Order>();
//        list.add(new Order("don hang 1",1000));
//        list.add(new Order("don hang 2",2000));
//        list.add(new Order("don hang 3",3000));
//        list.add(new Order("don hang 4",4000));
//        list.add(new Order("don hang 5",5000));

        list.add(new Order("don hang 6",6000));
        list.add(new Order("don hang 7",7000));
        list.add(new Order("don hang 8",8000));

        for (Order order : list) {
            RabbitSendHelper.Sender(order);
        }
    }
}
