package com.healthcare.model.appointment;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentEvent {
    private Long appointmentId;
    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String doctorName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String reason;
    private AppointmentStatus status;
    private String eventType;
    // APPOINTMENT_BOOKED, APPOINTMENT_CANCELLED, APPOINTMENT_RESCHEDULED, APPOINTMENT_COMPLETED
}