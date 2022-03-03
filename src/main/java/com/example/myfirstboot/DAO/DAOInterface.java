package com.example.myfirstboot.DAO;


import com.example.myfirstboot.Entity.Employees;

import java.util.List;

public interface DAOInterface {
    public List<Employees> getAllEmployees();
    public void addEployee(Employees employees);
    public void deleteEmployee(int id);
    public Employees getFromId(int id);
}
