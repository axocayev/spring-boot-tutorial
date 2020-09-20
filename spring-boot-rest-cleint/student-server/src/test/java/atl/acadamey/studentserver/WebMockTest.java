package atl.acadamey.studentserver;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import atl.acadamey.studentserver.controller.HomePageController;
import atl.acadamey.studentserver.controller.UserController;
import atl.acadamey.studentserver.model.Student;
import atl.acadamey.studentserver.repository.StudentRepository;
import atl.acadamey.studentserver.service.StudentService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomePageController.class)
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService service;
    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.hello()).thenReturn("Hello, World");
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }
}
