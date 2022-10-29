package com.example.user.mhinvest.Fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Context;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;

import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.user.mhinvest.ConexionSQLiteHelper;
import com.example.user.mhinvest.Main2Activity;
import com.example.user.mhinvest.R;
import com.example.user.mhinvest.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InfogeneralFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InfogeneralFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfogeneralFragment extends Fragment implements LocationListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InfogeneralFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfogeneralFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfogeneralFragment newInstance(String param1, String param2) {
        InfogeneralFragment fragment = new InfogeneralFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }




    //Declaración spinners
    private Spinner spinner_sepudoabrir;
    private Spinner spinner_tipocota;
    private Spinner spinner_tipoalcantarillado;
    private Spinner spinner_tipopozo;
    private Spinner spinner_excen;
    private Spinner spinner_sumideros;

    //Declaración TextViews
    private TextView textViewTipocota;
    private TextView textViewcota;
    private TextView textViewTipoalcantarillado;
    private TextView textViewTipopozo;
    private TextView textViewExcen;
    private TextView textViewGeolo;
    private TextView textViewAltura;
    private TextView textViewLatitud;
    private TextView textViewLongitud;
    private TextView textViewMotivo;
    private TextView textViewSumideros;

    //Declaración EditTexts
    private EditText editTextFecha;
    private EditText editTextDireccion;
    private EditText editTextBarrio;
    private EditText editTextMH;
    private EditText editTextIPID;

    private EditText editTextCota;
    private EditText editTextMedexcen;
    private EditText editTextAltura;
    private EditText editTextMotivo;
    private EditText editTextsumideros;

    //Declaración botón
    private Button buttonGeoref;

    //Declaración vista
    View vistainfogeneral;

    //Declaración variables de georeferencia
    private LocationManager locationManager;
    private String provider;


    private String fecha;
    private String direccion;
    private String barrio;
    private int mh;
    private String ipid;
    private String sepudoabrir;
    private String motivo;
    private String tipocota;
    private double cotatapa;
    private String tipoalcantarillado;
    private String tipopozo;
    private String excen;
    private double medexcen;
    private double altura;
    private String sumideros;
    private int cantidadsumideros;



    private double lat;
    private double lng;
    private int id;
    private ConexionSQLiteHelper conn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        vistainfogeneral = inflater.inflate(R.layout.fragment_infogeneral, container, false);


        textViewTipocota = vistainfogeneral.findViewById(R.id.textViewTipoCota);
        textViewcota = vistainfogeneral.findViewById(R.id.textViewCota);
        textViewTipoalcantarillado = vistainfogeneral.findViewById(R.id.textViewTipoalcan);
        textViewTipopozo = vistainfogeneral.findViewById(R.id.textViewTipoPozo);
        textViewExcen = vistainfogeneral.findViewById(R.id.textViewExcen);
        textViewGeolo = vistainfogeneral.findViewById(R.id.textViewGeolo);
        textViewAltura = vistainfogeneral.findViewById(R.id.textViewAltura);
        textViewMotivo = vistainfogeneral.findViewById(R.id.textViewMotivoabrir);
        textViewSumideros = vistainfogeneral.findViewById(R.id.textViewSumideros);


        editTextFecha = vistainfogeneral.findViewById(R.id.editText_fecha);
        editTextDireccion = vistainfogeneral.findViewById(R.id.editText_direccion);
        editTextBarrio = vistainfogeneral.findViewById(R.id.editText_barrio);
        editTextMH = vistainfogeneral.findViewById(R.id.editText_MH);
        editTextIPID = vistainfogeneral.findViewById(R.id.editText_IPID);
        editTextCota = vistainfogeneral.findViewById(R.id.editText_cotatapa);
        editTextMedexcen = vistainfogeneral.findViewById(R.id.editText_medexcen);
        editTextAltura = vistainfogeneral.findViewById(R.id.editText_Altura);
        editTextMotivo = vistainfogeneral.findViewById(R.id.editText_Motivo);
        editTextsumideros = vistainfogeneral.findViewById(R.id.editText_sumideros);



        textViewLatitud = vistainfogeneral.findViewById(R.id.editText_latitud);
        textViewLongitud = vistainfogeneral.findViewById(R.id.editText_longitud);
        buttonGeoref = vistainfogeneral.findViewById(R.id.button_georef);

        String timestamp = new SimpleDateFormat("yyyMMMdd_HHmmss").format(new Date());
        editTextFecha.setText(timestamp);


        //Spinner se pudo abrir
        spinner_sepudoabrir = vistainfogeneral.findViewById(R.id.spinner_sepudoabrir);
        String []opciones_sepudoabrir={"","Sí","No"};
        ArrayAdapter<String> adapter_sepudoabrir = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_sepudoabrir);
        //adapter_sepudoabrir.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_sepudoabrir.setAdapter(adapter_sepudoabrir);

        //Spinner tipo cota
        spinner_tipocota = (Spinner)vistainfogeneral.findViewById(R.id.spinner_tipocota);
        String []opcionescota={"","Asumida","Real"};
        ArrayAdapter<String> adapter_tipocota = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opcionescota);
        spinner_tipocota.setAdapter(adapter_tipocota);

        //Spinner tipo alcantarillado
        spinner_tipoalcantarillado = (Spinner)vistainfogeneral.findViewById(R.id.spinner_tipoalcantarillado);
        String []opciones_tipoalcantarillado={"","Lluvia","Negra","Combinada"};
        ArrayAdapter<String> adapter_tipoalcantarillado = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_tipoalcantarillado);
        spinner_tipoalcantarillado.setAdapter(adapter_tipoalcantarillado);

        //Spinner tipo pozo
        spinner_tipopozo = (Spinner)vistainfogeneral.findViewById(R.id.spinner_tipopozo);
        String []opciones_tipopozo={"","Camara","Alivio"};
        ArrayAdapter<String> adapter_tipopozo = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_tipopozo);
        spinner_tipopozo.setAdapter(adapter_tipopozo);

        //Spinner excentricidad
        spinner_excen = (Spinner)vistainfogeneral.findViewById(R.id.spinner_excen);
        String []opciones_excen={"","Concentrico","Excentrico"};
        ArrayAdapter<String> adapter_excen = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_excen);
        spinner_excen.setAdapter(adapter_excen);

        spinner_sumideros = (Spinner)vistainfogeneral.findViewById(R.id.spinner_sumideros) ;
        String []opciones_sumideros = {"","Sí","No"};
        ArrayAdapter<String> adapter_sumideros = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_sumideros);
        spinner_sumideros.setAdapter(adapter_sumideros);

        Main2Activity activity = (Main2Activity)getActivity();
        id = activity.tomarid();

        if ((savedInstanceState==null)&&(id!=0)){
            conn = new ConexionSQLiteHelper(getContext());
            consultarDatosDB();

        }

        if (savedInstanceState != null) {
            lat = savedInstanceState.getParcelable(" lat");
            lng = savedInstanceState.getParcelable(" lng");
        }

        if (lat==0){
            textViewLatitud.setHint("Latitud");
        }else {
            textViewLatitud.setText(String.valueOf(lat));
        }

        if (lng==0){
            textViewLongitud.setHint("Longitud");
        }else {
            textViewLongitud.setText(String.valueOf(lng));
        }

        try {
            if (fecha != null) {
                editTextFecha.setText(fecha);
            }
        }catch (Exception e){}

        try {
            if (direccion != null) {
                editTextDireccion.setText(direccion);
            }
        }catch (Exception e){}
        try {
            if (barrio != null) {
                editTextBarrio.setText(barrio);
            }
        }catch (Exception e){}
        try {
            if (mh != 0) {
                editTextMH.setText(Integer.toString(mh));
            }
        }catch (Exception e){}
        try {
            if (ipid != null) {
                editTextIPID.setText(ipid);
            }
        }catch (Exception e){}
        try {
            if (cotatapa != 0) {
                editTextCota.setText(Double.toString(cotatapa));
            }
        }catch (Exception e){}
        try {
            if (medexcen != 0) {
                editTextMedexcen.setText(Double.toString(medexcen));
            }
        }catch (Exception e){}
        try {
            if (altura != 0) {
                editTextAltura.setText(Double.toString(altura));
            }
        }catch (Exception e){}
        try {
            if (cantidadsumideros != 0) {
                editTextsumideros.setText(Integer.toString(cantidadsumideros));
            }
        }catch (Exception e){}
        try {
            if (motivo != null) {
                editTextMotivo.setText(motivo);
            }
        }catch (Exception e){}

        if(sepudoabrir!= null){
            int spinner_sepudoabirp = adapter_sepudoabrir.getPosition(sepudoabrir);
            spinner_sepudoabrir.setSelection(spinner_sepudoabirp);
        }
        if (tipocota!=null){
            int spinner_tipocotap = adapter_tipocota.getPosition(tipocota);
            spinner_tipocota.setSelection(spinner_tipocotap);
        }
        if (tipoalcantarillado!=null){
            int spinner_tipoalcantarilladop = adapter_tipoalcantarillado.getPosition(tipoalcantarillado);
            spinner_tipoalcantarillado.setSelection(spinner_tipoalcantarilladop);
        }
        if (tipopozo!=null){
            int spinner_tipopozop = adapter_tipopozo.getPosition(tipopozo);
            spinner_tipopozo.setSelection(spinner_tipopozop);
        }
        if (excen!=null){
            int spinner_excenp = adapter_excen.getPosition(excen);
            spinner_excen.setSelection(spinner_excenp);
        }

        if (sumideros!=null){
            int spinner_sumiderosp = adapter_sumideros.getPosition(sumideros);
            spinner_sumideros.setSelection(spinner_sumiderosp);
        }
        spinner_sepudoabrir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1)
                {
                    textViewMotivo.setVisibility(View.GONE);
                    textViewTipocota.setVisibility(View.VISIBLE);
                    textViewcota.setVisibility(View.VISIBLE);
                    textViewTipoalcantarillado.setVisibility(View.VISIBLE);
                    textViewTipopozo.setVisibility(View.VISIBLE);
                    textViewExcen.setVisibility(View.VISIBLE);
                    textViewGeolo.setVisibility(View.VISIBLE);
                    textViewAltura.setVisibility(View.VISIBLE);
                    textViewLatitud.setVisibility(View.VISIBLE);
                    textViewLongitud.setVisibility(View.VISIBLE);
                    textViewSumideros.setVisibility(View.VISIBLE);

                    editTextMotivo.setVisibility(View.GONE);
                    editTextCota.setVisibility(View.VISIBLE);
                    editTextMedexcen.setVisibility(View.VISIBLE);
                    editTextAltura.setVisibility(View.VISIBLE);
                    editTextsumideros.setVisibility(View.VISIBLE);

                    buttonGeoref.setVisibility(View.VISIBLE);

                    spinner_tipocota.setVisibility(View.VISIBLE);
                    spinner_tipoalcantarillado.setVisibility(View.VISIBLE);
                    spinner_tipopozo.setVisibility(View.VISIBLE);
                    spinner_excen.setVisibility(View.VISIBLE);
                    spinner_sumideros.setVisibility(View.VISIBLE);
                }
                else if (i==2)
                {

                    textViewTipocota.setVisibility(View.GONE);
                    textViewcota.setVisibility(View.GONE);
                    textViewTipoalcantarillado.setVisibility(View.GONE);
                    textViewTipopozo.setVisibility(View.GONE);
                    textViewExcen.setVisibility(View.GONE);
                    textViewGeolo.setVisibility(View.GONE);
                    textViewAltura.setVisibility(View.GONE);
                    textViewLatitud.setVisibility(View.GONE);
                    textViewLongitud.setVisibility(View.GONE);
                    textViewSumideros.setVisibility(View.GONE);
                    textViewMotivo.setVisibility(View.VISIBLE);



                    editTextCota.setVisibility(View.GONE);
                    editTextMedexcen.setVisibility(View.GONE);
                    editTextAltura.setVisibility(View.GONE);
                    editTextsumideros.setVisibility(View.GONE);
                    editTextMotivo.setVisibility(View.VISIBLE);

                    buttonGeoref.setVisibility(View.GONE);

                    spinner_tipocota.setVisibility(View.GONE);
                    spinner_tipoalcantarillado.setVisibility(View.GONE);
                    spinner_tipopozo.setVisibility(View.GONE);
                    spinner_excen.setVisibility(View.GONE);
                    spinner_sumideros.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        spinner_excen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1)
                {
                    editTextMedexcen.setVisibility(View.INVISIBLE);
                } else if (i==2)
                {
                    editTextMedexcen.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_sumideros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1)
                {
                    editTextsumideros.setVisibility(View.VISIBLE);

                }
                else if(i==2)
                {
                    editTextsumideros.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonGeoref.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view)

            {
                final int permissionCheck = ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION);
                if (permissionCheck== PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);
                }
                LocationListener locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };
                locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                provider = locationManager.getBestProvider(criteria,true);
                locationManager.requestLocationUpdates(provider,500,1,locationListener);
                Location location = locationManager.getLastKnownLocation(provider);

                if (location != null){
                    lat = location.getLatitude();
                    lng = location.getLongitude();
                    textViewLatitud.setText(String.valueOf(lat));
                    textViewLongitud.setText(String.valueOf(lng));
                }
            }
        });


        return vistainfogeneral;
    }

    private void consultarDatosDB() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {Integer.toString(id)};
        String[] colums = new String[]{Utilidades.CAMPO_FECHA,Utilidades.CAMPO_DIRECCION,Utilidades.CAMPO_BARRIO, Utilidades.CAMPO_MH, Utilidades.CAMPO_IPID, Utilidades.CAMPO_SEPUDOABRIR, Utilidades.CAMPO_MOTIVO, Utilidades.CAMPO_TIPOCOTA, Utilidades.CAMPO_COTATAPA, Utilidades.CAMPO_TIPOALCANTARILLADO,Utilidades.CAMPO_TIPOPOZO, Utilidades.CAMPO_EXCENTRICIDAD, Utilidades.CAMPO_MEDEXCENTRICIDAD, Utilidades.CAMPO_ALTURA, Utilidades.CAMPO_SUMIDEROS, Utilidades.CAMPO_CANTIDADSUMIDEROS};
        try {
            Cursor cursor = db.query(Utilidades.TABLA_ALCANTARILLADO, colums, Utilidades.CAMPO_ID + " =?", parametros, null, null, null);
            cursor.moveToFirst();

            int fechap = cursor.getColumnIndex(Utilidades.CAMPO_FECHA);
            int diereccionp = cursor.getColumnIndex(Utilidades.CAMPO_DIRECCION);
            int barriop = cursor.getColumnIndex(Utilidades.CAMPO_BARRIO);
            int mhp = cursor.getColumnIndex(Utilidades.CAMPO_MH);
            int ipidp = cursor.getColumnIndex(Utilidades.CAMPO_IPID);
            int sepudoabrirp= cursor.getColumnIndex(Utilidades.CAMPO_SEPUDOABRIR);
            int motivop = cursor.getColumnIndex(Utilidades.CAMPO_MOTIVO);
            int tipocotap = cursor.getColumnIndex(Utilidades.CAMPO_TIPOCOTA);
            int cotatapap = cursor.getColumnIndex(Utilidades.CAMPO_COTATAPA);
            int tipoalcantarilladop= cursor.getColumnIndex(Utilidades.CAMPO_TIPOALCANTARILLADO);
            int tipopozop = cursor.getColumnIndex(Utilidades.CAMPO_TIPOPOZO);
            int excenp = cursor.getColumnIndex(Utilidades.CAMPO_EXCENTRICIDAD);
            int medexcenp = cursor.getColumnIndex(Utilidades.CAMPO_MEDEXCENTRICIDAD);
            int alturap = cursor.getColumnIndex(Utilidades.CAMPO_ALTURA);
            int sumiderosp = cursor.getColumnIndex(Utilidades.CAMPO_SUMIDEROS);
            int cantidadsumiderosp = cursor.getColumnIndex(Utilidades.CAMPO_CANTIDADSUMIDEROS);

            fecha = cursor.getString(fechap);
            direccion = cursor.getString(diereccionp);
            barrio = cursor.getString(barriop);
            mh = cursor.getInt(mhp);
            ipid = cursor.getString(ipidp);
            sepudoabrir = cursor.getString(sepudoabrirp);
            motivo = cursor.getString(motivop);
            tipocota = cursor.getString(tipocotap);
            cotatapa = cursor.getDouble(cotatapap);
            tipoalcantarillado= cursor.getString(tipoalcantarilladop);
            tipopozo = cursor.getString(tipopozop);
            excen = cursor.getString(excenp);
            medexcen = cursor.getDouble(medexcenp);
            altura = cursor.getDouble(alturap);
            sumideros = cursor.getString(sumiderosp);
            cantidadsumideros = cursor.getInt(cantidadsumiderosp);

            cursor.close();


        }catch (Exception e){

        }
        db.close();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("lat", String.valueOf(lat));
        outState.putString("lng", String.valueOf(lng));
    }

    public void tomarDatosInfo(){
        Intent intentInfo = getActivity().getIntent();
        Bundle bundleInfo = new Bundle();
        bundleInfo.putString("Fecha",editTextFecha.getText().toString());
        bundleInfo.putString("Direccion",editTextDireccion.getText().toString());
        bundleInfo.putString("Barrio",editTextBarrio.getText().toString());
        bundleInfo.putString("MH",editTextMH.getText().toString());
        bundleInfo.putString("IPID",editTextIPID.getText().toString());
        bundleInfo.putString("SePudoAbrir",spinner_sepudoabrir.getSelectedItem().toString());
        bundleInfo.putString("Motivo",editTextMotivo.getText().toString());
        bundleInfo.putString("TipoCota",spinner_tipocota.getSelectedItem().toString());
        bundleInfo.putString("CotaTapa",editTextCota.getText().toString());
        bundleInfo.putString("TipoAlcantarillado",spinner_tipoalcantarillado.getSelectedItem().toString());
        bundleInfo.putString("TipoPozo",spinner_tipopozo.getSelectedItem().toString());
        bundleInfo.putString("Excentricidad",spinner_excen.getSelectedItem().toString());
        bundleInfo.putString("MedExcen",editTextMedexcen.getText().toString());
        bundleInfo.putString("Longitud",textViewLongitud.getText().toString());
        bundleInfo.putString("Latitud",textViewLatitud.getText().toString());
        bundleInfo.putString("Altura",editTextAltura.getText().toString());
        bundleInfo.putString("Sumideros",spinner_sumideros.getSelectedItem().toString());
        bundleInfo.putString("CantidadSumideros",editTextsumideros.getText().toString());
        intentInfo.putExtras(bundleInfo);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }}

