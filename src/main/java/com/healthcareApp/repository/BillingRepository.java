package com.healthcareApp.repository;



import com.healthcareApp.model.Billing;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingRepository {

    public boolean createBilling(Billing billing) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "INSERT INTO billing(billId,bill,totalBill,personId) VALUES (?,?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,billing.getBillId());
            preparedStatement.setInt(2,billing.getBill());
            preparedStatement.setInt(3,billing.getTotalBill());
            preparedStatement.setInt(4,billing.getPersonId());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Billing> displayBilling() throws SQLException {

        List<Billing> billingList = new ArrayList<>();

        Connection connection = new ConnectionService().getConnection();

        String query = "SELECT * FROM billing";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Billing billing = new Billing(
                resultSet.getInt("billId"),
                resultSet.getInt("bill"),
                resultSet.getInt("totalBill"),
                resultSet.getInt("personId")
                );

                billingList.add(billing);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return billingList;
    }

    public boolean updateBilling(int billId,int totalBill) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "UPDATE billing SET totalBill = ? WHERE billId = ?";

        try(PreparedStatement preparedStatement= connection.prepareStatement(query)){

            preparedStatement.setInt(1,totalBill);
            preparedStatement.setInt(2,billId);

            int rowUpdated=preparedStatement.executeUpdate();

            return rowUpdated > 0;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public boolean deleteBilling(int billId) throws SQLException {

        Connection connection = new ConnectionService().getConnection();

        String query = "DELETE FROM billing WHERE billId=? ";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,billId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
