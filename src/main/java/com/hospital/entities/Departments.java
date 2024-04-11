package com.hospital.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments", schema = "hospitaldb")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Doctors> doctors;

    @OneToMany(mappedBy = "department")
    private List<Nurses> nurses;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public List<Nurses> getNurses() {
        return nurses;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public void setNurses(List<Nurses> nurses) {
        this.nurses = nurses;
    }
}