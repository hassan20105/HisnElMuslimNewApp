package com.hisnElMuslem.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Activities.AzkarDetailsActivity;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

import java.util.ArrayList;
import java.util.List;

public class AzkarRecycleViewAdapter extends RecyclerView.Adapter<AzkarRecycleViewAdapter.ViewHolder> {
    Context context;
    private List<String> mData;
    private int favData;
    private LayoutInflater mInflater;
    private AzkarDBServices azkarDBServices;
    private  boolean isFavourite;


    public AzkarRecycleViewAdapter(Context context, List<String> mData,boolean isFavourite) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
        this.isFavourite = isFavourite;
        azkarDBServices = new AzkarDBServices(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.azkaritems_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String category = mData.get(position);
        holder.categoryTV.setText(category);
        if (!isFavourite) {
            try {
                favData = azkarDBServices.selectDistinctFavourite(category);
            } catch (Exception e) {
                favData = 0;
            }
            if (favData == 0) {
                holder.favImg.setImageResource(R.drawable.unfav);
            } else if (favData == 1) {
                holder.favImg.setImageResource(R.drawable.fav);
            }
        }
        else
        {
            holder.favImg.setVisibility(View.INVISIBLE);
        }

        holder.categoryTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AzkarDetailsActivity.class);
                intent.putExtra("azkarList", (ArrayList) azkarDBServices.selectZekrOnly(category));
                intent.putExtra("category",category);
                context.startActivity(intent);

            }
        });
        holder.favImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int img_unfav = 0;
                if (holder.favImg.getDrawable().getConstantState().equals(context.getResources().getDrawable(R.drawable.unfav).getConstantState())) {
                    holder.favImg.setImageResource(R.drawable.fav);
                    img_unfav = 1;
                }
                else
                {
                    holder.favImg.setImageResource(R.drawable.unfav);
                }
                azkarDBServices.updateFavouriteCatalog(category,img_unfav);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTV;
        ImageView favImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTV = itemView.findViewById(R.id.categoryTV);
            favImg = itemView.findViewById(R.id.favImg);
        }
    }


}
