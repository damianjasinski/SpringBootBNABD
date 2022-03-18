package com.ZAI.demo.repository;

import com.ZAI.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %?1")
    List<Employee> findAllWhereName(String username);


    //List<User> findByUsername(String username);
}