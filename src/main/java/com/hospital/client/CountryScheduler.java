package com.hospital.client;

import com.hospital.repositories.CountryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@ApplicationScoped
public class CountryScheduler {

    @Inject
    @RestClient
    CountryService countryService;

    @Inject
    CountryRepository countryRepository;

    @Scheduled(every = "30s")
    void scheduledJob() {
        Set<Country> countries = countryService.getAvailableCountries();
        countries.forEach(country -> {
            if (!countryRepository.exists(country.countryCode)) {
                countryRepository.save(country);
            }
        });
    }
}