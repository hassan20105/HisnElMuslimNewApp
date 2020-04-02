package com.hisnElMuslem.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Activities.FavouriteAzkarActivity;
import com.hisnElMuslem.myapplication.Adapters.AzkarRecycleViewAdapter;
import com.hisnElMuslem.myapplication.Model.ZekrItems;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;
import com.hisnElMuslem.myapplication.Utilities.CSVFile;

import java.io.InputStream;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    private AzkarDBServices azkarDBServices;
    private AzkarRecycleViewAdapter recyclerViewAdapter;
    private ImageView favImg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.rec_azkar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        azkarDBServices = new AzkarDBServices(getActivity());
        if (azkarDBServices.selectZekrDetail().isEmpty()) {
            requestCSVFile();
        }
        recyclerViewAdapter = new AzkarRecycleViewAdapter
                (getActivity(), azkarDBServices.selectCategoryDetail(),false);
        recyclerView.setAdapter(recyclerViewAdapter);
        favImg = root.findViewById(R.id.favImg);
        favImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FavouriteAzkarActivity.class));
            }
        });


        return root;
    }
    public void requestCSVFile() {
        InputStream inputStream = getResources().openRawResource(R.raw.sql);
        CSVFile csvFile = new CSVFile(inputStream);
        List<ZekrItems> zekrItems = csvFile.read();
        for (int i = 0; i < zekrItems.size(); i++) {
            azkarDBServices.insertZekr(zekrItems.get(i));
        }
    }
}
