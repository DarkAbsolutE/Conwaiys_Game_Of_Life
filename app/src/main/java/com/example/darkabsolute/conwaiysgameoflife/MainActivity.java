package com.example.darkabsolute.conwaiysgameoflife;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.darkabsolute.acciones.Iniciar;


public class MainActivity extends ActionBarActivity {

    GridView gridview;
    Button buttonI, buttonD;
    ImageAdapter imageAdapter;

    Backgound backgound;
    Iniciar iniciar;
    Thread thread;
    boolean bucle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonI = (Button) findViewById(R.id.iniciar);
        buttonD = (Button) findViewById(R.id.detener);

        imageAdapter = new ImageAdapter(this);

        gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(imageAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            imageAdapter.setmThumbIds(position);

            gridview.setAdapter(imageAdapter);
            }
        });
    }

    public void iniciar(View view) {

        gridview.setEnabled(false);
        buttonD.setVisibility(view.VISIBLE);
        buttonI.setVisibility(view.INVISIBLE);
        bucle = true;

        backgound = new Backgound(imageAdapter, gridview, bucle, this);
        backgound.execute();

        iniciar = new Iniciar(imageAdapter, gridview, bucle, this);
        thread = new Thread(iniciar);
        thread.start();
    }

    public void detener(View view) {
        gridview.setEnabled(true);
        buttonD.setVisibility(view.INVISIBLE);
        buttonI.setVisibility(view.VISIBLE);
        bucle = false;

        thread.interrupt();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reset) {
            for (int x = 0; x <= 48; x++) {
                imageAdapter.setmThumbIdsEspera(x);
                gridview.setAdapter(imageAdapter);
            }

            bucle = false;
            if (thread != null) thread.interrupt();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
