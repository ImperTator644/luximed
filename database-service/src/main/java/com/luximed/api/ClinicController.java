package com.luximed.api;

import com.luximed.model.Clinic;
import com.luximed.repository.ClinicRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/database/clinic")
public class ClinicController {

    private final ClinicRepository clinicRepository;

    public ClinicController(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public void addClinic(@RequestParam String buildingNumber,
                          @RequestParam String city,
                          @RequestParam String postalCode,
                          @RequestParam String street)
    {
        Clinic clinic = new Clinic();
        clinic.setBuildingNumber(buildingNumber);
        clinic.setCity(city);
        clinic.setPostalCode(postalCode);
        clinic.setStreet(street);
        clinicRepository.save(clinic);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get")
    public Clinic getClinicById(@RequestParam Integer id)
    {
        return clinicRepository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "delete")
    public void deleteClinic(@RequestParam Integer id)
    {
        clinicRepository.deleteById(id);
    }
}
