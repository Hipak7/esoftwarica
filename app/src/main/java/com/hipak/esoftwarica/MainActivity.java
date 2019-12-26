package com.hipak.esoftwarica;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hipak.esoftwarica.adapter.Students;
import com.hipak.esoftwarica.fragment.AboutFragment;
import com.hipak.esoftwarica.fragment.AddFragment;
import com.hipak.esoftwarica.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Students> studentsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (studentsList.isEmpty()) {
            studentsList.add(new Students("Raaj Kayastha ", "male", "Nepal, Kathmandu", 20));
            studentsList.add(new Students("Prakriti Pradhan", "female", "USA, New York", 19));
            studentsList.add(new Students("Anita Shrestha", "female", "Australia, Sydney", 21));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navHome:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navAddStudent:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.navAboutUs:
                    selectedFragment = new AboutFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        return true;
        }
    };

}
