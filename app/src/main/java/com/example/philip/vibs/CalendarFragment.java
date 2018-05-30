package com.example.philip.vibs;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philip.vibs.adapter.CalendarItemAdapter;
import com.example.philip.vibs.adapter.InboxRecyclerAdapter;

public class CalendarFragment extends android.support.v4.app.Fragment {

    public static View view;
    public RecyclerView recyclerViewPlanner;
    public CalendarItemAdapter mCalendarItemAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_planner, container, false);

        recyclerViewPlanner = view.findViewById(R.id.recycler_view_planner);
        mCalendarItemAdapter = new CalendarItemAdapter();
        LinearLayoutManager mLayoutManagerInbox = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewPlanner.getContext(),
                mLayoutManagerInbox.getOrientation());
        recyclerViewPlanner.addItemDecoration(dividerItemDecoration);
        recyclerViewPlanner.setLayoutManager(mLayoutManagerInbox);
        recyclerViewPlanner.setAdapter(mCalendarItemAdapter);
        recyclerViewPlanner.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerViewPlanner.setItemAnimator(itemAnimator);
        return view;
    }
}
