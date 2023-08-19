package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClientService;
import com.luximed.frontservice.dto.AppointmentDto;
import com.luximed.frontservice.service.CurrentUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {
    private final ClientService clientService;
    private final CurrentUserService currentUserService;

    public AppointmentController(ClientService clientService, CurrentUserService currentUserService) {
        this.clientService = clientService;
        this.currentUserService = currentUserService;
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

    @GetMapping("my/appointments")
    public String getAppointmentsByPatientId(ModelMap map){
        String pesel = currentUserService.getCurrentUser();
        List<AppointmentDto> myAppointments = clientService.getAppointmentsByPesel(pesel);
        map.put("myAppointments", myAppointments);

        return "my-appointments";
    }
}
