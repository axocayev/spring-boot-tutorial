package atl.acadamey.studentserver.controller;

import atl.acadamey.studentserver.model.Student;
import atl.acadamey.studentserver.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {

    private StudentRepository studentRepository;
    public UserController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable Long id){
        log.info("id {}" ,id);
        Student student=studentRepository.getOne(id);
        log.info("stduent {} " ,student);
        return student;
    }
    @GetMapping("/student/list")
    public List<Student> getList(){

        List<Student> students= studentRepository.findAll();
        log.info("stduents {} " ,students);

        return students;
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody  Student student){
        log.info("student {}" ,student);
        Student studentsaved=studentRepository.save(student);
        log.info("studentsaved {} " ,studentsaved);
        return studentsaved;
    }



}
