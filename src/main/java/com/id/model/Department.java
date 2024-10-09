package com.id.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String departmentName;
    @Setter
    private String departmentCode;

    @OneToMany(mappedBy = "department")
    private List<Employee> employee;
}
