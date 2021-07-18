package com.example.bankup.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import com.example.bankup.CustomerTab;
import com.example.bankup.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE "+Params.TABLE_NAME+"("+Params.KEY_ID+" INTEGER PRIMARY KEY,"
                +Params.KEY_NAME+" TEXT,"+Params.KEY_NUMBER+" TEXT,"+Params.KEY_BALANCE+" INTEGER )";

        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCustomerTab(CustomerTab customerTab){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put(Params.KEY_NAME,customerTab.getCustomerName());
        contentValues.put(Params.KEY_NUMBER,customerTab.getCustomerNumber());
        contentValues.put(Params.KEY_BALANCE,customerTab.getCustomerBalance());

        db.insert(Params.TABLE_NAME,null,contentValues);
        db.close();
    }

    public ArrayList<CustomerTab> getAllCustomer (){
        SQLiteDatabase db= getReadableDatabase();
        ArrayList<CustomerTab> customerTabList =new ArrayList<>();
        String select= "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);

        if(cursor.moveToFirst()){

            do{
                CustomerTab customerTab =new CustomerTab();
                customerTab.setId(Integer.parseInt(cursor.getString(0)));
                customerTab.setCustomerName(cursor.getString(1));
                customerTab.setCustomerNumber(cursor.getString(2));
                customerTab.setCustomerBalance(cursor.getInt(3));

                customerTabList.add(customerTab);

            }while(cursor.moveToNext());
        }
        return customerTabList;
    }

    public int updateBalance (CustomerTab customerTab){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();


        values.put(Params.KEY_BALANCE,customerTab.getCustomerBalance());


        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{String.valueOf(customerTab.getId())});

    }
    public  void deleteCustomer(String s){
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(Params.TABLE_NAME,Params.KEY_NUMBER+"=?",new String[]{s});
    }

    public  int getcount(){
        String query="SELECT * FROM "+Params.TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);

        return cursor.getCount();
    }
}
