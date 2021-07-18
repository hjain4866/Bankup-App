package com.example.bankup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCustomer extends AppCompatActivity {
    EditText Name;
    EditText Number;
    EditText Balance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customer);
Name=findViewById(R.id.et_name);
Number=findViewById(R.id.et_number);
Balance=findViewById(R.id.et_balance);

    }

    public void savedata(View view) {
       String name =Name.getText().toString();
       String number=Number.getText().toString();
       int balance=Integer.parseInt(Balance.getText().toString());
        CustomerTab customerTab=new CustomerTab();
        customerTab.setCustomerName(name);
        customerTab.setCustomerNumber(number);
        customerTab.setCustomerBalance(balance);

        MainActivity.db.addCustomerTab(customerTab);

        Toast.makeText(getApplicationContext(),"Customer Added",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(AddCustomer.this, MainActivity.class);
        AddCustomer.this.startActivity(myIntent);
    }
}
