package com.hospital.entities;

import com.hospital.DTO.DoctorsDTO;
import com.hospital.repositories.DoctorsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/doctors")
public class DoctorsResource {

    @Inject
    DoctorsRepository doctorsRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoctorsDTO getDoctor(@PathParam("id") int id) {
        Doctors doctor = doctorsRepository.findById(id);
        return convertToDto(doctor);
    }

    private DoctorsDTO convertToDto(Doctors doctor) {
        DoctorsDTO dto = new DoctorsDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setDepartmentId(doctor.getDepartmentId());
        return dto;
    }
}