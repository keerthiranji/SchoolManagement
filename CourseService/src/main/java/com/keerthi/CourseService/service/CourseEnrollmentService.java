package com.keerthi.CourseService.service;
import com.keerthi.CourseService.model.Enrollment;
import com.keerthi.CourseService.repo.CourseEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentService {

    @Autowired
    CourseEnrollmentRepository courseEnrollmentRepository;

    public Enrollment enrollCourse(Enrollment enrollment)
    {
        return courseEnrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments()
    {
        return courseEnrollmentRepository.findAll() ;
    }

//    public Enrollment getEnrollment (Long id){
//       Optional<Enrollment> enrollment = courseEnrollmentRepository.findById(id);
//        if (enrollment.isPresent()) {
//            return enrollment.get();
//        }
//        throw new EnrollmentNo99tFoundException("Enrollment not found for the id " + id);
//    }

    public boolean deleteEnrollment(Long id){
        Optional<Enrollment> enrollment = courseEnrollmentRepository.findById(id);
        if (enrollment.isPresent()) {
            courseEnrollmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

//    public String editEnrollment(Enrollment enrollment){
//        Optional<Enrollment> enrollmentFromDB = courseEnrollmentRepository.findById(enrollment.getEnrollmentId());
//        if (enrollmentFromDB.isPresent()) {
//            Enrollment enrollment1 = enrollmentFromDB.get();
//            enrollment1.setName(enrollment.getName());
//            courseEnrollmentRepository.save(enrollment1);
//            return "Enrollment details  updated for this id: " + enrollment.getEnrollmentId();
//        }
//        return "Enrollment not found with this id: " + enrollment.getEnrollmentId();
//    }

}
