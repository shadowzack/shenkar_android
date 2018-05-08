package com.shenkar.battl.shenkar_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BirthdayAdapter extends RecyclerView.Adapter<BirthdayAdapter.ViewHolder> {
        List<birthday> birthdays;


        public BirthdayAdapter(List<birthday> birthdays){
            this.birthdays=birthdays;
        }


    @NonNull
    @Override
    public BirthdayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BirthdayAdapter.ViewHolder holder, int position) {
        holder.firstname.setText(birthdays.get(position).getFirstname());


        holder.birthday.setText(birthdays.get(position).getBirthday().toString());
        holder.comment.setText(birthdays.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return birthdays.size();
    }

    public class  ViewHolder extends  RecyclerView.ViewHolder{
        public TextView firstname;
        public TextView birthday;
        public TextView comment;


        public ViewHolder(View itemView) {
            super(itemView);
            firstname=itemView.findViewById(R.id.firstname);
            birthday=itemView.findViewById(R.id.birthday);
            comment=itemView.findViewById(R.id.comment);
        }
    }
}
