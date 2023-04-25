package com.luximed.repository;

import com.luximed.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT * FROM Appointment a WHERE a.patient_id = ?1",nativeQuery = true)
    List<Appointment> getAppointmentsByPatientId(Integer id);

    @Query(value = "SELECT * FROM Appointment a WHERE a.patient_id = ?1",nativeQuery = true)
    List<Appointment> getAppointmentsByPatientIdTwo(String id);
}
