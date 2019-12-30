package com.example.huashangdian.NewItemsPackage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragment;

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public MyPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        mFragment=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

}
