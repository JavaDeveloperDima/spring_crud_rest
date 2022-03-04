package com.example.myfirstboot.Controller;

import com.example.myfirstboot.Entity.Employees;
import com.example.myfirstboot.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping()
    public String getAll(Model model){
        List<Employees> list = employeeService.getAllEmployees();
        model.addAttribute("employeeList",list);
        return "showAllEmployee";
    }
    @GetMapping("/{id}")
    public String getFromId(@PathVariable int id,Model model){
        model.addAttribute("employee",employeeService.getFromId(id));
        return "showInfo";

    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id,Model model){
        Employees employee = employeeService.getFromId(id);
        model.addAttribute("employee" +
                "",employee);
        return "edit";
    }
    @GetMapping("/new")
    public String addNewEmployees(Model model){
        Employees employees = new Employees();
        model.addAttribute("employee",employees);
        return "addEmployee";
    }
    @PostMapping()
    public String updateEmployees(@ModelAttribute("employee")Employees employees){
        employeeService.addNewEmployee(employees);
        return "redirect:/api";
    }
    @PostMapping("/delete/{id}")
    public String deleteEmpl(@PathVariable int id){
        Employees employees = employeeService.getFromId(id);
        employeeService.deleteEmployee(id);
        return "redirect:/api";
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("employee")Employees employees){//@PathVariable("id")int id){
        employeeService.addNewEmployee(employees);
        return "redirect:/api";
    }

}
