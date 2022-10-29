package com.example.user.mhinvest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.mhinvest.Utilidades.Utilidades;

/**
 * Created by User on 25/09/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    private  static final String DB_NAME = "bdAlcantarillado.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public ConexionSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatosAlcantarillado)
    {
        baseDatosAlcantarillado.execSQL(Utilidades.CREAR_TABLA_ALCANTARILLADO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
