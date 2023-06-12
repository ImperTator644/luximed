package com.luximed.reservation.controller;

import com.luximed.reservation.Exception.IllegalAppointmentTimeException;
import com.luximed.reservation.client.DatabaseClient;
import com.luximed.reservation.dto.AppointmentDto;
import com.luximed.reservation.dto.AppointmentTypeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    private final DatabaseClient databaseClient;


    public AppointmentController(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @PostMapping(value = "add")
    public void addAppointment(@RequestParam Integer patientId,
                              @RequestParam String date,
                              @RequestParam String dateTime,
                              @RequestParam Integer clinicId,
                              @RequestParam Integer doctorId,
                              @RequestParam Integer appointmentTypeId) throws IllegalAppointmentTimeException {

        LocalDate appointmentDate = LocalDate.parse(date);
        Integer duration = getAppointmentTypeById(appointmentTypeId).getDuration();
        LocalTime start = LocalTime.parse(dateTime);
        LocalTime end = LocalTime.parse(dateTime).plusMinutes(duration);

        List<AppointmentDto> doctorAppointments = getAppointmentsByDoctorId(doctorId);
        List<AppointmentDto> doctorAppointmentsToday = doctorAppointments.stream()
                .filter(d -> d.getDate().equals(appointmentDate))
                .collect(Collectors.toList());

        for (AppointmentDto dto : doctorAppointmentsToday){
            if (!((dto.getStart().isAfter(start) && dto.getStart().isAfter(end)) || (dto.getStart().isBefore(start) && dto.getEnd().isBefore(start)))){
                throw new IllegalAppointmentTimeException("Doctor have another appointment at this time. Choose different time");
            }
        }
        databaseClient.addAppointment(patientId, date, dateTime, clinicId, doctorId, appointmentTypeId);
    }

    @GetMapping(value = "{id}")
    public AppointmentDto getAppointment(@PathVariable Integer id){
        AppointmentDto appointment = databaseClient.getAppointment(id);
        appointment.setTitle(appointment.getAppointmentType().getName() + " - " +
                appointment.getDoctor().getPersonalData().getName() + " " +
                appointment.getDoctor().getPersonalData().getSurname());
        appointment.setStart(appointment.getTime());
        appointment.setEnd(appointment.getTime().plusMinutes(appointment.getAppointmentType().getDuration()));

        return appointment;
    }

    @GetMapping(value = "/type/{id}")
    public AppointmentTypeDto getAppointmentTypeById(@PathVariable Integer id){
        return databaseClient.getAppointmentTypeById(id);
    }

    @GetMapping(value = "/spec/{specialization}")
    public List<AppointmentTypeDto> getAppointmentTypeBySpec(@PathVariable String specialization){
        return databaseClient.getAppointmentTypeBySpec(specialization);
    }

    @GetMapping (value = "/doctor/{id}")
    public List<AppointmentDto> getAppointmentsByDoctorId(@PathVariable Integer id) {
        List<AppointmentDto> list = databaseClient.getAppointmentsByDoctorId(id);
        for(AppointmentDto dto : list){
            dto.setTitle(dto.getAppointmentType().getName() + " - " +
                    dto.getDoctor().getPersonalData().getName() + " " +
                    dto.getDoctor().getPersonalData().getSurname());
            dto.setStart(dto.getTime());
            dto.setEnd(dto.getTime().plusMinutes(dto.getAppointmentType().getDuration()));
        }
        return list;
    }
}
