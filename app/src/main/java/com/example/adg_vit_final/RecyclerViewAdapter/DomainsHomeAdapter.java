package com.example.adg_vit_final.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.HomeDomainsObject;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DomainsHomeAdapter extends RecyclerView.Adapter<ViewHolderDomains> {
    @NonNull
    @NotNull

    ArrayList<HomeDomainsObject> list;
    Context context;

    public DomainsHomeAdapter(@NotNull Context context, ArrayList<HomeDomainsObject> list) {
        this.list = list;
        this.context = context;
    }

    public ViewHolderDomains onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_home_domains,parent,false);
        return new ViewHolderDomains(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderDomains holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.domainName.setText(list.get(position).getDomainName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolderDomains extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView domainName;

    public ViewHolderDomains(@NonNull @NotNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_home_domain);
        domainName = itemView.findViewById(R.id.domain_name);

    }
}
