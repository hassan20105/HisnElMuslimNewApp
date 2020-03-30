package com.hisnElMuslem.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.hisnElMuslem.myapplication.Fragments.FragmentCollectionAdapter;
import com.hisnElMuslem.myapplication.R;

import java.util.ArrayList;

public class AzkarDetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentCollectionAdapter adapter;
    private TextView headerNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar_details);
        headerNameTV = findViewById(R.id.headerName);
        headerNameTV.setText(getIntent().getStringExtra("category"));
        ArrayList<String> zekrItems = getIntent().getStringArrayListExtra("azkarList");
        viewPager = findViewById(R.id.view_pager);
        adapter = new FragmentCollectionAdapter(getSupportFragmentManager(), zekrItems);
        viewPager.setAdapter(adapter);


    }

    public void onClickActionBar(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
