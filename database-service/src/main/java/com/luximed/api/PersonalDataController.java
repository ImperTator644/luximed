package com.luximed.api;

import com.luximed.model.PersonalData;
import com.luximed.repository.PersonalDataRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "personal data", description = "Personal data API")
@RestController
@RequestMapping(value = "api/database/personalData")
public class PersonalDataController {

    private final PersonalDataRepository personalDataRepository;

    public PersonalDataController(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<PersonalData> getAllPersonalData() {
        return personalDataRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{pesel}")
    public PersonalData getPersonalDataByPesel(@PathVariable String pesel) {
        return personalDataRepository.findPersonalDataByPesel(pesel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public void addCPersonalData(@RequestBody PersonalData personalData) {
        personalDataRepository.save(personalData);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void deletePersonalData(@RequestParam Integer id) {
        personalDataRepository.deleteById(id);
    }

}
