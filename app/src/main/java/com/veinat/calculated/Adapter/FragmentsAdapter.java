package com.veinat.calculated.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentsAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    private Fragment fragment1, fragment2, fragment3;

    public FragmentsAdapter(FragmentManager fm, int numOfTabs, Fragment fragment1, Fragment fragment2, Fragment fragment3) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.fragment1 = fragment1;
        this.fragment2 = fragment2;
        this.fragment3 = fragment3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragment1;
            case 1:
                return fragment2;
            case 2:
                return fragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
