package com.example.bankup;

import androidx.annotation.NonNull;

public class CustomerTab {
   private int Id;
   private String CustomerName;
   private String CustomerNumber;
   private int CustomerBalance;

   public CustomerTab(){ }

    public CustomerTab(String customerName, String customerNumber, int customerBalance) {

        CustomerName = customerName;
        CustomerNumber = customerNumber;
        CustomerBalance = customerBalance;
    }

    public CustomerTab(int id, String customerName, String customerNumber, int customerBalance) {
        Id = id;
        CustomerName = customerName;
        CustomerNumber = customerNumber;
        CustomerBalance = customerBalance;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public int getCustomerBalance() {
        return CustomerBalance;
    }

    public void setCustomerBalance(int customerBalance) {
        CustomerBalance = customerBalance;
    }
}
