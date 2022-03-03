package com.example.myfirstboot.Controller;

import com.example.myfirstboot.Entity.Employees;
import com.example.myfirstboot.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employees> getAll(){
        List<Employees> list = employeeService.getAllEmployees();
        return list;
    }
    @GetMapping("/employees/{id}")
    public Employees getFromId(@PathVariable int id){
        return employeeService.getFromId(id);
    }
    @PostMapping("/employees")
    public Employees addNewEmployees(@RequestBody Employees employees){
        employeeService.addNewEmployee(employees);
        return employees;
    }
    @PutMapping("/employees")
    public Employees updateEmployees(@RequestBody Employees employees){
        employeeService.addNewEmployee(employees);
        return employees;
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmpl(@PathVariable int id){
        Employees employees = employeeService.getFromId(id);
        employeeService.deleteEmployee(id);
    }

}
