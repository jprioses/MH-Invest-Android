package com.example.user.mhinvest.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
 * {@link TramosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TramosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TramosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TramosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TramosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TramosFragment newInstance(String param1, String param2) {
        TramosFragment fragment = new TramosFragment();
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
    View vistatramos;

    //variables Entra/sale
   private Spinner spinner_entra_sale1;
    private Spinner spinner_entra_sale2;
    private  Spinner spinner_entra_sale3;
    private  Spinner spinner_entra_sale4;
    private  Spinner spinner_entra_sale5;
    private  Spinner spinner_entra_sale6;
    //variables material tramos
    private  Spinner spinner_material1;
    private   Spinner spinner_material2;
    private  Spinner spinner_material3;
    private  Spinner spinner_material4;
    private  Spinner spinner_material5;
    private  Spinner spinner_material6;
    //variables estado tramos
    private  Spinner spinner_estado1;
    private  Spinner spinner_estado2;
    private  Spinner spinner_estado3;
    private   Spinner spinner_estado4;
    private   Spinner spinner_estado5;
    private  Spinner spinner_estado6;
    //variables deformacion tramos
    private  Spinner spinner_deformacion1;
    private  Spinner spinner_deformacion2;
    private   Spinner spinner_deformacion3;
    private  Spinner spinner_deformacion4;
    private  Spinner spinner_deformacion5;
    private  Spinner spinner_deformacion6;
    //variables tipo deformacion tramos
    private  Spinner spinner_tipodeform1;
    private  Spinner spinner_tipodeform2;
    private  Spinner spinner_tipodeform3;
    private   Spinner spinner_tipodeform4;
    private   Spinner spinner_tipodeform5;
    private   Spinner spinner_tipodeform6;
    //variables tipo agua tramos
    private  Spinner spinner_tipodeagua1;
    private   Spinner spinner_tipodeagua2;
    private   Spinner spinner_tipodeagua3;
    private   Spinner spinner_tipodeagua4;
    private  Spinner spinner_tipodeagua5;
    private   Spinner spinner_tipodeagua6;


    private TextView textViewT1;
    private TextView textViewT2;
    private TextView textViewT3;
    private TextView textViewT4;
    private TextView textViewT5;
    private TextView textViewT6;

    private EditText editTextHeje1;
    private EditText editTextHeje2;
    private EditText editTextHeje3;
    private EditText editTextHeje4;
    private EditText editTextHeje5;
    private EditText editTextHeje6;
    private EditText editTextConecta1;
    private EditText editTextConecta2;
    private EditText editTextConecta3;
    private EditText editTextConecta4;
    private EditText editTextConecta5;
    private EditText editTextConecta6;
    private EditText editTextDiam1;
    private EditText editTextDiam2;
    private EditText editTextDiam3;
    private EditText editTextDiam4;
    private EditText editTextDiam5;
    private EditText editTextDiam6;
    private EditText editTextHcaja1;
    private EditText editTextHcaja2;
    private EditText editTextHcaja3;
    private EditText editTextHcaja4;
    private EditText editTextHcaja5;
    private EditText editTextHcaja6;
    private EditText editTextHbatea1;
    private EditText editTextHbatea2;
    private EditText editTextHbatea3;
    private EditText editTextHbatea4;
    private EditText editTextHbatea5;
    private EditText editTextHbatea6;
    private EditText editTextTramos;

    private TableRow rowT1;
    private TableRow rowT2;
    private TableRow rowT3;
    private TableRow rowT4;
    private TableRow rowT5;
    private TableRow rowT6;


    private boolean visibilityTvT2 = true;
    private boolean visibilityTvT3 = true;
    private boolean visibilityTvT4 = true;
    private boolean visibilityTvT5 = true;
    private boolean visibilityTvT6 = true;
    private boolean visibilityRowT2 = true;
    private boolean visibilityRowT3 = true;
    private boolean visibilityRowT4 = true;
    private boolean visibilityRowT5 = true;
    private boolean visibilityRowT6 = true;


    private String entra1;
    private String entra2;
    private String entra3;
    private String entra4;
    private String entra5;
    private String entra6;

    private double heje1;
    private double heje2;
    private double heje3;
    private double heje4;
    private double heje5;
    private double heje6;

    private String conecta1;
    private String conecta2;
    private String conecta3;
    private String conecta4;
    private String conecta5;
    private String conecta6;

    private double diam1;
    private double diam2;
    private double diam3;
    private double diam4;
    private double diam5;
    private double diam6;

    private double hcaja1;
    private double hcaja2;
    private double hcaja3;
    private double hcaja4;
    private double hcaja5;
    private double hcaja6;

    private double hbatea1;
    private double hbatea2;
    private double hbatea3;
    private double hbatea4;
    private double hbatea5;
    private double hbatea6;

    private String material1;
    private String material2;
    private String material3;
    private String material4;
    private String material5;
    private String material6;

    private String estado1;
    private String estado2;
    private String estado3;
    private String estado4;
    private String estado5;
    private String estado6;

    private String deformacion1;
    private String deformacion2;
    private String deformacion3;
    private String deformacion4;
    private String deformacion5;
    private String deformacion6;

    private String tipodeformacion1;
    private String tipodeformacion2;
    private String tipodeformacion3;
    private String tipodeformacion4;
    private String tipodeformacion5;
    private String tipodeformacion6;

    private String tipoagua1;
    private String tipoagua2;
    private String tipoagua3;
    private String tipoagua4;
    private String tipoagua5;
    private String tipoagua6;



    private ConexionSQLiteHelper conn;
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistatramos = inflater.inflate(R.layout.fragment_tramos, container, false);

        textViewT1 = vistatramos.findViewById(R.id.textViewT1);
        textViewT2 = vistatramos.findViewById(R.id.textViewT2);
        textViewT3 = vistatramos.findViewById(R.id.textViewT3);
        textViewT4 = vistatramos.findViewById(R.id.textViewT4);
        textViewT5 = vistatramos.findViewById(R.id.textViewT5);
        textViewT6 = vistatramos.findViewById(R.id.textViewT6);

        editTextHeje1 = vistatramos.findViewById(R.id.edittext_heje1);
        editTextHeje2 = vistatramos.findViewById(R.id.edittext_heje2);
        editTextHeje3 = vistatramos.findViewById(R.id.edittext_heje3);
        editTextHeje4 = vistatramos.findViewById(R.id.edittext_heje4);
        editTextHeje5 = vistatramos.findViewById(R.id.edittext_heje5);
        editTextHeje6 = vistatramos.findViewById(R.id.edittext_heje6);
        editTextConecta1 = vistatramos.findViewById(R.id.edittext_conecta1);
        editTextConecta2 = vistatramos.findViewById(R.id.edittext_conecta2);
        editTextConecta3 = vistatramos.findViewById(R.id.edittext_conecta3);
        editTextConecta4 = vistatramos.findViewById(R.id.edittext_conecta4);
        editTextConecta5 = vistatramos.findViewById(R.id.edittext_conecta5);
        editTextConecta6 = vistatramos.findViewById(R.id.edittext_conecta6);
        editTextDiam1 = vistatramos.findViewById(R.id.edittext_diam1);
        editTextDiam2 = vistatramos.findViewById(R.id.edittext_diam2);
        editTextDiam3 = vistatramos.findViewById(R.id.edittext_diam3);
        editTextDiam4 = vistatramos.findViewById(R.id.edittext_diam4);
        editTextDiam5 = vistatramos.findViewById(R.id.edittext_diam5);
        editTextDiam6 = vistatramos.findViewById(R.id.edittext_diam6);
        editTextHcaja1 = vistatramos.findViewById(R.id.edittext_hcaja1);
        editTextHcaja2 = vistatramos.findViewById(R.id.edittext_hcaja2);
        editTextHcaja3 = vistatramos.findViewById(R.id.edittext_hcaja3);
        editTextHcaja4 = vistatramos.findViewById(R.id.edittext_hcaja4);
        editTextHcaja5 = vistatramos.findViewById(R.id.edittext_hcaja5);
        editTextHcaja6 = vistatramos.findViewById(R.id.edittext_hcaja6);
        editTextHbatea1 = vistatramos.findViewById(R.id.edittext_hvbatea1);
        editTextHbatea2 = vistatramos.findViewById(R.id.edittext_hvbatea2);
        editTextHbatea3 = vistatramos.findViewById(R.id.edittext_hvbatea3);
        editTextHbatea4 = vistatramos.findViewById(R.id.edittext_hvbatea4);
        editTextHbatea5 = vistatramos.findViewById(R.id.edittext_hvbatea5);
        editTextHbatea6 = vistatramos.findViewById(R.id.edittext_hvbatea6);
        editTextTramos = vistatramos.findViewById(R.id.editTextTramos);

        rowT1=vistatramos.findViewById(R.id.row_T1);
        rowT2=vistatramos.findViewById(R.id.row_T2);
        rowT3=vistatramos.findViewById(R.id.row_T3);
        rowT4=vistatramos.findViewById(R.id.row_T4);
        rowT5=vistatramos.findViewById(R.id.row_T5);
        rowT6=vistatramos.findViewById(R.id.row_T6);

        if (savedInstanceState!= null) {

            visibilityTvT2 = savedInstanceState.getBoolean("visibilityTvT2");
            visibilityTvT3 = savedInstanceState.getBoolean("visibilityTvT3");
            visibilityTvT4 = savedInstanceState.getBoolean("visibilityTvT4");
            visibilityTvT5 = savedInstanceState.getBoolean("visibilityTvT5");
            visibilityTvT6 = savedInstanceState.getBoolean("visibilityTvT6");

            visibilityRowT2 = savedInstanceState.getBoolean("visibilityRowT2");
            visibilityRowT3 = savedInstanceState.getBoolean("visibilityRowT3");
            visibilityRowT4 = savedInstanceState.getBoolean("visibilityRowT4");
            visibilityRowT5 = savedInstanceState.getBoolean("visibilityRowT5");
            visibilityRowT6 = savedInstanceState.getBoolean("visibilityRowT6");

        }

        textViewT2.setVisibility(visibilityTvT2 ? View.VISIBLE : View.INVISIBLE);
        textViewT3.setVisibility(visibilityTvT3 ? View.VISIBLE : View.INVISIBLE);
        textViewT4.setVisibility(visibilityTvT4 ? View.VISIBLE : View.INVISIBLE);
        textViewT5.setVisibility(visibilityTvT5 ? View.VISIBLE : View.INVISIBLE);
        textViewT6.setVisibility(visibilityTvT6 ? View.VISIBLE : View.INVISIBLE);

        rowT2.setVisibility(visibilityRowT2 ? View.VISIBLE : View.INVISIBLE);
        rowT3.setVisibility(visibilityRowT3 ? View.VISIBLE : View.INVISIBLE);
        rowT4.setVisibility(visibilityRowT4 ? View.VISIBLE : View.INVISIBLE);
        rowT5.setVisibility(visibilityRowT5 ? View.VISIBLE : View.INVISIBLE);
        rowT6.setVisibility(visibilityRowT6 ? View.VISIBLE : View.INVISIBLE);

        //Spinner entrasale
        spinner_entra_sale1 = vistatramos.findViewById(R.id.spinner_entra1);
        spinner_entra_sale2 = vistatramos.findViewById(R.id.spinner_entra2);
        spinner_entra_sale3 = vistatramos.findViewById(R.id.spinner_entra3);
        spinner_entra_sale4 = vistatramos.findViewById(R.id.spinner_entra4);
        spinner_entra_sale5 = vistatramos.findViewById(R.id.spinner_entra5);
        spinner_entra_sale6 = vistatramos.findViewById(R.id.spinner_entra6);
        String []opciones_entrasale={"","Entra","Sale"};
        ArrayAdapter<String> adapter_entrasale = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_entrasale);
        spinner_entra_sale1.setAdapter(adapter_entrasale);
        spinner_entra_sale2.setAdapter(adapter_entrasale);
        spinner_entra_sale3.setAdapter(adapter_entrasale);
        spinner_entra_sale4.setAdapter(adapter_entrasale);
        spinner_entra_sale5.setAdapter(adapter_entrasale);
        spinner_entra_sale6.setAdapter(adapter_entrasale);

        //Spinner materialtramos
        spinner_material1 = vistatramos.findViewById(R.id.spinner_material1);
        spinner_material2 = vistatramos.findViewById(R.id.spinner_material2);
        spinner_material3 = vistatramos.findViewById(R.id.spinner_material3);
        spinner_material4 = vistatramos.findViewById(R.id.spinner_material4);
        spinner_material5 = vistatramos.findViewById(R.id.spinner_material5);
        spinner_material6 = vistatramos.findViewById(R.id.spinner_material6);
        String []opciones_material={"","Mamposteria","Gres","PVC","Concreto","Polietileno","Otro"};
        ArrayAdapter<String> adapter_material = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_material);
        spinner_material1.setAdapter(adapter_material);
        spinner_material2.setAdapter(adapter_material);
        spinner_material3.setAdapter(adapter_material);
        spinner_material4.setAdapter(adapter_material);
        spinner_material5.setAdapter(adapter_material);
        spinner_material6.setAdapter(adapter_material);

        //Spinner estado tramos
        spinner_estado1 = vistatramos.findViewById(R.id.spinner_estado1);
        spinner_estado2 = vistatramos.findViewById(R.id.spinner_estado2);
        spinner_estado3 = vistatramos.findViewById(R.id.spinner_estado3);
        spinner_estado4 = vistatramos.findViewById(R.id.spinner_estado4);
        spinner_estado5 = vistatramos.findViewById(R.id.spinner_estado5);
        spinner_estado6 = vistatramos.findViewById(R.id.spinner_estado6);
        String []opciones_estado={"","Bueno","Regular","Malo"};
        ArrayAdapter<String> adapter_estado = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_estado);
        spinner_estado1.setAdapter(adapter_estado);
        spinner_estado2.setAdapter(adapter_estado);
        spinner_estado3.setAdapter(adapter_estado);
        spinner_estado4.setAdapter(adapter_estado);
        spinner_estado5.setAdapter(adapter_estado);
        spinner_estado6.setAdapter(adapter_estado);

        //Spinner deformacion tramos
        spinner_deformacion1 = vistatramos.findViewById(R.id.spinner_deformacion1);
        spinner_deformacion2 = vistatramos.findViewById(R.id.spinner_deformacion2);
        spinner_deformacion3 = vistatramos.findViewById(R.id.spinner_deformacion3);
        spinner_deformacion4 = vistatramos.findViewById(R.id.spinner_deformacion4);
        spinner_deformacion5 = vistatramos.findViewById(R.id.spinner_deformacion5);
        spinner_deformacion6 = vistatramos.findViewById(R.id.spinner_deformacion6);
        String []opciones_deformacion={"","Sí","No"};
        ArrayAdapter<String> adapter_deformacion = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_deformacion);
        spinner_deformacion1.setAdapter(adapter_deformacion);
        spinner_deformacion2.setAdapter(adapter_deformacion);
        spinner_deformacion3.setAdapter(adapter_deformacion);
        spinner_deformacion4.setAdapter(adapter_deformacion);
        spinner_deformacion5.setAdapter(adapter_deformacion);
        spinner_deformacion6.setAdapter(adapter_deformacion);

        //Spinner tipo deformacion tramos
        spinner_tipodeform1 = vistatramos.findViewById(R.id.spinner_tipodeformacion1);
        spinner_tipodeform2 = vistatramos.findViewById(R.id.spinner_tipodeformacion2);
        spinner_tipodeform3 = vistatramos.findViewById(R.id.spinner_tipodeformacion3);
        spinner_tipodeform4 = vistatramos.findViewById(R.id.spinner_tipodeformacion4);
        spinner_tipodeform5 = vistatramos.findViewById(R.id.spinner_tipodeformacion5);
        spinner_tipodeform6 = vistatramos.findViewById(R.id.spinner_tipodeformacion6);
        String []opciones_tipodeform={"","Horizontal","Vertical"};
        ArrayAdapter<String> adapter_tipodeform = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_tipodeform);
        spinner_tipodeform1.setAdapter(adapter_tipodeform);
        spinner_tipodeform2.setAdapter(adapter_tipodeform);
        spinner_tipodeform3.setAdapter(adapter_tipodeform);
        spinner_tipodeform4.setAdapter(adapter_tipodeform);
        spinner_tipodeform5.setAdapter(adapter_tipodeform);
        spinner_tipodeform6.setAdapter(adapter_tipodeform);

        //Spinner tipo agua tramos
        spinner_tipodeagua1 = vistatramos.findViewById(R.id.spinner_tipoagua1);
        spinner_tipodeagua2 = vistatramos.findViewById(R.id.spinner_tipoagua2);
        spinner_tipodeagua3 = vistatramos.findViewById(R.id.spinner_tipoagua3);
        spinner_tipodeagua4 = vistatramos.findViewById(R.id.spinner_tipoagua4);
        spinner_tipodeagua5 = vistatramos.findViewById(R.id.spinner_tipoagua5);
        spinner_tipodeagua6 = vistatramos.findViewById(R.id.spinner_tipoagua6);
        String []opciones_tipodeagua={"","Negra","Llluvia","Combinada"};
        ArrayAdapter<String> adapter_tipodeagua = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, opciones_tipodeagua);
        spinner_tipodeagua1.setAdapter(adapter_tipodeagua);
        spinner_tipodeagua2.setAdapter(adapter_tipodeagua);
        spinner_tipodeagua3.setAdapter(adapter_tipodeagua);
        spinner_tipodeagua4.setAdapter(adapter_tipodeagua);
        spinner_tipodeagua5.setAdapter(adapter_tipodeagua);
        spinner_tipodeagua6.setAdapter(adapter_tipodeagua);

        spinner_entra_sale1.setFocusableInTouchMode(true);
        spinner_entra_sale2.setFocusableInTouchMode(true);
        spinner_entra_sale3.setFocusableInTouchMode(true);
        spinner_entra_sale4.setFocusableInTouchMode(true);
        spinner_entra_sale5.setFocusableInTouchMode(true);
        spinner_entra_sale6.setFocusableInTouchMode(true);
        spinner_estado1.setFocusableInTouchMode(true);
        spinner_estado2.setFocusableInTouchMode(true);
        spinner_estado3.setFocusableInTouchMode(true);
        spinner_estado4.setFocusableInTouchMode(true);
        spinner_estado5.setFocusableInTouchMode(true);
        spinner_estado6.setFocusableInTouchMode(true);
        spinner_material1.setFocusableInTouchMode(true);
        spinner_material2.setFocusableInTouchMode(true);
        spinner_material3.setFocusableInTouchMode(true);
        spinner_material4.setFocusableInTouchMode(true);
        spinner_material5.setFocusableInTouchMode(true);
        spinner_material6.setFocusableInTouchMode(true);
        spinner_deformacion1.setFocusableInTouchMode(true);
        spinner_deformacion2.setFocusableInTouchMode(true);
        spinner_deformacion3.setFocusableInTouchMode(true);
        spinner_deformacion4.setFocusableInTouchMode(true);
        spinner_deformacion5.setFocusableInTouchMode(true);
        spinner_deformacion6.setFocusableInTouchMode(true);
        spinner_tipodeform1.setFocusableInTouchMode(true);
        spinner_tipodeform2.setFocusableInTouchMode(true);
        spinner_tipodeform3.setFocusableInTouchMode(true);
        spinner_tipodeform4.setFocusableInTouchMode(true);
        spinner_tipodeform5.setFocusableInTouchMode(true);
        spinner_tipodeform6.setFocusableInTouchMode(true);
        spinner_tipodeagua1.setFocusableInTouchMode(true);
        spinner_tipodeagua2.setFocusableInTouchMode(true);
        spinner_tipodeagua3.setFocusableInTouchMode(true);
        spinner_tipodeagua4.setFocusableInTouchMode(true);
        spinner_tipodeagua5.setFocusableInTouchMode(true);
        spinner_tipodeagua6.setFocusableInTouchMode(true);

        Main2Activity activity = (Main2Activity)getActivity();
        id = activity.tomarid();

        if ((savedInstanceState==null)&&(id!=0)){
            conn = new ConexionSQLiteHelper(getContext());
            consultarDatosDB();

        }
