package com.test.vikrant.anime;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.test.vikrant.anime.BottomBar.BottomNavigationBehavior;
import com.test.vikrant.anime.BottomBar.Bottom_List_Category;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private Toolbar mainToolbar;
    private Toolbar toolbar;
    private Fragment fragment=null;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragment=HomeActivity.getINSTANCE();
        loadFragment(fragment);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        toolbar=(Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle("FasAnime");

        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar
                ,R.string.OpenNavigation, R.string.CloseNavigationBar);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack();
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
}
