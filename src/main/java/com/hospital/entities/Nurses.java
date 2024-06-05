package com.hospital.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nurses", schema = "hospitaldb")
public class Nurses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @OneToMany(mappedBy = "nurse")
    private List<Appointments> appointments;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Departments getDepartment() {
        return department;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}