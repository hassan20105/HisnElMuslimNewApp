package com.hisnElMuslem.myapplication.ui.Setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Utilities.SharedPrefrenceUtilities;

public class SettingFragmnet extends Fragment {
    private Switch vibrateSwitch, soundSwitch;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment_layout, container, false);
        vibrateSwitch = view.findViewById(R.id.vibrateSwitch);
        soundSwitch = view.findViewById(R.id.soundSwitch);
        sharedPref = getActivity().getSharedPreferences(SharedPrefrenceUtilities.MyPREFERENCES, Context.MODE_PRIVATE);
        if (SharedPrefrenceUtilities.isSharedDataFound(sharedPref)) {
            vibrateSwitch.setChecked(sharedPref.getBoolean(SharedPrefrenceUtilities.vibrateValue, false));
            soundSwitch.setChecked(sharedPref.getBoolean(SharedPrefrenceUtilities.soundValue, false));
        }
        vibrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor = sharedPref.edit();
                editor.putBoolean(SharedPrefrenceUtilities.vibrateValue, isChecked);
                editor.commit();
            }
        });
        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor = sharedPref.edit();
                editor.putBoolean(SharedPrefrenceUtilities.soundValue, isChecked);
                editor.commit();
            }
        });

        return view;
    }




}
