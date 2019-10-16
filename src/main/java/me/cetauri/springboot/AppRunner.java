package me.cetauri.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var env = context.getEnvironment();
        System.out.println("app.name:" + env.getProperty("app.name"));
        System.out.println("app.test:" + env.getProperty("app.test"));


    }
}
