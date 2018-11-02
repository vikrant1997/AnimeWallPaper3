package com.test.vikrant.anime.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.test.vikrant.anime.fragment.CategoryFragment;
import com.test.vikrant.anime.fragment.TrendingFragment;
import com.test.vikrant.anime.fragment.FavoriteFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return CategoryFragment.getINSTANCE();
        else if (position == 1)
            return TrendingFragment.getINSTANCE();
        else if (position == 2) return FavoriteFragment.getINSTANCE();
        else return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Category";
            case 1:
                return "Trending";
            case 2:
                return "Favorite";
        }
        return "";
    }

}