package com.ZAI.demo.bootstrap;

import com.ZAI.demo.models.Department;
import com.ZAI.demo.models.Employee;
import com.ZAI.demo.repository.DepartmentRepository;
import com.ZAI.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.annotation.PostConstruct;
@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public RunAtStart(@Autowired EmployeeRepository employeeRepository, @Autowired DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void initUser() {

        Department department1 = new Department("RND");
        departmentRepository.save(department1);

        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));

        List<Employee> employees = employeeRepository.findAllWhereName("Pan");

        for (Employee emp: employees) {
            System.out.println(emp);
        }


    }
}
