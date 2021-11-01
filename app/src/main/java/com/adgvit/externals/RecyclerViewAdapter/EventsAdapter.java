package com.adgvit.externals.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.adgvit.externals.DataModels.EventsDataModel;
import com.adgvit.externals.JavaActivities.EventDetails;


import java.util.List;

import com.adgvit.externals.R;
import static com.adgvit.externals.NetworkUtil.NetworkUtils.getDate;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.myviewholder> {
    private List<EventsDataModel> dataList;
    private Context context;

    public EventsAdapter(Context context, List<EventsDataModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.events_cardview,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.myviewholder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.date.setText(getDate(dataList.get(position).getDate()));
        Glide.with(context).load(dataList.get(position).getImageURL()).override(300,300).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), EventDetails.class);
                intent.putExtra("event_id","" + dataList.get(position).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class  myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,date;
        public myviewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.events_image);
            title = itemView.findViewById(R.id.events_title);
            date = itemView.findViewById(R.id.events_date);
        }
    }
}
