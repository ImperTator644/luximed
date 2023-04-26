package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClinicClient;
import com.luximed.frontservice.dto.AppointmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestAppointmentController {
    private final ClinicClient clinicClient;

    public TestAppointmentController(ClinicClient clinicClient) {
        this.clinicClient = clinicClient;
    }

    @GetMapping("calendar")
    public String getCalendarAllAppointments() {
        return "calendar";
    }


    @GetMapping("appointment/all")
    @ResponseBody
    public List<AppointmentDto> getAppointments() {
        List<AppointmentDto> list = clinicClient.getAppointments();
        for(AppointmentDto dto : list){
            dto.setTitle(dto.getAppointmentType().getName() + " - " +
                    dto.getPatient().getPersonalData().getName() + " " +
                    dto.getPatient().getPersonalData().getSurname());
            dto.setStart(dto.getTime());
            dto.setEnd(dto.getTime().plusMinutes(dto.getAppointmentType().getDuration()));
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "appointment/{id}")
    @ResponseBody
    public AppointmentDto getAppointmentById(@PathVariable Integer id) {
        return clinicClient.getAppointmentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "appointment/patient/{id}")
    @ResponseBody
    public List<AppointmentDto> getAppointmentsByPatientId(@PathVariable Integer id) {
        List<AppointmentDto> list = clinicClient.getAppointmentsByPatientId(id);
        for(AppointmentDto dto : list){
            dto.setTitle(dto.getAppointmentType().getName() + " - " +
                    dto.getPatient().getPersonalData().getName() + " " +
                    dto.getPatient().getPersonalData().getSurname());
            dto.setStart(dto.getTime());
            dto.setEnd(dto.getTime().plusMinutes(dto.getAppointmentType().getDuration()));
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, value = "appointment/patient")
    public ModelAndView getAppointmentsByPatientIdTwo(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("calendar");
        mav.addObject("id", id);

        return mav;
    }


}
