package com.example.philip.vibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philip.vibs.adapter.ComplexItemAdapter;
import com.example.philip.vibs.adapter.InboxRecyclerAdapter;

import jp.wasabeef.blurry.Blurry;

public class InboxFragment extends android.support.v4.app.Fragment {

    private static final String TAG = InboxFragment.class.getSimpleName();
    public static boolean blurry = false;

    private RecyclerView recyclerViewInbox, recyclerViewFeed;
    private InboxRecyclerAdapter mAdapterInbox;
    private ComplexItemAdapter mAdapterComplexItems;
    public static View view;
    public InboxFragment() {
        // Required empty public constructor
    }

    public static InboxFragment newInstance(String param1, String param2) {
        InboxFragment fragment = new InboxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inbox, container, false);
        //section for recycler view on the bottom

        recyclerViewInbox = view.findViewById(R.id.recycler_view_inbox);
        mAdapterInbox = new InboxRecyclerAdapter();
        LinearLayoutManager mLayoutManagerInbox = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewInbox.getContext(),
                mLayoutManagerInbox.getOrientation());
        recyclerViewInbox.addItemDecoration(dividerItemDecoration);
        recyclerViewInbox.setLayoutManager(mLayoutManagerInbox);
        recyclerViewInbox.setAdapter(mAdapterInbox);
        recyclerViewInbox.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerViewInbox.setItemAnimator(itemAnimator);

        recyclerViewFeed = view.findViewById(R.id.recycler_view_feed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFeed.setLayoutManager(layoutManager);
        mAdapterComplexItems = new ComplexItemAdapter();
        recyclerViewFeed.setAdapter(mAdapterComplexItems);
        recyclerViewFeed.setItemAnimator(itemAnimator);
        recyclerViewFeed.addOnItemTouchListener(
                new RecyclerFeedItemClickListener(getContext(), recyclerViewFeed, new RecyclerFeedItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(getContext(), CloseUpItemDialog.class);
                        i.putExtra("position", position);
                        startActivity(i);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
    if(blurry)
    {
        Blurry.delete((ViewGroup) view);
        blurry = false;
    }
    }
}