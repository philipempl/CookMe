package com.example.philip.vibs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.philip.vibs.DataHolder;
import com.example.philip.vibs.R;
import com.example.philip.vibs.model.CalendarItem;
import com.example.philip.vibs.model.InboxItem;

import java.text.SimpleDateFormat;
import java.util.List;

public class CalendarItemAdapter  extends RecyclerView.Adapter<com.example.philip.vibs.adapter.CalendarItemAdapter.MyViewHolder> {

        private List<CalendarItem> calendarItems;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView from, to, subject;

            public MyViewHolder(View view) {
                super(view);
                from = (TextView) view.findViewById(R.id.calendar_item_from);
                to = (TextView) view.findViewById(R.id.calendar_item_to);
                subject = (TextView) view.findViewById(R.id.calendar_item_subject);
            }
        }


        public CalendarItemAdapter() {
            this.calendarItems = DataHolder.calendarItemsList;
        }

        @Override
        public com.example.philip.vibs.adapter.CalendarItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.calendar_item, parent, false);

            return new com.example.philip.vibs.adapter.CalendarItemAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(com.example.philip.vibs.adapter.CalendarItemAdapter.MyViewHolder holder, int position) {
            CalendarItem calendarItem = calendarItems.get(position);
            holder.subject.setText(calendarItem.getSubject());
            holder.from.setText(new SimpleDateFormat("hh:mm").format(calendarItem.getFrom()));
            holder.to.setText(new SimpleDateFormat("hh:mm").format(calendarItem.getTo()));

        }

        @Override
        public int getItemCount() {
            return calendarItems.size();
        }
}
