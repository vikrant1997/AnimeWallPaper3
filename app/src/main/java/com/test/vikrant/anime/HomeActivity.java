package com.test.vikrant.anime;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.test.vikrant.anime.Adapter.MyFragmentAdapter;
import com.test.vikrant.anime.BottomBar.BottomNavigationBehavior;

public class HomeActivity extends Fragment {

   private ViewPager viewPager;
   private TabLayout tabLayout;
    private FragmentActivity myContext;
    private MyFragmentAdapter adapter;
    private Toolbar toolbar;
    private static HomeActivity INSTANCE =null;
    private View view;
    public HomeActivity(){}
    private BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Test1","hello");
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.content_home, container, false);

        adapter = new MyFragmentAdapter(getChildFragmentManager(),getContext());
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);
        tabLayout = view.findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        return view;
    }

    public static HomeActivity getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new HomeActivity();
        return INSTANCE;
    }

=======
public class HomeActivity {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
}
