package az.atlacademy.testing;

import az.atlacademy.testing.controller.PageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PageControllerTest {
    @Autowired
    PageController pageController;

    @Test
    public void test_checkController() {
        assertThat(pageController).isNotNull();
    }
}
