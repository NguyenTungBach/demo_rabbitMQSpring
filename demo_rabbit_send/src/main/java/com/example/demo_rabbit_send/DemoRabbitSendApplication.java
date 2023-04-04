package com.example.demo_rabbit_send;

import com.example.demo_rabbit_send.util.RabbitSendHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DemoRabbitSendApplication {

	public static void main(String[] args) throws IOException, TimeoutException {

		SpringApplication.run(DemoRabbitSendApplication.class, args);
	}

}
