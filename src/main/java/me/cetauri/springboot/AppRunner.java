package me.cetauri.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext context;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var env = context.getEnvironment();
        System.out.println("app.name:" + env.getProperty("app.name"));
        System.out.println("app.test:" + env.getProperty("app.test"));

        URI uri = resourceLoader.getResource("classpath:/test.txt").getURI();
        String txt = Files.readString(Path.of(uri));
        System.out.println(txt);
    }
}
