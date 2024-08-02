package org.spring.springapi.controller;

import org.spring.springapi.model.Employee;
import org.spring.springapi.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EmployeeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome to the Employee API";
    }

    EmployeeService employeeService;

    public EmployeeController(EmployeeService itemService) {
        this.employeeService = itemService;
    }

    @GetMapping
    public List<Employee> getAllItems() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getItemById(@PathVariable Long id) {
        Optional<Employee> item = employeeService.findById(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createItem(@RequestBody Employee item) {
        return employeeService.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateItem(@PathVariable Long id, @RequestBody Employee item) {
        Optional<Employee> updatedItem = employeeService.update(id, item);
        return updatedItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = employeeService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
