package com.example.bankup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransferToAdaptor extends RecyclerView.Adapter<TransferToAdaptor.RecyclerViewHolder>  {
    Context context;
    ArrayList<CustomerTab> ItemArrayList;
    int Cid,nbalance;


    public TransferToAdaptor(Context context, ArrayList<CustomerTab> itemArrayList,int id,int Nbalance) {
        this.context = context;
        ItemArrayList = itemArrayList;
        Cid=id;
        nbalance=Nbalance;
    }


    @Override
    public TransferToAdaptor.RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.block,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TransferToAdaptor.RecyclerViewHolder holder, int position) {
        CustomerTab itemposition= ItemArrayList.get(position);


        holder.Name.setText(itemposition.getCustomerName());
        holder.Number.setText(itemposition.getCustomerNumber());
    }

    @Override
    public int getItemCount() {
        return ItemArrayList.size();
    }



    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView Name,Number;

        public RecyclerViewHolder(@NonNull  View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            Name=itemView.findViewById(R.id.tv_customername);
            Number=itemView.findViewById(R.id.tv_mobilenumber);


        }
        @Override
        public void onClick(View v) {
            int position = this.getAbsoluteAdapterPosition();
            CustomerTab customerTab = ItemArrayList.get(position);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setMessage("ARE YOU SURE TO TRANSFER ");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            CustomerTab customerTab5=new CustomerTab();
                            customerTab5.setId(Cid);
                            customerTab5.setCustomerBalance(nbalance);
                            MainActivity.db.updateBalance(customerTab5);


                            int balance= customerTab.getCustomerBalance();
                            customerTab.setCustomerBalance(balance+DisplayDetails.transferamount);

                            MainActivity.db.updateBalance(customerTab);

                            Toast.makeText(context.getApplicationContext(), "Transaction Successful",Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(context, MainActivity.class);

                            context.startActivity(intent);
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(context.getApplicationContext(), "Transaction Unsuccessful",Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(context, MainActivity.class);

                            context.startActivity(intent);
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();




        }
}}
