package com.hospital.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.hospital.DTO.DoctorsDTO;
import com.hospital.entities.Doctors;
import com.hospital.repositories.AppointmentsRepository;
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

    @Inject
    AppointmentsRepository appointmentsRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoctorsDTO getDoctor(@PathParam("id") int id) {
        Doctors doctor = doctorsRepository.findById(id);
        return convertToDto(doctor);
    }

    @GET
    @Path("/appointments/count/{minCount}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoctorsDTO> getDoctorsWithMinAppointments(@PathParam("minCount") long minCount) {
        List<Doctors> allDoctors = doctorsRepository.findAll();
        return allDoctors.stream()
            .filter(doctor -> appointmentsRepository.countByDoctorId(doctor.getId()) > minCount)
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoctorsDTO> getAllDoctors() {
        List<Doctors> doctors = doctorsRepository.findAll();
        return doctors.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
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