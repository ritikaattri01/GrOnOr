package com.example.nutritionking;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class BottomNav extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
       //For setting navigation item selector listener
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment( new Homepage()); // first fragment will be homepage
    }
    //To load new fragment and replace old fragment
    public boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }
    //For selecting the nav bar icons
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment= new Homepage();
                break;
            case R.id.navigation_dashboard:
                fragment= new OrderPage();
                break;
            case R.id.navigation_notifications:
                fragment= new ProfilePage();
                break;
        }
            return loadFragment(fragment);
    }
     //byDefault
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
