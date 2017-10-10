package org.vs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @RequestMapping("/employees/{empId}")
    public ResponseEntity getEmployee(@PathVariable("empId") String empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @RequestMapping("/refresh")
    public ResponseEntity refreshCache() {
        return ResponseEntity.ok(employeeService.refreshCache());
    }

}
