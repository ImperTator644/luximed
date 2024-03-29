package com.luximed.reservation.client;

import com.luximed.reservation.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="database-service")
public interface DatabaseClient {
    @GetMapping(value="api/database/specialization/all")
    List<SpecializationDto> getAllSpecializations();

    @GetMapping(value="api/database/clinic/by-city/{city}")
    List<ClinicDto> getClinicsByCity(@PathVariable String city);

    @GetMapping(value = "api/database/doctor/by-spec/{specialization}")
    List<DoctorDto> getDoctorsBySpecialization(@PathVariable String specialization);

    @GetMapping(value = "api/database/doctor/by-city/{city}")
    List<DoctorDto> getDoctorsByCity(@PathVariable String city);

    @GetMapping(value = "api/database/doctor/by-city-and-spec")
    List<DoctorDto> getDoctorsBySpecializationAndCity(@RequestParam String specialization, @RequestParam String city);

    @PostMapping(value = "api/database/appointment/add")
    void addAppointment(@RequestParam Integer patientId,
                        @RequestParam String date,
                        @RequestParam String dateTime,
                        @RequestParam Integer clinicId,
                        @RequestParam Integer doctorId,
                        @RequestParam Integer appointmentTypeId);

    @GetMapping(value = "api/database/appointment/{id}")
    AppointmentDto getAppointment(@PathVariable Integer id);

    @GetMapping(value = "api/database/appointmentType/{id}")
    AppointmentTypeDto getAppointmentTypeById(@PathVariable Integer id);

    @GetMapping(value = "api/database/appointmentType/spec/{specialization}")
    List<AppointmentTypeDto> getAppointmentTypeBySpec(@PathVariable String specialization);

    @GetMapping(value = "/api/database/appointment/doctor/{id}")
    List<AppointmentDto> getAppointmentsByDoctorId(@PathVariable Integer id);

    @GetMapping(value = "/api/database/patient/pesel/{pesel}")
    PatientDto getPatientByPesel(@PathVariable String pesel);

    @GetMapping(value = "/api/database/doctor/{id}")
    DoctorDto getDoctorById(@PathVariable Integer id);

    @GetMapping(value = "/api/database/clinic/{id}")
    ClinicDto getClinicById(@PathVariable Integer id);
}
