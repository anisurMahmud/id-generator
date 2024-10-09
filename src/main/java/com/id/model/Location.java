package com.id.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private String locationCode;

    @OneToMany(mappedBy = "location")
    private List<Employee> employee;
}
