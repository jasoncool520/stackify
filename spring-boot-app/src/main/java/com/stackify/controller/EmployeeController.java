package com.stackify.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.stackify.model.Employee;
import com.stackify.repository.EmployeeRepository;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @RequestMapping("/")
    public String getInfo(){
        StringBuffer sb = new StringBuffer();

        try {
            sb.append(Inet4Address.getLocalHost().getHostName()).append("\r\n");
            sb.append(Inet4Address.getLocalHost().getHostAddress()).append("\r\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
