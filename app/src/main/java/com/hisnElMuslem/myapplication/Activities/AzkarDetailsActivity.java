package com.hisnElMuslem.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.hisnElMuslem.myapplication.Fragments.FragmentCollectionAdapter;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

import java.util.ArrayList;
import java.util.List;

public class AzkarDetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentCollectionAdapter adapter;
    private TextView headerNameTV;
   private AzkarDBServices azkarDBServices ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar_details);
        azkarDBServices = new AzkarDBServices(this);
        headerNameTV = findViewById(R.id.headerName);
        headerNameTV.setText(getIntent().getStringExtra("category"));
        ArrayList<String> zekrItems = getIntent().getStringArrayListExtra("azkarList");
        List<String>countItems = azkarDBServices.selectCountOfZekrCategoryDetail(getIntent().getStringExtra("category"));
        List<String>refItems = azkarDBServices.selectReferenceOfZekrCategoryDetail(getIntent().getStringExtra("category"));
        List<String>descItems = azkarDBServices.selectDescriptionOfZekrCategoryDetail(getIntent().getStringExtra("category"));
        viewPager = findViewById(R.id.view_pager);
        adapter = new FragmentCollectionAdapter(getSupportFragmentManager(), zekrItems,countItems,refItems,descItems);
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
