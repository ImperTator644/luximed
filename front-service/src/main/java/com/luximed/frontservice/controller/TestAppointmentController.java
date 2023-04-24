package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClinicClient;
import com.luximed.frontservice.dto.AppointmentDto;
import com.luximed.frontservice.dto.PatientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestAppointmentController {
    private final ClinicClient clinicClient;

    public TestAppointmentController(ClinicClient clinicClient) {
        this.clinicClient = clinicClient;
    }

    @GetMapping("calendar")
    public String getCalendar(){
        return "calendar";
    }


    @GetMapping("appointment/all")
    @ResponseBody
    public List<AppointmentDto> getAppointments(){
        return clinicClient.getAppointments();
    }

    @GetMapping("patient/all")
    @ResponseBody
    public List<PatientDto> getPatients(){
        return clinicClient.getPatients();
    }
}
