package com.example.navigator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
// import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelStore;

import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //flash screen

       /* getWindow().setFlags(WindowManager.LayoutParams.FLAGS_FULLSCREEN,WindowManager.LayoutParams.FLAGS_FULLSCREEN);
        ImageView imageView=findViewById(R.id.image);
        Animation animation= AnimationUtils.LoadAnimation(this,R.Anim.animation_bike);
        imageView.startAnimation(animation);


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // startActivities(new Intent(MainActivity.this,));

            },delayMillis 5000);
        });*/


//close animation scrn


                drawerLayout = findViewById(R.id.drawer_layout);
                navigationView = findViewById(R.id.nav_view);
                toolbar = findViewById(R.id.toolbar);

                setSupportActionBar(toolbar);

        Menu menu=navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

                navigationView.bringToFront();
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawerLayout.addDrawerListener(toggle);
                toggle.syncState();
                navigationView.setNavigationItemSelectedListener(this);

                navigationView.setCheckedItem(R.id.home);
                }

@Override
 public void  onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.closeDrawer(GravityCompat.START);
    } else
        {
        super.onBackPressed();
    }
}

public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    switch (menuItem.getItemId()) {
        case R.id.home:
            break;
        case R.id.nav_bus:
            Intent intent = new Intent(MainActivity.this, Bus.class);
            startActivity(intent);
            break;

        case R.id.nav_share:
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
            break;
    }
    drawerLayout.closeDrawer(GravityCompat.START);
    return true;
}
}