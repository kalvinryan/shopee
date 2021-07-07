package com.example.shopee.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopee.R;
import com.example.shopee.controller.LoginAPK;
import com.example.shopee.models.ModelLogin;

public class FragmentSaya extends Fragment {
    public static String KEY_ACTIVITY="";
    TextView txtNamaUserku,alamat,txtid;
    Button Logout,jualBarang,btnakun;
    ImageButton bayar,kirim,kemas,riwayat;
    LoginAPK loginAPK;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_saya,container,false);
        View view= inflater.inflate(R.layout.fragment_saya,container,false);

        txtNamaUserku=(TextView) view.findViewById(R.id.txtNamaUser);
        txtid=(TextView) view.findViewById(R.id.txtIdUser);
        bayar=(ImageButton) view.findViewById(R.id.btnbayar);
        kemas=(ImageButton) view.findViewById(R.id.btnkemas);
        kirim=(ImageButton) view.findViewById(R.id.btnkirim);
        btnakun=(Button) view.findViewById(R.id.btnAkun);
        alamat=(TextView) view.findViewById(R.id.txtAlamatSaya);

        String ol = "online";
        loginAPK=new LoginAPK(getContext());
        ModelLogin modelLogin = loginAPK.getOnlineUser(ol);
        if (modelLogin !=null){
            txtid.setText(String.valueOf(modelLogin.getId()));
            txtNamaUserku.setText(modelLogin.getNama());
            alamat.setText("Alamat : "+modelLogin.getAlamat());
        }else {
            Toast.makeText(getActivity(),"gagal",Toast.LENGTH_LONG).show();
        }
        loginAPK.close();

        bayar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dibayar= new Intent(getActivity(), com.example.shopee.views.bayar.class);
                startActivity(dibayar);
            }
        });
        kemas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dikemas=new Intent(getActivity(), com.example.shopee.views.kemas.class);
                startActivity(dikemas);
            }
        });


        Logout=(Button) view.findViewById(R.id.btnLogout);
        Logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAPK = new LoginAPK(getContext());
                loginAPK.open();
                String updateStatus="offline";
                boolean update=loginAPK.updateStatusMembersLogout(updateStatus,txtid.getText().toString());
                if(update = true){
                    txtNamaUserku.setText("");
                    alamat.setText("");
                    Intent Login = new Intent(getActivity(),MainActivity.class);
                    startActivity(Login);
                    getActivity().finish();
                }else{
                    Toast.makeText(getActivity(),"Gagal update",Toast.LENGTH_LONG).show();
                }
                loginAPK.close();

            }
        });

        jualBarang=(Button) view.findViewById(R.id.btnJual_brg);
        jualBarang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formJualBrg = new Intent(getActivity(),AddProduct.class);
                startActivity(formJualBrg);
            }
        });
        btnakun.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;

    }

}
