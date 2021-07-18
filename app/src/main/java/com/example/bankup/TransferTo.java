package com.example.bankup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransferTo extends AppCompatActivity {
    RecyclerView recyclerView;
    private TransferToAdaptor recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferto);

        Intent intent=getIntent();
       int id = intent.getIntExtra("id",0);
       int nbalance=intent.getIntExtra("nbalance",0);

        recyclerView = findViewById(R.id.rv_transferto);
        LinearLayoutManager manager = new LinearLayoutManager(TransferTo.this);
        recyclerView.setLayoutManager(manager);

        ArrayList<CustomerTab> allcustomer =MainActivity.db.getAllCustomer();

        recyclerViewAdapter = new TransferToAdaptor(TransferTo.this, allcustomer,id,nbalance);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
