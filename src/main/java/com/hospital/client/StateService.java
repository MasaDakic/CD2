package com.hospital.client;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class StateService {

    private AtomicInteger stateCount = new AtomicInteger();

    public int getStateCount() {
        return stateCount.get();
    }

    public void fetchAndSaveStates() {
        stateCount.incrementAndGet();
    }
}