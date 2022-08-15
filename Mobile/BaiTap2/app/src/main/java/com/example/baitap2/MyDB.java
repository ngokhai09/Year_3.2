package com.example.baitap2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {
    public static final String TableName = "ThietBi";
    public static final String Id = "Id";
    public static final String Name = "Name";
    public static final String Description = "Description";
    public static final String Image = "Image";
    public static final String Status = "Status";

    public MyDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "(" + Id + " Integer Primary key," + Name + " Text," + Description + " Text," + Image + " Text," + Status + " Int)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + TableName);
        onCreate(sqLiteDatabase);
    }
    public void addItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getId());
        value.put(Name, item.getName());
        value.put(Description, item.getDescription());
        value.put(Image, item.getImage());
        value.put(Status, item.getStatus());
        db.insert(TableName, null, value);
        db.close();
    }
    public void upadteItem(int id, Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getId());
        value.put(Name, item.getName());
        value.put(Description, item.getDescription());
        value.put(Image, item.getImage());
        value.put(Status, item.getStatus());
        db.update(TableName, value, Id + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete from "+ TableName + " where Id = " + id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<Item> getAllItem(){
        ArrayList<Item> list = new ArrayList<>();
        String sql = "Select * from " + TableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            while (cursor.moveToNext()){
                Item item = new Item(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
                list.add(item);
            }
        }
        return list;
    }
}
