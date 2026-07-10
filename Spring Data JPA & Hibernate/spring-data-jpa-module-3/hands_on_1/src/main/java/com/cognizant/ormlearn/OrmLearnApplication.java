package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService service = context.getBean(EmployeeService.class);

        System.out.println("--- JPQL SELECT ---");
        System.out.println(service.jpqlSelect());

        System.out.println("--- JPQL UPDATE (id=1, salary=60000) ---");
        System.out.println(service.jpqlUpdate(1, 60000.0) + " row(s) updated");

        service.hqlInsert(999, "Kalyan Ranjan", 100.0);
        System.out.println("--- JPQL DELETE (id=999) ---");
        System.out.println(service.jpqlDelete(999) + " row(s) deleted");

        System.out.println("--- HQL INSERT (id=888, name=Kalyan Ranjan, salary=150) ---");
        System.out.println(service.hqlInsert(888, "Kalyan Ranjan", 150.0) + " row(s) inserted");

        System.out.println("--- HQL SELECT ---");
        System.out.println(service.hqlSelect());

        System.out.println("--- HQL UPDATE (id=888, salary=200) ---");
        System.out.println(service.hqlUpdate(888, 200.0) + " row(s) updated");

        System.out.println("--- HQL DELETE (id=888) ---");
        System.out.println(service.hqlDelete(888) + " row(s) deleted");
    }
}
