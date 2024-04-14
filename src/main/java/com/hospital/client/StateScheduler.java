package com.hospital.client;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StateScheduler {

    @Inject
    StateService stateService;

    @Scheduled(every = "10s")
    void scheduledJob() {
        stateService.fetchAndSaveStates();
    }
}