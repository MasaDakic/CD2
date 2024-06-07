package com.hospital.DTO;

public class MedicationsDTO {
    private int id;
    private String name;
    private String description;
    private String sideEffects;
    private String instructionFilePath;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getInstructionFilePath() {
        return instructionFilePath;
    }

    public void setInstructionFilePath(String instructionFilePath) {
        this.instructionFilePath = instructionFilePath;
    }
}