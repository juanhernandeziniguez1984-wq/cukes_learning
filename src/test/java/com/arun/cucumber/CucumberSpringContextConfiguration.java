package com.arun.cucumber;


import cucumber.api.java.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = App.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);

    @Before
    public void setUp() {
        LOGGER.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}
