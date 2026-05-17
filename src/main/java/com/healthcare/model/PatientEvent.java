package com.healthcare.model;

import lombok.Data;

@Data
public class PatientEvent {

    private Long patientId;
    private String name;
    private String disease;
    private String eventType; // CREATE, UPDATE, DELETE
}