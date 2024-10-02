package com.keerthi.tamilSchool.service;

import com.keerthi.tamilSchool.model.Enrollment;
import com.keerthi.tamilSchool.model.Student;
import com.keerthi.tamilSchool.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    CourseManagementFeignClient courseManagementFeignClient;

    WebClient webClient = WebClient.builder().build();

    public void enrollCourse(Enrollment enrollment) {
//        courseManagementFeignClient.enrollCourse(enrollment);

        ResponseEntity<Enrollment> enrollmentPacket = restTemplate
                .postForEntity("http://localhost:9090/enroll", enrollment, Enrollment.class);

        System.out.println("Enrollment packet received:" + enrollmentPacket.getBody());
        System.out.println("do some other work");

//       Mono<Enrollment> enrollmentMono = webClient.post().uri("http://localhost:9090/enroll")
//               .bodyValue(enrollment)
//               .retrieve()
//               .bodyToMono(Enrollment.class);
//
//       System.out.println("do some other work");
//
//       enrollmentMono.subscribe(System.out::println);q
    }

    public Student addData(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll() ;
    }

    public Student getStudent (Long id){
       Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public boolean deleteStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public String editStudent(Student student){
        Optional<Student> studentFromDB = studentRepository.findById(student.getId());
        if (studentFromDB.isPresent()) {
            Student student1 = studentFromDB.get();
            student1.setName(student.getName());
            studentRepository.save(student1);
            return "Student details  updated for this id: " + student.getId();
        }
        return "Student not found with this id: " + student.getId();
    }


}
