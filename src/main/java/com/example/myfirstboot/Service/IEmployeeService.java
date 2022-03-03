package com.example.myfirstboot.Service;



import com.example.myfirstboot.Entity.Employees;

import java.util.List;

public interface IEmployeeService {
    public List<Employees> getAllEmployees();
    public void addNewEmployee(Employees employees);
    public void deleteEmployee(int id);
    public Employees getFromId(int id);
}
