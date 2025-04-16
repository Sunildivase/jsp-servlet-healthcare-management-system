package com.healthcareApp.repository;


import com.healthcareApp.model.Department;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public boolean createDepartment(Department department) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "INSERT INTO department(deptId,deptName,doctorId,hospitalId) VALUES (?, ? ,? ,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,department.getDeptId());
            preparedStatement.setString(2,department.getDeptName());
            preparedStatement.setInt(3,department.getDoctorId());
            preparedStatement.setInt(4,department.getHospitalId());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;

        }catch (SQLException e){
            throw new RuntimeException("error inserting Department "+e.getMessage());
        }

    }

    public List<Department> displayDepartment() throws SQLException {

        List<Department> departmentList = new ArrayList<>();

        Connection connection = new ConnectionService().getConnection();

        String query = "SELECT * FROM department";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Department department = new Department(
                        resultSet.getInt("deptId"),
                        resultSet.getString("deptName"),
                        resultSet.getInt("doctorId"),
                        resultSet.getInt("hospitalName")
                );

                departmentList.add(department);
            }
        }catch (SQLException e){
            System.err.println("error retrieving departments "+e.getMessage());
        }


        return departmentList;
    }

    public boolean deleteDepartment(int deptId) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "DELETE FROM department where deptId = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,deptId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateDepartment(int deptId, String deptName) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "UPDATE department SET deptName=? WHERE deptId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, deptName);
            preparedStatement.setInt(2, deptId);

            int rowUpdated = preparedStatement.executeUpdate();

            return rowUpdated > 0;

        }
    }
}
