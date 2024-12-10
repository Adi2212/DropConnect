package com.example.dropconnect;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.dropconnect.Freagment.ReceivedFragment;
import com.example.dropconnect.Freagment.SavedFragment;
import com.example.dropconnect.Freagment.SentFragment;
import com.example.dropconnect.Freagment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set SentFragment as the default fragment
        if (savedInstanceState == null) {
            loadFragment(new SentFragment());
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.nav_sent) {
                    selectedFragment = new SentFragment();
                } else if (item.getItemId() == R.id.nav_received) {
                    selectedFragment = new ReceivedFragment();
                } else if (item.getItemId() == R.id.nav_saved) {
                    selectedFragment = new SavedFragment();
                } else if (item.getItemId() == R.id.nav_setting) {
                    selectedFragment = new SettingFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
                return true;
            }
        });

    }

    // Method to load the selected fragment
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.commit();
    }
}