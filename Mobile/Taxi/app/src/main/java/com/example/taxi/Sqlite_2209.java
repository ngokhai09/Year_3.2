package com.example.taxi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Sqlite_2209 extends SQLiteOpenHelper {
    public  static final String TableName = "HoaDon_NgoVanKhai";

    public static final String Id = "Id";
    public static final String Number = "Number";
    public static final String Road = "Road";
    public static final String Price = "Price";
    public static final String Discount = "Discount";
    public Sqlite_2209(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Number +" Text,"
                +Road +" FLOAT,"
                +Price +" FLOAT,"
                +Discount +" FLOAT)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng tableContact đã có
        sqLiteDatabase.execSQL("Drop table if exists "+ TableName);
        // Tạo lại
        onCreate(sqLiteDatabase);
    }
    public void addContact(Taxi item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Number, item.getNumber());
        value.put(Road, item.getRoad());
        value.put(Price, item.getPrice());
        value.put(Discount, item.getDiscount());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, Taxi item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
//        value.put(Id, item.getId());
        value.put(Number, item.getNumber());
        value.put(Road, item.getRoad());
        value.put(Price, item.getPrice());
        value.put(Discount, item.getDiscount());
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete From "+TableName+" Where ID = "+id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<Taxi> getAllContact(){
        ArrayList<Taxi> list = new ArrayList<>();

        String sql = "Select * from "+TableName;//" +" Order By soPhong DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                Taxi item = new Taxi(cursor.getInt(0),cursor.getString(1),
                        cursor.getFloat(2),cursor.getFloat(3),cursor.getFloat(4));
                list.add(item);
            }
        }
        return list;
    }
}
