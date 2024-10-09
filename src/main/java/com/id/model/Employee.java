package com.id.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String firstName;
    @Setter
    private String surname;
    @Setter
    private String customId;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
}
