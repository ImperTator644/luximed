package com.luximed.client.appointment;

import com.luximed.client.dto.AppointmentDto;
import com.luximed.client.dto.PersonalDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "database-service")
public interface ClientDatabase {

    @GetMapping(value = "/api/database/appointment/all")
    List<AppointmentDto> getAppointments();

    @GetMapping(value = "/api/database/appointment/{id}")
    AppointmentDto getAppointmentById(@PathVariable Integer id);

    @GetMapping(value = "/api/database/personalData/{pesel}")
    PersonalDataDto getPersonalDataByPesel(@PathVariable String pesel);

    @GetMapping(value = "/api/database/appointment/patient/{pesel}")
    List<AppointmentDto> getAppointmentsByPesel(@PathVariable String pesel);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/database/personalData/update")
    ResponseEntity<String> updatePersonalData(@RequestBody PersonalDataDto personalDataDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/database/personalData/delete")
    ResponseEntity<String> deletePersonaldata(@RequestParam String pesel);
}
