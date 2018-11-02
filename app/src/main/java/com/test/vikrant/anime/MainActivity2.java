package com.test.vikrant.anime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.test.vikrant.anime.BottomBar.Bottom_List_Category;
import com.test.vikrant.anime.fragment.TrendingFragment;
import com.test.vikrant.anime.fragment.FavoriteFragment;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private Toolbar mainToolbar;
    private Toolbar toolbar;
    private Fragment fragment=null;
    private SearchView searchView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        fragment=HomeActivity.getINSTANCE();
        loadFragment(fragment);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        toolbar=(Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle("FasAnime");

        setSupportActionBar(toolbar);

        // toolbar fancy stuff

        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar
                ,R.string.OpenNavigation, R.string.CloseNavigationBar);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.getMenu().removeItem(R.menu.menu_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(new
        BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = HomeActivity.getINSTANCE();
                        loadFragment(fragment);
                        return true;
                    case R.id.action_list:
                        fragment= Bottom_List_Category.getINSTANCE();
                        loadFragment(fragment);
                        return true;
                    case R.id.action_donate:
                        fragment=DonateActivity.getINSTANCE();
                        loadFragment(fragment);
                        return true;
                }
                if(fragment!=null) {
                    FragmentTransaction transaction =
                            getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container, fragment);
                    transaction.commit();
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_item_home) {
            fragment= HomeActivity.getINSTANCE();
            loadFragment(fragment);
            //drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_item_explore) {
            fragment= Bottom_List_Category.getINSTANCE();
            loadFragment(fragment);

        }  else if (id == R.id.nav_item_suport) {
            fragment=DonateActivity.getINSTANCE();
            loadFragment(fragment);
            //drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_item_share) {

        }else if(id==R.id.nav_item_rate){

        }
        //drawer.closeDrawers();
        //drawer.closeDrawer(GravityCompat.START);
        if (item.isChecked()) {
            item.setChecked(false);
        } else {
            item.setChecked(false);
        }
        //item.setChecked(true);
        return false;
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack();
        transaction.disallowAddToBackStack();
        transaction.commit();
        if(drawer!=null)
        drawer.closeDrawers();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        item.setVisible(false);//
        invalidateOptionsMenu();
        super.onCreateOptionsMenu(menu);
        return true;

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        searchView = (SearchView) menu.findItem(R.id.action_search)
//                .getActionView();
//        searchView.setVisibility(View.INVISIBLE);
//        return true;
//    }


}
