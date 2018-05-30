package com.example.philip.vibs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philip.vibs.DataHolder;
import com.example.philip.vibs.R;
import com.example.philip.vibs.model.InboxItem;

import java.text.SimpleDateFormat;
import java.util.List;


public class InboxRecyclerAdapter extends RecyclerView.Adapter<InboxRecyclerAdapter.MyViewHolder> {

    private List<InboxItem> inboxList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView sender, message, date;
        public ImageView profil;

        public MyViewHolder(View view) {
            super(view);
            sender = (TextView) view.findViewById(R.id.inbox_item_sender);
            message = (TextView) view.findViewById(R.id.inbox_item_message);
            date = (TextView) view.findViewById(R.id.inbox_item_date);
            profil = (ImageView) view.findViewById(R.id.inbox_item_image);
        }
    }


    public InboxRecyclerAdapter() {
        this.inboxList = DataHolder.inboxItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inbox_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InboxItem inboxItem = inboxList.get(position);
        holder.sender.setText(inboxItem.getSender());
        holder.message.setText(inboxItem.getMessage());
        holder.date.setText(new SimpleDateFormat("hh:mm").format(inboxItem.getDate()));
        holder.profil.setImageResource(inboxItem.getImage());

    }

    @Override
    public int getItemCount() {
        return inboxList.size();
    }
}