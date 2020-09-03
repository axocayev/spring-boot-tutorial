package atl.acadamey.studentclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
