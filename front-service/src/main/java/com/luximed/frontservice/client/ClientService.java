package com.luximed.frontservice.client;

import com.luximed.frontservice.dto.AppointmentDto;
import com.luximed.frontservice.dto.PersonalDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-service")
public interface ClientService {

    @GetMapping(value = "/api/client/appointment/all")
    List<AppointmentDto> getAppointments();

    @GetMapping(value = "/api/client/appointment/{id}")
    AppointmentDto getAppointmentById(@PathVariable Integer id);

    @GetMapping(value = "/api/client/appointment/patient/{pesel}")
    List<AppointmentDto> getAppointmentsByPesel(@PathVariable String pesel);

    @GetMapping(value = "/api/client/personalData/{pesel}")
    PersonalDataDto getPersonalDataByPesel(@PathVariable String pesel);
}
