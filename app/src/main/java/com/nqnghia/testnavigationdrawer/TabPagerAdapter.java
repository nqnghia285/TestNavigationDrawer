package com.nqnghia.testnavigationdrawer;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nqnghia.testnavigationdrawer.ui.FirstTabFragment;
import com.nqnghia.testnavigationdrawer.ui.SecondTabFragment;
import com.nqnghia.testnavigationdrawer.ui.ThirdTabFragment;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    ArrayList<String> titleOfTabs = new ArrayList<>();

    public TabPagerAdapter(FragmentManager fm, int numOfTabs, ArrayList<String> titleOfTabs) {
        super(fm);
        if (titleOfTabs != null && titleOfTabs.size() == numOfTabs) {
            this.numOfTabs = numOfTabs;
            this.titleOfTabs.removeAll(this.titleOfTabs);
            this.titleOfTabs.addAll(titleOfTabs);
        }
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FirstTabFragment();
            case 1:
                return new SecondTabFragment();
            case 2:
                return new ThirdTabFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position < titleOfTabs.size() && position > -1) {
            return titleOfTabs.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
