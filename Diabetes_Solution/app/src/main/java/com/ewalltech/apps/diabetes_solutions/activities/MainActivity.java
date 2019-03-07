package com.ewalltech.apps.diabetes_solutions.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.ewalltech.apps.diabetes_solutions.R;
import com.ewalltech.apps.diabetes_solutions.db.DBHelper;
import com.ewalltech.apps.diabetes_solutions.fragments.HomeFragment;
import com.ewalltech.apps.diabetes_solutions.fragments.TensorFlowFragment;
import com.ewalltech.apps.diabetes_solutions.maps.MappingActivity;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.home_fragment:
                    selectedFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                case R.id.location_fragment:
                    Intent intent=new Intent(getApplicationContext(), MappingActivity.class);
                    startActivity(intent);
//                    selectedFragment = new LocationFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//                    return true;
                case R.id.tensorflow_fragment:
                    selectedFragment = new TensorFlowFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper.getHelper(this);//.onCreate(Constants.config.DB_NAME);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

}
