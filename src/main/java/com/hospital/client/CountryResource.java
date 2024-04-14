package com.hospital.client;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/country")
public class CountryResource {

    @Inject
    @RestClient
    CountryService countryService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> getAllCountries() {
        return countryService.getAvailableCountries();
    }
}