package com.example.ahova.shoppinglist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ShoppingList.class, version = 1)
public abstract class ListDataBase extends RoomDatabase {

    public abstract ListDao listDao();

    private static volatile ListDataBase listRoomInstance;

    static ListDataBase getDatabase(final Context context) {
        if (listRoomInstance == null) {
            synchronized (ListDataBase.class) {
                if (listRoomInstance == null) {
                    listRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            ListDataBase.class, "note_database")
                            .build();
                }
            }
        }
        return listRoomInstance;
    }
}
