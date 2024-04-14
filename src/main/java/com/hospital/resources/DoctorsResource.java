package com.hospital.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.hospital.DTO.DoctorsDTO;
import com.hospital.entities.Doctors;
import com.hospital.repositories.AppointmentsRepository;
import com.hospital.repositories.DoctorsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDoctor(DoctorsDTO doctorDto) {
        Doctors doctor = convertToEntity(doctorDto);
        doctorsRepository.save(doctor);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("id") int id, DoctorsDTO doctorDto) {
        Doctors existingDoctor = doctorsRepository.findById(id);
        if (existingDoctor == null) {
            throw new NotFoundException("Doctor not found");
        }
        existingDoctor = updateEntityFromDto(existingDoctor, doctorDto);
        doctorsRepository.save(existingDoctor);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        Doctors existingDoctor = doctorsRepository.findById(id);
        if (existingDoctor == null) {
            throw new NotFoundException("Doctor not found");
        }
        doctorsRepository.delete(existingDoctor);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    private DoctorsDTO convertToDto(Doctors doctor) {
        DoctorsDTO dto = new DoctorsDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setDepartmentId(doctor.getDepartmentId());
        return dto;
    }

    private Doctors convertToEntity(DoctorsDTO dto) {
        Doctors doctor = new Doctors();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setDepartmentId(dto.getDepartmentId());
        return doctor;
    }

    private Doctors updateEntityFromDto(Doctors doctor, DoctorsDTO dto) {
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setDepartmentId(dto.getDepartmentId());
        return doctor;
    }
}