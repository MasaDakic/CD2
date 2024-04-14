package com.hospital.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CountryRepository {

    @Inject
    EntityManager em;

    public boolean exists(String countryCode) {
        return em.find(Country.class, countryCode) != null;
    }

    @Transactional
    public void save(Country country) {
        em.persist(country);
    }
}