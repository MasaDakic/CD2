package com.hospital.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medications", schema = "hospitaldb")
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String instructionFilePath;

    @OneToMany(mappedBy = "medication")
    private List<Prescriptions> prescriptions;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructionFilePath() {
        return instructionFilePath;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructionFilePath(String instructionFilePath) {
        this.instructionFilePath = instructionFilePath;
    }

    public void setPrescriptions(List<Prescriptions> prescriptions) {
        this.prescriptions = prescriptions;
    }
}