package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.EventsRVObject;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EventHomeAdapter extends RecyclerView.Adapter<ViewHolderEvents> {
    @NonNull
    @NotNull

    ArrayList<EventsRVObject> list;
    Context context;

    public EventHomeAdapter(@NotNull Context context, ArrayList<EventsRVObject> list) {
        this.list = list;
        this.context = context;
    }

    public ViewHolderEvents onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_home,parent,false);
        return new ViewHolderEvents(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderEvents holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImageView());
        holder.heading.setText(list.get(position).getHeading());
        holder.date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolderEvents extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView heading, date;

    public ViewHolderEvents(@NonNull @NotNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView_events_home);
        heading = itemView.findViewById(R.id.heading_events_home);
        date = itemView.findViewById(R.id.date_events_home);

    }
}
