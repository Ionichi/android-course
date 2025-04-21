package com.ionichi.tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private NewsFragment _newsFragment = new NewsFragment();
    private Context _context;
    private ECommerceFragment _ecommerceFragment = new ECommerceFragment();
    private int _tabCount;
    private CampusFragment _campusFragment = new CampusFragment();

    public MyFragmentPagerAdapter(Context context, FragmentManager fm, int tabCount) {
        super(fm);

        _context = context;
        _tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return _ecommerceFragment;
            case 1:
                return _newsFragment;
            default:
                return _campusFragment;
        }
    }

    @Override
    public int getCount() {
        return _tabCount;
    }
}
