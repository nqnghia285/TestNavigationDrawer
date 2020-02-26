package com.nqnghia.testnavigationdrawer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawer).build();

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    Log.e(TAG, "onCreate: " + menuItem.getItemId());
                    navController.navigate(R.id.nav_home);
                    break;
                case R.id.nav_gallery:
                    Log.e(TAG, "onCreate: " + menuItem.getItemId());
                    navController.navigate(R.id.nav_gallery);
                    break;
                case R.id.nav_slideshow:
                    Log.e(TAG, "onCreate: " + menuItem.getItemId());
                    navController.navigate(R.id.nav_slideshow);
                    break;
            }
            drawer.closeDrawer(Gravity.START);
            return true;
        });

        navigationView.setCheckedItem(R.id.nav_slideshow);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            Menu menu = navigationView.getMenu();
            for (int h = 0, size = menu.size(); h < size; h++) {
                MenuItem item = menu.getItem(h);
                NavDestination currentDestination = destination;
                while (currentDestination.getId() != item.getItemId() && currentDestination.getParent() != null) {
                    currentDestination = currentDestination.getParent();
                }
                item.setChecked(currentDestination.getId() == item.getItemId());
            }
            drawer.closeDrawer(Gravity.START);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
