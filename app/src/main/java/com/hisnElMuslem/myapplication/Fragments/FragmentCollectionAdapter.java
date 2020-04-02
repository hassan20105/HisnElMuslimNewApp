package com.hisnElMuslem.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

import java.util.ArrayList;
import java.util.List;

public class FragmentCollectionAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> zekrItems;
    private List<String>countItesms;
    public FragmentCollectionAdapter( FragmentManager fm, ArrayList<String> zekrItems,List<String>countItesms) {
        super(fm);
        this.zekrItems = zekrItems;
        this.countItesms = countItesms;


    }

    @Override
    public Fragment getItem(int position) {
        DynamicFragment dynamicFragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", zekrItems.get(position));
        bundle.putString("count",countItesms.get(position));
        dynamicFragment.setArguments(bundle);
        return dynamicFragment;
    }

    @Override
    public int getCount() {
        return zekrItems.size();
    }
}
