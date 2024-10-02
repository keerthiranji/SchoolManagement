package com.keerthi.tamilSchool.service;
import com.keerthi.tamilSchool.model.Enrollment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Keerthi", url = "http://localhost:9090")
public interface CourseManagementFeignClient {

    @PostMapping("/enroll")
    public ResponseEntity<Enrollment>enrollCourse(@RequestBody Enrollment enrollment);

}
