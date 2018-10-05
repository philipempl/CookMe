package com.example.philip.vibs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.philip.vibs.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private ActionBar actionToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        createProtoListFeed();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment = new RecipeFragment();
        loadFragment(fragment);
        //actionToolbar = getSupportActionBar();
        //actionToolbar.setTitle("Inbox");

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_recipes:
                    fragment = new RecipeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
                    fragment = new RecipeFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_search:
                    fragment = new RecipeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new RecipeFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void createProtoListFeed() {

        DataHolder.feedObjectList = new ArrayList<>();
        DataHolder.feedObjectList.clear();
        //TODO
        //Add elements
        List<Integer> resImages = getImages();

        DataHolder.feedObjectList.add(new Recipe("Spaghetti aglio e olio", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));

    }


    public List<Integer> getImages() {
        List<Integer> resImages = new ArrayList<>();
        resImages.add(R.drawable.titelbild);
        resImages.add(R.drawable.titelbild);
        resImages.add(R.drawable.titelbild2);
        resImages.add(R.drawable.titelbild3);
        resImages.add(R.drawable.titelbild4);

        return resImages;
    }
}
