package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.DataModels.AboutUs;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AboutRVAdapter extends RecyclerView.Adapter<ViewHolderAboutUs>{
    @NonNull
    @NotNull

    Context context;
    ArrayList<AboutUs> list;

    public AboutRVAdapter(@NotNull Context context, ArrayList<AboutUs> list) {
        this.context = context;
        this.list = list;
    }

    public ViewHolderAboutUs onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.about_us_cardview, parent, false);
        return new ViewHolderAboutUs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderAboutUs holder, int position) {
        holder.nameAboutUs.setText(list.get(position).getName());
        holder.desgAboutUs.setText(list.get(position).getDesignation());



        Glide.with(context)
        .load(list.get(position).getPic())
                .into(holder.imageViewAboutUs);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolderAboutUs extends RecyclerView.ViewHolder {

    ImageView imageViewAboutUs;
    TextView nameAboutUs, desgAboutUs;

    public ViewHolderAboutUs(@NonNull @NotNull View itemView) {
        super(itemView);

        imageViewAboutUs = itemView.findViewById(R.id.image_about);
        nameAboutUs = itemView.findViewById(R.id.about_us_name);
        desgAboutUs = itemView.findViewById(R.id.aboutus_designation);
    }
}
