package com.test.vikrant.anime.Adapter;

<<<<<<< HEAD
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.test.vikrant.anime.R;
import com.test.vikrant.anime.fragment.CategoryFragment;
import com.test.vikrant.anime.fragment.DailyPopularFragment;
import com.test.vikrant.anime.fragment.RecentsFragment;

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
            return DailyPopularFragment.getINSTANCE();
        else if (position == 2) return RecentsFragment.getINSTANCE();
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
                return "Popular";
            case 2:
                return "Recents";
        }
        return "";
    }

}
=======
public class MyFragmentAdapter {
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
