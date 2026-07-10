package com.cognizant.ormlearn.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EntityManager entityManager;

    // JPQL Methods

    @Transactional
    public List<Employee> jpqlSelect() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Transactional
    public int jpqlUpdate(int id, double newSalary) {
        Query query = entityManager.createQuery("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id");
        query.setParameter("salary", newSalary);
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Transactional
    public int jpqlDelete(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    // HQL Methods

    @Transactional
    public List<Employee> hqlSelect() {
        Session session = entityManager.unwrap(Session.class);
        SelectionQuery<Employee> query = session.createSelectionQuery("FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Transactional
    public int hqlUpdate(int id, double newSalary) {
        Session session = entityManager.unwrap(Session.class);
        MutationQuery query = session.createMutationQuery("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id");
        query.setParameter("salary", newSalary);
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Transactional
    public int hqlDelete(int id) {
        Session session = entityManager.unwrap(Session.class);
        MutationQuery query = session.createMutationQuery("DELETE FROM Employee e WHERE e.id = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Transactional
    public int hqlInsert(int newId, String newName, double newSalary) {
        Session session = entityManager.unwrap(Session.class);
        MutationQuery query = session.createMutationQuery(
                "INSERT INTO Employee (id, name, salary, permanent) VALUES (:id, :name, :salary, true)"
        );
        query.setParameter("id", newId);
        query.setParameter("name", newName);
        query.setParameter("salary", newSalary);
        return query.executeUpdate();
    }
}
