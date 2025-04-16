package com.healthcareApp.repository;


import com.healthcareApp.model.Doctor;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    public boolean createDoctor(Doctor doctor) throws SQLException {

        Connection connection = new ConnectionService().getConnection(); // GET connection here

       String query = "INSERT INTO doctor VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, doctor.getDoctorId());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getLastName());
            preparedStatement.setInt(4, doctor.getAge());
            preparedStatement.setString(5, doctor.getGender());
            preparedStatement.setString(6, doctor.getContactNo());
            preparedStatement.setString(7, doctor.getSpeciality());
            preparedStatement.setInt(8, doctor.getExperience());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting Doctor: " + e.getMessage(), e);
        }

    }

    public List<Doctor> displayDoctor() throws SQLException {

        List<Doctor> doctorList = new ArrayList<>();

        Connection connection = new ConnectionService().getConnection();

        String query = "SELECT * FROM doctor";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("doctorId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("contactNo"),
                        resultSet.getString("speciality"),
                        resultSet.getInt("experience")
                );

                doctorList.add(doctor);

            }
        } catch (SQLException e) {
            System.err.println("Error retrieving doctors: " + e.getMessage());

        }
        return doctorList;
    }

    public boolean deleteDoctor(int doctorId) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "DELETE FROM doctor WHERE doctorId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, doctorId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;
        }

    }

    public boolean updateDoctor(int doctorId, String firstName) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "UPDATE doctor SET firstName= ? WHERE doctorId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, doctorId);

            int rowUpdated = preparedStatement.executeUpdate();

            return rowUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage(), e);
        }
    }


}


