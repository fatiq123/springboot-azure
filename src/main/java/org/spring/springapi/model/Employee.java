package org.spring.springapi.model;

import lombok.Data;
import lombok.Getter;

@Getter
public class Employee {

    // Getters and Setters
    private Long id;
    private String name;
    private String description;



    // Constructors
    public Employee() {}

    public Employee(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
