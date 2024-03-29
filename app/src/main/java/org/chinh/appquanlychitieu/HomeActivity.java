package org.chinh.appquanlychitieu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.chinh.appquanlychitieu.ui.adapter.AdapterViewPager;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.fragment.FragmentKhoanThu;
import org.chinh.appquanlychitieu.ui.fragment.FragmentThongKe;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);

        fragmentArrayList.add(new FragmentHome());
        fragmentArrayList.add(new FragmentKhoanThu());
        fragmentArrayList.add(new FragmentThongKe());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.setSelectedItemId(R.id.itHome);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.itUser);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.itFavorite);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // Lấy ID của MenuItem
                if (itemId == R.id.itHome) {
                    pagerMain.setCurrentItem(0);
                } else if (itemId == R.id.itUser) {
                    pagerMain.setCurrentItem(1);
                } else if (itemId == R.id.itFavorite) {
                    pagerMain.setCurrentItem(2);
                }

                return true;
            }
        });
    }


}