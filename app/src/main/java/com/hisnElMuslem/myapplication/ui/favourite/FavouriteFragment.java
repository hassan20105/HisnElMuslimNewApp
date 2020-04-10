package com.hisnElMuslem.myapplication.ui.favourite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Activities.MainActivity;
import com.hisnElMuslem.myapplication.Adapters.AzkarRecycleViewAdapter;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

public class FavouriteFragment extends Fragment {


    private FavouriteViewModel galleryViewModel;
    RecyclerView recyclerView;
    private AzkarDBServices azkarDBServices;
    private AzkarRecycleViewAdapter recyclerViewAdapter;
    private ImageView fback;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(FavouriteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favourite, container, false);
        fback = root.findViewById(R.id.fback);
        fback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        recyclerView = root.findViewById(R.id.rec_azkar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        azkarDBServices = new AzkarDBServices(getActivity());
        recyclerViewAdapter = new AzkarRecycleViewAdapter
                (getActivity(), azkarDBServices.selectFavouriteCategoryDetail(),true);
        recyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }
}
