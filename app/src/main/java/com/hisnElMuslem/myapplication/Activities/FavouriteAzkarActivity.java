package com.hisnElMuslem.myapplication.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Adapters.AzkarRecycleViewAdapter;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

public class FavouriteAzkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private AzkarDBServices azkarDBServices;
    private AzkarRecycleViewAdapter recyclerViewAdapter;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setContentView(R.layout.activity_favourite_azkar);
        recyclerView = findViewById(R.id.rec_azkar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        azkarDBServices = new AzkarDBServices(this);
        recyclerViewAdapter = new AzkarRecycleViewAdapter
                (this, azkarDBServices.selectFavouriteCategoryDetail(),true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    public void onClickFavActionBar(View view) {
        switch (view.getId())
        {
            case R.id.fback:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
