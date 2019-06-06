package com.example.ahova.shoppinglist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Shopping List")
public class ShoppingList {

    public String getProduct(){
        return product;
    }

    public int getDatePurchased(){
        return purchaed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "product name")
    public String product;

    @ColumnInfo(name = "purchased date")
    public int purchaed;

    public ShoppingList(String product, int purchaed) {
        this.product = product;
        this.purchaed = purchaed;
    }
}