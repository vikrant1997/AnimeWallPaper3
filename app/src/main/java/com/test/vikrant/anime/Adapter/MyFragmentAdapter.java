package com.test.vikrant.anime.Adapter;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
<<<<<<< HEAD

import com.test.vikrant.anime.fragment.CategoryFragment;
import com.test.vikrant.anime.fragment.TrendingFragment;
import com.test.vikrant.anime.fragment.FavoriteFragment;
=======
import android.support.v4.view.ViewPager;

import com.test.vikrant.anime.R;
import com.test.vikrant.anime.fragment.CategoryFragment;
import com.test.vikrant.anime.fragment.DailyPopularFragment;
import com.test.vikrant.anime.fragment.RecentsFragment;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

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
<<<<<<< HEAD
            return TrendingFragment.getINSTANCE();
        else if (position == 2) return FavoriteFragment.getINSTANCE();
=======
            return DailyPopularFragment.getINSTANCE();
        else if (position == 2) return RecentsFragment.getINSTANCE();
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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
<<<<<<< HEAD
                return "Trending";
            case 2:
                return "Favorite";
=======
                return "Popular";
            case 2:
                return "Recents";
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        }
        return "";
    }

<<<<<<< HEAD
}
=======
}
=======
public class MyFragmentAdapter {
}
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
