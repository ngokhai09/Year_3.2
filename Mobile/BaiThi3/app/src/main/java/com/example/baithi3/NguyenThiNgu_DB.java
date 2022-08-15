package com.example.baithi3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NguyenThiNgu_DB extends SQLiteOpenHelper {
    // tên bảng
    public  static final String TableName = "HoaDon_NguyenThiNgu";
    // Tên các cột trong bảng
    public static final String Id = "Id";
    public static final String Ten = "Ten";
    public static final String soPhong = "soPhong";
    public static final String donGia = "donGia";
    public static final String soNgay = "soNgay";
    public NguyenThiNgu_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Tạo câu SQL để tạo bảng
        String sqlCreate = "Create table if not exists " + TableName + "("
                +Id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Ten +" Text,"
                +soPhong +" INTEGER,"
                +donGia +" INTEGER,"
                +soNgay +" INTEGER)";
        // Chạy câu truy vấn sql để tạo bảng
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng tableContact đã có
        sqLiteDatabase.execSQL("Drop table if exists "+ TableName);
        // Tạo lại
        onCreate(sqLiteDatabase);
    }
    public void addContact(HoaDon_NguyenThiNgu item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Ten, item.getName());
        value.put(soPhong, item.getSoPhong());
        value.put(donGia, item.getDonGia());
        value.put(soNgay, item.getSoNgay());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, HoaDon_NguyenThiNgu item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, item.getID());
        value.put(Ten, item.getName());
        value.put(soPhong, item.getSoPhong());
        value.put(donGia, item.getDonGia());
        value.put(soNgay, item.getSoNgay());
        db.update(TableName, value,Id +"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Delete From "+TableName+" Where ID = "+id;
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<HoaDon_NguyenThiNgu> getAllContact(){
        ArrayList<HoaDon_NguyenThiNgu> list = new ArrayList<>();
        // câu truy vấn
        String sql = "Select * from "+TableName;// +" Order By donGia*soNgay DESC";
        //Lấy đối tượng csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //Chạy câu truy vấn trả về dạng Cursor
        Cursor cursor = db.rawQuery(sql, null);
        // Tạo ArrayList<Contact> để trả về
        if(cursor != null){
            while (cursor.moveToNext()){
                HoaDon_NguyenThiNgu item = new HoaDon_NguyenThiNgu(cursor.getInt(0),cursor.getString(1),
                        cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                list.add(item);
            }
        }
        return list;
    }
}

