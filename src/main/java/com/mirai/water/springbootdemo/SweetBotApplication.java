package com.mirai.water.springbootdemo;

import com.mirai.water.springbootdemo.qqbot.QBot;
import com.mirai.water.springbootdemo.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SweetBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(SweetBotApplication.class,args);
        ApplicationContext context = SpringUtil.getApplicationContext();
        QBot qBot = context.getBean(QBot.class);
        qBot.startBot();
    }
}
