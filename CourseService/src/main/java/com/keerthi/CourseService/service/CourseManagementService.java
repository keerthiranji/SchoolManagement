package com.keerthi.CourseService.service;

import com.keerthi.CourseService.exception.CourseNotFoundException;
import com.keerthi.CourseService.model.Course;
import com.keerthi.CourseService.repo.CourseManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseManagementService {

    @Autowired
    CourseManagementRepository courseManagementRepository;

    public Course addCourse(Course course)
    {
        return courseManagementRepository.save(course);
    }

    public List<Course> getAllCourses()
    {
        return courseManagementRepository.findAll() ;
    }

    public Course getCourse (Long id){
       Optional<Course> course = courseManagementRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        }
        throw new CourseNotFoundException("Course not found for the id " + id);
    }

    public boolean deleteCourse(Long id){
        Optional<Course> course = courseManagementRepository.findById(id);
        if (course.isPresent()) {
            courseManagementRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public String editCourse(Course course){
        Optional<Course> courseFromDB = courseManagementRepository.findById(course.getId());
        if (courseFromDB.isPresent()) {
            Course course1 = courseFromDB.get();
            course1.setName(course.getName());
            courseManagementRepository.save(course1);
            return "Course details  updated for this id: " + course.getId();
        }
        return "Course not found with this id: " + course.getId();
    }

}
