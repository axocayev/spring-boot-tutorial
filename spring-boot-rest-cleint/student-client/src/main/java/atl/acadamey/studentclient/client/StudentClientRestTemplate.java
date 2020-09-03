package atl.acadamey.studentclient.client;

import atl.acadamey.studentclient.domain.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class StudentClientRestTemplate {


    private final String BASE_URL = "http://localhost:9999/api/v1";
    private RestTemplate restTemplate;

    public StudentClientRestTemplate(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public Student studentById(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(BASE_URL + "/student/" + id, HttpMethod.GET, entity, Student.class).getBody();
    }

    public List<Student> studentList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        Student students[] = restTemplate.exchange(BASE_URL + "/student/list",
                HttpMethod.GET,
                entity,
                Student[].class).getBody();

        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        return studentList;

    }

    public Student save(Student student) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(student,headers);
        Student students = restTemplate.exchange(BASE_URL + "/student",
                HttpMethod.POST,
                entity,
                Student.class).getBody();


        return students;

    }


}
