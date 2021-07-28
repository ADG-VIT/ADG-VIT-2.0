package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.DomainsDataModel;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DomainsAdapter extends RecyclerView.Adapter<DomainsAdapter.myviewholder> {

    private List<DomainsDataModel> dataList;
    private Context context;
    public DomainsAdapter(Context context,List<DomainsDataModel> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.domain_card_view,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DomainsAdapter.myviewholder holder, int position) {
        holder.imageView.setImageResource(dataList.get(position).getImage());
        holder.title.setText(dataList.get(position).getTitle());
        holder.desc.setText(dataList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,desc;
        public myviewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.domain_icon);
            title = itemView.findViewById(R.id.domains_title);
            desc = itemView.findViewById(R.id.domains_desc);
        }
    }
}
