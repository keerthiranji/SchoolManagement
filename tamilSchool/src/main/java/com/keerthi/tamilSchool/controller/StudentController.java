package com.keerthi.tamilSchool.controller;

import com.keerthi.tamilSchool.model.Enrollment;
import com.keerthi.tamilSchool.model.Student;
import com.keerthi.tamilSchool.repo.StudentRepository;
import com.keerthi.tamilSchool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
public class StudentController {

      //  List<Student> studentList = new ArrayList<>();

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    ResponseEntity<Student> createStudent(@RequestBody Student student) {

        return ResponseEntity.status(200).body(studentService.addData(student));
    }

    @PostMapping("/enroll")
    ResponseEntity<Void>enrollCourse(@RequestBody Enrollment enrollment) {
        studentService.enrollCourse(enrollment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents() throws InterruptedException {
        Thread.sleep(5000L);
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    ResponseEntity<Student> getStudent(@PathVariable Long id) {
        studentService.getStudent(id);
       return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/student/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(404).body("student deleted for the id: " + id);
    }
    
    @PutMapping("/student")
    ResponseEntity<String> updateStudent(@RequestBody Student student){
        return ResponseEntity.status(200).body(studentService.editStudent(student));

    }
}


