package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView imageView;
    private TextView txtView1, txtView2, txtView3;
    private List<View> views;
    private int offset = 0;
    private int currentIndex = 0;
    private int bmpW;
    private View v1, v2, v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        initImageView();
        initTextView();
        initViewPager();

    }

    private void initViewPager(){

        viewPager = findViewById(R.id.view_pager);
        views = new ArrayList<View>();
        LayoutInflater inflater = getLayoutInflater();
        v1 = inflater.inflate(R.layout.fragment_a, null);
        v2 = inflater.inflate(R.layout.fragment_b, null);
        v3 = inflater.inflate(R.layout.fragment_c, null);
        views.add(v1);
        views.add(v2);
        views.add(v3);
        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());

    }

    private void initTextView(){

        txtView1 = findViewById(R.id.text1);
        txtView2 = findViewById(R.id.text2);
        txtView3 = findViewById(R.id.text3);

        txtView1.setOnClickListener(new MyOnClickListener(0));
        txtView2.setOnClickListener(new MyOnClickListener(1));
        txtView3.setOnClickListener(new MyOnClickListener(2));

    }

    private void initImageView(){

        imageView = findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.a).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        int screenW = dm.widthPixels;
        offset = (screenW / 3 -bmpW) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imageView.setImageMatrix(matrix);

    }

    private class MyOnClickListener implements View.OnClickListener{

        private int index = 0;

        public MyOnClickListener(int i){
            index = i;
        }

        @Override
        public void onClick(View view) {
            viewPager.setCurrentItem(index);

        }
    }

    public class MyViewPagerAdapter extends PagerAdapter{

        private List<View> mListView;

        public MyViewPagerAdapter(List<View> mListView){
            this.mListView = mListView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mListView.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mListView.get(position), 0);
            return mListView.get(position);
        }

        @Override
        public int getCount() {
            return mListView.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        int one = offset * 2 + bmpW;
        int two = one * 2;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            Animation animation = new TranslateAnimation(one * currentIndex, one * position, 0, 0);
            currentIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            imageView.startAnimation(animation);
            Toast.makeText(PagerActivity.this, viewPager.getCurrentItem()+"page has been chosen.", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}