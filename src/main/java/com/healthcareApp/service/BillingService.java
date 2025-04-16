package com.healthcareApp.service;

import com.healthcareApp.model.Billing;
import com.healthcareApp.repository.BillingRepository;

import java.sql.SQLException;
import java.util.List;

public class BillingService {

   private static final BillingRepository billingRepository = new BillingRepository();

   public boolean insertBilling(Billing billing) throws SQLException {
       return billingRepository.createBilling(billing);
   }

   public List<Billing> displayBilling() throws SQLException {
       return billingRepository.displayBilling();
   }

   public boolean updateBilling(int billId,int totalBill) throws SQLException {
       return billingRepository.updateBilling(billId,totalBill);
   }

   public boolean deleteBilling(int billId) throws SQLException {
       return billingRepository.deleteBilling(billId);
   }
}
