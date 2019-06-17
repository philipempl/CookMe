package io.frontend.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.philip.vibs.R;
import com.rd.PageIndicatorView;

import java.util.Objects;

import io.frontend.model.Recipe;
import io.frontend.recyclerview.adapter.IngredientRecyclerAdapter;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class RecipeDetailActivity extends AppCompatActivity {

    Recipe recipe;
    CustomPagerAdapter mCustomPagerAdapter;
   CollapsingToolbarLayout collapsingToolbarLayout;
   IngredientRecyclerAdapter ingredientRecyclerAdapter;
    PageIndicatorView pageIndicatorView;
    Toolbar toolbar;
    ViewPager viewPager;
    TextView description;
    ImageView ivCharacter, ivPricing, ivNutrions;
    Snackbar sb_cook;
    NestedScrollView nsc_recipe;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_item_detail_view);

        description = findViewById(R.id.recipe_detail_description);
        recipe = (Recipe) Objects.requireNonNull(getIntent().getExtras()).getSerializable("RECIPE");
        description.setText(recipe.getDescription());

        MaterialRatingBar mrb =  findViewById(R.id.rb_recipe_item_detail);
        mrb.setNumStars(5);
        mrb.setProgress(9);
        setupToolBar();
        setupViewPager();
        setupImageViews();
        setupIngredients();
        setupSnackBar();
    }

    private void setupSnackBar() {
        sb_cook = Snackbar.make(findViewById(android.R.id.content), "should disappear when scrolling!", Snackbar.LENGTH_LONG);
         nsc_recipe= findViewById(R.id.nsc_recipe);

        final Snackbar snackbar = Snackbar
                .make(findViewById(R.id.cl_recipe_detail_item), recipe.getTitle(), Snackbar.LENGTH_INDEFINITE)
                .setAction("Jetzt kochen!", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        nsc_recipe.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {
                    snackbar.show();
                }
                if(scrollY < oldScrollY)
                {
                    snackbar.dismiss();
                }
            }
        });
}

    private void setupIngredients() {
        RecyclerView rv_ingredients = findViewById(R.id.rv_recipe_detail_item_ingredients);
        ingredientRecyclerAdapter = new IngredientRecyclerAdapter(recipe.getListIngredients());
        rv_ingredients.setAdapter(ingredientRecyclerAdapter);
        rv_ingredients.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void setupImageViews() {
        ivCharacter =  findViewById(R.id.iv_recipe_item_detail_character);
        ivPricing = findViewById(R.id.iv_recipe_item_detail_pricing);
        ivNutrions = findViewById(R.id.iv_recipe_item_detail_nutrions);

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int param = (int) ((displayMetrics.widthPixels / displayMetrics.density)/3);
        ivCharacter.getLayoutParams().height = param;
        ivPricing.getLayoutParams().height =param;
        ivNutrions.getLayoutParams().height = param;
        ivCharacter.getLayoutParams().width = param;
        ivPricing.getLayoutParams().width =param;
        ivNutrions.getLayoutParams().width = param;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.export_action) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 private class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        private CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return recipe.getListImages().size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view ==  object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.recipe_detail_view_image, container, false);

            ImageView imageView =  itemView.findViewById(R.id.recipe_detail_view_image);
            imageView.setImageResource(recipe.getListImages().get(position));
            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }
    private void setupViewPager() {
        mCustomPagerAdapter = new CustomPagerAdapter(this);
        viewPager =  findViewById(R.id.vprecipeImages);
        viewPager.setAdapter(mCustomPagerAdapter);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(recipe.getListImages().size()); // specify total count of indicators
        pageIndicatorView.setSelection(1);
    }

    private void setupToolBar() {
        toolbar = findViewById(R.id.recipe_detail_view_toolbar);
        collapsingToolbarLayout = findViewById(R.id.recipe_detail_view_collapsing_toolbar);
        toolbar.setTitle(recipe.getTitle());
        toolbar.getBackground().setAlpha(0);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.recipe_detail_view_app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(recipe.getTitle());
                    toolbar.setTitle(recipe.getTitle());
                    toolbar.getBackground().setAlpha(255);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    toolbar.setTitle(" ");
                    toolbar.getBackground().setAlpha(0);
                    isShow = false;
                }
            }
        });
    }


}