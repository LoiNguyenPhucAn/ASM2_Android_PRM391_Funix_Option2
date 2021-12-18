package com.example.animal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MyViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<AnimalType> listAnimal;

    public MyViewPagerAdapter(Context mContext, ArrayList<AnimalType> listAnimal) {
        this.mContext = mContext;
        this.listAnimal = listAnimal;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.text_content, container, false);
        AnimalType animalInfo = listAnimal.get(position);

        ImageView image = v.findViewById(R.id.iv_detail_image);
        TextView text = v.findViewById(R.id.tv_detail_content_text);
        TextView title = v.findViewById(R.id.detail_title);
        ImageView heart = v.findViewById(R.id.heart_button);

        image.setImageBitmap(animalInfo.getImagedetail());
        text.setText(animalInfo.getDetail());
        title.setText(animalInfo.getTitle());

        container.addView(v);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tagOfHeart = (String) heart.getTag();
                if (tagOfHeart.equals("nonefillcolor")){
                    heart.setImageDrawable(mContext.getDrawable(R.drawable.heart_button_filled));
                    heart.setTag("filled");
                }else{
                    heart.setImageDrawable(mContext.getDrawable(R.drawable.heart_button));
                    heart.setTag("nonefillcolor");
                }
            }
        });

        return v;
    }

    @Override
    public int getCount() {
        return listAnimal.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
