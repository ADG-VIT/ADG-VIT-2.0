package com.adgvit.externals.RecyclerViewAdapter;

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
import com.adgvit.externals.JavaActivities.ProjectDetailsView;
import com.adgvit.externals.NetworkModels.ProjectModelNetwork;
import com.adgvit.externals.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProjectsAdapterHome extends RecyclerView.Adapter<ProjectsAdapterHome.ProjectViewHolder>{
    Context context;
    List<ProjectModelNetwork> list;

    public ProjectsAdapterHome(List<ProjectModelNetwork> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_projects_home,parent,false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProjectsAdapterHome.ProjectViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProjectDetailsView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",list.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.name.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail()).into(holder.projectImage);

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
        }
    }


}
