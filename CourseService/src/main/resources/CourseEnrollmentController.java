package com.keerthi.tamilSchool.controller;

import com.keerthi.tamilSchool.model.Enrollment;
import com.keerthi.tamilSchool.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseEnrollmentController {

      //  List<Enrollment> courseList = new ArrayList<>();

    @Autowired
    CourseEnrollmentService courseEnrollmentService;

    @PostMapping("/enroll")
    ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(courseEnrollmentService.enrollCourse(enrollment), HttpStatus.CREATED);
    }

    @GetMapping("/enroll")
    ResponseEntity<List<Enrollment>> getEnrollments() {
        return ResponseEntity.status(200).body(courseEnrollmentService.getAllEnrollments());
    }

//    @GetMapping("/course/{id}")
//    ResponseEntity<Enrollment> getEnrollment(@PathVariable Long id) {
//       return new ResponseEntity<>(courseEnrollmentService.getEnrollment(id), HttpStatus.OK);
//    }

    @DeleteMapping("/enroll/{id}")
    ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
        courseEnrollmentService.deleteEnrollment(id);
        return ResponseEntity.status(404).body("course deleted for the id: " + id);
    }
    
//    @PutMapping("/course")
//    ResponseEntity<String> updateEnrollment(@RequestBody Enrollment enrollment){
//        return ResponseEntity.status(200).body(courseEnrollmentService.editEnrollment(enrollment));
//
//    }
}


