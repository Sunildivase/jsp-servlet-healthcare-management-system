package com.healthcareApp.service;

import com.healthcareApp.model.Prescription;
import com.healthcareApp.repository.PrescriptionRepository;

import java.sql.SQLException;
import java.util.List;

public class PrescriptionService {

    private static final PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

    public boolean insertPrescription(Prescription prescription) throws SQLException {
        return prescriptionRepository.createPrescription(prescription);
    }

    public List<Prescription> displayPrescription() throws SQLException {
        return prescriptionRepository.displayPrescription();
    }

    public boolean updatePrescription(int prescriptionId,String prescriptionDetails) throws SQLException {
        return prescriptionRepository.updatePrescription(prescriptionId,prescriptionDetails);
    }
    public boolean deletePrescription(int prescriptionId) throws SQLException {
        return prescriptionRepository.deletePrescription(prescriptionId);
    }
}
