package com.ranks.lifecycleawarecomponent.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")// TODO: this annotation is used to make a table in database with this class name
public class User {

    @PrimaryKey  // TODO: this annotation is to make this field Primary key in database
    private int uid;

    @ColumnInfo(name = "first_name") // TODO: this is used if database column name to be kept different
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
