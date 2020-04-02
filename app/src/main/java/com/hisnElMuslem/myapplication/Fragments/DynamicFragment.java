package com.hisnElMuslem.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hisnElMuslem.myapplication.R;

public class DynamicFragment extends Fragment {
    private TextView display_TV,countTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        display_TV = view.findViewById(R.id.display_TV);
        countTV = view.findViewById(R.id.countTV);
        String msg = getArguments().getString("msg");
        String count = getArguments().getString("count");
        display_TV.setText(msg);
        if(count.equals(null)||count.equals("1")||count.equals("مرة وأحدة"))
        countTV.setText("مرة واحدة");
        else
            countTV.setText(count);
        return view;
    }
}
