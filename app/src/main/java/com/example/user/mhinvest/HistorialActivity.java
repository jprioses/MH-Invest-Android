package com.example.user.mhinvest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mhinvest.Utilidades.Utilidades;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {

    ArrayList<Integer> lista_id;
    ArrayList<String> lista_mh;
    int lista_idbuscar;
    ArrayList<String> lista_mhbuscar;
    EditText editTextBuscar;
    ListView textViewBuscar;
    ListView listViewLista;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        conn = new ConexionSQLiteHelper(getApplicationContext());
        listViewLista = (ListView) findViewById(R.id.lista);
        editTextBuscar = (EditText) findViewById(R.id.editTextBuscar);
        textViewBuscar = (ListView) findViewById(R.id.textViewBuscar);

        consultarListaDatos();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista_mh);
        listViewLista.setAdapter(adapter);



        editTextBuscar.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE)
                {
                    cosultar();
                    ArrayAdapter adapter1 = new ArrayAdapter(HistorialActivity.this, android.R.layout.simple_list_item_1,lista_mhbuscar);
                    textViewBuscar.setAdapter(adapter1);
                }
                return false;
            }
        });

        listViewLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
               int id=  lista_id.get(pos);
               Intent intent = new Intent(HistorialActivity.this, Main2Activity.class);
               Bundle bundle = new Bundle();
               bundle.putInt("id", id);
               intent.putExtras(bundle);
               startActivity(intent);

            }
        });

        textViewBuscar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HistorialActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", lista_idbuscar);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }



    private void cosultar() {
        SQLiteDatabase db1 = conn.getReadableDatabase() ;
        lista_mhbuscar = new ArrayList<>();
        String[] parametros = {editTextBuscar.getText().toString(),editTextBuscar.getText().toString(),};
        String[] campos = {Utilidades.CAMPO_ID, Utilidades.CAMPO_FECHA,Utilidades.CAMPO_IPID,Utilidades.CAMPO_MH};


        try {
            Cursor cursorconsultar = db1.query(Utilidades.TABLA_ALCANTARILLADO, campos, Utilidades.CAMPO_IPID + " =? OR " + Utilidades.CAMPO_MH + " =? ", parametros,null,null,null);
            cursorconsultar.moveToFirst();
            int id = cursorconsultar.getColumnIndex(Utilidades.CAMPO_ID);
            int fecha = cursorconsultar.getColumnIndex(Utilidades.CAMPO_FECHA);
            int IPID = cursorconsultar.getColumnIndex(Utilidades.CAMPO_IPID);
            int MH = cursorconsultar.getColumnIndex(Utilidades.CAMPO_MH);
            lista_idbuscar=cursorconsultar.getInt(id);
            lista_mhbuscar.add(cursorconsultar.getString(id)+ "-" + cursorconsultar.getString(fecha)+ "-" + cursorconsultar.getString(IPID) + "-" + cursorconsultar.getString(MH));
            cursorconsultar.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"No se encuentra MH", Toast.LENGTH_LONG).show();
        }

        db1.close();


    }

    private void consultarListaDatos() {
        lista_id = new ArrayList<>();
        lista_mh = new ArrayList<>();
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] colums = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FECHA, Utilidades.CAMPO_IPID, Utilidades.CAMPO_MH};


        Cursor cursor = db.query(Utilidades.TABLA_ALCANTARILLADO, colums, null, null, null , null, null);


        if (cursor.moveToFirst()){
            do {

                int id = cursor.getColumnIndex(Utilidades.CAMPO_ID);
                int fecha = cursor.getColumnIndex(Utilidades.CAMPO_FECHA);
                int IPID = cursor.getColumnIndex(Utilidades.CAMPO_IPID);
                int MH = cursor.getColumnIndex(Utilidades.CAMPO_MH);
                lista_id.add(cursor.getInt(id));
                lista_mh.add(cursor.getInt(id) + "-" + cursor.getString(fecha) + "-" + cursor.getString(IPID) + "-" + cursor.getInt(MH));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.historial_menu, menu);
        return true;


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int idmenu = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (idmenu == R.id.action_convertir) {

            ExportarExcel export = new ExportarExcel(getApplicationContext());
            export.exportDataBaseIntoCSV(1);
            return true;
        }
        if (idmenu == R.id.action_convertirSinimagenes) {

            ExportarExcel export = new ExportarExcel(getApplicationContext());
            export.exportDataBaseIntoCSV(0);
            return true;
        }
        if (idmenu == R.id.action_borrardatos) {

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setCancelable(false);
            dialogo1.setMessage("¿Si no ha exportado, podria perder la infromación?");
            dialogo1.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    ConexionSQLiteHelper conexionSQLiteHelper = new ConexionSQLiteHelper(HistorialActivity.this);
                    SQLiteDatabase db = conexionSQLiteHelper.getWritableDatabase();
                    db.delete(Utilidades.TABLA_ALCANTARILLADO,null,null);
                    db.execSQL ("delete from sqlite_sequence where name='"+Utilidades.TABLA_ALCANTARILLADO+"'");
                    db.close();

                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    dialogo1.dismiss();
                }
            });
            dialogo1.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}