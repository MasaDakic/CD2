package com.hospital.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

@Path("/api/v3")
@RegisterRestClient(configKey = "countries-api")
public interface CountryService {

    @GET
    @Path("/AvailableCountries")
    Set<Country> getAvailableCountries();
}