package com.example.sieuthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    BottomNavigationView bottomNav;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.viewPagerMain);
        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNavigationMain);
        viewPagerAdapter = new ViewPagerAdapter(this);

        // View Pager

        setUpViewPager();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_product:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_notifications:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_account:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        viewPager.setCurrentItem(0);
                }
                return true;
            }
        });

        // share preferences luu thong tin dang nhap
        sharedPreferences = getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("hoten");
        editor.remove("sdt");
        editor.remove("gioitinh");
        editor.remove("email");
        editor.putString("username", "tam");
        editor.putString("hoten", "Nguyễn Hồng Tâm");
        editor.putString("sdt", "0386396597");
        editor.putString("gioitinh", "nu");
        editor.putString("email", "tttt@gmail.com");

        editor.commit();

    }



    @SuppressLint("WrongConstant")
    private void setUpViewPager() {
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setLayoutDirection(View.TEXT_DIRECTION_LTR);
        viewPager.setPageTransformer(new DepthPageTransformer());

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNav.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.action_product).setChecked(true);
                        break;
                    case 2:
                        bottomNav.getMenu().findItem(R.id.action_notifications).setChecked(true);
                        break;
                    case 3:
                        bottomNav.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;
                    default:
                        bottomNav.getMenu().findItem(R.id.action_home).setChecked(true);
                }
            }
        });
    }
}