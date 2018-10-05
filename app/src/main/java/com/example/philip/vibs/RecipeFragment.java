package com.example.philip.vibs;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philip.vibs.adapter.ComplexItemAdapter;
import com.example.philip.vibs.adapter.RecipeRecyclerAdapter;

import java.io.Serializable;

import jp.wasabeef.blurry.Blurry;

public class RecipeFragment extends android.support.v4.app.Fragment {

    private static final String TAG = RecipeFragment.class.getSimpleName();
    public static boolean blurry = false;

    private RecyclerView recyclerViewHorizontal, recyclerViewVertical;
    private RecipeRecyclerAdapter mAdapterHorizontal;
    private ComplexItemAdapter mAdapterComplexItems;
    public static View view;
    public RecipeFragment() {
        // Required empty public constructor
    }

    public static RecipeFragment newInstance(String param1, String param2) {
        RecipeFragment fragment = new RecipeFragment();
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


        configureRecipeView(inflater, container);
        recyclerViewHorizontal.addOnItemTouchListener(
                new RecyclerFeedItemClickListener(getContext(), recyclerViewHorizontal, new RecyclerFeedItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                       Intent i = new Intent(getContext(), RecipeDetailActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putSerializable("RECIPE", (Serializable) DataHolder.feedObjectList.get(position));
                        i.putExtras(bundle);
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
    private void configureRecipeView(LayoutInflater inflater, ViewGroup container) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        //section for recycler view on the bottom

        recyclerViewHorizontal = view.findViewById(R.id.recycler_view_inbox);
        mAdapterHorizontal = new RecipeRecyclerAdapter();
        LinearLayoutManager mLayoutManagerInbox = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewHorizontal.getContext(),
                mLayoutManagerInbox.getOrientation());
        recyclerViewHorizontal.addItemDecoration(dividerItemDecoration);
        recyclerViewHorizontal.setLayoutManager(mLayoutManagerInbox);
        recyclerViewHorizontal.setAdapter(mAdapterComplexItems);
        recyclerViewHorizontal.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerViewHorizontal.setItemAnimator(itemAnimator);

        recyclerViewHorizontal = view.findViewById(R.id.recycler_view_feed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(layoutManager);
        mAdapterComplexItems = new ComplexItemAdapter();
        recyclerViewHorizontal.setAdapter(mAdapterComplexItems);
        recyclerViewHorizontal.setItemAnimator(itemAnimator);
    }
}