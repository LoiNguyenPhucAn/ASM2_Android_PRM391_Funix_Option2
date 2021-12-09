package com.example.animal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animal.databinding.ScreenMh001BgBinding;

public class ScreenBG extends Fragment {

    ScreenMh001BgBinding mh001BgBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.screen_mh001_bg,container,false);

        mh001BgBinding = ScreenMh001BgBinding.inflate(inflater,container,false);
        return mh001BgBinding.getRoot();

    }
}
