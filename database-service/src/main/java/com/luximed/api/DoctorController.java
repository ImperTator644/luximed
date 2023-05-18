package com.luximed.api;

import com.luximed.model.Doctor;
import com.luximed.model.PersonalData;
import com.luximed.model.Specialization;
import com.luximed.repository.DoctorRepository;
import com.luximed.repository.PersonalDataRepository;
import com.luximed.repository.SpecializationRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Tag(name = "doctor", description = "Doctor API")
@RestController
@RequestMapping(value = "api/database/doctor")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final PersonalDataRepository personalDataRepository;
    private final SpecializationRepository specializationRepository;

    public DoctorController(DoctorRepository doctorRepository,
                            PersonalDataRepository personalDataRepository,
                            SpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.personalDataRepository = personalDataRepository;
        this.specializationRepository = specializationRepository;
    }


    @RequestMapping(method = RequestMethod.POST, value = "add")
    public void addDoctor(@RequestParam String pesel,
                          @RequestParam List<String> specializations) {
        PersonalData personalData = personalDataRepository.findPersonalDataByPesel(pesel);
        List<Specialization> specializationList = new ArrayList<>();

        specializations.forEach(s -> {
            Specialization specialization = specializationRepository.findFirstByName(s);
            if (nonNull(specialization)) {
                specializationList.add(specialization);
            }
        });

        Doctor doctor = Doctor.builder()
                .personalData(personalData)
                .specialization(specializationList)
                .build();
        doctorRepository.save(doctor);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by-spec/{specialization}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable String specialization) {
        return doctorRepository.getDoctorsBySpecialization(specialization);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by-city/{city}")
    public List<Doctor> getDoctorsByCity(@PathVariable String city) {
        return doctorRepository.getDoctorsByCity(city);
    }

    @GetMapping(value = "by-city-and-spec")
    public List<Doctor> getDoctorsBySpecializationAndClinic(@RequestParam String specializationName, @RequestParam String city) {
        return doctorRepository.getDoctorBySpecializationAndCity(specializationName, city);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void deleteDoctor(@RequestParam Integer id) {
        doctorRepository.deleteById(id);
    }


}
