package me.cetauri.springboot.runner;

import me.cetauri.springboot.beans.TestController;
import me.cetauri.springboot.validator.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

@Component
public class SampleAppRunner implements ApplicationRunner {
    private static final Logger logger = LogManager.getLogger(SampleAppRunner.class);


    @Autowired
    private TestController testController;


    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource2 = resourceLoader.getResource("http://www.dotal.org");

        System.out.println(resource2.getInputStream().toString());

        var resource = resourceLoader.getResource("classpath:log4j2.xml");
        logger.info(resource.getDescription() + " exist? : " + Files.exists(Path.of(resource.getURI())));


        var stringArgs = new String[]{"Spring"};
        var message = messageSource.getMessage("test", stringArgs, Locale.US);
        var message_kr = messageSource.getMessage("test", stringArgs, Locale.KOREA);

        logger.warn("message test : " + message);
        logger.warn("message test KR: " + message_kr);

        var event = new Event();
        event.setId(0);
        event.setLimit(11);
//        event.setTitle("aaaa");
        Errors errors = new BeanPropertyBindingResult(null, "event");
        validator.validate(event, errors);

//        errors.getFieldErrors().forEach(System.out::println);
        errors.getAllErrors().forEach(x -> {
                Arrays.stream(x.getCodes()).forEach(System.out::println);
                System.out.println(x.getDefaultMessage());
            }
        );


    }
}
