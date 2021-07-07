package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.database.Database;


public class daftar extends AppCompatActivity {
    EditText etnama;
    EditText etUsername;
    EditText etpassword;
    EditText etalamat;
    Button btnDaftar;
    RadioGroup rgender;
    Database LoginUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        etnama=findViewById(R.id.txtnama);
        etUsername=findViewById(R.id.txtusername);
        etpassword=findViewById(R.id.txtpassword);
        etalamat=findViewById(R.id.txtalamat);
        rgender=(RadioGroup)findViewById(R.id.rdgroup);
        btnDaftar=(Button)findViewById(R.id.btnDaftar);
        LoginUser= new Database(this);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jkl="";
                String nama=etnama.getText().toString();
                String username=etUsername.getText().toString();
                String password=etpassword.getText().toString();
                String alamat=etalamat.getText().toString();
                String membrs="register";

                int id = rgender.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rgblaki:
                        jkl="Laki-laki";
                        break;
                    case R.id.rgbperempuan:
                        jkl="Perempuan";
                        break;
                }
                long val = LoginUser.AddUser(nama,username,password,jkl,alamat,membrs);
                if (val > 0) {
                    Toast.makeText(daftar.this, "Anda Telah Terdafar", Toast.LENGTH_SHORT).show();
                    Intent moveTologin =  new Intent(daftar.this, MainActivity.class);
                    startActivity(moveTologin);
                }
                else {
                    Toast.makeText(daftar.this, "Pendaftaran Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button btnkembali=(Button)findViewById(R.id.Btnback);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(daftar.this,MainActivity.class);
                startActivity(back);
            }
        });
    }


}