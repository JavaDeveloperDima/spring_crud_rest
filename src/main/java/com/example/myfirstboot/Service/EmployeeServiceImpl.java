package com.example.myfirstboot.Service;

import com.example.myfirstboot.DAO.DAOInterface;
import com.example.myfirstboot.Entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private DAOInterface daoInterface;
    @Override
    @Transactional
    public List<Employees> getAllEmployees() {
        return daoInterface.getAllEmployees();
    }

    @Override
    @Transactional
    public void addNewEmployee(Employees employees){
        daoInterface.addEployee(employees);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        daoInterface.deleteEmployee(id);
    }

    @Override
    @Transactional
    public Employees getFromId(int id) {
       return daoInterface.getFromId(id);
    }
}
