package az.atlacademy.testing;

import az.atlacademy.testing.controller.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyRestTesting {
    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void testStudent() throws Exception {

        ResponseEntity<Customer> rspn = testRestTemplate.getForEntity("/customer", Customer.class);

        assertThat(rspn.getStatusCode()).isEqualTo(HttpStatus.OK);


        assertThat(rspn.getBody().getName()).isEqualTo("Anar");
        assertThat(rspn.getBody().getSurname()).isEqualTo("Xocayev");

}
}
