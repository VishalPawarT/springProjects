package org.techames;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techames.reactive.security.SpringSecurity5Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSecurity5Application.class)
public class SpringContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
