package com.example.shopee.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.shopee.models.ModelLogin;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="myshop";
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 12);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE tb_user(" +
                "id_user INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama VARCHAR(50)," +
                "username VARCHAR(50)," +
                "password VARCHAR(50)," +
                "jkl VARCHAR(50)," +
                "alamat VARCHAR(50),"+
                "status_members VARCHAR(50));";

        String produk =  "CREATE TABLE tb_produk(" +
                "id_produk INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_brg TEXT," +
                "harga_brg TEXT," +
                "stock_brg TEXT,"+"foto_brg TEXT);";

        String transaksi =  "CREATE TABLE tb_transaksi(" +
                "id_transaksi INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_produk INTEGER," +
                "id_user INTEGER," +
                "tanggal DATE,"+"keterangan VARCHAR(200));";
        String pembayaran =  "CREATE TABLE tb_pembayaran(" +
                "id_pembayaran INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tanggal DATE," +
                "total_bayar INTEGER," +
                "id_transaksi DATE);";
        String pembeli =  "CREATE TABLE tb_pembeli(" +
                "id_pembeli INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_pembeli VARCHAR(30)," +
                "jk VARCHAR(20)," +
                "no_telp VARCHAR(50)," +
                "alamat TEXT);";

        db.execSQL(query);
        db.execSQL(produk);
        db.execSQL(transaksi);
        db.execSQL(pembayaran);
        db.execSQL(pembeli);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_user" );
        onCreate(db);
    }

    public long AddUser(String nama,String username,String password,String jkl,String alamat,String status_members){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(ModelLogin.Column_2,nama);
        values.put(ModelLogin.Column_3,username);
        values.put(ModelLogin.Column_4,password);
        values.put(ModelLogin.Column_5,jkl);
        values.put(ModelLogin.Column_6,alamat);
        values.put(ModelLogin.Column_7,status_members);
        long id = db.insert(ModelLogin.Tabel_name,null,values);
        db.close();
        return id;
    }

    public boolean checkuser(String username, String password) {
        String[] columns = { ModelLogin.Column_1} ;
        SQLiteDatabase db = getReadableDatabase();
        String selection = ModelLogin.Column_3 + "=?" + " and " + ModelLogin.Column_4 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(ModelLogin.Tabel_name, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }


}
