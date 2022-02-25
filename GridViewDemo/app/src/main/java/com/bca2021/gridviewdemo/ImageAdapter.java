package com.bca2021.gridviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

class ImageAdapter extends BaseAdapter {
    Context thisContext;

    public ImageAdapter(Context cnt) {
        thisContext = cnt;
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int postion, View view, ViewGroup viewGroup) {
        ImageView img = new ImageView(thisContext);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        //img.setLayoutParams(params);
        img.setImageResource(flags[postion]);
        return img;
    }

    public Integer[] flags = {
            R.drawable.india,
            R.drawable.afghanistan,
            R.drawable.australia,
            R.drawable.canada,
            R.drawable.fiji,
            R.drawable.israel,
            R.drawable.japan,
            R.drawable.iceland
    };
}
