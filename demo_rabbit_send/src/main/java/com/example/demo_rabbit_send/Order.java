package com.example.demo_rabbit_send;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private String name;
    private Integer totalPrice;

    public Order(String name, Integer totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }
}
