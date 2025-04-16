package com.healthcareApp.service;


import com.healthcareApp.model.Hospital;
import com.healthcareApp.repository.HospitalRepository;

import java.sql.SQLException;
import java.util.List;

public class HospitalService {

     private static final HospitalRepository hospitalRepository = new HospitalRepository();

    public boolean insertHospital(Hospital hospital) throws SQLException {
        return hospitalRepository.createHospital(hospital);
    }

    public List<Hospital> displayHospital() throws SQLException {
        return hospitalRepository.displayHospital();
    }

    public boolean deleteHospital(int hospitalId) throws SQLException {
        return hospitalRepository.deleteHospital(hospitalId);
    }

    public boolean updateHospital(int hospitalId , String hospitalName) throws SQLException {
        return hospitalRepository.updateHospital(hospitalId,hospitalName);
    }
}
