package com.keerthi.CourseService.controller;

import com.keerthi.CourseService.model.Course;
import com.keerthi.CourseService.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseManagementController {

      //  List<Course> courseList = new ArrayList<>();

    @Autowired
    CourseManagementService courseManagementService;

    @PostMapping("/course")
    ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseManagementService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.status(200).body(courseManagementService.getAllCourses());
    }

    @GetMapping("/course/{id}")
    ResponseEntity<Course> getCourse(@PathVariable Long id) {
       return new ResponseEntity<>(courseManagementService.getCourse(id), HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseManagementService.deleteCourse(id);
        return ResponseEntity.status(404).body("course deleted for the id: " + id);
    }
    
    @PutMapping("/course")
    ResponseEntity<String> updateCourse(@RequestBody Course course){
        return ResponseEntity.status(200).body(courseManagementService.editCourse(course));

    }
}


