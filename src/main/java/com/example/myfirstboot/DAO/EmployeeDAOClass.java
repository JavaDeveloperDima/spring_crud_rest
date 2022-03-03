package com.example.myfirstboot.DAO;


import com.example.myfirstboot.Entity.Employees;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOClass implements DAOInterface{
    private List<Employees> employeesList = new ArrayList<>();
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employees> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        employeesList = session.createQuery("from Employees ").getResultList();
        return employeesList;
    }

    @Override
    public void addEployee(Employees employees) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employees);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(Employees.class,id));
    }

    @Override
    public Employees getFromId(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employees.class,id);
    }

}