try {
    if (heje1 != 0) {
        editTextHeje1.setText(Double.toString(heje1));
    }
}catch (Exception e){}
try {
    if (heje2 != 0) {
        editTextHeje2.setText(Double.toString(heje2));
    }
}catch (Exception e){}
try{
    if (heje3 != 0) {
        editTextHeje3.setText(Double.toString(heje3));
    }
}catch (Exception e){}
try{
    if (heje4 != 0) {
        editTextHeje4.setText(Double.toString(heje4));
    }
}catch (Exception e){}
try {
    if (heje5 != 0) {
        editTextHeje5.setText(Double.toString(heje5));
    }
}catch (Exception e){}
try {
    if (heje6 != 0) {
        editTextHeje6.setText(Double.toString(heje6));
    }
}catch (Exception e){}
try {
    if (conecta1 != null) {
        editTextConecta1.setText(conecta1);
    }
}catch (Exception e){}
try {
    if (conecta2 != null) {
        editTextConecta2.setText(conecta2);
    }
}catch (Exception e){}
try {
    if (conecta3 != null) {
        editTextConecta3.setText(conecta3);
    }
}catch (Exception e){}
try {
    if (conecta4 != null) {
        editTextConecta4.setText(conecta4);
    }
}catch (Exception e){}
try {
    if (conecta5 != null) {
        editTextConecta5.setText(conecta5);
    }
}catch (Exception e){}
try {
    if (conecta6 != null) {
        editTextConecta6.setText(conecta6);
    }
}catch (Exception e){}
try{
    if (diam1 != 0) {
        editTextDiam1.setText(Double.toString(diam1));
    }
}catch (Exception e){}
try {
    if (diam2 != 0) {
        editTextDiam2.setText(Double.toString(diam2));
    }
}catch (Exception e){}
try {
    if (diam3 != 0) {
        editTextDiam3.setText(Double.toString(diam3));
    }
}catch (Exception e){}
try{
    if (diam4 != 0) {
        editTextDiam4.setText(Double.toString(diam4));
    }
}catch (Exception e){}
try {
    if (diam5 != 0) {
        editTextDiam5.setText(Double.toString(diam5));
    }
}catch (Exception e){}
try {
    if (diam6 != 0) {
        editTextDiam6.setText(Double.toString(diam6));
    }
}catch (Exception e){}
        try {
    if (hcaja1 != 0) {
        editTextHcaja1.setText(Double.toString(hcaja1));
    }
        }catch (Exception e){}
  try {
    if (hcaja2 != 0) {
        editTextHcaja2.setText(Double.toString(hcaja2));
    }
  }catch (Exception e){}
  try {
    if (hcaja3 != 0) {
        editTextHcaja3.setText(Double.toString(hcaja3));
    }
  }catch (Exception e){}
  try {
    if (hcaja4 != 0) {
        editTextHcaja4.setText(Double.toString(hcaja4));
    }
  }catch (Exception e){}
  try {
    if (hcaja5 != 0) {
        editTextHcaja5.setText(Double.toString(hcaja5));
    }
  }catch (Exception e){}
  try {
    if (hcaja6 != 0) {
        editTextHcaja6.setText(Double.toString(hcaja6));
    }
  }catch (Exception e){}
  try {
    if (hbatea1 != 0) {
        editTextHbatea1.setText(Double.toString(hbatea1));
    }
  }catch (Exception e){}
  try {
    if (hbatea2 != 0) {
        editTextHbatea2.setText(Double.toString(hbatea2));
    }
  }catch (Exception e){}
  try {
    if (hbatea3 != 0) {
        editTextHbatea3.setText(Double.toString(hbatea3));
    }
  }catch (Exception e){}
    if (hbatea4 != 0) {
        editTextHbatea4.setText(Double.toString(hbatea4));
    }
  try {

    if (hbatea5 != 0) {
        editTextHbatea5.setText(Double.toString(hbatea5));
    }
  }catch (Exception e){}
  try {
    if (hbatea6 != 0) {
        editTextHbatea6.setText(Double.toString(hbatea6));
    }
}catch (Exception e){}

        if (entra1!=null){
           int spinner_entra1p = adapter_entrasale.getPosition(entra1);
           spinner_entra_sale1.setSelection(spinner_entra1p);
        }
        if (entra2!=null){
            int spinner_entra2p = adapter_entrasale.getPosition(entra2);
            spinner_entra_sale2.setSelection(spinner_entra2p);
        }
        if (entra3!=null){
            int spinner_entra3p = adapter_entrasale.getPosition(entra3);
            spinner_entra_sale3.setSelection(spinner_entra3p);
        }
        if (entra4!=null){
            int spinner_entra4p = adapter_entrasale.getPosition(entra4);
            spinner_entra_sale4.setSelection(spinner_entra4p);
        }
        if (entra5!=null){
            int spinner_entra5p = adapter_entrasale.getPosition(entra5);
            spinner_entra_sale5.setSelection(spinner_entra5p);
        }
        if (entra6!=null){
            int spinner_entra6p = adapter_entrasale.getPosition(entra6);
            spinner_entra_sale6.setSelection(spinner_entra6p);
        }
        if (material1!=null){
            int spinner_material1p = adapter_material.getPosition(material1);
            spinner_material1.setSelection(spinner_material1p);
        }
        if (material2!=null){
            int spinner_material2p = adapter_material.getPosition(material2);
            spinner_material2.setSelection(spinner_material2p);
        }
        if (material3!=null){
            int spinner_material3p = adapter_material.getPosition(material3);
            spinner_material3.setSelection(spinner_material3p);
        }
        if (material4!=null){
            int spinner_material4p = adapter_material.getPosition(material4);
            spinner_material4.setSelection(spinner_material4p);
        }
        if (material5!=null){
            int spinner_material5p = adapter_material.getPosition(material5);
            spinner_material5.setSelection(spinner_material5p);
        }
        if (material6!=null){
            int spinner_material6p = adapter_material.getPosition(material6);
            spinner_material6.setSelection(spinner_material6p);
        }
        if (deformacion1!=null){
            int spinner_deformacion1p = adapter_deformacion.getPosition(deformacion1);
            spinner_deformacion1.setSelection(spinner_deformacion1p);
        }
        if (deformacion2!=null){
            int spinner_deformacion2p = adapter_deformacion.getPosition(deformacion2);
            spinner_deformacion2.setSelection(spinner_deformacion2p);
        }
        if (deformacion3!=null){
            int spinner_deformacion3p = adapter_deformacion.getPosition(deformacion3);
            spinner_deformacion3.setSelection(spinner_deformacion3p);
        }
        if (deformacion4!=null){
            int spinner_deformacion4p = adapter_deformacion.getPosition(deformacion4);
            spinner_deformacion4.setSelection(spinner_deformacion4p);
        }
        if (deformacion5!=null){
            int spinner_deformacion5p = adapter_deformacion.getPosition(deformacion5);
            spinner_deformacion5.setSelection(spinner_deformacion5p);
        }
        if (deformacion6!=null){
            int spinner_deformacion6p = adapter_deformacion.getPosition(deformacion6);
            spinner_deformacion6.setSelection(spinner_deformacion6p);
        }
        if (tipodeformacion1!=null){
            int spinner_tipodeformacion1p = adapter_tipodeform.getPosition(tipodeformacion1);
            spinner_tipodeform1.setSelection(spinner_tipodeformacion1p);
        }
        if (tipodeformacion2!=null){
            int spinner_tipodeformacion2p = adapter_tipodeform.getPosition(tipodeformacion2);
            spinner_tipodeform2.setSelection(spinner_tipodeformacion2p);
        }
        if (tipodeformacion3!=null){
            int spinner_tipodeformacion3p = adapter_tipodeform.getPosition(tipodeformacion3);
            spinner_tipodeform3.setSelection(spinner_tipodeformacion3p);
        }
        if (tipodeformacion4!=null){
            int spinner_tipodeformacion4p = adapter_tipodeform.getPosition(tipodeformacion4);
            spinner_tipodeform4.setSelection(spinner_tipodeformacion4p);
        }
        if (tipodeformacion5!=null){
            int spinner_tipodeformacion5p = adapter_tipodeform.getPosition(tipodeformacion5);
            spinner_tipodeform5.setSelection(spinner_tipodeformacion5p);
        }
        if (tipodeformacion6!=null){
            int spinner_tipodeformacion6p = adapter_tipodeform.getPosition(tipodeformacion6);
            spinner_tipodeform6.setSelection(spinner_tipodeformacion6p);
        }
        if (tipoagua1!=null){
            int spinner_tipoagua1p = adapter_tipodeagua.getPosition(tipoagua1);
            spinner_tipodeagua1.setSelection(spinner_tipoagua1p);
        }
        if (tipoagua2!=null){
            int spinner_tipoagua2p = adapter_tipodeagua.getPosition(tipoagua2);
            spinner_tipodeagua2.setSelection(spinner_tipoagua2p);
        }
        if (tipoagua3!=null){
            int spinner_tipoagua3p = adapter_tipodeagua.getPosition(tipoagua3);
            spinner_tipodeagua3.setSelection(spinner_tipoagua3p);
        }
        if (tipoagua4!=null){
            int spinner_tipoagua4p = adapter_tipodeagua.getPosition(tipoagua4);
            spinner_tipodeagua4.setSelection(spinner_tipoagua4p);
        }
        if (tipoagua5!=null){
            int spinner_tipoagua5p = adapter_tipodeagua.getPosition(tipoagua5);
            spinner_tipodeagua5.setSelection(spinner_tipoagua5p);
        }
        if (tipoagua6!=null){
            int spinner_tipoagua6p = adapter_tipodeagua.getPosition(tipoagua6);
            spinner_tipodeagua6.setSelection(spinner_tipoagua6p);
        }
        if (estado1!=null){
            int spinner_estado1p = adapter_estado.getPosition(estado1);
            spinner_estado1.setSelection(spinner_estado1p);
        }
        if (estado2!=null){
            int spinner_estado2p = adapter_estado.getPosition(estado2);
            spinner_estado2.setSelection(spinner_estado2p);
        }
        if (estado3!=null){
            int spinner_estado3p = adapter_estado.getPosition(estado3);
            spinner_estado3.setSelection(spinner_estado3p);
        }
        if (estado4!=null){
            int spinner_estado4p = adapter_estado.getPosition(estado4);
            spinner_estado4.setSelection(spinner_estado4p);
        }
        if (estado5!=null){
            int spinner_estado5p = adapter_estado.getPosition(estado5);
            spinner_estado5.setSelection(spinner_estado5p);
        }
        if (estado6!=null){
            int spinner_estado6p = adapter_estado.getPosition(estado6);
            spinner_estado6.setSelection(spinner_estado6p);
        }


       editTextTramos.setOnEditorActionListener(new EditText.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if(i== EditorInfo.IME_ACTION_DONE)
               {
                   String tr = editTextTramos.getText().toString();


                   if (tr.isEmpty()) {
                       Toast.makeText(getContext(), "Debe insertar un valor entre 1 y 6", Toast.LENGTH_SHORT).show();

                   } else {
                       int Ntr = Integer.valueOf(tr);
                       if (Ntr == 1) {
                           textViewT2.setVisibility(View.INVISIBLE);
                           textViewT3.setVisibility(View.INVISIBLE);
                           textViewT4.setVisibility(View.INVISIBLE);
                           textViewT5.setVisibility(View.INVISIBLE);
                           textViewT6.setVisibility(View.INVISIBLE);
                           rowT2.setVisibility(View.INVISIBLE);
                           rowT3.setVisibility(View.INVISIBLE);
                           rowT4.setVisibility(View.INVISIBLE);
                           rowT5.setVisibility(View.INVISIBLE);
                           rowT6.setVisibility(View.INVISIBLE);

                           visibilityTvT2 = false;
                           visibilityTvT3 = false;
                           visibilityTvT4 = false;
                           visibilityTvT5 = false;
                           visibilityTvT6 = false;

                           visibilityRowT2= false;
                           visibilityRowT3= false;
                           visibilityRowT4= false;
                           visibilityRowT5= false;
                           visibilityRowT6= false;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       }
                       if (Ntr == 2) {
                           textViewT2.setVisibility(View.VISIBLE);
                           textViewT3.setVisibility(View.INVISIBLE);
                           textViewT4.setVisibility(View.INVISIBLE);
                           textViewT5.setVisibility(View.INVISIBLE);
                           textViewT6.setVisibility(View.INVISIBLE);
                           rowT2.setVisibility(View.VISIBLE);
                           rowT3.setVisibility(View.INVISIBLE);
                           rowT4.setVisibility(View.INVISIBLE);
                           rowT5.setVisibility(View.INVISIBLE);
                           rowT6.setVisibility(View.INVISIBLE);

                           visibilityTvT2 = true;
                           visibilityTvT3 = false;
                           visibilityTvT4 = false;
                           visibilityTvT5 = false;
                           visibilityTvT6 = false;

                           visibilityRowT2= true;
                           visibilityRowT3= false;
                           visibilityRowT4= false;
                           visibilityRowT5= false;
                           visibilityRowT6= false;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       }
                       if (Ntr == 3) {
                           textViewT2.setVisibility(View.VISIBLE);
                           textViewT3.setVisibility(View.VISIBLE);
                           textViewT4.setVisibility(View.INVISIBLE);
                           textViewT5.setVisibility(View.INVISIBLE);
                           textViewT6.setVisibility(View.INVISIBLE);
                           rowT2.setVisibility(View.VISIBLE);
                           rowT3.setVisibility(View.VISIBLE);
                           rowT4.setVisibility(View.INVISIBLE);
                           rowT5.setVisibility(View.INVISIBLE);
                           rowT6.setVisibility(View.INVISIBLE);

                           visibilityTvT2 = true;
                           visibilityTvT3 = true;
                           visibilityTvT4 = false;
                           visibilityTvT5 = false;
                           visibilityTvT6 = false;

                           visibilityRowT2= true;
                           visibilityRowT3= true;
                           visibilityRowT4= false;
                           visibilityRowT5= false;
                           visibilityRowT6= false;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       }
                       if (Ntr == 4) {
                           textViewT2.setVisibility(View.VISIBLE);
                           textViewT3.setVisibility(View.VISIBLE);
                           textViewT4.setVisibility(View.VISIBLE);
                           textViewT5.setVisibility(View.INVISIBLE);
                           textViewT6.setVisibility(View.INVISIBLE);
                           rowT2.setVisibility(View.VISIBLE);
                           rowT3.setVisibility(View.VISIBLE);
                           rowT4.setVisibility(View.VISIBLE);
                           rowT5.setVisibility(View.INVISIBLE);
                           rowT6.setVisibility(View.INVISIBLE);

                           visibilityTvT2 = true;
                           visibilityTvT3 = true;
                           visibilityTvT4 = true;
                           visibilityTvT5 = false;
                           visibilityTvT6 = false;

                           visibilityRowT2= true;
                           visibilityRowT3= true;
                           visibilityRowT4= true;
                           visibilityRowT5= false;
                           visibilityRowT6= false;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       }
                       if (Ntr == 5) {
                           textViewT2.setVisibility(View.VISIBLE);
                           textViewT3.setVisibility(View.VISIBLE);
                           textViewT4.setVisibility(View.VISIBLE);
                           textViewT5.setVisibility(View.VISIBLE);
                           textViewT6.setVisibility(View.INVISIBLE);
                           rowT2.setVisibility(View.VISIBLE);
                           rowT3.setVisibility(View.VISIBLE);
                           rowT4.setVisibility(View.VISIBLE);
                           rowT5.setVisibility(View.VISIBLE);
                           rowT6.setVisibility(View.INVISIBLE);

                           visibilityTvT2 = true;
                           visibilityTvT3 = true;
                           visibilityTvT4 = true;
                           visibilityTvT5 = true;
                           visibilityTvT6 = false;

                           visibilityRowT2= true;
                           visibilityRowT3= true;
                           visibilityRowT4= true;
                           visibilityRowT5= true;
                           visibilityRowT6= false;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       }
                       if (Ntr == 6) {
                           textViewT2.setVisibility(View.VISIBLE);
                           textViewT3.setVisibility(View.VISIBLE);
                           textViewT4.setVisibility(View.VISIBLE);
                           textViewT5.setVisibility(View.VISIBLE);
                           textViewT6.setVisibility(View.VISIBLE);
                           rowT2.setVisibility(View.VISIBLE);
                           rowT3.setVisibility(View.VISIBLE);
                           rowT4.setVisibility(View.VISIBLE);
                           rowT5.setVisibility(View.VISIBLE);
                           rowT6.setVisibility(View.VISIBLE);

                           visibilityTvT2 = true;
                           visibilityTvT3 = true;
                           visibilityTvT4 = true;
                           visibilityTvT5 = true;
                           visibilityTvT6 = true;

                           visibilityRowT2= true;
                           visibilityRowT3= true;
                           visibilityRowT4= true;
                           visibilityRowT5= true;
                           visibilityRowT6= true;

                           InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           imm.hideSoftInputFromWindow(editTextTramos.getWindowToken(), 0);

                       } if (Ntr>6||Ntr==0){
                           Toast.makeText(getContext(), "Debe insertar un valor entre 1 y 6", Toast.LENGTH_SHORT).show();

                       }
                   }


                   return true;
               }
               return false;
           }

       });

       editTextHbatea1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if (i==EditorInfo.IME_ACTION_DONE) {
                   String text = editTextHbatea1.getText().toString();

                   for (int j = 0; j < text.length(); j++) {
                       if (text.charAt(j) == '+') {
                           try {
                           String[] s = text.split("[+]");
                           double s1 = Double.parseDouble(s[0]);
                           double s2 = Double.parseDouble(s[1]);

                           double resultado = s1 + s2;

                           editTextHbatea1.setText(String.valueOf(resultado));
                           }catch (Exception e){
                               Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                           }
                           break;

                       }
                   }
                   InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                   imm.hideSoftInputFromWindow(editTextHbatea1.getWindowToken(), 0);
                   return true;
               }
               return false;
           }
       });

       editTextHbatea2.setOnEditorActionListener(new EditText.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if (i==EditorInfo.IME_ACTION_DONE) {
                   String text = editTextHbatea2.getText().toString();

                   for (int j = 0; j < text.length(); j++) {
                       if (text.charAt(j) == '+') {
                           try{
                           String[] s = text.split("[+]");
                           double s1 = Double.parseDouble(s[0]);
                           double s2 = Double.parseDouble(s[1]);

                           double resultado = s1 + s2;

                           editTextHbatea2.setText(String.valueOf(resultado));
                           }catch (Exception e){
                               Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                           }
                           break;

                       }
                   }
                   InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                   imm.hideSoftInputFromWindow(editTextHbatea2.getWindowToken(), 0);
                   return true;
               }
               return false;
           }
       });

        editTextHbatea3.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i==EditorInfo.IME_ACTION_DONE) {
                    String text = editTextHbatea3.getText().toString();

                    for (int j = 0; j < text.length(); j++) {
                        if (text.charAt(j) == '+') {
                            try {
                            String[] s = text.split("[+]");
                            double s1 = Double.parseDouble(s[0]);
                            double s2 = Double.parseDouble(s[1]);

                            double resultado = s1 + s2;

                            editTextHbatea3.setText(String.valueOf(resultado));
                            }catch (Exception e){
                                Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                            }
                            break;

                        }
                    }
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextHbatea3.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        editTextHbatea4.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i==EditorInfo.IME_ACTION_DONE) {
                    String text = editTextHbatea4.getText().toString();

                    for (int j = 0; j < text.length(); j++) {
                        if (text.charAt(j) == '+') {
                            try {

                                String[] s = text.split("[+]");
                                double s1 = Double.parseDouble(s[0]);
                                double s2 = Double.parseDouble(s[1]);

                                double resultado = s1 + s2;

                                editTextHbatea4.setText(String.valueOf(resultado));
                            }catch (Exception e){
                                Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                            }
                            break;

                        }
                    }
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextHbatea4.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        editTextHbatea5.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i==EditorInfo.IME_ACTION_DONE) {
                    String text = editTextHbatea5.getText().toString();

                    for (int j = 0; j < text.length(); j++) {
                        if (text.charAt(j) == '+') {
                            try {

                                String[] s = text.split("[+]");
                                double s1 = Double.parseDouble(s[0]);
                                double s2 = Double.parseDouble(s[1]);

                                double resultado = s1 + s2;

                                editTextHbatea5.setText(String.valueOf(resultado));
                            }catch (Exception e){
                                Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                            }
                            break;

                        }
                    }
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextHbatea5.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        editTextHbatea6.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i==EditorInfo.IME_ACTION_DONE) {
                    String text = editTextHbatea6.getText().toString();

                    for (int j = 0; j < text.length(); j++) {
                        if (text.charAt(j) == '+') {
                            try {
                                String[] s = text.split("[+]");
                                double s1 = Double.parseDouble(s[0]);
                                double s2 = Double.parseDouble(s[1]);

                                double resultado = s1 + s2;

                                editTextHbatea6.setText(String.valueOf(resultado));
                            } catch (Exception e){
                            Toast.makeText(getContext(),"Dato no valido para suma",Toast.LENGTH_SHORT).show();
                        }
                            break;

                        }
                    }
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextHbatea6.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
        return vistatramos;
    }

    private void consultarDatosDB() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {Integer.toString(id)};
        String[] columsTramos = new String[]{Utilidades.CAMPO_ENTRA1,Utilidades.CAMPO_ENTRA2,Utilidades.CAMPO_ENTRA3,Utilidades.CAMPO_ENTRA4,Utilidades.CAMPO_ENTRA5,Utilidades.CAMPO_ENTRA6,Utilidades.CAMPO_HEJE1,Utilidades.CAMPO_HEJE2,Utilidades.CAMPO_HEJE3,Utilidades.CAMPO_HEJE4,Utilidades.CAMPO_HEJE5,Utilidades.CAMPO_HEJE6, Utilidades.CAMPO_CONECTA1,Utilidades.CAMPO_CONECTA2,Utilidades.CAMPO_CONECTA3,Utilidades.CAMPO_CONECTA4,Utilidades.CAMPO_CONECTA5,Utilidades.CAMPO_CONECTA6, Utilidades.CAMPO_DIAM1, Utilidades.CAMPO_DIAM2, Utilidades.CAMPO_DIAM3, Utilidades.CAMPO_DIAM4, Utilidades.CAMPO_DIAM5, Utilidades.CAMPO_DIAM6,  Utilidades.CAMPO_HCAJA1,Utilidades.CAMPO_HCAJA2,Utilidades.CAMPO_HCAJA3,Utilidades.CAMPO_HCAJA4,Utilidades.CAMPO_HCAJA5,Utilidades.CAMPO_HCAJA6,Utilidades.CAMPO_HBATEA1,Utilidades.CAMPO_HBATEA2,Utilidades.CAMPO_HBATEA3,Utilidades.CAMPO_HBATEA4,Utilidades.CAMPO_HBATEA5,Utilidades.CAMPO_HBATEA6,Utilidades.CAMPO_MATERIAL1,Utilidades.CAMPO_MATERIAL2 ,Utilidades.CAMPO_MATERIAL3 ,Utilidades.CAMPO_MATERIAL4 ,Utilidades.CAMPO_MATERIAL5 ,Utilidades.CAMPO_MATERIAL6, Utilidades.CAMPO_ESTADO1, Utilidades.CAMPO_ESTADO2,Utilidades.CAMPO_ESTADO3,Utilidades.CAMPO_ESTADO4,Utilidades.CAMPO_ESTADO5,Utilidades.CAMPO_ESTADO6, Utilidades.CAMPO_DEFORMACION1, Utilidades.CAMPO_DEFORMACION2, Utilidades.CAMPO_DEFORMACION3, Utilidades.CAMPO_DEFORMACION4, Utilidades.CAMPO_DEFORMACION5, Utilidades.CAMPO_DEFORMACION6,  Utilidades.CAMPO_TIPODEFORMACION1, Utilidades.CAMPO_TIPODEFORMACION2, Utilidades.CAMPO_TIPODEFORMACION3, Utilidades.CAMPO_TIPODEFORMACION4, Utilidades.CAMPO_TIPODEFORMACION5, Utilidades.CAMPO_TIPODEFORMACION6,  Utilidades.CAMPO_TIPOAGUA1,Utilidades.CAMPO_TIPOAGUA2,Utilidades.CAMPO_TIPOAGUA3,Utilidades.CAMPO_TIPOAGUA4,Utilidades.CAMPO_TIPOAGUA5,Utilidades.CAMPO_TIPOAGUA6  };
        try {
            Cursor cursorTramos = db.query(Utilidades.TABLA_ALCANTARILLADO, columsTramos, Utilidades.CAMPO_ID + " =?", parametros, null, null, null);
            cursorTramos.moveToFirst();

            int entra1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA1);
            int entra2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA2);
            int entra3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA3);
            int entra4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA4);
            int entra5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA5);
            int entra6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ENTRA6);

            int heje1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE1);
            int heje2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE2);
            int heje3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE3);
            int heje4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE4);
            int heje5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE5);
            int heje6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HEJE6);

            int conecta1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA1);
            int conecta2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA2);
            int conecta3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA3);
            int conecta4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA4);
            int conecta5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA5);
            int conecta6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_CONECTA6);

            int diam1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM1);
            int diam2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM2);
            int diam3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM3);
            int diam4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM4);
            int diam5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM5);
            int diam6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DIAM6);

            int hcaja1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA1);
            int hcaja2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA2);
            int hcaja3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA3);
            int hcaja4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA4);
            int hcaja5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA5);
            int hcaja6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HCAJA6);

            int hbatea1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA1);
            int hbatea2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA2);
            int hbatea3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA3);
            int hbatea4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA4);
            int hbatea5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA5);
            int hbatea6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_HBATEA6);

            int material1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL1);
            int material2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL2);
            int material3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL3);
            int material4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL4);
            int material5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL5);
            int material6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_MATERIAL6);

            int estado1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO1);
            int estado2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO2);
            int estado3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO3);
            int estado4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO4);
            int estado5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO5);
            int estado6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_ESTADO6);

            int deformacion1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION1);
            int deformacion2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION2);
            int deformacion3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION3);
            int deformacion4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION4);
            int deformacion5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION5);
            int deformacion6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_DEFORMACION6);

            int tipodeformacion1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION1);
            int tipodeformacion2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION2);
            int tipodeformacion3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION3);
            int tipodeformacion4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION4);
            int tipodeformacion5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION5);
            int tipodeformacion6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION6);

            int tipoagua1p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA1);
            int tipoagua2p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA2);
            int tipoagua3p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA3);
            int tipoagua4p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA4);
            int tipoagua5p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA5);
            int tipoagua6p = cursorTramos.getColumnIndex(Utilidades.CAMPO_TIPOAGUA6);

            entra1 = cursorTramos.getString(entra1p);
            entra2 = cursorTramos.getString(entra2p);
            entra3 = cursorTramos.getString(entra3p);
            entra4 = cursorTramos.getString(entra4p);
            entra5 = cursorTramos.getString(entra5p);
            entra6 = cursorTramos.getString(entra6p);

            heje1 = cursorTramos.getDouble(heje1p);
            heje2 = cursorTramos.getDouble(heje2p);
            heje3 = cursorTramos.getDouble(heje3p);
            heje4 = cursorTramos.getDouble(heje4p);
            heje5 = cursorTramos.getDouble(heje5p);
            heje6 = cursorTramos.getDouble(heje6p);

            conecta1 = cursorTramos.getString(conecta1p);
            conecta2 = cursorTramos.getString(conecta2p);
            conecta3 = cursorTramos.getString(conecta3p);
            conecta4 = cursorTramos.getString(conecta4p);
            conecta5 = cursorTramos.getString(conecta5p);
            conecta6 = cursorTramos.getString(conecta6p);

            diam1 = cursorTramos.getDouble(diam1p);
            diam2 = cursorTramos.getDouble(diam2p);
            diam3 = cursorTramos.getDouble(diam3p);
            diam4 = cursorTramos.getDouble(diam4p);
            diam5 = cursorTramos.getDouble(diam5p);
            diam6 = cursorTramos.getDouble(diam6p);

            hcaja1 = cursorTramos.getDouble(hcaja1p);
            hcaja2 = cursorTramos.getDouble(hcaja2p);
            hcaja3 = cursorTramos.getDouble(hcaja3p);
            hcaja4 = cursorTramos.getDouble(hcaja4p);
            hcaja5 = cursorTramos.getDouble(hcaja5p);
            hcaja6 = cursorTramos.getDouble(hcaja6p);

            hbatea1 = cursorTramos.getDouble(hbatea1p);
            hbatea2 = cursorTramos.getDouble(hbatea2p);
            hbatea3 = cursorTramos.getDouble(hbatea3p);
            hbatea4 = cursorTramos.getDouble(hbatea4p);
            hbatea5 = cursorTramos.getDouble(hbatea5p);
            hbatea6 = cursorTramos.getDouble(hbatea6p);

            material1 = cursorTramos.getString(material1p);
            material2 = cursorTramos.getString(material2p);
            material3 = cursorTramos.getString(material3p);
            material4 = cursorTramos.getString(material4p);
            material5 = cursorTramos.getString(material5p);
            material6 = cursorTramos.getString(material6p);

            estado1 = cursorTramos.getString(estado1p);
            estado2 = cursorTramos.getString(estado2p);
            estado3 = cursorTramos.getString(estado3p);
            estado4 = cursorTramos.getString(estado4p);
            estado5 = cursorTramos.getString(estado5p);
            estado6 = cursorTramos.getString(estado6p);

            deformacion1 = cursorTramos.getString(deformacion1p);
            deformacion2 = cursorTramos.getString(deformacion2p);
            deformacion3 = cursorTramos.getString(deformacion3p);
            deformacion4 = cursorTramos.getString(deformacion4p);
            deformacion5 = cursorTramos.getString(deformacion5p);
            deformacion6 = cursorTramos.getString(deformacion6p);

            tipodeformacion1 = cursorTramos.getString(tipodeformacion1p);
            tipodeformacion2 = cursorTramos.getString(tipodeformacion2p);
            tipodeformacion3 = cursorTramos.getString(tipodeformacion3p);
            tipodeformacion4 = cursorTramos.getString(tipodeformacion4p);
            tipodeformacion5 = cursorTramos.getString(tipodeformacion5p);
            tipodeformacion6 = cursorTramos.getString(tipodeformacion6p);

            tipoagua1 = cursorTramos.getString(tipoagua1p);
            tipoagua2 = cursorTramos.getString(tipoagua2p);
            tipoagua3 = cursorTramos.getString(tipoagua3p);
            tipoagua4 = cursorTramos.getString(tipoagua4p);
            tipoagua5 = cursorTramos.getString(tipoagua5p);
            tipoagua6 = cursorTramos.getString(tipoagua6p);

            cursorTramos.close();

        }catch (Exception e){

        }
        db.close();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("visibilityTvT2", visibilityTvT2);
        outState.putBoolean("visibilityTvT3", visibilityTvT3);
        outState.putBoolean("visibilityTvT4", visibilityTvT4);
        outState.putBoolean("visibilityTvT5", visibilityTvT5);
        outState.putBoolean("visibilityTvT6", visibilityTvT6);

        outState.putBoolean("visibilityRowT2", visibilityRowT2);
        outState.putBoolean("visibilityRowT3", visibilityRowT3);
        outState.putBoolean("visibilityRowT4", visibilityRowT4);
        outState.putBoolean("visibilityRowT5", visibilityRowT5);
        outState.putBoolean("visibilityRowT6", visibilityRowT6);
    }

    public void tomarDatosTramos(){
        Intent intentTramos = getActivity().getIntent();
        Bundle bundleTramos = new Bundle();
        bundleTramos.putString("EntraT1",spinner_entra_sale1.getSelectedItem().toString());
        bundleTramos.putString("EntraT2",spinner_entra_sale2.getSelectedItem().toString());
        bundleTramos.putString("EntraT3",spinner_entra_sale3.getSelectedItem().toString());
        bundleTramos.putString("EntraT4",spinner_entra_sale4.getSelectedItem().toString());
        bundleTramos.putString("EntraT5",spinner_entra_sale5.getSelectedItem().toString());
        bundleTramos.putString("EntraT6",spinner_entra_sale6.getSelectedItem().toString());
        bundleTramos.putString("HejeT1",editTextHeje1.getText().toString());
        bundleTramos.putString("HejeT2",editTextHeje2.getText().toString());
        bundleTramos.putString("HejeT3",editTextHeje3.getText().toString());
        bundleTramos.putString("HejeT4",editTextHeje4.getText().toString());
        bundleTramos.putString("HejeT5",editTextHeje5.getText().toString());
        bundleTramos.putString("HejeT6",editTextHeje6.getText().toString());
        bundleTramos.putString("ConectaT1",editTextConecta1.getText().toString());
        bundleTramos.putString("ConectaT2",editTextConecta2.getText().toString());
        bundleTramos.putString("ConectaT3",editTextConecta3.getText().toString());
        bundleTramos.putString("ConectaT4",editTextConecta4.getText().toString());
        bundleTramos.putString("ConectaT5",editTextConecta5.getText().toString());
        bundleTramos.putString("ConectaT6",editTextConecta6.getText().toString());
        bundleTramos.putString("DiamT1",editTextDiam1.getText().toString());
        bundleTramos.putString("DiamT2",editTextDiam2.getText().toString());
        bundleTramos.putString("DiamT3",editTextDiam3.getText().toString());
        bundleTramos.putString("DiamT4",editTextDiam4.getText().toString());
        bundleTramos.putString("DiamT5",editTextDiam5.getText().toString());
        bundleTramos.putString("DiamT6",editTextDiam6.getText().toString());
        bundleTramos.putString("HcajaT1",editTextHcaja1.getText().toString());
        bundleTramos.putString("HcajaT2",editTextHcaja2.getText().toString());
        bundleTramos.putString("HcajaT3",editTextHcaja3.getText().toString());
        bundleTramos.putString("HcajaT4",editTextHcaja4.getText().toString());
        bundleTramos.putString("HcajaT5",editTextHcaja5.getText().toString());
        bundleTramos.putString("HcajaT6",editTextHcaja6.getText().toString());
        bundleTramos.putString("HbateaT1",editTextHbatea1.getText().toString());
        bundleTramos.putString("HbateaT2",editTextHbatea2.getText().toString());
        bundleTramos.putString("HbateaT3",editTextHbatea3.getText().toString());
        bundleTramos.putString("HbateaT4",editTextHbatea4.getText().toString());
        bundleTramos.putString("HbateaT5",editTextHbatea5.getText().toString());
        bundleTramos.putString("HbateaT6",editTextHbatea6.getText().toString());
        bundleTramos.putString("MaterialT1",spinner_material1.getSelectedItem().toString());
        bundleTramos.putString("MaterialT2",spinner_material2.getSelectedItem().toString());
        bundleTramos.putString("MaterialT3",spinner_material3.getSelectedItem().toString());
        bundleTramos.putString("MaterialT4",spinner_material4.getSelectedItem().toString());
        bundleTramos.putString("MaterialT5",spinner_material5.getSelectedItem().toString());
        bundleTramos.putString("MaterialT6",spinner_material6.getSelectedItem().toString());
        bundleTramos.putString("EstadoT1",spinner_estado1.getSelectedItem().toString());
        bundleTramos.putString("EstadoT2",spinner_estado2.getSelectedItem().toString());
        bundleTramos.putString("EstadoT3",spinner_estado3.getSelectedItem().toString());
        bundleTramos.putString("EstadoT4",spinner_estado4.getSelectedItem().toString());
        bundleTramos.putString("EstadoT5",spinner_estado5.getSelectedItem().toString());
        bundleTramos.putString("EstadoT6",spinner_estado6.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT1",spinner_deformacion1.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT2",spinner_deformacion2.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT3",spinner_deformacion3.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT4",spinner_deformacion4.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT5",spinner_deformacion5.getSelectedItem().toString());
        bundleTramos.putString("DeformacionT6",spinner_deformacion6.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT1",spinner_tipodeform1.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT2",spinner_tipodeform2.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT3",spinner_tipodeform3.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT4",spinner_tipodeform4.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT5",spinner_tipodeform5.getSelectedItem().toString());
        bundleTramos.putString("TipoDeformacionT6",spinner_tipodeform6.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT1",spinner_tipodeagua1.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT2",spinner_tipodeagua2.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT3",spinner_tipodeagua3.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT4",spinner_tipodeagua4.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT5",spinner_tipodeagua5.getSelectedItem().toString());
        bundleTramos.putString("TipoAguaT6",spinner_tipodeagua6.getSelectedItem().toString());
        intentTramos.putExtras(bundleTramos);


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
