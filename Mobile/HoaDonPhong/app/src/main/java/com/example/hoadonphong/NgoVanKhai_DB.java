package com.example.hoadonphong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;

public class NgoVanKhai_DB extends SQLiteOpenHelper {
    public  static final String TableName = "HoaDon_NgoVanKhai";

    public static final String Id = "Id";
    public static final String Name = "Name";
    public static final String Room = "Room";
    public static final String Price = "Price";
    public static final String Day = "Day";
    public NgoVanKhai_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Name +" Text,"
                +Room +" Text,"
                +Price +" INTEGER,"
                +Day +" INTEGER)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng tableContact đã có
        sqLiteDatabase.execSQL("Drop table if exists "+ TableName);
        // Tạo lại
        onCreate(sqLiteDatabase);
    }
    public void addContact(HoaDon_NgoVanKhai item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Name, item.getName());
        value.put(Room, item.getRoom());
        value.put(Price, item.getPrice());
        value.put(Day, item.getDay());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, HoaDon_NgoVanKhai item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Name, item.getName());
        value.put(Room, item.getRoom());
        value.put(Price, item.getPrice());
        value.put(Day, item.getDay());
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete From "+TableName+" Where ID = "+id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<HoaDon_NgoVanKhai> getAllContact(){
        ArrayList<HoaDon_NgoVanKhai> list = new ArrayList<>();

        String sql = "Select * from "+TableName;//" +" Order By soPhong DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                HoaDon_NgoVanKhai item = new HoaDon_NgoVanKhai(cursor.getInt(0),cursor.getString(1),
                        cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
                list.add(item);
            }
        }
        return list;
    }
}
