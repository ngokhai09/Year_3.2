package com.example.baithi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NgoVanKhai_Sqlite extends SQLiteOpenHelper {
    public  static final String TableName = "VeTau_NgoVanKhai";

    public static final String Id = "Id";
    public static final String Start = "Start";
    public static final String Finish = "Finish";
    public static final String Price = "Price";
    public static final String Revert = "Revert";


    public NgoVanKhai_Sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Start +" Text,"
                +Finish +" Text,"
                +Price +" FLOAT,"
                +Revert +" INTEGER)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng tableContact đã có
        sqLiteDatabase.execSQL("Drop table if exists "+ TableName);
        // Tạo lại
        onCreate(sqLiteDatabase);
    }
    public void addContact(Vetau item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Start, item.getStart());
        value.put(Finish, item.getFinish());
        value.put(Price, item.getPrice());
        value.put(Revert, item.isRevert()?1:0);
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, Vetau item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Start, item.getStart());
        value.put(Finish, item.getFinish());
        value.put(Price, item.getPrice());
        value.put(Revert, item.isRevert()?1:0);
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete From "+TableName+" Where ID = "+id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<Vetau> getAllContact(){
        ArrayList<Vetau> list = new ArrayList<>();

        String sql = "Select * from "+TableName;//" +" Order By soPhong DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                Vetau item = new Vetau(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2), cursor.getFloat(3), (cursor.getInt(4) == 1));
                list.add(item);
            }
        }
        return list;
    }
}
