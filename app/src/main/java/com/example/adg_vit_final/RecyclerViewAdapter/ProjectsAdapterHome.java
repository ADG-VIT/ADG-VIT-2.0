package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProjectsAdapterHome extends RecyclerView.Adapter<ProjectsAdapterHome.ProjectViewHolder>{
    Context context;
    List<ProjectItems> list;

    public ProjectsAdapterHome(List<ProjectItems> list, Context context) {
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
//        holder.projectImage.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

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
