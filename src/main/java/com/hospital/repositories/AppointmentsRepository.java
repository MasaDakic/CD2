package com.hospital.repositories;

import com.hospital.entities.Appointments;
import com.speedment.jpastreamer.application.JPAStreamer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class AppointmentsRepository {

    private final JPAStreamer jpaStreamer;

    @PersistenceContext
    EntityManager entityManager;

    public AppointmentsRepository(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    @Transactional
    public long countByDoctorId(int doctorId) {
        return jpaStreamer.stream(Appointments.class)
                .filter(appointments -> appointments.getDoctor() != null && appointments.getDoctor().getId() == doctorId)
                .count();
    }

    @Transactional
    public Optional<Appointments> findById(Integer id) {
        return jpaStreamer.stream(Appointments.class)
                .filter(appointments -> appointments.getId().equals(id))
                .findFirst();
    }

    @Transactional
    public List<Appointments> findAll() {
        return jpaStreamer.stream(Appointments.class)
                .collect(Collectors.toList());
    }

    @Transactional
    public Appointments save(Appointments appointment) {
        if (appointment.getId() == null) {
            entityManager.persist(appointment);
            return appointment;
        } else {
            return entityManager.merge(appointment);
        }
    }

    @Transactional
    public void delete(Appointments appointment) {
        if (entityManager.contains(appointment)) {
            entityManager.remove(appointment);
        } else {
            entityManager.remove(entityManager.merge(appointment));
        }
    }
}