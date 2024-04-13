package com.hospital.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "appointments", schema = "hospitaldb")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date appointment_date;
    private Time appointment_time;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurses nurse;

    // Getters
    public int getId() {
        return id;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public Time getAppointment_time() {
        return appointment_time;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public Patients getPatient() {
        return patient;
    }

    public Nurses getNurse() {
        return nurse;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public void setAppointment_time(Time appointment_time) {
        this.appointment_time = appointment_time;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public void setNurse(Nurses nurse) {
        this.nurse = nurse;
    }
}