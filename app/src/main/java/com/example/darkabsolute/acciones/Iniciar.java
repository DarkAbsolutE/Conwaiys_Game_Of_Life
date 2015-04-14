package com.example.darkabsolute.acciones;

import android.os.AsyncTask;
import android.transition.Slide;
import android.widget.GridView;
import android.widget.Toast;

import com.example.darkabsolute.conwaiysgameoflife.ImageAdapter;
import com.example.darkabsolute.conwaiysgameoflife.MainActivity;

/**
 * Created by DarkAbsolutE on 25/03/2015.
 */
public class Iniciar implements Runnable {

    GridView gridview;
    ImageAdapter imageAdapter;

    Integer [][] escenario;
    int vivos = 2130837558, muertos = 2130837557, espera = 2130837555, contador = 0, c = 0;
    int colum, fila, elementos = 49;

    boolean bucle;
    int generacion = 0;

    private MainActivity mainActivity;

    public Iniciar(ImageAdapter imageAdapter, GridView gridview, boolean bucle, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.imageAdapter = imageAdapter;
        this.gridview = gridview;
        this.bucle = bucle;
    }

    @Override
    public void run() {

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //while (bucle) {
                    celulas();
                    gridview.setAdapter(imageAdapter);

                    generacion++;
                    Toast.makeText(mainActivity, "" + generacion, Toast.LENGTH_SHORT).show();

                    /*try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                //}
            }
        });
    }

    public void celulas() {

        colum = gridview.getNumColumns();
        fila = elementos/gridview.getNumColumns();

        crearEscenario();

        for (int x = 0; x < fila; x++) {
            for (int y = 0; y < colum; y++) {
                check(x, y);
            }
        }
    }

    public void check(int x, int y) {

        if (x < fila && y == 0) {
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
            } else if (x == fila-1) {
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
        }else if (x == 0 && y < colum) {
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
            } else if (y == colum-1) {
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
        } else if(x == fila-1 && y < colum) {
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
            } else if (y == colum - 1) {
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
        } else if (y == colum-1 && x < fila) {
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
            } else if (x == fila - 1) {
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
        } else if (contador == 3 && escenario[x][y] == muertos) {
            imageAdapter.setmThumbIds(c);
        }
        contador = 0;
        c++;
    }

    public void crearEscenario() {
        escenario = new Integer[fila][colum];
        int z = 0;
        for (int x = 0; x < fila; x++) {
            for (int y = 0; y < colum; y++) {
                escenario[x][y] = imageAdapter.mThumbIds[z];
                z++;
            }
        }
    }
}
