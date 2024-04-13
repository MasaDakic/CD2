package com.hospital.DTO;

import java.sql.Date;
import java.sql.Time;

public class AppointmentsDTO {
    private int id;
    private Date date;
    private Time time;
    private int patientId;
    private int doctorId;
    private int nurseId;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) { 
        this.nurseId = nurseId;
    }
}