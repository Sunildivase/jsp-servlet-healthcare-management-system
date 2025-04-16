package com.healthcareApp.repository;



import com.healthcareApp.model.Prescription;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionRepository {

    public boolean createPrescription(Prescription prescription) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = " INSERT INTO prescription(prescriptionId,prescriptionDetails,personId) VALUES (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,prescription.getPrescriptionId());
            preparedStatement.setString(2,prescription.getPrescriptionDetails());
            preparedStatement.setInt(3,prescription.getPersonId());

            int rowInserted=preparedStatement.executeUpdate();

            return rowInserted > 0;
        }

    }

    public List<Prescription> displayPrescription() throws SQLException {

        List<Prescription> prescriptionList = new ArrayList<>();

        Connection connection = new ConnectionService().getConnection();

        String query = "SELECT * FROM prescription";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Prescription prescription = new Prescription(
                resultSet.getInt("prescriptionId"),
                resultSet.getString("prescriptionDetails"),
                resultSet.getInt("personId")
                );

                prescriptionList.add(prescription);

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return prescriptionList;
    }

    public boolean updatePrescription(int prescriptionId,String prescriptionDetails) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "UPDATE prescription SET prescriptionDetails = ? WHERE prescriptionId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,prescriptionDetails);
            preparedStatement.setInt(2,prescriptionId);

            int rowUpdated=preparedStatement.executeUpdate();

            return rowUpdated > 0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public boolean deletePrescription(int prescriptionId) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "DELETE FROM prescription WHERE prescriptionId= ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,prescriptionId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
