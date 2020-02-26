package com.nqnghia.testnavigationdrawer.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.nqnghia.testnavigationdrawer.R;
import com.nqnghia.testnavigationdrawer.TabPagerAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";
    private HomeViewModel homeViewModel;
    private TabPagerAdapter tabPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager = root.findViewById(R.id.viewPager);

        ArrayList<String> titleOfTabs = new ArrayList<>();
        titleOfTabs.add("First");
        titleOfTabs.add("Second");
        titleOfTabs.add("Third");

        // Note: getChildFragmentManager()
        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount(), titleOfTabs);
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Button firstToSecond = root.findViewById(R.id.action_first_to_second);
                Button firstToThird = root.findViewById(R.id.action_first_to_third);
                Button secondToFirst = root.findViewById(R.id.action_second_to_first);
                Button secondToThird = root.findViewById(R.id.action_second_to_third);
                Button thirdToFirst = root.findViewById(R.id.action_third_to_first);
                Button thirdToSecond = root.findViewById(R.id.action_third_to_second);

                switch (viewPager.getCurrentItem()) {
                    case 0:
                        if (firstToSecond != null && firstToThird != null) {
                            firstToSecond.setOnClickListener(HomeFragment.this::onClick);
                            firstToThird.setOnClickListener(HomeFragment.this::onClick);
                        }
                        break;
                    case 1:
                        if (secondToFirst != null && secondToThird != null) {
                            secondToFirst.setOnClickListener(HomeFragment.this::onClick);
                            secondToThird.setOnClickListener(HomeFragment.this::onClick);
                        }
                        break;
                    case 2:
                        if (thirdToFirst != null && thirdToSecond != null) {
                            thirdToFirst.setOnClickListener(HomeFragment.this::onClick);
                            thirdToSecond.setOnClickListener(HomeFragment.this::onClick);
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (viewPager != null) {
            switch (v.getId()) {
                case R.id.action_second_to_first:
                case R.id.action_third_to_first:
                    Log.e(TAG, "to_first_tab_btn");
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.action_first_to_second:
                case R.id.action_third_to_second:
                    Log.e(TAG, "to_second_tab_btn");
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.action_first_to_third:
                case R.id.action_second_to_third:
                    Log.e(TAG, "to_third_tab_btn");
                    viewPager.setCurrentItem(2);
                    break;
                default:
                    break;
            }
        }
    }
}
