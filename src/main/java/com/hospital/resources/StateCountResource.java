package com.hospital.resources;

import com.hospital.client.StateService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/statecount")
public class StateCountResource {

    @Inject
    StateService stateService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStateCount() {
        return "State count: " + stateService.getStateCount();
    }
}