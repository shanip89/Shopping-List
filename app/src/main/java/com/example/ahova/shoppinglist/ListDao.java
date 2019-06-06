package com.example.ahova.shoppinglist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListDao {
    @Query("SELECT * FROM `shopping list`" )
    List<ShoppingList> getAllproducts();

    // add to the list
    @Insert
    void insertAll(ShoppingList... shoppingLists);

}
