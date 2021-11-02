package com.adgvit.externals.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.externals.DataModels.DomainsDataModel;
import com.adgvit.externals.DataModels.HomeDomainsObject;
import com.adgvit.externals.R;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DomainsHomeAdapter extends RecyclerView.Adapter<ViewHolderDomains> {
    @NonNull
    @NotNull

    List<DomainsDataModel> list;
    Context context;

    public DomainsHomeAdapter(@NotNull Context context, List<DomainsDataModel> list) {
        this.list = list;
        this.context = context;
    }

    public ViewHolderDomains onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_home_domains,parent,false);
        System.out.println("DomainHome Prints");
        return new ViewHolderDomains(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderDomains holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.domainName.setText(list.get(position).getTitle());
        System.out.println(list.get(position).getTitle());
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
