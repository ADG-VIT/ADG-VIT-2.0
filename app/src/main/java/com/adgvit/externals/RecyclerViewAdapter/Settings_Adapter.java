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

import com.adgvit.externals.DataModels.SettingsItems;
import com.adgvit.externals.JavaActivities.About;
import com.adgvit.externals.JavaActivities.Appearance;
import com.adgvit.externals.JavaActivities.Notofication;
import com.adgvit.externals.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Settings_Adapter extends RecyclerView.Adapter<Settings_Adapter.SettingsViewHolder> {
    Context context;
    List<SettingsItems> list;
    public static Intent intent;

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
                if (list.get(holder.getAdapterPosition()).getText().equals("Appearance")){

                    intent = new Intent(context, Appearance.class);
                    context.startActivity(intent);
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("About Us")){
                    context.startActivity(new Intent(context, About.class));
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Notifications")){
                    context.startActivity(new Intent(context, Notofication.class));
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Our Instagram"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("https://www.instagram.com/adgvit/"));
                    context.startActivity(intent);
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Our Twitter"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("https://twitter.com/ADGVIT"));
                    context.startActivity(intent);
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Our Facebook"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("https://www.facebook.com/vitios"));
                    context.startActivity(intent);
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Our LinkedIn"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("https://www.linkedin.com/company/adgvit/mycompany/"));
                    context.startActivity(intent);
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Contact Us"))
                {
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    String[] recipients={"Appledevelopersgroup@gmail.com"};
                    intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                    intent.setType("text/html");
                    intent.setPackage("com.google.android.gm");
                    context.startActivity(Intent.createChooser(intent, "Send mail"));
                }
                else if(list.get(holder.getAdapterPosition()).getText().equals("Share with Peers"))
                {
                    Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    share.putExtra(Intent.EXTRA_TEXT, "Find all the latest happenings at ADG within a single app." + "\nJust scroll down and Stay updated!" + "\nGrab your phones and download now." + "\nApp Link : https://play.google.com/store/apps/details?id=com.adgvit.externals");

                    context.startActivity(Intent.createChooser(share, "Share With Peers"));
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
