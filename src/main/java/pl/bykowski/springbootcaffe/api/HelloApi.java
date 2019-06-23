package pl.bykowski.springbootcaffe.api;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloApi {

    private MessageSource messageSource;

    @Autowired
    public HelloApi(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/say-hello")
    public String get(@RequestHeader String local,
                      @RequestParam String name,
                      @RequestParam String surname) {

        return messageSource.getMessage(
                "welcome",
                new Object[]{name, surname},
                Locale.forLanguageTag(local));
    }


}
