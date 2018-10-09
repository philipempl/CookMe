package io.frontend.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.philip.vibs.R;

import java.util.ArrayList;
import java.util.List;

import io.frontend.dataholder.DataHolder;
import io.frontend.fragment.RecipeFragment;
import io.frontend.model.FoodStuff;
import io.frontend.model.Ingredient;
import io.frontend.model.Recipe;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        createProtoListFeed();
        BottomNavigationView navigation = findViewById(R.id.navigation);
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
        // load io.frontend.fragment
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
        List<Ingredient> ingredientList = getIngredients();

        DataHolder.feedObjectList.add(new Recipe("Spaghetti aglio e olio", getDescription(), resImages, 4, ingredientList, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));
        DataHolder.feedObjectList.add(new Recipe("Lasagne", "Geile Lasagne", resImages, 4, null, 150, "Challenging", null));

    }


    public List<Integer> getImages() {
        List<Integer> resImages = new ArrayList<>();
        resImages.add(R.drawable.titelbild);
        resImages.add(R.drawable.titelbild2);
        resImages.add(R.drawable.titelbild3);
        resImages.add(R.drawable.titelbild4);

        return resImages;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();
        FoodStuff fs1 = new FoodStuff("Spaghetti", null, null, 0, "g", 0);
        FoodStuff fs2 = new FoodStuff("Knoblauchzehe(n)", null, null, 0, null, 0);
        FoodStuff fs3 =new FoodStuff("Petersilie, glatte", null, null, 0, "Bund", 0);
        FoodStuff fs4 =new FoodStuff("Chilischote(n), getrocknet", null, null, 0, null, 0);
        FoodStuff fs5 =new FoodStuff("Olivenöl", null, null, 0, null, 0);
        FoodStuff fs6 =new FoodStuff("Meersalz", null, null, 0, "TL", 0);
        FoodStuff fs7 =new FoodStuff("Pfeffer", null, null, 0, "TL", 0);
        FoodStuff fs8 =new FoodStuff("Zitrone(n), unbehandelt", null, null, 0, null, 0);

        ingredientList.add(new Ingredient(fs1, 300));
        ingredientList.add(new Ingredient(fs2, 4));
        ingredientList.add(new Ingredient(fs3, 0.5));
        ingredientList.add(new Ingredient(fs4, 3));
        ingredientList.add(new Ingredient(fs5, 6));
        ingredientList.add(new Ingredient(fs6, 1));
        ingredientList.add(new Ingredient(fs7, 1));
        ingredientList.add(new Ingredient(fs8, 1));

        return ingredientList;
    }

    public String getDescription() {

        return "Die Spaghetti in Salzwasser bissfest kochen. \n" +
                "\n" +
                "Inzwischen die Knoblauchzehen abziehen und in Scheiben schneiden. Die Petersilie waschen, trocken schütteln und die Blättchen abzupfen. Die Chilischoten zerstoßen. Die Zitrone heiß waschen und in Scheiben schneiden. \n" +
                "\n" +
                "Die Spaghetti abgießen und abtropfen lassen. \n" +
                "\n" +
                "In einer großen Pfanne das Olivenöl erhitzen. Knoblauch, Petersilienblättchen und Chili kurz darin anbraten, die Zitronenscheiben dazugeben und mitbraten. Die Spaghetti dazugeben und darin schwenken. Mit Meersalz und Pfeffer würzen. \n" +
                "\n" +
                "Vor dem Servieren die Zitronenscheiben herausnehmen";
    }
}
