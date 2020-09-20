package az.atlacademy.testing;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PageMappingTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_ControllerMapping() throws Exception{
    assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/home",String.class ))
            .isEqualTo("Hello World");
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/home",String.class ))
                .contains("ll");

    }
}
