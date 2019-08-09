package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import static com.example.navigationview.R.id.firstItem;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener ,
        FirstFragment.OnFragmentInteractionListener,
        SecondFragment.OnFragmentInteractionListener,
        ThirdFragment.OnFragmentInteractionListener
{

    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.main, new ThirdFragment())
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new SecondFragment())
                .commit();*/
         drawer = findViewById(R.id.main);
        NavigationView navigationView = findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        int item;
//        item = menuItem.getItemId();

        Fragment fragment = null;

        Class fragmentClass = null;
        System.out.println("hello" );
        switch (menuItem.getItemId()){
            case (R.id.firstItem): {
                fragmentClass = FirstFragment.class;
                System.out.println("-------------------1111");
                break;}
            case (R.id.secondItem): {
                fragmentClass =  SecondFragment.class;
                System.out.println("--------------------222");break;}
            case (R.id.thirdItem): {
                fragmentClass =  ThirdFragment.class;
                System.out.println("--------------------3333");break;}
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
        menuItem.setChecked(true);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onFragmentInteractionFirst(Uri uri) {

    }

    @Override
    public void onFragmentInteractionSecond(Uri uri) {

    }

    @Override
    public void onFragmentInteractionThird(Uri uri) {

    }
}
