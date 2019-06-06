package com.example.ahova.shoppinglist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.room.Room;

import java.util.List;

public class CreateList extends AppCompatActivity {

    EditText product;
    EditText datePurchaed;
    Button clickMe;

    @Override
    protected void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.create_list);

        product = (EditText) findViewById(R.id.add_product);
        datePurchaed = (EditText) findViewById(R.id.purchsed_date);
        clickMe = (Button) findViewById(R.id.save_product);

        final ListDataBase db = Room.databaseBuilder(getApplicationContext(), ListDataBase.class, "My products")
                .allowMainThreadQueries()
                .build();



        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ShoppingList shoppingList = new ShoppingList(product.getText().toString(), datePurchaed.getText().length());
               db.listDao().insertAll(shoppingList);
                startActivity(new Intent(CreateList.this, MainActivity.class));
            }
        });

    }
}
