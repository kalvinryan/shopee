package com.example.shopee.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.shopee.database.Database;
import com.example.shopee.models.ModelLogin;
import com.example.shopee.models.ProdukDetails;

import java.util.ArrayList;
import java.util.List;

public class LoginAPK {
    private SQLiteDatabase db,dbRead;
    private Database database;
    List<ProdukDetails> produkDetails = new ArrayList<>();
    public final static String Tabel_name="tb_user";
    public final static String Column_1="id";
    public final static String Column_2="nama";
    public final static String Column_3="username";
    public final static String Column_4="password";
    public final static String Column_5="jkl";
    public final static String Column_6="alamat";
    public final static String Column_7="status_members";


    String[] allProduk={Column_2,Column_3,Column_4,Column_5,Column_6,};

    public LoginAPK(Context context) {
        database=new Database(context);
    }
    public void open() throws SQLException {
        db=database.getWritableDatabase();
    }
    public void close(){
        database.close();
    }

    public boolean updateStatusMembersLogin(String status,String nama){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_7,status);
        db.update(Tabel_name,contentValues, "username = ?",new String[]{nama});
        return true;
    }
    public boolean updateStatusMembersLogout(String status,String id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_7,status);
        db.update(Tabel_name,contentValues, " id_user = "+id,null);
        return true;
    }
    public ModelLogin getOnlineUser(String status_members){
        String query = "SELECT * FROM "+ Tabel_name +" WHERE "+ Column_7 +" =\""+status_members+"\";";
        db=database.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        ModelLogin modelLogin=new ModelLogin();
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            modelLogin.setId(Integer.valueOf(cursor.getInt(0)));
            modelLogin.setNama(cursor.getString(1));
            modelLogin.setAlamat(cursor.getString(5));
        }else {
            modelLogin=null;
        }
        return modelLogin;
    }


}
