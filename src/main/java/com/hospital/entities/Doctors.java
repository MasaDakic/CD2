package com.hospital.entities;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "doctors", schema = "hospitaldb")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonManagedReference
    private Departments department;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
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

    public Integer getDepartmentId() {
        return department != null ? department.getId() : null;
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

    public void setDepartmentId(int departmentId) {
        if (this.department == null) {
            this.department = new Departments();
        }
        this.department.setId(departmentId);
    }
}