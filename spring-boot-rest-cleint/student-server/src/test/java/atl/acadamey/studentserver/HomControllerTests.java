package atl.acadamey.studentserver;

import atl.acadamey.studentserver.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HomControllerTests {
    @Autowired
    UserController userController;
    @Test
    public void contexLoads() throws Exception {
        assertThat(userController).isNotNull();
    }
}
