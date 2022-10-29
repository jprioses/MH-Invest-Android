package com.example.user.mhinvest.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mhinvest.ConexionSQLiteHelper;
import com.example.user.mhinvest.Main2Activity;
import com.example.user.mhinvest.R;
import com.example.user.mhinvest.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ElementosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ElementosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElementosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ElementosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElementosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElementosFragment newInstance(String param1, String param2) {
        ElementosFragment fragment = new ElementosFragment();
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
    View vistaelementos;
    //Declaracíón spinners
    //variables tiene elementos
    private Spinner spinner_tienetapa;
    private Spinner spinner_tienecuello;
    private Spinner spinner_tienecono;
    private Spinner spinner_tienecilindro;
    private Spinner spinner_tieneescalones;
    private Spinner spinner_tienecañuela;
    private Spinner spinner_tienecamara;
    //variables estado elementos
    private  Spinner spinner_estadotapa;
    private  Spinner spinner_estadocuello;
    private  Spinner spinner_estadocono;
    private  Spinner spinner_estadocilindro;
    private  Spinner spinner_estadoescalones;
    private  Spinner spinner_estadocañuela;
    //variables material elementos
    private Spinner spinner_materialtapa;
    private  Spinner spinner_materialcilindro;
    private  Spinner spinner_materialescalones;



    private TextView textViewTapa;
    private TextView textViewCuello;
    private TextView textViewCono;
    private TextView textViewCilindro;
    private TextView textViewEscalones;
    private TextView textViewCañuela;
    private TextView textViewCamara;


    private EditText editTextDiamcilindro;
    private EditText editTextOidocamara;
    private EditText editTextCantidadescalones;
    private EditText editTextAlturacamara;
    private EditText editTextTramocamara;
    private EditText editTextAnchocañuela;
    private EditText editText_observacionestapa;
    private EditText editText_observacionescuello;
    private EditText editText_observacionescono;
    private EditText editText_observacionescilindro;
    private EditText editText_observacionesescalones;
    private EditText editText_observacionescañuela;
    private EditText editText_observacionescamara;

    private TableRow rowTapa;
    private TableRow rowCuello;
    private TableRow rowCono;
    private TableRow rowCilindro;
    private TableRow rowEscalones;
    private TableRow rowCañuela;
    private TableRow rowCamara;

    private String tapa;
    private String cuello;
    private String cono;
    private String cilindro;
    private String escalones;
    private String cañuela;
    private String camara;
    private String estadotapa;
    private String estadocuello;
    private String estadocono;
    private String estadocilindro;
    private String estadoescalones;
    private String estadocañuela;
    private String tipotapa;
    private String materialcilindro;
    private String tipoescalones;
    private String observacionestapa;
    private String observacionescuello;
    private String observacionescono;
    private String observacionescamara;
    private String observacionesgenerales;
    private double diamcilindro;
    private int cantidadescalones;
    private double diaoidocamara;
    private double alturaoidocamara;
    private double anchocañuela;


    private ConexionSQLiteHelper conn;
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistaelementos= inflater.inflate(R.layout.fragment_elementos, container, false);

        textViewTapa = vistaelementos.findViewById(R.id.textViewTapa);
        textViewCuello = vistaelementos.findViewById(R.id.textViewCuello);
        textViewCono = vistaelementos.findViewById(R.id.textViewCono);
        textViewCilindro = vistaelementos.findViewById(R.id.textViewCilindro);
        textViewEscalones = vistaelementos.findViewById(R.id.textViewEscalones);
        textViewCañuela = vistaelementos.findViewById(R.id.textViewCañuela);
        textViewCamara = vistaelementos.findViewById(R.id.textViewCamara);


        editTextDiamcilindro = vistaelementos.findViewById(R.id.edittext_diam_cilindro);
        editTextOidocamara = vistaelementos.findViewById(R.id.edittext_oido_camara);
        editTextCantidadescalones= vistaelementos.findViewById(R.id.edittext_cantidad_escalones);
        editTextAlturacamara = vistaelementos.findViewById(R.id.edittext_altura_camara);
        editTextTramocamara = vistaelementos.findViewById(R.id.edittext_tramo_camara);
        editTextAnchocañuela= vistaelementos.findViewById(R.id.edittext_ancho_cañuela);
        editText_observacionestapa=vistaelementos.findViewById(R.id.edittext_observaciones_tapa);
        editText_observacionescuello=vistaelementos.findViewById(R.id.edittext_observaciones_cuello);
        editText_observacionescono=vistaelementos.findViewById(R.id.edittext_observaciones_cono);
        editText_observacionescilindro=vistaelementos.findViewById(R.id.edittext_observaciones_cilindro);
        editText_observacionesescalones=vistaelementos.findViewById(R.id.edittext_observaciones_escalones);
        editText_observacionescañuela=vistaelementos.findViewById(R.id.edittext_observaciones_cañuela);
        editText_observacionescamara=vistaelementos.findViewById(R.id.edittext_observaciones_camara);





        rowTapa=vistaelementos.findViewById(R.id.elementos_row_tapa);
        rowCuello = vistaelementos.findViewById(R.id.elementos_row_cuello);
        rowCono = vistaelementos.findViewById(R.id.elementos_row_cono);
        rowCilindro = vistaelementos.findViewById(R.id.elementos_row_cilindro);
        rowEscalones= vistaelementos.findViewById(R.id.elementos_row_escalones);
        rowCañuela = vistaelementos.findViewById(R.id.elementos_row_cañuela);
        rowCamara = vistaelementos.findViewById(R.id.elementos_row_camara);







        //Spinner tiene elemento
        spinner_tienetapa= vistaelementos.findViewById(R.id.spinner_tiene_tapa);
        spinner_tienecuello= vistaelementos.findViewById(R.id.spinner_tiene_cuello);
        spinner_tienecono= vistaelementos.findViewById(R.id.spinner_tiene_cono);
        spinner_tienecilindro= vistaelementos.findViewById(R.id.spinner_tiene_cilindro);
        spinner_tieneescalones= vistaelementos.findViewById(R.id.spinner_tiene_escalones);
        spinner_tienecañuela= vistaelementos.findViewById(R.id.spinner_tiene_cañuela);
        spinner_tienecamara= vistaelementos.findViewById(R.id.spinner_tiene_camara);
        String []opciones_tieneelementos={"","Sí","No"};
        ArrayAdapter<String> adapter_tieneelementos = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_tieneelementos);
        spinner_tienetapa.setAdapter(adapter_tieneelementos);
        spinner_tienecuello.setAdapter(adapter_tieneelementos);
        spinner_tienecono.setAdapter(adapter_tieneelementos);
        spinner_tienecilindro.setAdapter(adapter_tieneelementos);
        spinner_tieneescalones.setAdapter(adapter_tieneelementos);
        spinner_tienecañuela.setAdapter(adapter_tieneelementos);
        spinner_tienecamara.setAdapter(adapter_tieneelementos);

        //Spinner estado elemento
        spinner_estadotapa= vistaelementos.findViewById(R.id.spinner_estado_tapa);
        String []opciones_estadotapa = {"","Buen estado","Con grietas","Partida","Sin concreto","Regular","Mala"};
        final ArrayAdapter<String> adapter_estadotapa = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadotapa);
        spinner_estadotapa.setAdapter(adapter_estadotapa);

        spinner_estadocuello= vistaelementos.findViewById(R.id.spinner_estado_cuello);
        String []opciones_estadocuello={"","Bueno","Grietas","Partido","Hundido","Regular","Malo"};
        final ArrayAdapter<String> adapter_estadocuello = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadocuello);
        spinner_estadocuello.setAdapter(adapter_estadocuello);

        spinner_estadocono= vistaelementos.findViewById(R.id.spinner_estado_cono);
        String []opciones_estadocono={"","Bueno","Grietas","Partido","Regular","Malo"};
        final ArrayAdapter<String> adapter_estadocono= new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadocono);
        spinner_estadocono.setAdapter(adapter_estadocono);

        spinner_estadocilindro= vistaelementos.findViewById(R.id.spinner_estado_cilindro);
        String []opciones_estadocilindro={"","Grietas","Partido","Huecos","Sin pañete","Regular","Malo"};
        final ArrayAdapter<String> adapter_estadocilindro = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadocilindro);
        spinner_estadocilindro.setAdapter(adapter_estadocilindro);

        spinner_estadoescalones= vistaelementos.findViewById(R.id.spinner_estado_escalones);
        String []opciones_estadoescalones={"","Buenos","Doblados","Regulares","Faltan","Malos","Corroidos"};
        final ArrayAdapter<String> adapter_estadoescalones = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadoescalones);
        spinner_estadoescalones.setAdapter(adapter_estadoescalones);

        spinner_estadocañuela= vistaelementos.findViewById(R.id.spinner_estado_cañuela);
        String []opciones_estadocañuela={"","Buena","Desgastada","Regular","Sedimentada","Socavada","Mala"};
        final ArrayAdapter<String> adapter_estadocañuela = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estadocañuela);
        spinner_estadocañuela.setAdapter(adapter_estadocañuela);


        //Spinner material elemento
        spinner_materialtapa= vistaelementos.findViewById(R.id.spinner_material_tapa);
        String []opciones_materialtapa={"","Concreto","Polipropileno","Hierro con bisagras","Hierro sin bisagras","Tapa seguridad","Tapa en fibra","Tapa en acero"};
        ArrayAdapter<String> adapter_materialtapa = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_materialtapa);
        spinner_materialtapa.setAdapter(adapter_materialtapa);

        spinner_materialcilindro= vistaelementos.findViewById(R.id.spinner_material_cilindro);
        String []opciones_materialcilindro={"","Mamposteria","Concreto","Otro"};
        ArrayAdapter<String> adapter_materialcilindro = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_materialcilindro);
        spinner_materialcilindro.setAdapter(adapter_materialcilindro);

        spinner_materialescalones= vistaelementos.findViewById(R.id.spinner_material_escalones);
        String []opciones_materialescalones={"","Ladrillo","Plastico","Hierro"};
        ArrayAdapter<String> adapter_materialescalones = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_materialescalones);
        spinner_materialescalones.setAdapter(adapter_materialescalones);

        spinner_tienetapa.setFocusableInTouchMode(true);
        spinner_tienecuello.setFocusableInTouchMode(true);
        spinner_tienecono.setFocusableInTouchMode(true);
        spinner_tienecilindro.setFocusableInTouchMode(true);
        spinner_tieneescalones.setFocusableInTouchMode(true);
        spinner_tienecañuela.setFocusableInTouchMode(true);
        spinner_tienecamara.setFocusableInTouchMode(true);
        spinner_estadotapa.setFocusableInTouchMode(true);
        spinner_estadocuello.setFocusableInTouchMode(true);
        spinner_estadocono.setFocusableInTouchMode(true);
        spinner_estadocilindro.setFocusableInTouchMode(true);
        spinner_estadoescalones.setFocusableInTouchMode(true);
        spinner_estadocañuela.setFocusableInTouchMode(true);
        spinner_materialtapa.setFocusableInTouchMode(true);
        spinner_materialcilindro.setFocusableInTouchMode(true);
        spinner_materialcilindro.setFocusableInTouchMode(true);

        Main2Activity activity = (Main2Activity)getActivity();
        id = activity.tomarid();

        if ((savedInstanceState==null)&&(id!=0)){
            conn = new ConexionSQLiteHelper(getContext());
            consultarDatosDB();

        }
        try {
            if (observacionestapa != null) {
                editText_observacionestapa.setText(observacionestapa);
            }
        }catch (Exception e){}
        try {
            if (observacionescuello != null) {
                editText_observacionescuello.setText(observacionescuello);
            }
        }catch (Exception e){}
        try {
            if (observacionescono != null) {
                editText_observacionescono.setText(observacionescono);
            }
        }catch (Exception e){}
        try {
            if (observacionescamara != null) {
                editText_observacionescamara.setText(observacionescamara);
            }
        }catch (Exception e){}
        try {
            if (diamcilindro != 0) {
                editTextDiamcilindro.setText(Double.toString(diamcilindro));
            }
        }catch (Exception e){}
        try {
            if (cantidadescalones != 0) {
                editTextCantidadescalones.setText(Integer.toString(cantidadescalones));
            }
        }catch (Exception e){}
        try {
            if (diaoidocamara != 0) {
                editTextOidocamara.setText(Double.toString(diaoidocamara));
            }
        }catch (Exception e){}
        try {
            if (alturaoidocamara != 0) {
                editTextAlturacamara.setText(Double.toString(alturaoidocamara));
            }
        }catch (Exception e){}
        try {
            if (anchocañuela != 0) {
                editTextAnchocañuela.setText(Double.toString(anchocañuela));
            }

        }catch (Exception e){}

        if(tapa!=null){
           int spinner_tienetapap = adapter_tieneelementos.getPosition(tapa);
           spinner_tienetapa.setSelection(spinner_tienetapap);
        }
        if(cuello!=null){
            int spinner_tienecuellop = adapter_tieneelementos.getPosition(cuello);
            spinner_tienecuello.setSelection(spinner_tienecuellop);
        }
        if(cono!=null){
            int spinner_tieneconop = adapter_tieneelementos.getPosition(cono);
            spinner_tienecono.setSelection(spinner_tieneconop);
        }
        if(cilindro!=null){
            int spinner_tienecilindrop = adapter_tieneelementos.getPosition(cilindro);
            spinner_tienecilindro.setSelection(spinner_tienecilindrop);
        }
        if(escalones!=null){
            int spinner_tieneescalonesp = adapter_tieneelementos.getPosition(escalones);
            spinner_tieneescalones.setSelection(spinner_tieneescalonesp);
        }
        if(cañuela!=null){
            int spinner_tienecañuelap = adapter_tieneelementos.getPosition(cañuela);
            spinner_tienecañuela.setSelection(spinner_tienecañuelap);
        }
        if(camara!=null){
            int spinner_tienecamarap = adapter_tieneelementos.getPosition(camara);
            spinner_tienecamara.setSelection(spinner_tienecamarap);
        }
        if(estadotapa!=null){
            int spinner_estadotapap = adapter_estadotapa.getPosition(estadotapa);
            spinner_estadotapa.setSelection(spinner_estadotapap);
        }
        if(estadocuello!=null){
            int spinner_estadocuellop = adapter_estadocuello.getPosition(estadocuello);
            spinner_estadocuello.setSelection(spinner_estadocuellop);
        }
        if(estadocono!=null){
            int spinner_estadoconop = adapter_estadocono.getPosition(estadocono);
            spinner_estadocono.setSelection(spinner_estadoconop);
        }
        if(estadocilindro!=null){
            int spinner_estadocilindrop = adapter_estadocilindro.getPosition(estadocilindro);
            spinner_estadocilindro.setSelection(spinner_estadocilindrop);
        }
        if(estadoescalones!=null){
            int spinner_estadoescalonesp = adapter_estadoescalones.getPosition(estadoescalones);
            spinner_estadoescalones.setSelection(spinner_estadoescalonesp);
        }
        if(estadocañuela!=null){
            int spinner_estadocañuelap = adapter_estadocañuela.getPosition(estadocañuela);
            spinner_estadocañuela.setSelection(spinner_estadocañuelap);
        }
        if(tipotapa!=null){
            int spinner_tipotapap = adapter_materialtapa.getPosition(tipotapa);
            spinner_materialtapa.setSelection(spinner_tipotapap);
        }
        if(materialcilindro!=null){
            int spinner_materialcilindrop = adapter_materialcilindro.getPosition(materialcilindro);
            spinner_materialcilindro.setSelection(spinner_materialcilindrop);
        }
        if(tipoescalones!=null){
            int spinner_tipoescalonesp = adapter_materialescalones.getPosition(tipoescalones);
            spinner_materialescalones.setSelection(spinner_tipoescalonesp);
        }

        spinner_tienetapa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==2)
                {
                    textViewTapa.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                    spinner_estadotapa.setEnabled(false);
                    spinner_materialtapa.setEnabled(false);
                    editText_observacionestapa.setEnabled(false);
                    editText_observacionestapa.setText("");
                    spinner_estadotapa.setSelection(0);
                    spinner_materialtapa.setSelection(0);
                    rowTapa.setBackgroundResource(R.color.color_celdas_vacias);
                }
                if (i==1)
                {
                    textViewTapa.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                    spinner_estadotapa.setEnabled(true);
                    spinner_materialtapa.setEnabled(true);
                    editText_observacionestapa.setEnabled(true);
                    rowTapa.setBackground(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_tienecuello.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (i==2)
                {
                    textViewCuello.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                    spinner_estadocuello.setEnabled(false);
                    editText_observacionescuello.setEnabled(false);
                    editText_observacionescuello.setText("");
                    spinner_estadocuello.setSelection(0);
                    rowCuello.setBackgroundResource(R.color.color_celdas_vacias);
                }
                if (i==1)
                {
                    textViewCuello.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                    spinner_estadocuello.setEnabled(true);
                    editText_observacionescuello.setEnabled(true);
                    rowCuello.setBackground(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_tienecono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                if (i==2)
                {
                    textViewCono.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                    spinner_estadocono.setEnabled(false);
                    editText_observacionescono.setEnabled(false);
                    editText_observacionescono.setText("");
                    spinner_estadocono.setSelection(0);
                    rowCono.setBackgroundResource(R.color.color_celdas_vacias);
                }
                if (i==1)
                {
                    textViewCono.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                    spinner_estadocono.setEnabled(true);
                    editText_observacionescono.setEnabled(true);
                    rowCono.setBackground(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            spinner_tienecilindro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    if (i==2)
                    {
                        textViewCilindro.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                        spinner_estadocilindro.setEnabled(false);
                        spinner_materialcilindro.setEnabled(false);
                        editTextDiamcilindro.setEnabled(false);
                        editTextDiamcilindro.setText("");
                        editText_observacionescilindro.setEnabled(false);
                        editText_observacionescilindro.setText("");
                        spinner_materialcilindro.setSelection(0);
                        spinner_estadocilindro.setSelection(0);
                        rowCilindro.setBackgroundResource(R.color.color_celdas_vacias);
                    }
                    if (i==1)
                    {
                        textViewCilindro.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                        spinner_estadocilindro.setEnabled(true);
                        spinner_materialcilindro.setEnabled(true);
                        editTextDiamcilindro.setEnabled(true);
                        editText_observacionescono.setEnabled(true);
                        rowCilindro.setBackground(null);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spinner_estadoescalones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    if (i==2)
                    {
                        textViewEscalones.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                        spinner_estadoescalones.setEnabled(false);
                        spinner_materialescalones.setEnabled(false);
                        editTextCantidadescalones.setEnabled(false);
                        editTextCantidadescalones.setText("");
                        editText_observacionesescalones.setEnabled(false);
                        editText_observacionesescalones.setText("");
                        spinner_materialescalones.setSelection(0);
                        spinner_estadoescalones.setSelection(0);
                        rowEscalones.setBackgroundResource(R.color.color_celdas_vacias);
                    }
                    if (i==1)
                    {
                        textViewEscalones.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                        spinner_estadoescalones.setEnabled(true);
                        spinner_materialescalones.setEnabled(true);
                        editTextCantidadescalones.setEnabled(true);
                        editText_observacionesescalones.setEnabled(true);
                        rowEscalones.setBackground(null);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spinner_tienecañuela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    if (i==2)
                    {
                        textViewCañuela.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                        spinner_estadocañuela.setEnabled(false);
                        editTextAnchocañuela.setEnabled(false);
                        editTextAnchocañuela.setText("");
                        editText_observacionescañuela.setEnabled(false);
                        editText_observacionescañuela.setText("");
                        spinner_estadocañuela.setSelection(0);
                        rowCañuela.setBackgroundResource(R.color.color_celdas_vacias);
                    }
                    if (i==1)
                    {
                        textViewCañuela.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                        spinner_estadocañuela.setEnabled(true);
                        editTextAnchocañuela.setEnabled(true);
                        editText_observacionescañuela.setEnabled(true);
                        rowCañuela.setBackground(null);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spinner_tienecamara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    if (i==2)
                    {
                        textViewCamara.setTextColor((getResources().getColor(R.color.color_texto_desactivado)));
                        editTextOidocamara.setEnabled(false);
                        editTextOidocamara.setText("");
                        editTextAlturacamara.setEnabled(false);
                        editTextAlturacamara.setText("");
                        editTextTramocamara.setEnabled(false);
                        editTextTramocamara.setText("");
                        editText_observacionescamara.setEnabled(false);
                        editText_observacionescamara.setText("");
                        rowCamara.setBackgroundResource(R.color.color_celdas_vacias);
                    }
                    if (i==1)
                    {
                        textViewCamara.setTextColor((getResources().getColor(R.color.color_texto_activo)));
                        editTextOidocamara.setEnabled(true);
                        editTextAlturacamara.setEnabled(true);
                        editTextTramocamara.setEnabled(true);
                        editText_observacionescamara.setEnabled(true);
                        rowCamara.setBackground(null);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            editTextAlturacamara.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i== EditorInfo.IME_ACTION_DONE) {
                        String text = editTextAlturacamara.getText().toString();

                        for (int j = 0; j < text.length(); j++) {
                            if (text.charAt(j) == '+') {
                                try {
                                String[] s = text.split("[+]");
                                double s1 = Double.parseDouble(s[0]);
                                double s2 = Double.parseDouble(s[1]);

                                double resultado = s1 + s2;

                                editTextAlturacamara.setText(String.valueOf(resultado));
                                }catch (Exception e){
                                    Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                                }
                                break;

                            }
                        }
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editTextAlturacamara.getWindowToken(), 0);
                        return true;
                    }
                    return false;
                }
            });

        return vistaelementos;
    }

    private void consultarDatosDB() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {Integer.toString(id)};
        String[] colums = new String[]{Utilidades.CAMPO_TAPA,Utilidades.CAMPO_ESTADOTAPA,Utilidades.CAMPO_TIPOTAPA, Utilidades.CAMPO_OBSERVACIONESTAPA, Utilidades.CAMPO_CUELLO, Utilidades.CAMPO_ESTADOCUELLO, Utilidades.CAMPO_OBSERVACIONESCUELLO, Utilidades.CAMPO_CONO, Utilidades.CAMPO_ESTADOCONO, Utilidades.CAMPO_OBSERVACIONESCONO,Utilidades.CAMPO_CILINDRO, Utilidades.CAMPO_ESTADOCILINDRO, Utilidades.CAMPO_MATERIALCILINDRO, Utilidades.CAMPO_DIAMETROCILINDRO, Utilidades.CAMPO_ESCALONES, Utilidades.CAMPO_ESTADOESCALONES,  Utilidades.CAMPO_TIPOESCALONES, Utilidades.CAMPO_CANTIDADESCALONES, Utilidades.CAMPO_CAÑUELA,  Utilidades.CAMPO_ESTADOCAÑUELA,  Utilidades.CAMPO_ANCHOCAÑUELA,  Utilidades.CAMPO_CAMARA,  Utilidades.CAMPO_DIAMETROOIDOCAMARA,  Utilidades.CAMPO_ALTURAOIDOCAMARA,  Utilidades.CAMPO_OBSERVACIONESGENERALES,  Utilidades.CAMPO_OBSERVACIONADICIONAL};

        try {
            Cursor cursorElementos = db.query(Utilidades.TABLA_ALCANTARILLADO, colums, Utilidades.CAMPO_ID + " =?", parametros, null, null, null);
            cursorElementos.moveToFirst();

            int tapap= cursorElementos.getColumnIndex( Utilidades.CAMPO_TAPA);
            int estadotapap= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOTAPA);
            int tipotapap= cursorElementos.getColumnIndex( Utilidades.CAMPO_TIPOTAPA);
            int observacionestapap= cursorElementos.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESTAPA);
            int cuellop= cursorElementos.getColumnIndex( Utilidades.CAMPO_CUELLO);
            int estadocuellop= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOCUELLO);
            int observacionescuellop= cursorElementos.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESCUELLO);
            int conop= cursorElementos.getColumnIndex( Utilidades.CAMPO_CONO);
            int estadoconop= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOCONO);
            int observacionesconop= cursorElementos.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESCONO);
            int cilindrop= cursorElementos.getColumnIndex( Utilidades.CAMPO_CILINDRO);
            int estadocilindrop= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOCILINDRO);
            int materialcilindrop= cursorElementos.getColumnIndex( Utilidades.CAMPO_MATERIALCILINDRO);
            int diamcilindrop= cursorElementos.getColumnIndex( Utilidades.CAMPO_DIAMETROCILINDRO);
            int escalonesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESCALONES);
            int estadoescalonesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOESCALONES);
            int tipoescalonesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_TIPOESCALONES);
            int cantidadescalonesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_CANTIDADESCALONES);
            int cañuelap= cursorElementos.getColumnIndex( Utilidades.CAMPO_CAÑUELA);
            int estadocañuelap= cursorElementos.getColumnIndex( Utilidades.CAMPO_ESTADOCAÑUELA);
            int anchocañuelap= cursorElementos.getColumnIndex( Utilidades.CAMPO_ANCHOCAÑUELA);
            int camarap= cursorElementos.getColumnIndex( Utilidades.CAMPO_CAMARA);
            int dimoidocamarap= cursorElementos.getColumnIndex( Utilidades.CAMPO_DIAMETROOIDOCAMARA);
            int alturaoidocamarap= cursorElementos.getColumnIndex( Utilidades.CAMPO_ALTURAOIDOCAMARA);
            int observacionesgeneralesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESGENERALES);
            int observacionesadionalesp= cursorElementos.getColumnIndex( Utilidades.CAMPO_OBSERVACIONADICIONAL);

            tapa = cursorElementos.getString(tapap);
            cuello = cursorElementos.getString(cuellop);
            cono = cursorElementos.getString(conop);
            cilindro = cursorElementos.getString(cilindrop);
            escalones= cursorElementos.getString(escalonesp);
            cañuela = cursorElementos.getString(cañuelap);
            camara = cursorElementos.getString(camarap);
            estadotapa = cursorElementos.getString(estadotapap);
            estadocuello = cursorElementos.getString(estadocuellop);
            estadocono = cursorElementos.getString(estadoconop);
            estadocilindro = cursorElementos.getString(estadocilindrop);
            estadoescalones = cursorElementos.getString(estadoescalonesp);
            estadocañuela = cursorElementos.getString(estadocañuelap);
            tipotapa = cursorElementos.getString(tipotapap);
            materialcilindro = cursorElementos.getString(materialcilindrop);
            tipoescalones = cursorElementos.getString(tipoescalonesp);
            observacionestapa  = cursorElementos.getString(observacionestapap);
            observacionescuello  = cursorElementos.getString(observacionescuellop);
            observacionescono  = cursorElementos.getString(observacionesconop);;
            observacionesgenerales  = cursorElementos.getString(observacionesgeneralesp);
            observacionescamara  = cursorElementos.getString(observacionesadionalesp);
            diamcilindro = cursorElementos.getDouble(diamcilindrop);
            cantidadescalones = cursorElementos.getInt(cantidadescalonesp);
            anchocañuela = cursorElementos.getDouble(anchocañuelap);
            diaoidocamara = cursorElementos.getDouble(dimoidocamarap);
            alturaoidocamara = cursorElementos.getDouble(alturaoidocamarap);

            cursorElementos.close();


        }catch (Exception e){

        }
        db.close();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void tomarDatosElementos(){
        Intent intentElementos = getActivity().getIntent();
        Bundle bundleElementos = new Bundle();
        bundleElementos.putString("TieneTapa",spinner_tienetapa.getSelectedItem().toString());
        bundleElementos.putString("TieneCuello",spinner_tienecuello.getSelectedItem().toString());
        bundleElementos.putString("TieneCono",spinner_tienecono.getSelectedItem().toString());
        bundleElementos.putString("TieneCilindro",spinner_tienecilindro.getSelectedItem().toString());
        bundleElementos.putString("TieneEscalones",spinner_tieneescalones.getSelectedItem().toString());
        bundleElementos.putString("TieneCañuela",spinner_tienecañuela.getSelectedItem().toString());
        bundleElementos.putString("TieneCamara",spinner_tienecamara.getSelectedItem().toString());
        bundleElementos.putString("EstadoTapa",spinner_estadotapa.getSelectedItem().toString());
        bundleElementos.putString("EstadoCuello",spinner_estadocuello.getSelectedItem().toString());
        bundleElementos.putString("EstadoCono",spinner_estadocono.getSelectedItem().toString());
        bundleElementos.putString("EstadoCilindro",spinner_estadocilindro.getSelectedItem().toString());
        bundleElementos.putString("EstadoEscalones",spinner_estadoescalones.getSelectedItem().toString());
        bundleElementos.putString("EstadoCañuela",spinner_estadocañuela.getSelectedItem().toString());
        bundleElementos.putString("MaterialTapa",spinner_materialtapa.getSelectedItem().toString());
        bundleElementos.putString("MaterialCilindro",spinner_materialcilindro.getSelectedItem().toString());
        bundleElementos.putString("MaterialEscalones",spinner_materialescalones.getSelectedItem().toString());
        bundleElementos.putString("DiamCilindro",editTextDiamcilindro.getText().toString());
        bundleElementos.putString("DiamOido",editTextOidocamara.getText().toString());
        bundleElementos.putString("CantidadEscalones",editTextCantidadescalones.getText().toString());
        bundleElementos.putString("AlturaCamara",editTextAlturacamara.getText().toString());
        bundleElementos.putString("TramoCamara",editTextTramocamara.getText().toString());
        bundleElementos.putString("AnchoCañuela",editTextAnchocañuela.getText().toString());
        bundleElementos.putString("ObservacionesTapa",editText_observacionestapa.getText().toString());
        bundleElementos.putString("ObservacionesCuello",editText_observacionescuello.getText().toString());
        bundleElementos.putString("ObservacionesCono",editText_observacionescono.getText().toString());
        bundleElementos.putString("ObservacionesCilindro",editText_observacionescilindro.getText().toString());
        bundleElementos.putString("ObservacionesEscalones",editText_observacionesescalones.getText().toString());
        bundleElementos.putString("ObservacionesCañuela",editText_observacionescañuela.getText().toString());
        bundleElementos.putString("ObservacionesCamara",editText_observacionescamara.getText().toString());
        intentElementos.putExtras(bundleElementos);

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
    }
}
