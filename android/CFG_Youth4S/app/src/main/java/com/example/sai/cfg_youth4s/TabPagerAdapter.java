package com.example.sai.cfg_youth4s;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sai on 15-06-2018.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private String titles[]={"Education","Environment","Health","Enablement"};
    public TabPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new Education();
        if(position == 1)
            return new Environment();
        else if(position == 2)
            return new Health();
        else if(position == 3)
            return new Enablement();
        else
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }
}

