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


public class MainActivity extends ActionBarActivity {

    GridView gridview;
    Button buttonI, buttonD;
    ImageAdapter imageAdapter;
    Integer [][] escenario;
    boolean bucle = true;
    int vivos = 2130837558, muertos = 2130837557, espera = 2130837555, contador = 0, c = 0;
    int colum, fila;
    int generacion = 0;

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
        celulas();
        generacion++;
        Toast.makeText(MainActivity.this, "" + generacion, Toast.LENGTH_SHORT).show();

        gridview.setEnabled(true);
        buttonD.setVisibility(view.INVISIBLE);
        buttonI.setVisibility(view.VISIBLE);
        bucle = false;
    }

    public void detener(View view) {
        gridview.setEnabled(true);
        buttonD.setVisibility(view.INVISIBLE);
        buttonI.setVisibility(view.VISIBLE);
        bucle = false;
    }

    public void celulas() {
        int estado[] = {gridview.getNumColumns(), 49/gridview.getNumColumns()};

        colum = estado[0]; fila = estado[1];

        crearEscenario(estado[0], estado[1]);

        for (int x = 0; x < estado[1]; x++) {
            for (int y = 0; y < estado[0]; y++) {
                check(x, y);
            }
        }

        c = 0;
    }

    public void check(int x, int y) {

        if (x < colum && y == 0) {
            if (x == 0) {
                for (int a = x; a <= x+1 ; a++) {
                    for (int b = y; b <= y+1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else if (x == colum-1) {
                for (int a = x-1; a <= x; a++) {
                    for (int b = y; b <= y+1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else {
                for (int a = x-1; a <= x+1 ; a++) {
                    for (int b = y; b <= y+1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            }
        }else if (x == 0 && y < fila) {
            if (y == 0) {
                for (int a = x; a <= x + 1; a++) {
                    for (int b = y; b <= y + 1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else if (y == fila-1) {
                for (int a = x; a <= x+1; a++) {
                    for (int b = y-1; b <= y; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else {
                for (int a = x; a <= x + 1; a++) {
                    for (int b = y-1; b <= y + 1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            }
        } else if(x == colum-1 && y < fila) {
            if (y == 0) {
                for (int a = x-1; a <= x; a++) {
                    for (int b = y; b <= y+1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else if (y == fila - 1) {
                for (int a = x - 1; a <= x; a++) {
                    for (int b = y - 1; b <= y; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else {
                for (int a = x - 1; a <= x; a++) {
                    for (int b = y-1; b <= y+1; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            }
        } else if (y == fila-1 && x < colum) {
            if (x == 0) {
                for (int a = x; a <= x+1; a++) {
                    for (int b = y-1; b <= y; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            } else if (x == colum - 1) {
                for (int a = x - 1; a <= x; a++) {
                    for (int b = y - 1; b <= y; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            }else {
                for (int a = x - 1; a <= x+1; a++) {
                    for (int b = y-1; b <= y; b++) {
                        if (a != x || b != y) {
                            if (escenario[a][b] == vivos) {
                                contador++;
                            }
                        }
                    }
                }
            }
        } else {
            for (int a = x-1; a <= x+1 ; a++) {
                for (int b = y-1; b <= y+1; b++) {
                    if (a != x || b != y) {
                        if (escenario[a][b] == vivos) {
                            contador++;
                        }
                    }
                }
            }

        }

        if ((contador < 2 || contador > 3) && escenario[x][y] == vivos) {
            imageAdapter.setmThumbIdsMuertos(c);
            gridview.setAdapter(imageAdapter);
        } else if (contador == 3 && escenario[x][y] == muertos) {
            imageAdapter.setmThumbIds(c);
            gridview.setAdapter(imageAdapter);
        }
        contador = 0;
        c++;
    }

    public void crearEscenario(int columnas, int filas) {
        escenario = new Integer[columnas][filas];
        int z = 0;
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                escenario[x][y] = imageAdapter.mThumbIds[z];
                z++;
            }
        }
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
        if (id == R.id.recet) {
            for (int x = 0; x <= 48; x++) {
                imageAdapter.setmThumbIdsEspera(x);
                gridview.setAdapter(imageAdapter);
            }

            generacion = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
