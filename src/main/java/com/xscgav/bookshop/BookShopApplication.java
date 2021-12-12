package com.xscgav.bookshop;

import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BookShopApplication {

    @Autowired
    private UserEntityRepo userEntityRepo;

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testRepository(){
    }
}
