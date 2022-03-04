package com.example.myfirstboot.DAO;


import com.example.myfirstboot.Entity.Employees;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOClass implements DAOInterface{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employees> getAllEmployees() {
        Query query = entityManager.createQuery("from Employees");
        List<Employees> employeesList = query.getResultList();
        return employeesList;
    }

    @Override
    public void addEployee(Employees employees) {
        Employees employees1 = entityManager.merge(employees);
        employees.setId(employees1.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.remove(entityManager.find(Employees.class,id));
    }

    @Override
    public Employees getFromId(int id) {
       Employees employees = entityManager.find(Employees.class,id);
       return employees;
    }

}
