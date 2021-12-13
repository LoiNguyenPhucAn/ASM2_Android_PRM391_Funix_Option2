package com.example.animal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;


public class AnimalType {

    private String title;
    private Bitmap icon;
    private String tag;
    private TextView detail;

    public AnimalType(String title, Bitmap icon, String tag, TextView detail) {
        this.title = title;
        this.icon = icon;
        this.tag = tag;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public String getTag() {
        return tag;
    }

    public TextView getDetail() {
        return detail;
    }
}
