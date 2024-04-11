package com.hospital.entities;

import com.hospital.entities.Departments;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors", schema = "hospitaldb")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @OneToMany(mappedBy = "doctor")
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Prescriptions> prescriptions;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Departments getDepartment() {
        return department;
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

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public void setPrescriptions(List<Prescriptions> prescriptions) {
        this.prescriptions = prescriptions;
    }
}