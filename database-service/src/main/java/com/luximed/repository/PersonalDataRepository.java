package com.luximed.repository;

import com.luximed.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Integer> {

    public PersonalData findPersonalDataByPesel(String pesel);
}
