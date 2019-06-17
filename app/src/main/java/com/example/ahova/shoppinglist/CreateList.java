package com.example.ahova.shoppinglist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.room.Room;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class CreateList extends AppCompatActivity {

    EditText product;
    EditText datePurchaed;
    Button clickMe;
    DatePicker datePicker;
    EditText dateExpired;
    DatePicker datePickerEx;




    @Override
    protected void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.create_list);

        product = (EditText) findViewById(R.id.add_product);
        datePurchaed = (EditText) findViewById(R.id.purchsed_date);
        clickMe = (Button) findViewById(R.id.save_product);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        dateExpired = (EditText) findViewById(R.id.expired_date);
        datePickerEx = (DatePicker) findViewById(R.id.date_picker_expired);


        final ListDataBase db = Room.databaseBuilder(getApplicationContext(), ListDataBase.class, "My products")
                .allowMainThreadQueries()
                .build();



        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getDate = "Selected Date: "+ datePicker.getDayOfMonth()+"/"+ (datePicker.getMonth() + 1)+"/"+datePicker.getYear();
                String getExpired = "Selected Date: "+ datePickerEx.getDayOfMonth()+"/"+ (datePickerEx.getMonth() + 1)+"/"+datePickerEx.getYear();
                ShoppingList shoppingList = new ShoppingList(product.getText().toString(), getDate, getExpired);
               db.listDao().insertAll(shoppingList);
                startActivity(new Intent(CreateList.this, MainActivity.class));
            }
        });

    }
}
