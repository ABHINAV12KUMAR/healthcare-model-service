package com.healthcare.model.appointment;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class AppointmentDTO {

    private Long patientId;
    private String doctorName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String reason;
}