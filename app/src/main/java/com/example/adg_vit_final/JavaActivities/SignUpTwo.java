package com.example.adg_vit_final.JavaActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SignUpTwo extends AppCompatActivity {

    private int lastCheckedPosition = -1;
    RecyclerView recyclerView;
    ArrayList<obj> lst;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_two);
        getSupportActionBar().hide();

        buttonNext = findViewById(R.id.button_next);
        recyclerView = findViewById(R.id.select_clg_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lst = new ArrayList<>();

        lst.add(new obj("VIT Vellore", "Currently Studying in VIT Vellore Branch"));
        lst.add(new obj("Others", "Any other university including other Branches of VIT"));

        recyclerView.setAdapter(new Adapter(getApplicationContext(), lst));

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastCheckedPosition==0)
                    startActivity(new Intent(getApplicationContext(), Signup4.class));
                else if (lastCheckedPosition==1)
                    startActivity(new Intent(getApplication(), Signup3.class));
            }
        });

    }

    public class Adapter extends RecyclerView.Adapter<ViewHolderObj>{

        public Adapter(@NotNull Context context, ArrayList<obj> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @NotNull
        Context context;
        ArrayList<obj> list;

        public ViewHolderObj onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.card_view,parent,false);
            return new ViewHolderObj(view);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull SignUpTwo.ViewHolderObj holder, int position) {
            holder.textViewHeading.setText(list.get(position).stringHeading);
            holder.textViewLine.setText(list.get(position).stringLine);
            if (lastCheckedPosition != position)
                holder.radioButton.setChecked(false);
            holder.radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.radioButton.setChecked(true);
                    lastCheckedPosition = position;
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class ViewHolderObj extends RecyclerView.ViewHolder {

        RadioButton radioButton;
        TextView textViewHeading, textViewLine;
        public ViewHolderObj(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            textViewHeading = itemView.findViewById(R.id.textView_heading);
            textViewLine = itemView.findViewById(R.id.text_view_line);
        }
    }

    class obj{

        String stringHeading, stringLine;

        public String getStringHeading() {
            return stringHeading;
        }

        public void setStringHeading(String stringHeading) {
            this.stringHeading = stringHeading;
        }

        public String getStringLine() {
            return stringLine;
        }

        public void setStringLine(String stringLine) {
            this.stringLine = stringLine;
        }

        public obj(String stringHeading, String stringLine) {
            this.stringHeading = stringHeading;
            this.stringLine = stringLine;
        }
    }
}