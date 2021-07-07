package com.example.shopee.models;

import android.database.sqlite.SQLiteDatabase;

public class ModelLogin {
    SQLiteDatabase db;
    public final static String Tabel_name="tb_user";
    public final static String Column_1="id_user";
    public final static String Column_2="nama";
    public final static String Column_3="username";
    public final static String Column_4="password";
    public final static String Column_5="jkl";
    public final static String Column_6="alamat";
    public final static String Column_7="status_members";

    private int id;
    private String note;
    private String nama;
    private String username;
    private String password;
    private String jkl;
    private String alamat;
    private String status_members;

    public static final String Create_tabel="create table "+Tabel_name+"("+Column_1+" integer primary key autoincrement,"
            +Column_2+" text null,"+Column_3+" text null,"+Column_4+" text null,"+Column_5+" text null"+Column_6+" text null";

    public ModelLogin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJkl() {
        return jkl;
    }

    public void setJkl(String jkl) {
        this.jkl = jkl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus_members() {
        return status_members;
    }

    public void setStatus_members(String status_members) {
        this.status_members = status_members;
    }
}
