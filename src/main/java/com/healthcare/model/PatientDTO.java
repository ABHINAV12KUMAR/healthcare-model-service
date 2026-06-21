package com.healthcare.model;

import lombok.Data;

@Data
public class PatientDTO {

    private Long id;
    //@NotBlank(message = "Name is required")
    private String name;
    //@NotBlank(message = "Disease is required")
    private String disease;

    private String email;
}