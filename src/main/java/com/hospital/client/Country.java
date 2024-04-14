package com.hospital.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {
    @Id
    public String countryCode;
    public String name;
}