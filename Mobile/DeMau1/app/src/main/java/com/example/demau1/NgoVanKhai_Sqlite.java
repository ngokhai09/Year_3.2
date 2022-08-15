package com.example.demau1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NgoVanKhai_Sqlite extends SQLiteOpenHelper {
    public  static final String TableName = "Contact_NgoVanKhai";

    public static final String Id = "Id";
    public static final String Name = "Name";
    public static final String Phone = "Phone";
    public NgoVanKhai_Sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" INTEGER PRIMARY KEY, "
                +Name +" Text,"
                +Phone +" Text)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng tableContact đã có
        sqLiteDatabase.execSQL("Drop table if exists "+ TableName);
        // Tạo lại
        onCreate(sqLiteDatabase);
    }
    public void addContact(Contact_NgoVanKhai item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getId());
        value.put(Name, item.getName());
        value.put(Phone, item.getPhone());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, Contact_NgoVanKhai item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getId());
        value.put(Name, item.getName());
        value.put(Phone, item.getPhone());
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete From "+TableName+" Where ID = "+id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<Contact_NgoVanKhai> getAllContact(){
        ArrayList<Contact_NgoVanKhai> list = new ArrayList<>();

        String sql = "Select * from "+TableName;//" +" Order By soPhong DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                Contact_NgoVanKhai item = new Contact_NgoVanKhai(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2));
                list.add(item);
            }
        }
        return list;
    }
}
