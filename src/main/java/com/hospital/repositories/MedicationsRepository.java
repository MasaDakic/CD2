package com.hospital.repositories;

import com.hospital.entities.Medications;

import jakarta.persistence.EntityManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MedicationsRepository {

    @Inject
    EntityManager entityManager;

    public Medications findById(int id) {
        return entityManager.find(Medications.class, id);
    }

    @Transactional
    public void update(Medications medication) {
        entityManager.merge(medication);
    }
}