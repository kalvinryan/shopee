package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.controller.LoginAPK;
import com.example.shopee.database.Database;
import com.example.shopee.models.ModelLogin;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword,txtonline;
    TextView tvDaftar;
    Button btnLogin,btnLogout;
    Database Usercheck;
    LoginAPK loginAPK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usercheck = new Database(this);
        loginAPK= new LoginAPK(this);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogout=(Button)findViewById(R.id.btnLogout);
        etUsername = findViewById(R.id.txtusername);
        etPassword = findViewById(R.id.txtpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                Boolean res = Usercheck.checkuser(username,password);

                if (res == true)
                {
                    loginAPK.open();
                    String updateStatus="online";
                    boolean update=loginAPK.updateStatusMembersLogin(updateStatus,username);
                    if(update = true){
                        Intent homepage = new Intent(MainActivity.this, Home.class);
                        startActivity(homepage);
                        Toast.makeText(MainActivity.this, "Log in Berhasil ", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Log Status gagal terupdate ", Toast.LENGTH_SHORT).show();
                    }
                    loginAPK.close();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Log in Gagal ", Toast.LENGTH_SHORT).show();

                }

            }
        });
        Button Btndaftar=(Button)findViewById(R.id.btnDaftar);
        Btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(MainActivity.this,daftar.class);
                startActivity(Login);
            }
        });
    }


}