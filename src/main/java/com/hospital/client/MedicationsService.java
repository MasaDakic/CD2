package com.hospital.client;

import com.hospital.entities.Medications;
import com.hospital.repositories.MedicationsRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MedicationsService {

    @Inject
    MedicationsRepository medicationsRepository;

    public Medications findById(int id) {
        return medicationsRepository.findById(id);
    }

    @Transactional
    public void update(Medications medication) {
        medicationsRepository.update(medication);
    }
}