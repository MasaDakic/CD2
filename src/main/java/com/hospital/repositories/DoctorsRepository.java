package com.hospital.repositories;

import com.hospital.entities.Doctors;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DoctorsRepository {

    private final JPAStreamer jpaStreamer;

    @PersistenceContext
    EntityManager entityManager;

    public DoctorsRepository(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    @Transactional
    public Doctors findById(int id) {
        return jpaStreamer.stream(Doctors.class)
                .filter(doctors -> doctors.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Transactional
    public List<Doctors> findAll() {
        return jpaStreamer.stream(Doctors.class)
                .collect(Collectors.toList());
    }

    @Transactional
    public Doctors save(Doctors doctor) {
        return entityManager.merge(doctor);
    }

    @Transactional
    public void delete(Doctors doctor) {
        System.out.println("Deleting doctor: " + doctor);
        if (entityManager.contains(doctor)) {
            System.out.println("Doctor is managed. Removing directly.");
            entityManager.remove(doctor);
        } else {
            System.out.println("Doctor is not managed. Merging and then removing.");
            entityManager.remove(entityManager.merge(doctor));
        }
    }
}