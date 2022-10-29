package com.example.user.mhinvest.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.user.mhinvest.ConexionSQLiteHelper;
import com.example.user.mhinvest.Main2Activity;
import com.example.user.mhinvest.R;
import com.example.user.mhinvest.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FotosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FotosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FotosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FotosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FotosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FotosFragment newInstance(String param1, String param2) {
        FotosFragment fragment = new FotosFragment();
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

    View vistafotos;
    private EditText editTextNombreFotos;

    private ImageButton buttonFotoexterior;
    private ImageButton buttonFotopanoramica;
    private ImageButton buttonFotoesquema;
    private ImageButton buttonFototapa;
    private ImageButton buttonFotointerior1;
    private ImageButton buttonFotointerior2;
    private ImageButton buttonFotointerior3;
    private ImageButton buttonFotointerior4;

    String mcurrentPhotoPath;

    private Uri mImageUri1 = Uri.EMPTY;
    private Uri mImageUri2 = Uri.EMPTY;
    private Uri mImageUri3 = Uri.EMPTY;
    private Uri mImageUri4 = Uri.EMPTY;
    private Uri mImageUri5 = Uri.EMPTY;
    private Uri mImageUri6 = Uri.EMPTY;
    private Uri mImageUri7 = Uri.EMPTY;
    private Uri mImageUri8 = Uri.EMPTY;

    private static final int CAMERA_REQUEST1 = 123;
    private static final int CAMERA_REQUEST2 = 223;
    private static final int CAMERA_REQUEST3 = 323;
    private static final int CAMERA_REQUEST4 = 423;
    private static final int CAMERA_REQUEST5 = 523;
    private static final int CAMERA_REQUEST6 = 623;
    private static final int CAMERA_REQUEST7 = 723;
    private static final int CAMERA_REQUEST8 = 823;
    private ImageView imageViewFotoExterior;
    private ImageView imageViewFotoPanoramica;
    private ImageView imageViewFotoTapa;
    private ImageView imageViewFotoEsquema;
    private ImageView imageViewFotoInterior1;
    private ImageView imageViewFotoInterior2;
    private ImageView imageViewFotoInterior3;
    private ImageView imageViewFotoInterior4;

    Bitmap bitmapfotoexterior;
    Bitmap bitmapfotopanoramica;
    Bitmap bitmapfotoesquema;
    Bitmap bitmapfototapa;
    Bitmap bitmapfotointerior1;
    Bitmap bitmapfotointerior2;
    Bitmap bitmapfotointerior3;
    Bitmap bitmapfotointerior4;



    private byte[] bytearrayExterior;
   private byte[] bytearrayPanoramica;
    private byte[] bytearrayEsquema;
   private byte[] bytearrayTapa;
    private byte[] bytearrayInterior1;
    private byte[] bytearrayInterior2;
    private byte[] bytearrayInterior3;
    private byte[] bytearrayInterior4;


    private int id;
    ConexionSQLiteHelper conn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistafotos = inflater.inflate(R.layout.fragment_fotos, container, false);
        editTextNombreFotos = vistafotos.findViewById(R.id.editTextNombreFotos);
        buttonFotoexterior = vistafotos.findViewById(R.id.buttonFotoexterior);
        buttonFotopanoramica =vistafotos.findViewById(R.id.buttonFotopanoramica);
        buttonFotoesquema = vistafotos.findViewById(R.id.buttonFotoesquema);
        buttonFototapa = vistafotos.findViewById(R.id.buttonFototapa);
        buttonFotointerior1 =vistafotos.findViewById(R.id.buttonFotointerior1);
        buttonFotointerior2 = vistafotos.findViewById(R.id.buttonFotointerior2);
        buttonFotointerior3 = vistafotos.findViewById(R.id.buttonFotointerior3);
        buttonFotointerior4 = vistafotos.findViewById(R.id.buttonFotointerior4);


        imageViewFotoExterior = vistafotos.findViewById(R.id.imageViewFotoexterior);
        imageViewFotoPanoramica = vistafotos.findViewById(R.id.imageViewFotopanoramica);
        imageViewFotoTapa = vistafotos.findViewById(R.id.imageViewFototapa);
        imageViewFotoEsquema = vistafotos.findViewById(R.id.imageViewFotoesquema);
        imageViewFotoInterior1 = vistafotos.findViewById(R.id.imageViewFotointerior1);
        imageViewFotoInterior2 = vistafotos.findViewById(R.id.imageViewFotointerior2);
        imageViewFotoInterior3 = vistafotos.findViewById(R.id.imageViewFotointerior3);
        imageViewFotoInterior4 = vistafotos.findViewById(R.id.imageViewFotointerior4);

        Main2Activity activity = (Main2Activity)getActivity();
        id = activity.tomarid();

        if ((savedInstanceState==null)&&(id!=0)){
            conn = new ConexionSQLiteHelper(getContext());
            consultarDatosDB();

        }


        if (savedInstanceState != null)
        {
            bitmapfotoexterior = savedInstanceState.getParcelable(" bitmap1");
            bitmapfotopanoramica = savedInstanceState.getParcelable(" bitmap2");
            bitmapfotoesquema = savedInstanceState.getParcelable(" bitmap3");
            bitmapfototapa = savedInstanceState.getParcelable(" bitmap4");
            bitmapfotointerior1 = savedInstanceState.getParcelable(" bitmap5");
            bitmapfotointerior2 = savedInstanceState.getParcelable(" bitmap6");
            bitmapfotointerior3 = savedInstanceState.getParcelable(" bitmap7");
            bitmapfotointerior4 = savedInstanceState.getParcelable(" bitmap8");

        }

        imageViewFotoExterior.setImageBitmap(bitmapfotoexterior);
        imageViewFotoPanoramica.setImageBitmap(bitmapfotopanoramica);
        imageViewFotoEsquema.setImageBitmap(bitmapfotoesquema);
        imageViewFotoTapa.setImageBitmap(bitmapfototapa);
        imageViewFotoInterior1.setImageBitmap(bitmapfotointerior1);
        imageViewFotoInterior2.setImageBitmap(bitmapfotointerior2);
        imageViewFotoInterior3.setImageBitmap(bitmapfotointerior3);
        imageViewFotoInterior4.setImageBitmap(bitmapfotointerior4);




        buttonFotoexterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(1);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri1 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST1);
                }

            }
        });

        buttonFotopanoramica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(2);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri2 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST2);
                }



            }
        });

        buttonFotoesquema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(3);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri3 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST3);
                }


            }
        });

        buttonFototapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(4);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri4 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST4);
                }


            }
        });

        buttonFotointerior1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(5);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri5 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST5);
                }


            }
        });

        buttonFotointerior2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(6);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri6 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST6);
                }

            }
        });

        buttonFotointerior3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(7);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri7 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST7);
                }

            }
        });

        buttonFotointerior4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile=createImageFile(8);
                } catch (IOException ex) {
                    Log.e("error", "error creando archivo");
                }
                if (photoFile != null) {
                    mImageUri8 = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST8);
                }


            }
        });

        return vistafotos;
    }

    private void consultarDatosDB() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {Integer.toString(id)};
        String[] columsexterior = new String[]{Utilidades.CAMPO_FOTOEXTERIOR};
        String[] columspanoramica = new String[]{Utilidades.CAMPO_FOTOPANORAMICA};
        String[] columsesquema = new String[]{ Utilidades.CAMPO_FOTOESQUEMA};
        String[] columstapa = new String[]{ Utilidades.CAMPO_FOTOTAPA};
        String[] columsint1 = new String[]{ Utilidades.CAMPO_FOTOINTERIOR1};
        String[] columsint2 = new String[]{ Utilidades.CAMPO_FOTOINTERIOR2};
        String[] columsint3 = new String[]{ Utilidades.CAMPO_FOTOINTERIOR3};
        String[] columsint4 = new String[]{ Utilidades.CAMPO_FOTOINTERIOR4};



        try {
            Cursor cursorexterior = db.query(Utilidades.TABLA_ALCANTARILLADO, columsexterior, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
            cursorexterior.moveToFirst();
            bytearrayExterior = cursorexterior.getBlob(0);
            bitmapfotoexterior = BitmapFactory.decodeByteArray(bytearrayExterior, 0, bytearrayExterior.length);
            cursorexterior.close();

            Cursor cursorpannoramica = db.query(Utilidades.TABLA_ALCANTARILLADO, columspanoramica, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
            cursorpannoramica.moveToFirst();
            bytearrayPanoramica = cursorpannoramica.getBlob(0);
            bitmapfotopanoramica = BitmapFactory.decodeByteArray(bytearrayPanoramica, 0, bytearrayPanoramica.length);
            cursorpannoramica.close();

            Cursor cursoresquema = db.query(Utilidades.TABLA_ALCANTARILLADO, columsesquema, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
           cursoresquema.moveToFirst();
            bytearrayEsquema = cursoresquema.getBlob(0);
            bitmapfotoesquema = BitmapFactory.decodeByteArray(bytearrayEsquema, 0, bytearrayEsquema.length);
            cursoresquema.close();

            Cursor cursortapa = db.query(Utilidades.TABLA_ALCANTARILLADO, columstapa, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
           cursortapa.moveToFirst();
            bytearrayTapa = cursortapa.getBlob(0);
            bitmapfototapa = BitmapFactory.decodeByteArray(bytearrayTapa, 0, bytearrayTapa.length);
            cursortapa.close();

            Cursor cursorint1 = db.query(Utilidades.TABLA_ALCANTARILLADO, columsint1, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
            cursorint1.moveToFirst();
            bytearrayInterior1 = cursorint1.getBlob(0);
            bitmapfotointerior1 = BitmapFactory.decodeByteArray(bytearrayInterior1, 0, bytearrayInterior1.length);
            cursorint1.close();

            Cursor cursorint2 = db.query(Utilidades.TABLA_ALCANTARILLADO, columsint2, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
            cursorint2.moveToFirst();
            bytearrayInterior2 = cursorint2.getBlob(0);
            bitmapfotointerior2 = BitmapFactory.decodeByteArray(bytearrayInterior2, 0, bytearrayInterior2.length);
            cursorint2.close();

            Cursor cursorint3 = db.query(Utilidades.TABLA_ALCANTARILLADO, columsint3, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
           cursorint3.moveToFirst();
            bytearrayInterior3 = cursorint3.getBlob(0);
            bitmapfotointerior3 = BitmapFactory.decodeByteArray(bytearrayInterior3, 0, bytearrayInterior3.length);
            cursorint3.close();

            Cursor cursorint4 = db.query(Utilidades.TABLA_ALCANTARILLADO, columsint4, Utilidades.CAMPO_ID + " =?" , parametros,null,null,null);
             cursorint4.moveToFirst();
            bytearrayInterior4 = cursorint4.getBlob(0);
            bitmapfotointerior4 = BitmapFactory.decodeByteArray(bytearrayInterior4, 0, bytearrayInterior4.length);
            cursorint4.close();
        }catch (Exception e){

        }
        db.close();
    }

    private File createImageFile(int i) throws IOException {

        String tipo=null;

        switch (i){
            case 1:tipo="Exterior";
            break;
            case 2:tipo="Panoramica";
            break;
            case 3:tipo="Esquema";
            break;
            case 4:tipo="Tapa";
            break;
            case 5:tipo="Interior1";
            break;
            case 6:tipo="Interior2";
            break;
            case 7:tipo="Interior3";
            break;
            case 8:tipo="Interior4";
            break;
        }

        String timestamp = new SimpleDateFormat("yyyMMMdd_HHmmss").format(new Date());
        String imageFileName;
        if (editTextNombreFotos!=null){
            imageFileName = tipo+"_"+editTextNombreFotos.getText()+"_"+ timestamp + "_";
        }else {
            imageFileName = tipo+"_JPEG_"+ timestamp + "_";
        }
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!storageDir.exists()){
            storageDir.mkdir();
        }
        File image = File.createTempFile(imageFileName, ".jpg",storageDir);
        mcurrentPhotoPath = "file:"+image.getAbsolutePath();
        return image;

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==CAMERA_REQUEST1 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoExterior.setImageURI(Uri.parse(mImageUri1.toString()));
                bitmapfotoexterior = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri1);
                imageViewFotoExterior.setImageBitmap(bitmapfotoexterior);
                Bitmap bitmapFoto_Exterior = ((BitmapDrawable)imageViewFotoExterior.getDrawable()).getBitmap();
                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                bitmapFoto_Exterior.compress(Bitmap.CompressFormat.JPEG, 100, stream1);
                bytearrayExterior = stream1.toByteArray();
            }catch (Exception e){
                Log.e("Error","Imagen no asiganada");
            }

        }
        if (requestCode==CAMERA_REQUEST2 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoPanoramica.setImageURI(Uri.parse(mImageUri2.toString()));
                bitmapfotopanoramica = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri2);
                imageViewFotoPanoramica.setImageBitmap(bitmapfotopanoramica);
                Bitmap bitmapFoto_Panoramica = ((BitmapDrawable)imageViewFotoPanoramica.getDrawable()).getBitmap();
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bitmapFoto_Panoramica.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                bytearrayPanoramica = stream2.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST3 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoEsquema.setImageURI(Uri.parse(mImageUri3.toString()));
                bitmapfotoesquema = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri3);
                imageViewFotoEsquema.setImageBitmap(bitmapfotoesquema);
                Bitmap bitmapFoto_Esquema = ((BitmapDrawable)imageViewFotoEsquema.getDrawable()).getBitmap();
                ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
                bitmapFoto_Esquema.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                bytearrayEsquema = stream3.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST4 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoTapa.setImageURI(Uri.parse(mImageUri4.toString()));
                bitmapfototapa = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri4);
                imageViewFotoTapa.setImageBitmap(bitmapfototapa);
                Bitmap bitmapFoto_Tapa = ((BitmapDrawable)imageViewFotoTapa.getDrawable()).getBitmap();
                ByteArrayOutputStream stream4 = new ByteArrayOutputStream();
                bitmapFoto_Tapa.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                bytearrayTapa = stream4.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST5 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoInterior1.setImageURI(Uri.parse(mImageUri5.toString()));
                bitmapfotointerior1 = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri5);
                imageViewFotoInterior1.setImageBitmap(bitmapfotointerior1);
                Bitmap bitmapFoto_Interior1 = ((BitmapDrawable)imageViewFotoInterior1.getDrawable()).getBitmap();
                ByteArrayOutputStream stream5 = new ByteArrayOutputStream();
                bitmapFoto_Interior1.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                bytearrayInterior1 = stream5.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST6 && resultCode == Activity.RESULT_OK ){

            try {
              //  imageViewFotoInterior2.setImageURI(Uri.parse(mImageUri6.toString()));
                bitmapfotointerior2 = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri6);
                imageViewFotoInterior2.setImageBitmap(bitmapfotointerior2);
                Bitmap bitmapFoto_Interior2 = ((BitmapDrawable)imageViewFotoInterior2.getDrawable()).getBitmap();
                ByteArrayOutputStream stream6 = new ByteArrayOutputStream();
                bitmapFoto_Interior2.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                bytearrayInterior2 = stream6.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST7 && resultCode == Activity.RESULT_OK ){

            try {
               // imageViewFotoInterior3.setImageURI(Uri.parse(mImageUri7.toString()));
                bitmapfotointerior3 = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri7);
                imageViewFotoInterior3.setImageBitmap(bitmapfotointerior3);
                Bitmap bitmapFoto_Interior3 = ((BitmapDrawable)imageViewFotoInterior3.getDrawable()).getBitmap();
                ByteArrayOutputStream stream7 = new ByteArrayOutputStream();
                bitmapFoto_Interior3.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
                bytearrayInterior3 = stream7.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
        if (requestCode==CAMERA_REQUEST8 && resultCode == Activity.RESULT_OK ){

            try {
                //imageViewFotoInterior4.setImageURI(Uri.parse(mImageUri8.toString()));
                bitmapfotointerior4 = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), mImageUri8);
                imageViewFotoInterior4.setImageBitmap(bitmapfotointerior4);
                Bitmap bitmapFoto_Interior4 = ((BitmapDrawable)imageViewFotoInterior4.getDrawable()).getBitmap();
                ByteArrayOutputStream stream8 = new ByteArrayOutputStream();
                bitmapFoto_Interior4.compress(Bitmap.CompressFormat.JPEG, 100, stream8);
                bytearrayInterior4 = stream8.toByteArray();
            }catch (Exception e){
                Log.e("Error","Uri not set");
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putParcelable("bitmap1", bitmapfotoexterior);
        outState.putParcelable("bitmap2", bitmapfotopanoramica);
        outState.putParcelable("bitmap3", bitmapfotoesquema);
        outState.putParcelable("bitmap4", bitmapfototapa);
        outState.putParcelable("bitmap5", bitmapfotointerior1);
        outState.putParcelable("bitmap6", bitmapfotointerior2);
        outState.putParcelable("bitmap7", bitmapfotointerior3);
        outState.putParcelable("bitmap8", bitmapfotointerior4);



    }

    public void tomarDatosFotos(){
        Intent intentFotos = getActivity().getIntent();
        Bundle bundleFotos = new Bundle();
        bundleFotos.putByteArray("bytearray1", bytearrayExterior);
        bundleFotos.putByteArray("bytearray2", bytearrayPanoramica);
        bundleFotos.putByteArray("bytearray3", bytearrayEsquema);
        bundleFotos.putByteArray("bytearray4", bytearrayTapa);
        bundleFotos.putByteArray("bytearray5", bytearrayInterior1);
        bundleFotos.putByteArray("bytearray6", bytearrayInterior2);
        bundleFotos.putByteArray("bytearray7", bytearrayInterior3);
        bundleFotos.putByteArray("bytearray8", bytearrayInterior4);

        intentFotos.putExtras(bundleFotos);


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

