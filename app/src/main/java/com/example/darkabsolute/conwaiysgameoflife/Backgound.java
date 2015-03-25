package com.example.darkabsolute.conwaiysgameoflife;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.darkabsolute.acciones.Iniciar;

/**
 * Created by DarkAbsolutE on 25/03/2015.
 */
public class Backgound extends AsyncTask<Void, Integer, Boolean> {

    GridView gridview;
    ImageAdapter imageAdapter;

    boolean bucle = true;

    private MainActivity mainActivity;

    public Backgound(ImageAdapter imageAdapter, GridView gridview, boolean bucle, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.imageAdapter = imageAdapter;
        this.gridview = gridview;
        this.bucle = bucle;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        Iniciar iniciar = new Iniciar(imageAdapter, gridview, bucle, mainActivity);
        Thread thread = new Thread(iniciar);
        thread.start();
        return true;
    }
}
