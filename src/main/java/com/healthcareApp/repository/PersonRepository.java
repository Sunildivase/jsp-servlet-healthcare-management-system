package com.healthcareApp.repository;

import com.healthcareApp.model.Person;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    public boolean createPerson(Person person) throws SQLException {

        String query = "INSERT INTO person (personId, type, firstName, lastName, age , gender , contactNo , alternateMobile , address)" +
                " VALUES (?, ?, ?, ?, ?, ?, ? , ? ,?)";

        Connection connection = new ConnectionService().getConnection(); // GET connection here

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, person.getPersonId());
            preparedStatement.setString(2, person.getType());
            preparedStatement.setString(3, person.getFirstName());
            preparedStatement.setString(4, person.getLastName());
            preparedStatement.setString(5, person.getAge());
            preparedStatement.setString(6, person.getGender());
            preparedStatement.setString(7,person.getContactNo());
            preparedStatement.setString(8,person.getAlternateMobile());
            preparedStatement.setString(9,person.getAddress());


            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting person: " + e.getMessage(), e);
        }
    }

    public List<Person> displayPerson() throws SQLException {
        List<Person> personList = new ArrayList<>();

        Connection connection = new ConnectionService().getConnection();

        String query = "SELECT * FROM person";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getString("personId"),
                        resultSet.getString("type"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("contactNo"),
                        resultSet.getString("alternateMobile"),
                        resultSet.getString("address")

                );
                personList.add(person);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving persons: " + e.getMessage());
        }

        return personList;
    }


    public boolean deletePerson(int personId) {
        String query = "DELETE FROM person WHERE id = ?";

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, personId);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage(), e);
        }
    }

    public boolean updatePerson(int personId, String firstName) {
        String query = "UPDATE person SET firstName = ? WHERE personId = ?";

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, personId);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage(), e);
        }
    }
}
