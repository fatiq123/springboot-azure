package org.spring.springapi.service;

import org.spring.springapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> items = new ArrayList<>();
    private Long currentId = 1L;

    public List<Employee> findAll() {
        return items;
    }

    public Optional<Employee> findById(Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public Employee save(Employee item) {
        item.setId(currentId++);
        items.add(item);
        return item;
    }

    public Optional<Employee> update(Long id, Employee item) {
        return findById(id).map(existingItem -> {
            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            return existingItem;
        });
    }

    public boolean deleteById(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }


}
