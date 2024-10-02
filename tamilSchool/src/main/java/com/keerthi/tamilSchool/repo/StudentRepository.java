package com.keerthi.tamilSchool.repo;

import com.keerthi.tamilSchool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query(value = "update StudentTable st set st.name = ? where st.id = ?", nativeQuery = true)
    void updateName( String firstName,Long id);

}
