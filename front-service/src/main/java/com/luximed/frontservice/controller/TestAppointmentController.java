package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClientService;
import com.luximed.frontservice.dto.AppointmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestAppointmentController {
    private final ClientService clientService;

    public TestAppointmentController(ClientService
     clientService) {
        this.clientService = clientService;
    }

    @GetMapping("calendar")
    public String getCalendarAllAppointments() {
        return "calendar";
    }

    @GetMapping("appointment/all")
    @ResponseBody
    public List<AppointmentDto> getAppointments() {
        return clientService.getAppointments();
    }

    @RequestMapping(method = RequestMethod.GET, value = "appointment/{id}")
    @ResponseBody
    public AppointmentDto getAppointmentById(@PathVariable Integer id) {
        return clientService.getAppointmentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "appointment/patient/{pesel}")
    @ResponseBody
    public List<AppointmentDto> getAppointmentsByPesel(@PathVariable String pesel) {
        return clientService.getAppointmentsByPesel(pesel);
    }

}
