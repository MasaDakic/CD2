package com.hospital.entities;

import jakarta.persistence.*;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "prescriptions", schema = "hospitaldb")
public class Prescriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_prescribed;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medications medication;

    // Getters
    public int getId() {
        return id;
    }

    public Date getDate_prescribed() {
        return date_prescribed;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public Patients getPatient() {
        return patient;
    }

    public Medications getMedication() {
        return medication;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate_prescribed(Date date_prescribed) {
        this.date_prescribed = date_prescribed;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public void setMedication(Medications medication) {
        this.medication = medication;
    }
}