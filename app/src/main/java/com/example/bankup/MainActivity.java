package com.example.bankup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.bankup.data.MyDbHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;

    private BankAdaptor recyclerViewAdapter;
    public static MyDbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);






       db=new MyDbHandler(MainActivity.this);


        ArrayList<CustomerTab> allcustomer =db.getAllCustomer();



        recyclerViewAdapter = new BankAdaptor(MainActivity.this, allcustomer);
        recyclerView.setAdapter(recyclerViewAdapter);

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
                addCustomer();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addCustomer() {
        Intent myIntent = new Intent(MainActivity.this, AddCustomer.class);
        MainActivity.this.startActivity(myIntent);
    }


}