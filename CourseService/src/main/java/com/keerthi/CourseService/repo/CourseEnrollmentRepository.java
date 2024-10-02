package com.keerthi.CourseService.repo;

import com.keerthi.CourseService.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<Enrollment, Long> {


}
