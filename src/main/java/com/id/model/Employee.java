package com.id.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
}
