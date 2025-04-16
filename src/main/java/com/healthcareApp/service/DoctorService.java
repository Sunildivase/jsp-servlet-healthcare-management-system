package com.healthcareApp.service;



import com.healthcareApp.model.Doctor;
import com.healthcareApp.repository.DoctorRepository;

import java.sql.SQLException;
import java.util.List;

public class DoctorService {


    private static final DoctorRepository doctorRepository = new DoctorRepository();

    public boolean insertDoctor(Doctor doctor) throws SQLException {
        return doctorRepository.createDoctor(doctor);
    }

    public boolean updateDoctor(int doctorId,String firstName) throws SQLException {
        return doctorRepository.updateDoctor(doctorId,firstName);
    }

    public boolean deleteDoctor(int doctorId) throws SQLException {
        return doctorRepository.deleteDoctor(doctorId);
    }

    public List<Doctor> displayDoctor() throws SQLException {
        return  doctorRepository.displayDoctor();
    }
}



