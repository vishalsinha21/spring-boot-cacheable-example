package org.vs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<String, Employee> empMap = new HashMap<>();

    @Autowired
    public EmployeeService() {
        Employee employee1 = new Employee("1", "Vishal");
        Employee employee2 = new Employee("2", "Rajat");
        Employee employee3 = new Employee("3", "Nishant");

        empMap.put("1", employee1);
        empMap.put("2", employee2);
        empMap.put("3", employee3);

    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(empMap.values());
    }

    @Cacheable("employees")
    public Employee getEmployeeById(String empId) {
        System.out.println("getting employee by id");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return empMap.get(empId);
    }

    @CacheEvict(value = "employees", allEntries = true)
    public String refreshCache() {
        return "Cache refreshed";
    }

}
