package com.hisnElMuslem.myapplication.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.hisnElMuslem.myapplication.R;

public class DynamicFragment extends Fragment implements View.OnClickListener {
    private TextView display_TV,countTV,refTV ,descTV;
    private ImageView resetImgView;
    private CardView cardview;
   private int countValue;
   private String msg,count,ref,desc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        display_TV = view.findViewById(R.id.display_TV);
        countTV = view.findViewById(R.id.countTV);
        refTV = view.findViewById(R.id.refTV);
        descTV = view.findViewById(R.id.desc_TV);
        cardview = view.findViewById(R.id.cardview);
        resetImgView = view.findViewById(R.id.resetImgView);
         msg = getArguments().getString("msg");
         count = getArguments().getString("count");
         ref = getArguments().getString("ref");
         desc = getArguments().getString("desc");
        countTV.setText(count);
        countValue = Integer.parseInt(countTV.getText().toString());
        countTV.setOnClickListener(this);
        resetImgView.setOnClickListener(this);
        refTV.setText(ref);
        display_TV.setText(msg);
        return view;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.countTV:
                countValue = Integer.parseInt(countTV.getText().toString());
                if(countValue<1) {
                    cardview.setCardBackgroundColor(R.color.pink);
                }
                else {
                    countValue -= 1;
                    countTV.setText("" + countValue);
                }
                break;
            case R.id.resetImgView:
                countTV.setText(count);
                cardview.setCardBackgroundColor(R.color.pink);
                break;

        }
    }
}
