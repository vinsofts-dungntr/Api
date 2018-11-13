package com.vinsofts.apisecond.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vinsofts.apisecond.R;
import com.vinsofts.apisecond.model.Item;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder>{
    Context context;
    List<Item> mList;

    public MyAdapter(Context context, List<Item> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_item_recyclerview,viewGroup,false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder contactHolder, int i) {
        Item model=mList.get(i);
        contactHolder.tvID.setText(String.valueOf(model.getOwner().getUserId()));
        contactHolder.tvScore.setText(String.valueOf(model.getScore()));
        Glide.with(context).load(model.getOwner().getProfileImage()).into(contactHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ContactHolder extends RecyclerView.ViewHolder {
        TextView tvID;
        TextView tvScore;
        ImageView imageView;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            tvID=itemView.findViewById(R.id.tvID);
            tvScore=itemView.findViewById(R.id.tvScore);
            imageView=itemView.findViewById(R.id.imView);
        }
    }

}
