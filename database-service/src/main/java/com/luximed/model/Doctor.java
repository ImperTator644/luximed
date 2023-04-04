package com.luximed.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(nullable = false)
    private PersonalData personalData;

    @ManyToMany
    @JoinColumn(nullable = false)
    private List<Specialization> specialization;
}
