package com.shenkar.battl.shenkar_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
        ArrayList<String> users;


        public UserAdapter(ArrayList<String> users){
            this.users=users;
        }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.firtsname.setText(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class  ViewHolder extends  RecyclerView.ViewHolder{
        public TextView firtsname;

        public ViewHolder(View itemView) {
            super(itemView);
            firtsname=itemView.findViewById(R.id.firstname);
        }
    }
}
