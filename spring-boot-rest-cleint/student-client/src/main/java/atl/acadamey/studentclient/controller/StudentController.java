package atl.acadamey.studentclient.controller;

import atl.acadamey.studentclient.client.StudentClientRestTemplate;
import atl.acadamey.studentclient.client.StudentClientWebFlux;
import atl.acadamey.studentclient.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    StudentClientRestTemplate studentClientRestTemplate;
    StudentClientWebFlux studentClientWebFlux;

    public StudentController(StudentClientRestTemplate studentClientRestTemplate, StudentClientWebFlux studentClientWebFlux) {
        this.studentClientRestTemplate = studentClientRestTemplate;
        this.studentClientWebFlux = studentClientWebFlux;
    }

    @GetMapping("/student/list")
    public String getStudentList(Model model){
         //model.addAttribute("list" ,studentClientRestTemplate.studentList());

        List<Student>  list  =studentClientWebFlux.getList().collectList().block();
        model.addAttribute("list",list);
        return "studentlist";
    }
    @GetMapping("/student/{id}")
    public String getStudentList(Model model, @PathVariable Long id){
       // model.addAttribute("student" ,studentClientRestTemplate.studentById(id));

        Student student=studentClientWebFlux.studentById(id).block();
        model.addAttribute("student",student);
        return "student-detail";
    }

    @GetMapping("/student/add")
    public String addStudent(Model model){
        model.addAttribute("student" ,new Student());
        return "student";
    }
    @PostMapping("/student")
    public String addStudent(Model model, @ModelAttribute Student student ){

       // studentClientRestTemplate.save(student);
        studentClientWebFlux.save(student);
        return "redirect:/student/list";
    }
}
