package com.example.bankup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayDetails extends AppCompatActivity {
    public  static int transferamount;
    Context context;
    TextView Name,Number,Balance;
    int finalBalance,id,lbalance;
    EditText deposit,transfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent = getIntent();
        String name = intent.getStringExtra("Cname");
        String phone = intent.getStringExtra("Cphone");
        int balance=intent.getIntExtra("Cbalance",0);
        id=intent.getIntExtra("Cid",0);

        Name=findViewById(R.id.tv_name);
        Number=findViewById(R.id.tv_number);
        Balance=findViewById(R.id.tv_balance);
        deposit=findViewById(R.id.et_deposit);
        transfer=findViewById(R.id.et_transfer);

        finalBalance=balance;
        lbalance=balance;

        Name.setText(name);
        Number.setText(phone);
        Balance.setText(balance+"");


    }

    public void transferButton(View view) {
         transferamount=Integer.parseInt(transfer.getText().toString());
        if(transferamount<lbalance && transferamount>0){
            int Nbalance=lbalance-transferamount;


            Intent intent = new Intent(this, TransferTo.class);
            intent.putExtra("id",id);
            intent.putExtra("nbalance",Nbalance);
            this.startActivity(intent);
        }
        else{

            Toast.makeText(this,"Insufficient Balance",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

    }

    public void depositButton(View view) {
        finalBalance=finalBalance+Integer.parseInt(deposit.getText().toString());
        CustomerTab customerTab=new CustomerTab();
        customerTab.setId(id);
        customerTab.setCustomerBalance(finalBalance);
        MainActivity.db.updateBalance(customerTab);

        Toast.makeText(this,"Transaction Successful",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
