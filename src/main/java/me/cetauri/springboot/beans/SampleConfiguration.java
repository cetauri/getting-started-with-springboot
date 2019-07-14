package me.cetauri.springboot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {
    @Bean
    public TestController testController(){
        return new TestController();
    }

    @Bean
    public TestController2 testController2(){
        return new TestController2();
    }

}
