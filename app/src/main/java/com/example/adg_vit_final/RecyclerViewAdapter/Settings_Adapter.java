package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.SettingsItems;
import com.example.adg_vit_final.JavaActivities.Appearance;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Settings_Adapter extends RecyclerView.Adapter<Settings_Adapter.SettingsViewHolder> {
    Context context;
    List<SettingsItems> list;

    public Settings_Adapter(Context context, List<SettingsItems> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_settings, parent, false);

        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Settings_Adapter.SettingsViewHolder holder, int position) {
        holder.img1.setImageResource(list.get(position).getImg());
        holder.settingItem.setText(list.get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getText().equals("Appearance")){
                    context.startActivity(new Intent(context, Appearance.class));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SettingsViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView settingItem;


        public SettingsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.img_settings_card);
            settingItem=itemView.findViewById(R.id.cardview_settings_text);
            
        }
    }
}
