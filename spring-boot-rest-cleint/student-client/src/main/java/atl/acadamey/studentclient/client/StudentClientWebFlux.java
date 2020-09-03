package atl.acadamey.studentclient.client;

import atl.acadamey.studentclient.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StudentClientWebFlux {

    private final WebClient webClient;

    public StudentClientWebFlux(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9999/api/v1").build();
    }

    public Mono<Student> studentById(Long id) {
        return webClient.get()
                .uri("/student/" + id)
                .retrieve()
                .bodyToMono(Student.class);
    }


    public Flux<Student> getList() {
        return webClient.get()
                .uri("/student/list")
                .retrieve()
                .bodyToFlux(Student.class);
    }

    public Student save(Student student) {
        log.info("student {} ", student);
        Student student1 = webClient.post().uri("/student")
                .bodyValue(student).retrieve().bodyToMono(Student.class).block();
        log.info("Student saved {} ", student1);
        return student1;
    }
}
