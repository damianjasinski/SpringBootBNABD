package com.ZAI.demo.bootstrap;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.PaymentCardRepository;
import com.ZAI.demo.repository.UsersRepository;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@Data
public class RunAtStart {

    private final PaymentCardRepository paymentCardRepository;
    private final UsersRepository usersRepository;

    @PostConstruct
    public void initUser() {

        Users user1 = new Users(null, "Pankracy", "$2a$12$tQdopFPcVGF5h5VQbf3fAuaZHCoP1s6pXNR6EhOARxU3Hr4xNWXVu", LocalDate.now(),
                "pankracy@gmail.com", "USER", null, null);
        usersRepository.save(user1);
        Users user2 = new Users(null, "Pankraxcy", "$2a$12$tQdopFPcVGF5h5VQbf3fAuaZHCoP1s6pXNR6EhOARxU3Hr4xNWXVu", LocalDate.now(),
                "pankrdacy@gmail.com", "USER", null, null);
        usersRepository.save(user2);
        Users user3 = new Users(null, "panek", "$2a$12$tQdopFPcVGF5h5VQbf3fAuaZHCoP1s6pXNR6EhOARxU3Hr4xNWXVu", LocalDate.now(),
                "panek@gmail.com", "ADMIN", null, null);
        usersRepository.save(user3);

        PaymentCard paymentCard = new PaymentCard("1234123412341234", LocalDate.now(), "334", user1, null);
        paymentCardRepository.save(paymentCard);

//        Department department1 = new Department("RND");
//        departmentRepository.save(department1);
//
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//        employeeRepository.save(new Employee("Pan", "Kracy", 1234, department1));
//
//
//        List<Employee> employees = employeeRepository.findAllWhereName("Pan");
//
//        for (Employee emp: employees) {
//            System.out.println(emp);
//        }



    }
}
