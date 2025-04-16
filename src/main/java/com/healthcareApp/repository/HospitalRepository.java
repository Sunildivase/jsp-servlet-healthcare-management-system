package com.healthcareApp.repository;

import com.healthcareApp.model.Hospital;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalRepository {

    public boolean createHospital(Hospital hospital) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "INSERT INTO hospital(hospitalId,hospitalName,address,emailId,contactNo)" +
                " VALUES (?, ?, ? ,? ,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1,hospital.getHospitalId());
            preparedStatement.setString(2,hospital.getHospitalName());
            preparedStatement.setString(3,hospital.getAddress());
            preparedStatement.setString(4,hospital.getEmailId());
            preparedStatement.setString(5,hospital.getContactNo());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Hospital> displayHospital() throws SQLException {

      List<Hospital> hospitalList = new ArrayList<>();

      Connection connection = new ConnectionService().getConnection();

      String query = "SELECT * FROM hospital";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()){
              Hospital hospital = new Hospital(
              resultSet.getInt("hospitalId"),
              resultSet.getString("hospitalName"),
              resultSet.getString("address"),
              resultSet.getString("emailId"),
              resultSet.getString("contactNo")
              );

              hospitalList.add(hospital);
          }


      }catch (SQLException e){
          throw new RuntimeException(e);
      }
        return hospitalList;
    }

    public boolean deleteHospital(int hospitalId) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "DELETE FROM hospital WHERE hospitalId=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,hospitalId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public boolean updateHospital(int hospitalId,String hospitalName) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "UPDATE hospital SET hospitalName = ? WHERE hospitalId = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,hospitalName);
            preparedStatement.setInt(2,hospitalId);

            int rowUpdated=preparedStatement.executeUpdate();

            return rowUpdated > 0;
        }

    }
}
