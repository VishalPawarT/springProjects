package org.techames;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techames.app.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SpringContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
