package com.luximed.model;

import javax.persistence.*;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;
}
