package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shopee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    public TextView txtdata;
    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f =new FragmentHome();
                    break;
                case R.id.menu_notif:
                    f =new FragmentNotifikasi();
                    break;
                case R.id.menu_profile:
                    f =new FragmentSaya();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Fragment f =null;
        f=new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
//        myfragment(new FragmentHome());
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
    }


//    private void myfragment(Fragment  UI){
//        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container_fragment,UI);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }
}