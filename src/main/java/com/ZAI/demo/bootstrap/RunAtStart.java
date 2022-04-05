package com.ZAI.demo.bootstrap;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.PaymentCardRepository;
import com.ZAI.demo.repository.UsersRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Data
public class RunAtStart {

    private final PaymentCardRepository paymentCardRepository;
    private final UsersRepository usersRepository;

    @PostConstruct
    public void initUser() {

        Users user1 = new Users(null, "Pankracy", "123", LocalDate.now(),
                "pankracy@gmail.com", "USER", null, null);
        usersRepository.save(user1);

        PaymentCard paymentCard = new PaymentCard(123123123L, LocalDate.now(), "334", user1, null);
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
