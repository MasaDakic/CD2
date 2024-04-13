package com.hospital.resources;

import com.hospital.DTO.AppointmentsDTO;
import com.hospital.entities.Appointments;
import com.hospital.repositories.AppointmentsRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/appointments")
public class AppointmentsResource {

    @Inject
    AppointmentsRepository appointmentsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppointmentsDTO> getAllAppointments() {
        List<Appointments> appointments = appointmentsRepository.findAll();
        return appointments.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AppointmentsDTO getAppointmentById(@PathParam("id") int id) {
        Appointments appointment = appointmentsRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Appointment not found"));
        return convertToDto(appointment);
    }

    private AppointmentsDTO convertToDto(Appointments appointment) {
        AppointmentsDTO dto = new AppointmentsDTO();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getAppointment_date());
        dto.setTime(appointment.getAppointment_time());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setNurseId(appointment.getNurse().getId());
        return dto;
    }
}