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
    private List<String>refItems;
    private List<String>descItems;
    public FragmentCollectionAdapter( FragmentManager fm, ArrayList<String> zekrItems,List<String>countItesms,List<String>refItems,List<String>descItems) {
        super(fm);
        this.zekrItems = zekrItems;
        this.countItesms = countItesms;
        this.refItems = refItems;
        this.descItems = descItems;
    }

    @Override
    public Fragment getItem(int position) {
        DynamicFragment dynamicFragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", zekrItems.get(position));
        bundle.putString("count",countItesms.get(position));
        bundle.putString("ref",refItems.get(position));
        bundle.putString("desc",descItems.get(position));
        dynamicFragment.setArguments(bundle);
        return dynamicFragment;
    }

    @Override
    public int getCount() {
        return zekrItems.size();
    }
}
