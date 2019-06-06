package com.example.ahova.shoppinglist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListDataBase db = Room.databaseBuilder(getApplicationContext(), ListDataBase.class, "My products")
                .allowMainThreadQueries()
                .build();


        List<ShoppingList> products = db.listDao().getAllproducts();

        recyclerView = findViewById(R.id.shopping_recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(products);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateList.class);
                startActivity(intent);
            }
        });
    }
}
