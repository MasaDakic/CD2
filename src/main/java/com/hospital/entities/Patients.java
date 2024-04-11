package com.hospital.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patients", schema = "hospitaldb")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date date_of_birth;

    @OneToMany(mappedBy = "patient")
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "patient")
    private List<Prescriptions> prescriptions;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public List<Prescriptions> getPrescriptions() {
        return prescriptions;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public void setPrescriptions(List<Prescriptions> prescriptions) {
        this.prescriptions = prescriptions;
    }
}