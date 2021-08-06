package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.JavaActivities.ProjectDetailsView;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>{
    private Context context;
    private List<ProjectItems> list;

    public ProjectsAdapter(List<ProjectItems> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_projects, parent,false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProjectsAdapter.ProjectViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).override(300).into(holder.projectImage);
        holder.name.setText(list.get(position).getName());
        holder.shortDescp.setText(list.get(position).getShortDescp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),ProjectDetailsView.class);
                intent.putExtra("id", list.get(position).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder{
        ImageView projectImage;
        TextView name, shortDescp;
        public ProjectViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            projectImage = itemView.findViewById(R.id.project_imageview);
            name=itemView.findViewById(R.id.project_name);
            shortDescp = itemView.findViewById(R.id.short_descp);
        }
    }


}
