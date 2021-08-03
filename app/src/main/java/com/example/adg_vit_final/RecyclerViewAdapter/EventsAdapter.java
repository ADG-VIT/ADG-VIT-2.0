package com.example.adg_vit_final.RecyclerViewAdapter;
import android.content.Context;

import android.content.Intent;
import android.media.Image;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.DataModels.EventsDataModel;
import com.example.adg_vit_final.JavaActivities.EventDetails;
import com.example.adg_vit_final.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static android.os.Build.VERSION_CODES.R;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.myviewholder> {
    private List<EventsDataModel> dataList;
    private Context context;

    public EventsAdapter(Context context, List<EventsDataModel> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.adg_vit_final.R.layout.events_cardview,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EventsAdapter.myviewholder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.date.setText(getDate(dataList.get(position).getDate()));

        //Toast.makeText(context, "" + dataList.get(position).getImageURL(), Toast.LENGTH_SHORT).show();

            Glide.with(context).
                    load(dataList.get(position).getImageURL()).
                    override(357, 369).
                    into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), EventDetails.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }

    class  myviewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title,date;
        CardView card;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(com.example.adg_vit_final.R.id.events_image);
            title = itemView.findViewById(com.example.adg_vit_final.R.id.events_title);
            date = itemView.findViewById(com.example.adg_vit_final.R.id.events_date);
            card = itemView.findViewById(com.example.adg_vit_final.R.id.events_card);
        }
    }
}
