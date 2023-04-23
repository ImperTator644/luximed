package com.luximed.api;

import com.luximed.model.Doctor;
import com.luximed.model.PersonalData;
import com.luximed.repository.DoctorRepository;
import com.luximed.repository.PersonalDataRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "doctor", description = "Doctor API")
@RestController
@RequestMapping(value = "api/database/doctor")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final PersonalDataRepository personalDataRepository;

    public DoctorController(DoctorRepository doctorRepository,
                            PersonalDataRepository personalDataRepository) {
        this.doctorRepository = doctorRepository;
        this.personalDataRepository = personalDataRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public void addDoctor(@RequestParam String pesel) {
        PersonalData personalData = personalDataRepository.findPersonalDataByPesel(pesel);

        Doctor doctor = Doctor.builder()
                .personalData(personalData)
                .build();
        doctorRepository.save(doctor);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void deleteDoctor(@RequestParam Integer id) {
        doctorRepository.deleteById(id);
    }

}
