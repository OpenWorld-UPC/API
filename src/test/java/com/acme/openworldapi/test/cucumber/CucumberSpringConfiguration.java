package com.acme.openworldapi.test.cucumber;

import com.acme.openworldapi.OpenWorldApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(
        classes = OpenWorldApiApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(
        classes = OpenWorldApiApplication.class,
        loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
