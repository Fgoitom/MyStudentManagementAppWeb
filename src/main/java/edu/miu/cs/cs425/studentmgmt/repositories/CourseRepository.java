package edu.miu.cs.cs425.studentmgmt.repositories;

import edu.miu.cs.cs425.studentmgmt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
