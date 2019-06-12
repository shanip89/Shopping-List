package com.example.ahova.shoppinglist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Shopping List")
public class ShoppingList {

    public String getProduct(){
        return product;
    }

    public String getDatePurchased(){
        return purchaed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpired() {
        return dateExpired;
    }


    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "product name")
    public String product;

    @ColumnInfo(name = "purchased date")
    public String purchaed;

    @ColumnInfo(name = "expired date")
    public String dateExpired;

    public ShoppingList(String product, String purchaed, String dateExpired) {
        this.product = product;
        this.purchaed = purchaed;
        this.dateExpired = dateExpired;
    }
}
