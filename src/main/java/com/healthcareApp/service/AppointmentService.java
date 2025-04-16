package com.healthcareApp.service;


import com.healthcareApp.model.Appointment;
import com.healthcareApp.repository.AppointmentRepository;

import java.sql.SQLException;
import java.util.List;

public class AppointmentService {

    private static final AppointmentRepository appointmentRepository = new AppointmentRepository();

    public boolean insertAppointment(Appointment appointment) throws SQLException {
        return appointmentRepository.createAppointment(appointment);
    }

    public List<Appointment> displayAppointment() throws SQLException {
        return appointmentRepository.displayAppointment();
    }

    public boolean updateAppointment(int appointmentId,int personId) throws SQLException {
        return appointmentRepository.updateAppointment(appointmentId,personId);
    }

    public static boolean deleteAppointment(int appointmentId) throws SQLException {
        return appointmentRepository.deleteAppointment(appointmentId);
    }
}
