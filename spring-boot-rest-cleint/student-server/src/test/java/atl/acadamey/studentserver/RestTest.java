package atl.acadamey.studentserver;

import atl.acadamey.studentserver.model.Student;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RestTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @DisplayName("Check student Anar")
    @Test
    public void testStudent() throws Exception {
        ResponseEntity<Student> rspn = testRestTemplate.getForEntity("/api/v1/student/2", Student.class);

        assertThat(rspn.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(rspn.getBody().getName()).isEqualTo("Anar");

    }
}
