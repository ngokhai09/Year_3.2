package com.example.deuyen;

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
    public static final String Math = "Math";
    public static final String Physic = "Physic";
    public static final String Chemistry = "Chemistry";
    public NgoVanKhai_Sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" Text PRIMARY KEY, "
                +Name +" Text,"
                +Math +" FLOAT,"
                +Physic +" FLOAT,"
                +Chemistry +" FLOAT)";
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
        value.put(Math, item.getMath());
        value.put(Physic, item.getPhysic());
        value.put(Chemistry, item.getChemistry());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(String id, Contact_NgoVanKhai item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getId());
        value.put(Name, item.getName());
        value.put(Math, item.getMath());
        value.put(Physic, item.getPhysic());
        value.put(Chemistry, item.getChemistry());
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(String id){
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
                Contact_NgoVanKhai item = new Contact_NgoVanKhai(cursor.getString(0),cursor.getString(1),
                        cursor.getFloat(2),cursor.getFloat(3),cursor.getFloat(4));
                list.add(item);
            }
        }
        return list;
    }
}
