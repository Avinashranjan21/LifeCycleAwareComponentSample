package com.ranks.lifecycleawarecomponent.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class}, version = 1) // TODO: this is used to list all entity that will get converted into table in DB and version of the database
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
