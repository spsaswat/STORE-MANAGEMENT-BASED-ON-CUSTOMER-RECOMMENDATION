package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="market2.db";

    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "UID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "MIDDLE_NAME";
    public static final String COL_4 = "LAST_NAME";
    public static final String COL_5 = "AGE";
    public static final String COL_6 = "EMAIL";
    public static final String COL_7 = "PHONE_NO";
    public static final String COL_8 = "PASSWORD";


    public static final String TABLE_NAME_Cart = "Cart";
    public static final String COL_1_Cart = "PID";
    public static final String COL_2_Cart = "PRODUCT_NAME";
    public static final String COL_3_Cart = "PRICE";
    public static final String COL_4_Cart ="QUANTITY";
    public static final String COL_5_Cart ="UID";

    SQLiteDatabase db = this.getWritableDatabase();





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(UID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,MIDDLE_NAME TEXT,LAST_NAME TEXT,AGE INTEGER,EMAIL TEXT UNIQUE,PHONE_NO INTEGER,PASSWORD TEXT)");
        db.execSQL("create table " + TABLE_NAME_Cart + "(PID TEXT,PRODUCT_NAME TEXT,PRICE TEXT,QUANTITY TEXT,UID INTEGER,PRIMARY KEY (PID,UID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Cart);
    }




    public boolean insertData(String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME, int AGE, String EMAIL,long  PHONE_NO, String PASSWORD) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, FIRST_NAME);
        contentValues.put(COL_3, MIDDLE_NAME);
        contentValues.put(COL_4, LAST_NAME);
        contentValues.put(COL_5, AGE);
        contentValues.put(COL_6, EMAIL);
        contentValues.put(COL_7, PHONE_NO);
        contentValues.put(COL_8, PASSWORD);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public int check(String user, String pass) {

        Cursor res = db.rawQuery("SELECT *FROM " + TABLE_NAME + " WHERE " + COL_1 + "=? AND " + COL_8 + "=?", new String[]{user, pass});

        if (res.getCount() > 0) {
            return 1;

        }
        else {
            return 0;
        }
    }

    public Cursor showAllData_admin() {

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);
        return res;
    }
    public Cursor uidret(String email){

        Cursor res = db.rawQuery("SELECT "+COL_1+" FROM " + TABLE_NAME + " WHERE " + COL_6 + " = ?" , new String[]{email});
        return res;
    }

    public boolean updateData(String UID,String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME, int AGE, String EMAIL,long  PHONE_NO, String PASSWORD) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, FIRST_NAME);
        contentValues.put(COL_3, MIDDLE_NAME);
        contentValues.put(COL_4, LAST_NAME);
        contentValues.put(COL_5, AGE);
        contentValues.put(COL_6, EMAIL);
        contentValues.put(COL_7, PHONE_NO);
        contentValues.put(COL_8, PASSWORD);
        db.update(TABLE_NAME, contentValues, "UID=?", new String[]{UID});
        return true;
    }
    public Cursor showAllData(String UID) {

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +  COL_5_Cart + "=?", new String[]{UID});
        return res;
    }







    public boolean insertData_cart(String pid,String pro_name,String price,String quantity,String uid){

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_Cart,pid );
        contentValues.put(COL_2_Cart,pro_name );
        contentValues.put(COL_3_Cart, price);
        contentValues.put(COL_4_Cart, quantity);
        contentValues.put(COL_5_Cart, uid);
        long result = db.insert(TABLE_NAME_Cart, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public int empty_cart(String uid){

        return db.delete(TABLE_NAME_Cart, "UID=?", new String[]{uid});
    }

    public int delete_product(String pID,String uid) {

        return db.delete(TABLE_NAME_Cart, "UID=? AND PID=?", new String[]{uid,pID});
    }

    public Cursor get_cart_data(String UID){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME_Cart + " WHERE " +  COL_1 + "=?", new String[]{UID});
        return res;
    }

}
