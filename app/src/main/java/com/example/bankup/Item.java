package com.example.bankup;

import android.widget.TextView;

public class Item {
    private String CustomerName;
    private String CustomerMobileNumber;



    public Item(String name, String number){
        CustomerName=name;
        CustomerMobileNumber=number;
    }


    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return CustomerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        CustomerMobileNumber = customerMobileNumber;
    }




}
