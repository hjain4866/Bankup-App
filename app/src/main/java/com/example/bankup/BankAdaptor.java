package com.example.bankup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BankAdaptor extends RecyclerView.Adapter<BankAdaptor.RecyclerViewHolder> {
    Context context;
    ArrayList<CustomerTab> ItemArrayList;


    public BankAdaptor(Context context, ArrayList<CustomerTab> itemArrayList) {
        this.context = context;
        ItemArrayList = itemArrayList;
    }

    @Override
    public BankAdaptor.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.block,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankAdaptor.RecyclerViewHolder holder, int position) {
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
          String name= customerTab.getCustomerName();
          String number=customerTab.getCustomerNumber();
          int balance=customerTab.getCustomerBalance();
          int id=customerTab.getId();

            Intent intent = new Intent(context, DisplayDetails.class);
            intent.putExtra("Cname", name);
            intent.putExtra("Cphone", number);
            intent.putExtra("Cbalance",balance);
            intent.putExtra("Cid",id);
            context.startActivity(intent);
        }
    }}
