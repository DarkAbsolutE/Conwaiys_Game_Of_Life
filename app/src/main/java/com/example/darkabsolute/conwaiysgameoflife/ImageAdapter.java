package com.example.darkabsolute.conwaiysgameoflife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by DarkAbsolutE on 15/03/2015.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public void setmThumbIds (int position) {
        mThumbIds[position] = R.drawable.ic_vivo;
    }

    public void setmThumbIdsMuertos (int position) {
        mThumbIds[position] = R.drawable.ic_muerto;
    }

    public void setmThumbIdsEspera (int position) {
        mThumbIds[position] = R.drawable.ic_espera;
    }

    public void setmThumbIdsReset () {
    }

    public Integer[] mThumbIds = {
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera, R.drawable.ic_espera, R.drawable.ic_espera,
            R.drawable.ic_espera

    };
}
