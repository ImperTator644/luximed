package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClientService;
import com.luximed.frontservice.client.ClinicClient;
import com.luximed.frontservice.dto.AppointmentDto;
import com.luximed.frontservice.dto.PatientDto;
import com.luximed.frontservice.dto.PersonalDataDto;
import com.luximed.frontservice.model.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClinicClient clinicClient;
    private final ClientService clientService;
    private final CurrentUser currentUser;

    @GetMapping("patient/all")
    @ResponseBody
    public List<PatientDto> getPatients(){
        return clinicClient.getPatients();
    }

    @GetMapping("profile")
    public ModelAndView getPatient(){
        ModelAndView mav = new ModelAndView("user-profile");
        PersonalDataDto dataDto = clientService.getPersonalDataByPesel(currentUser.getUserName());
        mav.addObject("user",dataDto);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "my-calendar")
    public ModelAndView getMyCalendar() {
        ModelAndView mav = new ModelAndView("calendar");
        mav.addObject("pesel", currentUser.getUserName());
        return mav;
    }

}
