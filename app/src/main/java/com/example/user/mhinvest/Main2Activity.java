package com.example.user.mhinvest;



import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mhinvest.Fragments.ElementosFragment;
import com.example.user.mhinvest.Fragments.FotosFragment;
import com.example.user.mhinvest.Fragments.InfogeneralFragment;
import com.example.user.mhinvest.Fragments.TramosFragment;
import com.example.user.mhinvest.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Main2Activity extends AppCompatActivity implements FotosFragment.OnFragmentInteractionListener, InfogeneralFragment.OnFragmentInteractionListener,
        ElementosFragment.OnFragmentInteractionListener, TramosFragment.OnFragmentInteractionListener {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    //Variables infogeneral
    String fecha;
    String direccion;
    String barrio;
    String MH;
    String IPID;
    String sePudoAbrir;
    String motivo;
    String tipoCota;
    String cotaTapa;
    String tipoAlcantarillado;
    String tipoPozo;
    String excen;
    String medExcen;
    String longitud;
    String latitud;
    String altura;
    String sumideros;
    String cantidadSumideros;


//Variables Elementos
    String tieneTapa;
    String tieneCuello;
    String tieneCono;
    String tieneCilindro;
    String tieneEscalones;
    String tieneCañuela;
    String tieneCamara;
    String estadoTapa;
    String estadoCuello;
    String estadoCono;
    String estadoCilindro;
    String estadoEscalones;
    String estadoCañuela;
    String materialTapa;
    String materialCilindro;
    String materialEscalones;
    String diamCilindro;
    String diamOido;
    String cantidadEscalones;
    String alturaCamara;
    String tramoCamara;
    String anchoCañuela;
    String observacionesTapa;
    String observacionesCuello;
    String observacionesCono;
    String observacionesCilindro;
    String observacionesEscalones;
    String observacionesCañuela;
    String observacionesCamara;


//Variables tramos
    String entraT1;
    String entraT2;
    String entraT3;
    String entraT4;
    String entraT5;
    String entraT6;
    String hejeT1;
    String hejeT2;
    String hejeT3;
    String hejeT4;
    String hejeT5;
    String hejeT6;
    String conectaT1;
    String conectaT2;
    String conectaT3;
    String conectaT4;
    String conectaT5;
    String conectaT6;
    String diamT1;
    String diamT2;
    String diamT3;
    String diamT4;
    String diamT5;
    String diamT6;
    String hcajaT1;
    String hcajaT2;
    String hcajaT3;
    String hcajaT4;
    String hcajaT5;
    String hcajaT6;
    String hbateaT1;
    String hbateaT2;
    String hbateaT3;
    String hbateaT4;
    String hbateaT5;
    String hbateaT6;
    String materialT1;
    String materialT2;
    String materialT3;
    String materialT4;
    String materialT5;
    String materialT6;
    String estadoT1;
    String estadoT2;
    String estadoT3;
    String estadoT4;
    String estadoT5;
    String estadoT6;
    String deformacionT1;
    String deformacionT2;
    String deformacionT3;
    String deformacionT4;
    String deformacionT5;
    String deformacionT6;
    String tipoDeformacionT1;
    String tipoDeformacionT2;
    String tipoDeformacionT3;
    String tipoDeformacionT4;
    String tipoDeformacionT5;
    String tipoDeformacionT6;
    String tipoAguaT1;
    String tipoAguaT2;
    String tipoAguaT3;
    String tipoAguaT4;
    String tipoAguaT5;
    String tipoAguaT6;


    byte[] bytearrayExterior;
    byte[] bytearrayPanoramica;
    byte[] bytearrayEsquema;
    byte[] bytearrayTapa;
    byte[] bytearrayInterior1;
    byte[] bytearrayInterior2;
    byte[] bytearrayInterior3;
    byte[] bytearrayInterior4;


    int id;
    long idr;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        try {
            Bundle bundle = getIntent().getExtras();
            id = bundle.getInt("id");

            Toast.makeText(this, "Datos del id: " + id + "cargados con exito", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            id = 0;
            Toast.makeText(this,"Formulario nuevo", Toast.LENGTH_SHORT).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    public int tomarid(){
        return id;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int idmenu = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (idmenu == R.id.action_guardar) {
            if (id != 0) {
                Toast.makeText(getApplicationContext(), "Este archivo ya fue guardado, debe precionar boton actualizar", Toast.LENGTH_LONG).show();
            } else {

                FotosFragment fragmentFotos = (FotosFragment) getSupportFragmentManager().getFragments().get(0);
                InfogeneralFragment fragmentInfo = (InfogeneralFragment) getSupportFragmentManager().getFragments().get(1);
                ElementosFragment fragmentElementos = (ElementosFragment) getSupportFragmentManager().getFragments().get(2);
                TramosFragment fragmentTramos = (TramosFragment) getSupportFragmentManager().getFragments().get(3);

                fragmentFotos.tomarDatosFotos();
                fragmentInfo.tomarDatosInfo();
                fragmentElementos.tomarDatosElementos();
                fragmentTramos.tomarDatosTramos();

                Bundle bundleFotos = getIntent().getExtras();
                Bundle bundleInfo = getIntent().getExtras();
                Bundle bundleElementos = getIntent().getExtras();
                Bundle bundleTramos = getIntent().getExtras();


                fecha = bundleInfo.getString("Fecha");
                direccion = bundleInfo.getString("Direccion");
                barrio = bundleInfo.getString("Barrio");
                MH = bundleInfo.getString("MH");
                IPID = bundleInfo.getString("IPID");
                sePudoAbrir = bundleInfo.getString("SePudoAbrir");
                motivo = bundleInfo.getString("Motivo");
                tipoCota = bundleInfo.getString("TipoCota");
                cotaTapa = bundleInfo.getString("CotaTapa");
                tipoAlcantarillado = bundleInfo.getString("TipoAlcantarillado");
                tipoPozo = bundleInfo.getString("TipoPozo");
                excen = bundleInfo.getString("Excentricidad");
                medExcen = bundleInfo.getString("MedExcen");
                latitud = bundleInfo.getString("Latitud");
                longitud = bundleInfo.getString("Longitud");
                altura = bundleInfo.getString("Altura");
                sumideros = bundleInfo.getString("Sumideros");
                cantidadSumideros = bundleInfo.getString("CantidadSumideros");


                tieneTapa = bundleElementos.getString("TieneTapa");
                tieneCuello = bundleElementos.getString("TieneCuello");
                tieneCono = bundleElementos.getString("TieneCono");
                tieneCilindro = bundleElementos.getString("TieneCilindro");
                tieneEscalones = bundleElementos.getString("TieneEscalones");
                tieneCañuela = bundleElementos.getString("TieneCañuela");
                tieneCamara = bundleElementos.getString("TieneCamara");
                estadoTapa = bundleElementos.getString("EstadoTapa");
                estadoCuello = bundleElementos.getString("EstadoCuello");
                estadoCono = bundleElementos.getString("EstadoCono");
                estadoCilindro = bundleElementos.getString("EstadoCilindro");
                estadoEscalones = bundleElementos.getString("EstadoEscalones");
                estadoCañuela = bundleElementos.getString("EstadoCañuela");
                materialTapa = bundleElementos.getString("MaterialTapa");
                materialCilindro = bundleElementos.getString("MaterialCilindro");
                materialEscalones = bundleElementos.getString("MaterialEscalones");
                diamCilindro = bundleElementos.getString("DiamCilindro");
                diamOido = bundleElementos.getString("DiamOido");
                cantidadEscalones = bundleElementos.getString("CantidadEscalones");
                alturaCamara = bundleElementos.getString("AlturaCamara");
                tramoCamara = bundleElementos.getString("TramoCamara");
                anchoCañuela = bundleElementos.getString("AnchoCañuela");
                observacionesTapa = bundleElementos.getString("ObservacionesTapa");
                observacionesCuello = bundleElementos.getString("ObservacionesCuello");
                observacionesCono = bundleElementos.getString("ObservacionesCono");
                observacionesCilindro = bundleElementos.getString("ObservacionesCilindro");
                observacionesEscalones = bundleElementos.getString("ObservacionesEscalones");
                observacionesCañuela = bundleElementos.getString("ObservacionesCañuela");
                observacionesCamara = bundleElementos.getString("ObservacionesCamara");


                entraT1 = bundleTramos.getString("EntraT1");
                entraT2 = bundleTramos.getString("EntraT2");
                entraT3 = bundleTramos.getString("EntraT3");
                entraT4 = bundleTramos.getString("EntraT4");
                entraT5 = bundleTramos.getString("EntraT5");
                entraT6 = bundleTramos.getString("EntraT6");
                hejeT1 = bundleTramos.getString("HejeT1");
                hejeT2 = bundleTramos.getString("HejeT2");
                hejeT3 = bundleTramos.getString("HejeT3");
                hejeT4 = bundleTramos.getString("HejeT4");
                hejeT5 = bundleTramos.getString("HejeT5");
                hejeT6 = bundleTramos.getString("HejeT6");
                conectaT1 = bundleTramos.getString("ConectaT1");
                conectaT2 = bundleTramos.getString("ConectaT2");
                conectaT3 = bundleTramos.getString("ConectaT3");
                conectaT4 = bundleTramos.getString("ConectaT4");
                conectaT5 = bundleTramos.getString("ConectaT5");
                conectaT6 = bundleTramos.getString("ConectaT6");
                diamT1 = bundleTramos.getString("DiamT1");
                diamT2 = bundleTramos.getString("DiamT2");
                diamT3 = bundleTramos.getString("DiamT3");
                diamT4 = bundleTramos.getString("DiamT4");
                diamT5 = bundleTramos.getString("DiamT5");
                diamT6 = bundleTramos.getString("DiamT6");
                hcajaT1 = bundleTramos.getString("HcajaT1");
                hcajaT2 = bundleTramos.getString("HcajaT2");
                hcajaT3 = bundleTramos.getString("HcajaT3");
                hcajaT4 = bundleTramos.getString("HcajaT4");
                hcajaT5 = bundleTramos.getString("HcajaT5");
                hcajaT6 = bundleTramos.getString("HcajaT6");
                hbateaT1 = bundleTramos.getString("HbateaT1");
                hbateaT2 = bundleTramos.getString("HbateaT2");
                hbateaT3 = bundleTramos.getString("HbateaT3");
                hbateaT4 = bundleTramos.getString("HbateaT4");
                hbateaT5 = bundleTramos.getString("HbateaT5");
                hbateaT6 = bundleTramos.getString("HbateaT6");
                materialT1 = bundleTramos.getString("MaterialT1");
                materialT2 = bundleTramos.getString("MaterialT2");
                materialT3 = bundleTramos.getString("MaterialT3");
                materialT4 = bundleTramos.getString("MaterialT4");
                materialT5 = bundleTramos.getString("MaterialT5");
                materialT6 = bundleTramos.getString("MaterialT6");
                estadoT1 = bundleTramos.getString("EstadoT1");
                estadoT2 = bundleTramos.getString("EstadoT2");
                estadoT3 = bundleTramos.getString("EstadoT3");
                estadoT4 = bundleTramos.getString("EstadoT4");
                estadoT5 = bundleTramos.getString("EstadoT5");
                estadoT6 = bundleTramos.getString("EstadoT6");
                deformacionT1 = bundleTramos.getString("DeformacionT1");
                deformacionT2 = bundleTramos.getString("DeformacionT2");
                deformacionT3 = bundleTramos.getString("DeformacionT3");
                deformacionT4 = bundleTramos.getString("DeformacionT4");
                deformacionT5 = bundleTramos.getString("DeformacionT5");
                deformacionT6 = bundleTramos.getString("DeformacionT6");
                tipoDeformacionT1 = bundleTramos.getString("TipoDeformacionT1");
                tipoDeformacionT2 = bundleTramos.getString("TipoDeformacionT2");
                tipoDeformacionT3 = bundleTramos.getString("TipoDeformacionT3");
                tipoDeformacionT4 = bundleTramos.getString("TipoDeformacionT4");
                tipoDeformacionT5 = bundleTramos.getString("TipoDeformacionT5");
                tipoDeformacionT6 = bundleTramos.getString("TipoDeformacionT6");
                tipoAguaT1 = bundleTramos.getString("TipoAguaT1");
                tipoAguaT2 = bundleTramos.getString("TipoAguaT2");
                tipoAguaT3 = bundleTramos.getString("TipoAguaT3");
                tipoAguaT4 = bundleTramos.getString("TipoAguaT4");
                tipoAguaT5 = bundleTramos.getString("TipoAguaT5");
                tipoAguaT6 = bundleTramos.getString("TipoAguaT6");


                bytearrayExterior = bundleFotos.getByteArray("bytearray1");
                bytearrayPanoramica = bundleFotos.getByteArray("bytearray2");
                bytearrayEsquema = bundleFotos.getByteArray("bytearray3");
                bytearrayTapa = bundleFotos.getByteArray("bytearray4");
                bytearrayInterior1 = bundleFotos.getByteArray("bytearray5");
                bytearrayInterior2 = bundleFotos.getByteArray("bytearray6");
                bytearrayInterior3 = bundleFotos.getByteArray("bytearray7");
                bytearrayInterior4 = bundleFotos.getByteArray("bytearray8");


                Toast.makeText(getApplicationContext(), "Datos almacenados con exito", Toast.LENGTH_LONG).show();

                bdRegistro();
            }
            return true;
        }
        if (idmenu == R.id.action_actualizar) {
            if (id == 0) {
                Toast.makeText(this, "Debe guardar antes de actualizar", Toast.LENGTH_LONG).show();
            } else {
                FotosFragment fragmentFotos = (FotosFragment) getSupportFragmentManager().getFragments().get(0);
                InfogeneralFragment fragmentInfo = (InfogeneralFragment) getSupportFragmentManager().getFragments().get(1);
                ElementosFragment fragmentElementos = (ElementosFragment) getSupportFragmentManager().getFragments().get(2);
                TramosFragment fragmentTramos = (TramosFragment) getSupportFragmentManager().getFragments().get(3);

                fragmentFotos.tomarDatosFotos();
                fragmentInfo.tomarDatosInfo();
                fragmentElementos.tomarDatosElementos();
                fragmentTramos.tomarDatosTramos();

                Bundle bundleFotos = getIntent().getExtras();
                Bundle bundleInfo = getIntent().getExtras();
                Bundle bundleElementos = getIntent().getExtras();
                Bundle bundleTramos = getIntent().getExtras();


                fecha = bundleInfo.getString("Fecha");
                direccion = bundleInfo.getString("Direccion");
                barrio = bundleInfo.getString("Barrio");
                MH = bundleInfo.getString("MH");
                IPID = bundleInfo.getString("IPID");
                sePudoAbrir = bundleInfo.getString("SePudoAbrir");
                motivo = bundleInfo.getString("Motivo");
                tipoCota = bundleInfo.getString("TipoCota");
                cotaTapa = bundleInfo.getString("CotaTapa");
                tipoAlcantarillado = bundleInfo.getString("TipoAlcantarillado");
                tipoPozo = bundleInfo.getString("TipoPozo");
                excen = bundleInfo.getString("Excentricidad");
                medExcen = bundleInfo.getString("MedExcen");
                latitud = bundleInfo.getString("Latitud");
                longitud = bundleInfo.getString("Longitud");
                altura = bundleInfo.getString("Altura");
                sumideros = bundleInfo.getString("Sumideros");
                cantidadSumideros = bundleInfo.getString("CantidadSumideros");


                tieneTapa = bundleElementos.getString("TieneTapa");
                tieneCuello = bundleElementos.getString("TieneCuello");
                tieneCono = bundleElementos.getString("TieneCono");
                tieneCilindro = bundleElementos.getString("TieneCilindro");
                tieneEscalones = bundleElementos.getString("TieneEscalones");
                tieneCañuela = bundleElementos.getString("TieneCañuela");
                tieneCamara = bundleElementos.getString("TieneCamara");
                estadoTapa = bundleElementos.getString("EstadoTapa");
                estadoCuello = bundleElementos.getString("EstadoCuello");
                estadoCono = bundleElementos.getString("EstadoCono");
                estadoCilindro = bundleElementos.getString("EstadoCilindro");
                estadoEscalones = bundleElementos.getString("EstadoEscalones");
                estadoCañuela = bundleElementos.getString("EstadoCañuela");
                materialTapa = bundleElementos.getString("MaterialTapa");
                materialCilindro = bundleElementos.getString("MaterialCilindro");
                materialEscalones = bundleElementos.getString("MaterialEscalones");
                diamCilindro = bundleElementos.getString("DiamCilindro");
                diamOido = bundleElementos.getString("DiamOido");
                cantidadEscalones = bundleElementos.getString("CantidadEscalones");
                alturaCamara = bundleElementos.getString("AlturaCamara");
                tramoCamara = bundleElementos.getString("TramoCamara");
                anchoCañuela = bundleElementos.getString("AnchoCañuela");
                observacionesTapa = bundleElementos.getString("ObservacionesTapa");
                observacionesCuello = bundleElementos.getString("ObservacionesCuello");
                observacionesCono = bundleElementos.getString("ObservacionesCono");
                observacionesCilindro = bundleElementos.getString("ObservacionesCilindro");
                observacionesEscalones = bundleElementos.getString("ObservacionesEscalones");
                observacionesCañuela = bundleElementos.getString("ObservacionesCañuela");
                observacionesCamara = bundleElementos.getString("ObservacionesCamara");


                entraT1 = bundleTramos.getString("EntraT1");
                entraT2 = bundleTramos.getString("EntraT2");
                entraT3 = bundleTramos.getString("EntraT3");
                entraT4 = bundleTramos.getString("EntraT4");
                entraT5 = bundleTramos.getString("EntraT5");
                entraT6 = bundleTramos.getString("EntraT6");
                hejeT1 = bundleTramos.getString("HejeT1");
                hejeT2 = bundleTramos.getString("HejeT2");
                hejeT3 = bundleTramos.getString("HejeT3");
                hejeT4 = bundleTramos.getString("HejeT4");
                hejeT5 = bundleTramos.getString("HejeT5");
                hejeT6 = bundleTramos.getString("HejeT6");
                conectaT1 = bundleTramos.getString("ConectaT1");
                conectaT2 = bundleTramos.getString("ConectaT2");
                conectaT3 = bundleTramos.getString("ConectaT3");
                conectaT4 = bundleTramos.getString("ConectaT4");
                conectaT5 = bundleTramos.getString("ConectaT5");
                conectaT6 = bundleTramos.getString("ConectaT6");
                diamT1 = bundleTramos.getString("DiamT1");
                diamT2 = bundleTramos.getString("DiamT2");
                diamT3 = bundleTramos.getString("DiamT3");
                diamT4 = bundleTramos.getString("DiamT4");
                diamT5 = bundleTramos.getString("DiamT5");
                diamT6 = bundleTramos.getString("DiamT6");
                hcajaT1 = bundleTramos.getString("HcajaT1");
                hcajaT2 = bundleTramos.getString("HcajaT2");
                hcajaT3 = bundleTramos.getString("HcajaT3");
                hcajaT4 = bundleTramos.getString("HcajaT4");
                hcajaT5 = bundleTramos.getString("HcajaT5");
                hcajaT6 = bundleTramos.getString("HcajaT6");
                hbateaT1 = bundleTramos.getString("HbateaT1");
                hbateaT2 = bundleTramos.getString("HbateaT2");
                hbateaT3 = bundleTramos.getString("HbateaT3");
                hbateaT4 = bundleTramos.getString("HbateaT4");
                hbateaT5 = bundleTramos.getString("HbateaT5");
                hbateaT6 = bundleTramos.getString("HbateaT6");
                materialT1 = bundleTramos.getString("MaterialT1");
                materialT2 = bundleTramos.getString("MaterialT2");
                materialT3 = bundleTramos.getString("MaterialT3");
                materialT4 = bundleTramos.getString("MaterialT4");
                materialT5 = bundleTramos.getString("MaterialT5");
                materialT6 = bundleTramos.getString("MaterialT6");
                estadoT1 = bundleTramos.getString("EstadoT1");
                estadoT2 = bundleTramos.getString("EstadoT2");
                estadoT3 = bundleTramos.getString("EstadoT3");
                estadoT4 = bundleTramos.getString("EstadoT4");
                estadoT5 = bundleTramos.getString("EstadoT5");
                estadoT6 = bundleTramos.getString("EstadoT6");
                deformacionT1 = bundleTramos.getString("DeformacionT1");
                deformacionT2 = bundleTramos.getString("DeformacionT2");
                deformacionT3 = bundleTramos.getString("DeformacionT3");
                deformacionT4 = bundleTramos.getString("DeformacionT4");
                deformacionT5 = bundleTramos.getString("DeformacionT5");
                deformacionT6 = bundleTramos.getString("DeformacionT6");
                tipoDeformacionT1 = bundleTramos.getString("TipoDeformacionT1");
                tipoDeformacionT2 = bundleTramos.getString("TipoDeformacionT2");
                tipoDeformacionT3 = bundleTramos.getString("TipoDeformacionT3");
                tipoDeformacionT4 = bundleTramos.getString("TipoDeformacionT4");
                tipoDeformacionT5 = bundleTramos.getString("TipoDeformacionT5");
                tipoDeformacionT6 = bundleTramos.getString("TipoDeformacionT6");
                tipoAguaT1 = bundleTramos.getString("TipoAguaT1");
                tipoAguaT2 = bundleTramos.getString("TipoAguaT2");
                tipoAguaT3 = bundleTramos.getString("TipoAguaT3");
                tipoAguaT4 = bundleTramos.getString("TipoAguaT4");
                tipoAguaT5 = bundleTramos.getString("TipoAguaT5");
                tipoAguaT6 = bundleTramos.getString("TipoAguaT6");


                bytearrayExterior = bundleFotos.getByteArray("bytearray1");
                bytearrayPanoramica = bundleFotos.getByteArray("bytearray2");
                bytearrayEsquema = bundleFotos.getByteArray("bytearray3");
                bytearrayTapa = bundleFotos.getByteArray("bytearray4");
                bytearrayInterior1 = bundleFotos.getByteArray("bytearray5");
                bytearrayInterior2 = bundleFotos.getByteArray("bytearray6");
                bytearrayInterior3 = bundleFotos.getByteArray("bytearray7");
                bytearrayInterior4 = bundleFotos.getByteArray("bytearray8");


                Toast.makeText(getApplicationContext(), "Datos actualizados con exito", Toast.LENGTH_LONG).show();
                bdactualizar();
            }
            return true;
        }
        if (idmenu == R.id.action_salir) {

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setCancelable(false);
            dialogo1.setMessage("¿Seguro que desea salir?");
            dialogo1.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                   finish();
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
        if (idmenu == R.id.action_cargardatos) {

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setCancelable(false);
            dialogo1.setMessage("¿Seguro que desea salir?");
            dialogo1.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    Intent intent = new Intent(Main2Activity.this,HistorialActivity.class);
                    startActivity(intent);
                    finish();
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


    private void bdactualizar() {

            ConexionSQLiteHelper conexionSQLiteHelper = new ConexionSQLiteHelper(this);
            SQLiteDatabase db = conexionSQLiteHelper.getWritableDatabase();
            String[] parametros = new String[]{Integer.toString(id)};
            ContentValues values = new ContentValues();


            values.put(Utilidades.CAMPO_APELLIDOS, "");
            values.put(Utilidades.CAMPO_NOMBRE, "");
            values.put(Utilidades.CAMPO_FECHARESPUESTA, fecha);
            values.put(Utilidades.CAMPO_FECHA, fecha);
            values.put(Utilidades.CAMPO_FOTOEXTERIOR, bytearrayExterior);
            values.put(Utilidades.CAMPO_FOTOPANORAMICA, bytearrayPanoramica);
            values.put(Utilidades.CAMPO_MH, MH);
            values.put(Utilidades.CAMPO_IPID, IPID);
            values.put(Utilidades.CAMPO_DIRECCION, direccion);
            values.put(Utilidades.CAMPO_BARRIO, barrio);
            values.put(Utilidades.CAMPO_GEOLOCALIZACION, "Latitud:" + latitud + "\n" + "Longitud:" + longitud);
            values.put(Utilidades.CAMPO_SEPUDOABRIR, sePudoAbrir);
            values.put(Utilidades.CAMPO_MOTIVO, motivo);
            values.put(Utilidades.CAMPO_TIPOCOTA, tipoCota);
            values.put(Utilidades.CAMPO_COTATAPA, cotaTapa);
            values.put(Utilidades.CAMPO_FOTOESQUEMA, bytearrayEsquema);
            values.put(Utilidades.CAMPO_FOTOTAPA, bytearrayTapa);
            values.put(Utilidades.CAMPO_TIPOALCANTARILLADO, tipoAlcantarillado);
            values.put(Utilidades.CAMPO_TIPOPOZO, tipoPozo);
            values.put(Utilidades.CAMPO_EXCENTRICIDAD, excen);
            values.put(Utilidades.CAMPO_MEDEXCENTRICIDAD, medExcen);
            values.put(Utilidades.CAMPO_ALTURA, altura);

            values.put(Utilidades.CAMPO_TRAMO1, "");
            values.put(Utilidades.CAMPO_HEJE1, hejeT1);
            values.put(Utilidades.CAMPO_ENTRA1, entraT1);
            values.put(Utilidades.CAMPO_CONECTA1, conectaT1);
            values.put(Utilidades.CAMPO_DIAM1, diamT1);
            values.put(Utilidades.CAMPO_HCAJA1, hcajaT1);
            values.put(Utilidades.CAMPO_DISTANCIABATEA1, "");
            values.put(Utilidades.CAMPO_HINCLINADA1, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE1, "");
            values.put(Utilidades.CAMPO_CALCULO1, "");
            values.put(Utilidades.CAMPO_HBATEA1, hbateaT1);
            values.put(Utilidades.CAMPO_MATERIAL1, materialT1);
            values.put(Utilidades.CAMPO_ESTADO1, estadoT1);
            values.put(Utilidades.CAMPO_DEFORMACION1, deformacionT1);
            values.put(Utilidades.CAMPO_TIPODEFORMACION1, tipoDeformacionT1);
            values.put(Utilidades.CAMPO_TIPOAGUA1, tipoAguaT1);


            values.put(Utilidades.CAMPO_TRAMO2, "");
            values.put(Utilidades.CAMPO_HEJE2, hejeT2);
            values.put(Utilidades.CAMPO_ENTRA2, entraT2);
            values.put(Utilidades.CAMPO_CONECTA2, conectaT2);
            values.put(Utilidades.CAMPO_DIAM2, diamT2);
            values.put(Utilidades.CAMPO_HCAJA2, hcajaT2);
            values.put(Utilidades.CAMPO_DISTANCIABATEA2, "");
            values.put(Utilidades.CAMPO_HINCLINADA2, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE2, "");
            values.put(Utilidades.CAMPO_CALCULO2, "");
            values.put(Utilidades.CAMPO_HBATEA2, hbateaT2);
            values.put(Utilidades.CAMPO_MATERIAL2, materialT2);
            values.put(Utilidades.CAMPO_ESTADO2, estadoT2);
            values.put(Utilidades.CAMPO_DEFORMACION2, deformacionT2);
            values.put(Utilidades.CAMPO_TIPODEFORMACION2, tipoDeformacionT2);
            values.put(Utilidades.CAMPO_TIPOAGUA2, tipoAguaT2);

            values.put(Utilidades.CAMPO_TRAMO3, "");
            values.put(Utilidades.CAMPO_HEJE3, hejeT3);
            values.put(Utilidades.CAMPO_ENTRA3, entraT3);
            values.put(Utilidades.CAMPO_CONECTA3, conectaT3);
            values.put(Utilidades.CAMPO_DIAM3, diamT3);
            values.put(Utilidades.CAMPO_HCAJA3, hcajaT3);
            values.put(Utilidades.CAMPO_DISTANCIABATEA3, "");
            values.put(Utilidades.CAMPO_HINCLINADA3, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE3, "");
            values.put(Utilidades.CAMPO_CALCULO3, "");
            values.put(Utilidades.CAMPO_HBATEA3, hbateaT3);
            values.put(Utilidades.CAMPO_MATERIAL3, materialT3);
            values.put(Utilidades.CAMPO_ESTADO3, estadoT3);
            values.put(Utilidades.CAMPO_DEFORMACION3, deformacionT3);
            values.put(Utilidades.CAMPO_TIPODEFORMACION3, tipoDeformacionT3);
            values.put(Utilidades.CAMPO_TIPOAGUA3, tipoAguaT3);

            values.put(Utilidades.CAMPO_TRAMO4, "");
            values.put(Utilidades.CAMPO_HEJE4, hejeT4);
            values.put(Utilidades.CAMPO_ENTRA4, entraT4);
            values.put(Utilidades.CAMPO_CONECTA4, conectaT4);
            values.put(Utilidades.CAMPO_DIAM4, diamT4);
            values.put(Utilidades.CAMPO_HCAJA4, hcajaT4);
            values.put(Utilidades.CAMPO_DISTANCIABATEA4, "");
            values.put(Utilidades.CAMPO_HINCLINADA4, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE4, "");
            values.put(Utilidades.CAMPO_CALCULO4, "");
            values.put(Utilidades.CAMPO_HBATEA4, hbateaT4);
            values.put(Utilidades.CAMPO_MATERIAL4, materialT4);
            values.put(Utilidades.CAMPO_ESTADO4, estadoT4);
            values.put(Utilidades.CAMPO_DEFORMACION4, deformacionT4);
            values.put(Utilidades.CAMPO_TIPODEFORMACION4, tipoDeformacionT4);
            values.put(Utilidades.CAMPO_TIPOAGUA4, tipoAguaT4);

            values.put(Utilidades.CAMPO_TRAMO5, "");
            values.put(Utilidades.CAMPO_HEJE5, hejeT5);
            values.put(Utilidades.CAMPO_ENTRA5, entraT5);
            values.put(Utilidades.CAMPO_CONECTA5, conectaT5);
            values.put(Utilidades.CAMPO_DIAM5, diamT5);
            values.put(Utilidades.CAMPO_HCAJA5, hcajaT5);
            values.put(Utilidades.CAMPO_DISTANCIABATEA5, "");
            values.put(Utilidades.CAMPO_HINCLINADA5, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE5, "");
            values.put(Utilidades.CAMPO_CALCULO5, "");
            values.put(Utilidades.CAMPO_HBATEA5, hbateaT5);
            values.put(Utilidades.CAMPO_MATERIAL5, materialT5);
            values.put(Utilidades.CAMPO_ESTADO5, estadoT5);
            values.put(Utilidades.CAMPO_DEFORMACION5, deformacionT5);
            values.put(Utilidades.CAMPO_TIPODEFORMACION5, tipoDeformacionT5);
            values.put(Utilidades.CAMPO_TIPOAGUA5, tipoAguaT5);

            values.put(Utilidades.CAMPO_TRAMO6, "");
            values.put(Utilidades.CAMPO_HEJE6, hejeT6);
            values.put(Utilidades.CAMPO_ENTRA6, entraT6);
            values.put(Utilidades.CAMPO_CONECTA6, conectaT6);
            values.put(Utilidades.CAMPO_DIAM6, diamT6);
            values.put(Utilidades.CAMPO_HCAJA6, hcajaT6);
            values.put(Utilidades.CAMPO_DISTANCIABATEA6, "");
            values.put(Utilidades.CAMPO_HINCLINADA6, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE6, "");
            values.put(Utilidades.CAMPO_CALCULO6, "");
            values.put(Utilidades.CAMPO_HBATEA6, hbateaT6);
            values.put(Utilidades.CAMPO_MATERIAL6, materialT6);
            values.put(Utilidades.CAMPO_ESTADO6, estadoT6);
            values.put(Utilidades.CAMPO_DEFORMACION6, deformacionT6);
            values.put(Utilidades.CAMPO_TIPODEFORMACION6, tipoDeformacionT6);
            values.put(Utilidades.CAMPO_TIPOAGUA6, tipoAguaT6);

            values.put(Utilidades.CAMPO_TAPA, tieneTapa);
            values.put(Utilidades.CAMPO_ESTADOTAPA, estadoTapa);
            values.put(Utilidades.CAMPO_TIPOTAPA, materialTapa);
            values.put(Utilidades.CAMPO_OBSERVACIONESTAPA, observacionesTapa);

            values.put(Utilidades.CAMPO_CUELLO, tieneCuello);
            values.put(Utilidades.CAMPO_ESTADOCUELLO, estadoCuello);
            values.put(Utilidades.CAMPO_OBSERVACIONESCUELLO, observacionesCuello);

            values.put(Utilidades.CAMPO_CONO, tieneCono);
            values.put(Utilidades.CAMPO_ESTADOCONO, estadoCono);
            values.put(Utilidades.CAMPO_OBSERVACIONESCONO, observacionesCono);

            values.put(Utilidades.CAMPO_CILINDRO, tieneCilindro);
            values.put(Utilidades.CAMPO_MATERIALCILINDRO, materialCilindro);
            values.put(Utilidades.CAMPO_DIAMETROCILINDRO, diamCilindro);
            values.put(Utilidades.CAMPO_ESTADOCILINDRO, estadoCilindro);

            values.put(Utilidades.CAMPO_ESCALONES, tieneEscalones);
            values.put(Utilidades.CAMPO_TIPOESCALONES, materialEscalones);
            values.put(Utilidades.CAMPO_ESTADOESCALONES, estadoEscalones);
            values.put(Utilidades.CAMPO_CANTIDADESCALONES, cantidadEscalones);

            values.put(Utilidades.CAMPO_CAÑUELA, tieneCañuela);
            values.put(Utilidades.CAMPO_ESTADOCAÑUELA, estadoCañuela);
            values.put(Utilidades.CAMPO_ANCHOCAÑUELA, anchoCañuela);

            values.put(Utilidades.CAMPO_CAMARA, tieneCamara);
            values.put(Utilidades.CAMPO_ALTURAOIDOCAMARA, alturaCamara);
            values.put(Utilidades.CAMPO_DIAMETROOIDOCAMARA, diamOido);

            values.put(Utilidades.CAMPO_OBSERVACIONESGENERALES, "");
            values.put(Utilidades.CAMPO_OBSERVACIONADICIONAL, observacionesCilindro + observacionesEscalones + observacionesCañuela + observacionesCamara);

            values.put(Utilidades.CAMPO_FOTOINTERIOR1, bytearrayInterior1);
            values.put(Utilidades.CAMPO_FOTOINTERIOR2, bytearrayInterior2);
            values.put(Utilidades.CAMPO_FOTOINTERIOR3, bytearrayInterior3);
            values.put(Utilidades.CAMPO_FOTOINTERIOR4, bytearrayInterior4);

            values.put(Utilidades.CAMPO_SUMIDEROS, sumideros);
            values.put(Utilidades.CAMPO_CANTIDADSUMIDEROS, cantidadSumideros);
            values.put(Utilidades.CAMPO_CAMPOENTRADA, "");


            db.update(Utilidades.TABLA_ALCANTARILLADO,values,Utilidades.CAMPO_ID + " =? ",parametros);

            Toast.makeText(getApplicationContext(),"Actualización exitosa", Toast.LENGTH_SHORT).show();
            db.close();

    }

    private void bdRegistro() {



            ConexionSQLiteHelper conexionSQLiteHelper = new ConexionSQLiteHelper(this);
            SQLiteDatabase db = conexionSQLiteHelper.getWritableDatabase();
            ContentValues values = new ContentValues();


            values.put(Utilidades.CAMPO_APELLIDOS, "");
            values.put(Utilidades.CAMPO_NOMBRE, "");
            values.put(Utilidades.CAMPO_FECHARESPUESTA, fecha);
            values.put(Utilidades.CAMPO_FECHA, fecha);
            values.put(Utilidades.CAMPO_FOTOEXTERIOR, bytearrayExterior);
            values.put(Utilidades.CAMPO_FOTOPANORAMICA, bytearrayPanoramica);
            values.put(Utilidades.CAMPO_MH, MH);
            values.put(Utilidades.CAMPO_IPID, IPID);
            values.put(Utilidades.CAMPO_DIRECCION, direccion);
            values.put(Utilidades.CAMPO_BARRIO, barrio);
            values.put(Utilidades.CAMPO_GEOLOCALIZACION, "Latitud:" + latitud + "\n" + "Longitud:" + longitud);
            values.put(Utilidades.CAMPO_SEPUDOABRIR, sePudoAbrir);
            values.put(Utilidades.CAMPO_MOTIVO, motivo);
            values.put(Utilidades.CAMPO_TIPOCOTA, tipoCota);
            values.put(Utilidades.CAMPO_COTATAPA, cotaTapa);
            values.put(Utilidades.CAMPO_FOTOESQUEMA, bytearrayEsquema);
            values.put(Utilidades.CAMPO_FOTOTAPA, bytearrayTapa);
            values.put(Utilidades.CAMPO_TIPOALCANTARILLADO, tipoAlcantarillado);
            values.put(Utilidades.CAMPO_TIPOPOZO, tipoPozo);
            values.put(Utilidades.CAMPO_EXCENTRICIDAD, excen);
            values.put(Utilidades.CAMPO_MEDEXCENTRICIDAD, medExcen);
            values.put(Utilidades.CAMPO_ALTURA, altura);

            values.put(Utilidades.CAMPO_TRAMO1, "");
            values.put(Utilidades.CAMPO_HEJE1, hejeT1);
            values.put(Utilidades.CAMPO_ENTRA1, entraT1);
            values.put(Utilidades.CAMPO_CONECTA1, conectaT1);
            values.put(Utilidades.CAMPO_DIAM1, diamT1);
            values.put(Utilidades.CAMPO_HCAJA1, hcajaT1);
            values.put(Utilidades.CAMPO_DISTANCIABATEA1, "");
            values.put(Utilidades.CAMPO_HINCLINADA1, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE1, "");
            values.put(Utilidades.CAMPO_CALCULO1, "");
            values.put(Utilidades.CAMPO_HBATEA1, hbateaT1);
            values.put(Utilidades.CAMPO_MATERIAL1, materialT1);
            values.put(Utilidades.CAMPO_ESTADO1, estadoT1);
            values.put(Utilidades.CAMPO_DEFORMACION1, deformacionT1);
            values.put(Utilidades.CAMPO_TIPODEFORMACION1, tipoDeformacionT1);
            values.put(Utilidades.CAMPO_TIPOAGUA1, tipoAguaT1);


            values.put(Utilidades.CAMPO_TRAMO2, "");
            values.put(Utilidades.CAMPO_HEJE2, hejeT2);
            values.put(Utilidades.CAMPO_ENTRA2, entraT2);
            values.put(Utilidades.CAMPO_CONECTA2, conectaT2);
            values.put(Utilidades.CAMPO_DIAM2, diamT2);
            values.put(Utilidades.CAMPO_HCAJA2, hcajaT2);
            values.put(Utilidades.CAMPO_DISTANCIABATEA2, "");
            values.put(Utilidades.CAMPO_HINCLINADA2, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE2, "");
            values.put(Utilidades.CAMPO_CALCULO2, "");
            values.put(Utilidades.CAMPO_HBATEA2, hbateaT2);
            values.put(Utilidades.CAMPO_MATERIAL2, materialT2);
            values.put(Utilidades.CAMPO_ESTADO2, estadoT2);
            values.put(Utilidades.CAMPO_DEFORMACION2, deformacionT2);
            values.put(Utilidades.CAMPO_TIPODEFORMACION2, tipoDeformacionT2);
            values.put(Utilidades.CAMPO_TIPOAGUA2, tipoAguaT2);

            values.put(Utilidades.CAMPO_TRAMO3, "");
            values.put(Utilidades.CAMPO_HEJE3, hejeT3);
            values.put(Utilidades.CAMPO_ENTRA3, entraT3);
            values.put(Utilidades.CAMPO_CONECTA3, conectaT3);
            values.put(Utilidades.CAMPO_DIAM3, diamT3);
            values.put(Utilidades.CAMPO_HCAJA3, hcajaT3);
            values.put(Utilidades.CAMPO_DISTANCIABATEA3, "");
            values.put(Utilidades.CAMPO_HINCLINADA3, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE3, "");
            values.put(Utilidades.CAMPO_CALCULO3, "");
            values.put(Utilidades.CAMPO_HBATEA3, hbateaT3);
            values.put(Utilidades.CAMPO_MATERIAL3, materialT3);
            values.put(Utilidades.CAMPO_ESTADO3, estadoT3);
            values.put(Utilidades.CAMPO_DEFORMACION3, deformacionT3);
            values.put(Utilidades.CAMPO_TIPODEFORMACION3, tipoDeformacionT3);
            values.put(Utilidades.CAMPO_TIPOAGUA3, tipoAguaT3);

            values.put(Utilidades.CAMPO_TRAMO4, "");
            values.put(Utilidades.CAMPO_HEJE4, hejeT4);
            values.put(Utilidades.CAMPO_ENTRA4, entraT4);
            values.put(Utilidades.CAMPO_CONECTA4, conectaT4);
            values.put(Utilidades.CAMPO_DIAM4, diamT4);
            values.put(Utilidades.CAMPO_HCAJA4, hcajaT4);
            values.put(Utilidades.CAMPO_DISTANCIABATEA4, "");
            values.put(Utilidades.CAMPO_HINCLINADA4, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE4, "");
            values.put(Utilidades.CAMPO_CALCULO4, "");
            values.put(Utilidades.CAMPO_HBATEA4, hbateaT4);
            values.put(Utilidades.CAMPO_MATERIAL4, materialT4);
            values.put(Utilidades.CAMPO_ESTADO4, estadoT4);
            values.put(Utilidades.CAMPO_DEFORMACION4, deformacionT4);
            values.put(Utilidades.CAMPO_TIPODEFORMACION4, tipoDeformacionT4);
            values.put(Utilidades.CAMPO_TIPOAGUA4, tipoAguaT4);

            values.put(Utilidades.CAMPO_TRAMO5, "");
            values.put(Utilidades.CAMPO_HEJE5, hejeT5);
            values.put(Utilidades.CAMPO_ENTRA5, entraT5);
            values.put(Utilidades.CAMPO_CONECTA5, conectaT5);
            values.put(Utilidades.CAMPO_DIAM5, diamT5);
            values.put(Utilidades.CAMPO_HCAJA5, hcajaT5);
            values.put(Utilidades.CAMPO_DISTANCIABATEA5, "");
            values.put(Utilidades.CAMPO_HINCLINADA5, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE5, "");
            values.put(Utilidades.CAMPO_CALCULO5, "");
            values.put(Utilidades.CAMPO_HBATEA5, hbateaT5);
            values.put(Utilidades.CAMPO_MATERIAL5, materialT5);
            values.put(Utilidades.CAMPO_ESTADO5, estadoT5);
            values.put(Utilidades.CAMPO_DEFORMACION5, deformacionT5);
            values.put(Utilidades.CAMPO_TIPODEFORMACION5, tipoDeformacionT5);
            values.put(Utilidades.CAMPO_TIPOAGUA5, tipoAguaT5);

            values.put(Utilidades.CAMPO_TRAMO6, "");
            values.put(Utilidades.CAMPO_HEJE6, hejeT6);
            values.put(Utilidades.CAMPO_ENTRA6, entraT6);
            values.put(Utilidades.CAMPO_CONECTA6, conectaT6);
            values.put(Utilidades.CAMPO_DIAM6, diamT6);
            values.put(Utilidades.CAMPO_HCAJA6, hcajaT6);
            values.put(Utilidades.CAMPO_DISTANCIABATEA6, "");
            values.put(Utilidades.CAMPO_HINCLINADA6, "");
            values.put(Utilidades.CAMPO_DISTANCIABASE6, "");
            values.put(Utilidades.CAMPO_CALCULO6, "");
            values.put(Utilidades.CAMPO_HBATEA6, hbateaT6);
            values.put(Utilidades.CAMPO_MATERIAL6, materialT6);
            values.put(Utilidades.CAMPO_ESTADO6, estadoT6);
            values.put(Utilidades.CAMPO_DEFORMACION6, deformacionT6);
            values.put(Utilidades.CAMPO_TIPODEFORMACION6, tipoDeformacionT6);
            values.put(Utilidades.CAMPO_TIPOAGUA6, tipoAguaT6);

            values.put(Utilidades.CAMPO_TAPA, tieneTapa);
            values.put(Utilidades.CAMPO_ESTADOTAPA, estadoTapa);
            values.put(Utilidades.CAMPO_TIPOTAPA, materialTapa);
            values.put(Utilidades.CAMPO_OBSERVACIONESTAPA, observacionesTapa);

            values.put(Utilidades.CAMPO_CUELLO, tieneCuello);
            values.put(Utilidades.CAMPO_ESTADOCUELLO, estadoCuello);
            values.put(Utilidades.CAMPO_OBSERVACIONESCUELLO, observacionesCuello);

            values.put(Utilidades.CAMPO_CONO, tieneCono);
            values.put(Utilidades.CAMPO_ESTADOCONO, estadoCono);
            values.put(Utilidades.CAMPO_OBSERVACIONESCONO, observacionesCono);

            values.put(Utilidades.CAMPO_CILINDRO, tieneCilindro);
            values.put(Utilidades.CAMPO_MATERIALCILINDRO, materialCilindro);
            values.put(Utilidades.CAMPO_DIAMETROCILINDRO, diamCilindro);
            values.put(Utilidades.CAMPO_ESTADOCILINDRO, estadoCilindro);

            values.put(Utilidades.CAMPO_ESCALONES, tieneEscalones);
            values.put(Utilidades.CAMPO_TIPOESCALONES, materialEscalones);
            values.put(Utilidades.CAMPO_ESTADOESCALONES, estadoEscalones);
            values.put(Utilidades.CAMPO_CANTIDADESCALONES, cantidadEscalones);

            values.put(Utilidades.CAMPO_CAÑUELA, tieneCañuela);
            values.put(Utilidades.CAMPO_ESTADOCAÑUELA, estadoCañuela);
            values.put(Utilidades.CAMPO_ANCHOCAÑUELA, anchoCañuela);

            values.put(Utilidades.CAMPO_CAMARA, tieneCamara);
            values.put(Utilidades.CAMPO_ALTURAOIDOCAMARA, alturaCamara);
            values.put(Utilidades.CAMPO_DIAMETROOIDOCAMARA, diamOido);

            values.put(Utilidades.CAMPO_OBSERVACIONESGENERALES, "");
            values.put(Utilidades.CAMPO_OBSERVACIONADICIONAL, observacionesCilindro + observacionesEscalones + observacionesCañuela + observacionesCamara);

            values.put(Utilidades.CAMPO_FOTOINTERIOR1, bytearrayInterior1);
            values.put(Utilidades.CAMPO_FOTOINTERIOR2, bytearrayInterior2);
            values.put(Utilidades.CAMPO_FOTOINTERIOR3, bytearrayInterior3);
            values.put(Utilidades.CAMPO_FOTOINTERIOR4, bytearrayInterior4);

            values.put(Utilidades.CAMPO_SUMIDEROS, sumideros);
            values.put(Utilidades.CAMPO_CANTIDADSUMIDEROS, cantidadSumideros);
            values.put(Utilidades.CAMPO_CAMPOENTRADA, "");


            long idresultante = db.insert(Utilidades.TABLA_ALCANTARILLADO, Utilidades.CAMPO_ID, values);
            id=Long.valueOf(idresultante).intValue();
            Toast.makeText(getApplicationContext(), "Datos añadidos a la base de datos con exito: " + idresultante, Toast.LENGTH_LONG).show();
            db.close();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = null;

            switch (sectionNumber){
                case 1:fragment= new FotosFragment();
                    break;
                case 2:fragment= new InfogeneralFragment();
                    break;
                case 3:fragment= new ElementosFragment();
                    break;
                case 4:fragment= new TramosFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}
