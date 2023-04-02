package com.luximed.model;

import javax.persistence.*;

@Entity
public class AppointmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Specialization specialization;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer duration;
}
