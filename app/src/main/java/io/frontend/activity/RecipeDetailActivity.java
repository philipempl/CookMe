package io.frontend.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class RecipeDetailActivity extends AppCompatActivity {

    Recipe recipe;
    CustomPagerAdapter mCustomPagerAdapter;
    net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout collapsingToolbarLayout;
    PageIndicatorView pageIndicatorView;
    Toolbar toolbar;
    ViewPager viewPager;
    boolean firstPage;
    TextView description;
    ImageView ivCharacter, ivPricing, ivNutrions;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details_item);

        description = findViewById(R.id.recipe_detail_description);
        recipe = (Recipe) Objects.requireNonNull(getIntent().getExtras()).getSerializable("RECIPE");

        MaterialRatingBar mrb =  findViewById(R.id.rb_recipe_item_detail);
        mrb.setNumStars(5);
        mrb.setProgress(9);
        setupToolBar();
        setupViewPager();
        setupImageViews();
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
        firstPage = true;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
                if(position > 0)
                {
                    collapsingToolbarLayout.setTitle("");
                    toolbar.setTitle("");
                    toolbar.setSubtitle("");
                    firstPage = false;
                }
                else if (position == 0)
                {
                    collapsingToolbarLayout.setTitle(recipe.getTitle());
                    firstPage = true;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {/*empty*/}
        });

    }

    private void setupToolBar() {
        toolbar = findViewById(R.id.toolbar);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbar.setTitle(recipe.getTitle());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = true;
                } else if (isShow && firstPage) {
                    collapsingToolbarLayout.setTitle(recipe.getTitle());
                    isShow = false;
                }
            }
        });

    }


}