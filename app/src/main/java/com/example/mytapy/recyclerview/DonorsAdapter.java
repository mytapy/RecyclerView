package com.example.mytapy.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DonorsAdapter extends RecyclerView.Adapter<DonorsAdapter.CustomViewHolder> {


    Context context;
    ArrayList<Donors> donorList;

    public DonorsAdapter(Context context, ArrayList<Donors> donorList) {
        this.context = context;
        this.donorList = donorList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Donors donor = donorList.get(position);
        holder.tvDisplayName.setText(donor.getFirstName());
        holder.tvEmailID.setText(donor.getEmail());
    }

    @Override
    public int getItemCount() {
        return donorList.size() ;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // ImageView ivProfilePic;
        TextView tvDisplayName;
        TextView tvEmailID;

        public CustomViewHolder(View itemView) {
            super(itemView);
            // ivProfilePic = (ImageView) itemView.findViewById(R.id.ivProfilePic);
            tvDisplayName = (TextView) itemView.findViewById(R.id.tvDisplayName);
            tvEmailID = (TextView) itemView.findViewById(R.id.tvEmail);

        }
    }
}
