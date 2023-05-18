package com.luximed.client.controller;

import com.luximed.client.appointment.ClientDatabase;
import com.luximed.client.dto.AppointmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/client/appointment")
public class AppointmentController {
    private final ClientDatabase client;

    public AppointmentController(ClientDatabase client) {
        this.client = client;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<AppointmentDto> getAppointments() {
        List<AppointmentDto> list = client.getAppointments();
        for(AppointmentDto dto : list){
            dto.setTitle(dto.getAppointmentType().getName() + " - " +
                    dto.getPatient().getPersonalData().getName() + " " +
                    dto.getPatient().getPersonalData().getSurname());
            dto.setStart(dto.getTime());
            dto.setEnd(dto.getTime().plusMinutes(dto.getAppointmentType().getDuration()));
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public AppointmentDto getAppointmentById(@PathVariable Integer id) {
        return client.getAppointmentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
    @ResponseBody
    public List<AppointmentDto> getAppointmentsByPatientId(@PathVariable Integer id) {
        List<AppointmentDto> list = client.getAppointmentsByPatientId(id);
        for(AppointmentDto dto : list){
            dto.setTitle(dto.getAppointmentType().getName() + " - " +
                    dto.getPatient().getPersonalData().getName() + " " +
                    dto.getPatient().getPersonalData().getSurname());
            dto.setStart(dto.getTime());
            dto.setEnd(dto.getTime().plusMinutes(dto.getAppointmentType().getDuration()));
        }
        return list;
    }
}
