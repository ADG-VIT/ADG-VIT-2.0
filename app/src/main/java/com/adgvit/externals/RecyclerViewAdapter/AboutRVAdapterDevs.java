package com.adgvit.externals.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.externals.DataModels.AboutUs;
import com.adgvit.externals.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AboutRVAdapterDevs extends RecyclerView.Adapter<ViewHolderAboutUsDevs>{
    @NonNull
    @NotNull

    Context context;
    List<AboutUs> list;

    public AboutRVAdapterDevs(@NotNull Context context, List<AboutUs> list) {
        this.context = context;
        this.list = list;
    }

    public ViewHolderAboutUsDevs onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.about_us_cardview, parent, false);
        return new ViewHolderAboutUsDevs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderAboutUsDevs holder, int position) {
        holder.nameAboutUs.setText(list.get(position).getName());
        holder.desgAboutUs.setText(list.get(position).getDesignation());
        holder.imageViewAboutUs.setImageResource(list.get(position).getPic());

        holder.github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Url = list.get(position).getGithub();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(Url));
                context.startActivity(intent);
            }
        });

        holder.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Url = list.get(position).getLinkedIn();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(Url));
                context.startActivity(intent);
            }
        });

        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Url = list.get(position).getEmail();
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + Url));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_SUBJECT, "text/plain");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolderAboutUsDevs extends RecyclerView.ViewHolder {

    ImageView imageViewAboutUs,github,linkedin,mail;
    TextView nameAboutUs, desgAboutUs;
    public ViewHolderAboutUsDevs(@NonNull @NotNull View itemView) {
        super(itemView);

        imageViewAboutUs = itemView.findViewById(R.id.image_about);
        nameAboutUs = itemView.findViewById(R.id.about_us_name);
        desgAboutUs = itemView.findViewById(R.id.aboutus_designation);
        github = itemView.findViewById(R.id.about_github);
        linkedin = itemView.findViewById(R.id.about_linkedIn);
        mail = itemView.findViewById(R.id.about_mail);
    }
}
