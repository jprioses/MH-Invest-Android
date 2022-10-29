package com.example.user.mhinvest;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

import com.example.user.mhinvest.Utilidades.Utilidades;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by User on 27/09/2018.
 */

public class ExportarExcel {
    Context context;

    private int apellidos;
    private int nombres;
    private String fecharespuesta;
    private String fecha;
    private byte[] bytearrayExterior=null;
    private byte[] bytearrayPanoramica;
    private int mh;
    private String ipid;
    private String direccion;
    private String barrio;
    private String geolicalizacion;
    private String sepudoabrir;
    private String motivo;
    private String tipocota;
    private double cotatapa;
    private byte[] bytearrayEsquema;
    private byte[] bytearrayTapa;
    private String tipoalcantarillado;
    private String tipopozo;
    private String excen;
    private double medexcen;
    private double altura;
    private String tramo1;
    private double heje1;
    private String entra1;
    private String conecta1;
    private double diam1;
    private double hcaja1;
    private String distanciabatea1;
    private double hinclinada1;
    private double distanciabase1;
    private double calculo1;
    private double hbatea1;
    private String material1;
    private String estado1;
    private String deformacion1;
    private String tipodeformacion1;
    private String tipoagua1;
    private String tramo2;
    private double heje2;
    private String entra2;
    private String conecta2;
    private double diam2;
    private double hcaja2;
    private String distanciabatea2;
    private double hinclinada2;
    private double distanciabase2;
    private double calculo2;
    private double hbatea2;
    private String material2;
    private String estado2;
    private String deformacion2;
    private String tipodeformacion2;
    private String tipoagua2;
    private String tramo3;
    private double heje3;
    private String entra3;
    private String conecta3;
    private double diam3;
    private double hcaja3;
    private String distanciabatea3;
    private double hinclinada3;
    private double distanciabase3;
    private double calculo3;
    private double hbatea3;
    private String material3;
    private String estado3;
    private String deformacion3;
    private String tipodeformacion3;
    private String tipoagua3;
    private String tramo4;
    private double heje4;
    private String entra4;
    private String conecta4;
    private double diam4;
    private double hcaja4;
    private String distanciabatea4;
    private double hinclinada4;
    private double distanciabase4;
    private double calculo4;
    private double hbatea4;
    private String material4;
    private String estado4;
    private String deformacion4;
    private String tipodeformacion4;
    private String tipoagua4;
    private String tramo5;
    private double heje5;
    private String entra5;
    private String conecta5;
    private double diam5;
    private double hcaja5;
    private String distanciabatea5;
    private double hinclinada5;
    private double distanciabase5;
    private double calculo5;
    private double hbatea5;
    private String material5;
    private String estado5;
    private String deformacion5;
    private String tipodeformacion5;
    private String tipoagua5;
    private String tramo6;
    private double heje6;
    private String entra6;
    private String conecta6;
    private double diam6;
    private double hcaja6;
    private String distanciabatea6;
    private double hinclinada6;
    private double distanciabase6;
    private double calculo6;
    private double hbatea6;
    private String material6;
    private String estado6;
    private String deformacion6;
    private String tipodeformacion6;
    private String tipoagua6;
    private String tapa;
    private String estadotapa;
    private String tipotapa;
    private String observacionestapa;
    private String cuello;
    private String estadocuello;
    private String observacionescuello;
    private String cono;
    private String estadocono;
    private String observacionescono;
    private String cilindro;
    private String materialcilindro;
    private double diamcilindro;
    private String estadocilindro;
    private String escalones;
    private String tipoescalones;
    private String estadoescalones;
    private int cantidadescalones;
    private String cañuela;
    private String estadocañuela;
    private double anchocañuela;
    private String camara;
    private double alturaoidocamara;
    private double diaoidocamara;
    private String observacionesgenerales;
    private String observacionescamara;
    private byte[] bytearrayInterior1;
    private byte[] bytearrayInterior2;
    private byte[] bytearrayInterior3;
    private byte[] bytearrayInterior4;
    private String sumideros;
    private int cantidadsumideros;
    private String campoentrada;




    public ExportarExcel(Context context) {
        this.context = context;
    }



    public void exportDataBaseIntoCSV(int imagenes) {


        String timestamp = new SimpleDateFormat("yyyMMMdd_HHmmss").format(new Date());
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        ConexionSQLiteHelper dbHelper = new ConexionSQLiteHelper(context);
        Workbook workbook = new HSSFWorkbook();

        CreationHelper helper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Hoja 1");


       // File directory = new File(storageDir.getAbsolutePath());
        //create directory if not exist
        if (!storageDir.isDirectory()) {
            storageDir.mkdirs();
        }


            SQLiteDatabase db = dbHelper.getReadableDatabase();

            File file = new File(storageDir, "Investigacion_MH_Rionegro_"+timestamp+".xls");
            Cursor cursorcolumnas = db.rawQuery("select * from "+Utilidades.TABLA_ALCANTARILLADO,null);

            Row headerrow = sheet.createRow(0) ;

            for (int i=1;i<151;i++){
                Cell cell = headerrow.createCell(i-1);
                cell.setCellValue(cursorcolumnas.getColumnName(i));
            }
            cursorcolumnas.close();

            String[] columsdif = new String[]{Utilidades.CAMPO_ID,Utilidades.CAMPO_GEOLOCALIZACION,Utilidades.CAMPO_CAMPOENTRADA,Utilidades.CAMPO_DISTANCIABATEA1, Utilidades.CAMPO_HINCLINADA1, Utilidades.CAMPO_DISTANCIABASE1, Utilidades.CAMPO_CALCULO1,
                    Utilidades.CAMPO_DISTANCIABATEA2, Utilidades.CAMPO_HINCLINADA2, Utilidades.CAMPO_DISTANCIABASE2, Utilidades.CAMPO_CALCULO2,
                    Utilidades.CAMPO_DISTANCIABATEA3, Utilidades.CAMPO_HINCLINADA3, Utilidades.CAMPO_DISTANCIABASE3, Utilidades.CAMPO_CALCULO3,
                    Utilidades.CAMPO_DISTANCIABATEA4, Utilidades.CAMPO_HINCLINADA4, Utilidades.CAMPO_DISTANCIABASE4, Utilidades.CAMPO_CALCULO4,
                    Utilidades.CAMPO_DISTANCIABATEA5, Utilidades.CAMPO_HINCLINADA5, Utilidades.CAMPO_DISTANCIABASE5, Utilidades.CAMPO_CALCULO5,
                    Utilidades.CAMPO_DISTANCIABATEA6, Utilidades.CAMPO_HINCLINADA6, Utilidades.CAMPO_DISTANCIABASE6, Utilidades.CAMPO_CALCULO6,Utilidades.CAMPO_ENTRA1,Utilidades.CAMPO_ENTRA2,Utilidades.CAMPO_ENTRA3,
                    Utilidades.CAMPO_ENTRA4,Utilidades.CAMPO_ENTRA5,
                    Utilidades.CAMPO_ENTRA6,Utilidades.CAMPO_HEJE1,
                    Utilidades.CAMPO_HEJE2,Utilidades.CAMPO_HEJE3,
                    Utilidades.CAMPO_HEJE4,Utilidades.CAMPO_HEJE5,
                    Utilidades.CAMPO_HEJE6, Utilidades.CAMPO_CONECTA1,
                    Utilidades.CAMPO_CONECTA2,Utilidades.CAMPO_CONECTA3,
                    Utilidades.CAMPO_CONECTA4,Utilidades.CAMPO_CONECTA5,
                    Utilidades.CAMPO_CONECTA6, Utilidades.CAMPO_DIAM1,
                    Utilidades.CAMPO_DIAM2, Utilidades.CAMPO_DIAM3,
                    Utilidades.CAMPO_DIAM4, Utilidades.CAMPO_DIAM5,
                    Utilidades.CAMPO_DIAM6,  Utilidades.CAMPO_HCAJA1,
                    Utilidades.CAMPO_HCAJA2,Utilidades.CAMPO_HCAJA3,
                    Utilidades.CAMPO_HCAJA4,Utilidades.CAMPO_HCAJA5,
                    Utilidades.CAMPO_HCAJA6,Utilidades.CAMPO_HBATEA1,
                    Utilidades.CAMPO_HBATEA2,Utilidades.CAMPO_HBATEA3,
                    Utilidades.CAMPO_HBATEA4,Utilidades.CAMPO_HBATEA5,
                    Utilidades.CAMPO_HBATEA6,Utilidades.CAMPO_MATERIAL1,
                    Utilidades.CAMPO_MATERIAL2 ,Utilidades.CAMPO_MATERIAL3 ,
                    Utilidades.CAMPO_MATERIAL4 ,Utilidades.CAMPO_MATERIAL5 ,
                    Utilidades.CAMPO_MATERIAL6, Utilidades.CAMPO_ESTADO1,
                    Utilidades.CAMPO_ESTADO2,Utilidades.CAMPO_ESTADO3,
                    Utilidades.CAMPO_ESTADO4,Utilidades.CAMPO_ESTADO5,
                    Utilidades.CAMPO_ESTADO6, Utilidades.CAMPO_DEFORMACION1,
                    Utilidades.CAMPO_DEFORMACION2, Utilidades.CAMPO_DEFORMACION3,
                    Utilidades.CAMPO_DEFORMACION4, Utilidades.CAMPO_DEFORMACION5,
                    Utilidades.CAMPO_DEFORMACION6,  Utilidades.CAMPO_TIPODEFORMACION1,
                    Utilidades.CAMPO_TIPODEFORMACION2, Utilidades.CAMPO_TIPODEFORMACION3,
                    Utilidades.CAMPO_TIPODEFORMACION4, Utilidades.CAMPO_TIPODEFORMACION5,
                    Utilidades.CAMPO_TIPODEFORMACION6,  Utilidades.CAMPO_TIPOAGUA1,
                    Utilidades.CAMPO_TIPOAGUA2,Utilidades.CAMPO_TIPOAGUA3,
                    Utilidades.CAMPO_TIPOAGUA4,Utilidades.CAMPO_TIPOAGUA5,
                    Utilidades.CAMPO_TIPOAGUA6,Utilidades.CAMPO_TAPA,
                    Utilidades.CAMPO_ESTADOTAPA,Utilidades.CAMPO_TIPOTAPA,
                    Utilidades.CAMPO_OBSERVACIONESTAPA,
                    Utilidades.CAMPO_CUELLO, Utilidades.CAMPO_ESTADOCUELLO,
                    Utilidades.CAMPO_OBSERVACIONESCUELLO, Utilidades.CAMPO_CONO,
                    Utilidades.CAMPO_ESTADOCONO, Utilidades.CAMPO_OBSERVACIONESCONO,
                    Utilidades.CAMPO_CILINDRO, Utilidades.CAMPO_ESTADOCILINDRO,
                    Utilidades.CAMPO_MATERIALCILINDRO, Utilidades.CAMPO_DIAMETROCILINDRO,
                    Utilidades.CAMPO_ESCALONES, Utilidades.CAMPO_ESTADOESCALONES,
                    Utilidades.CAMPO_TIPOESCALONES, Utilidades.CAMPO_CANTIDADESCALONES,
                    Utilidades.CAMPO_CAÑUELA,  Utilidades.CAMPO_ESTADOCAÑUELA,
                    Utilidades.CAMPO_ANCHOCAÑUELA,  Utilidades.CAMPO_CAMARA,
                    Utilidades.CAMPO_DIAMETROOIDOCAMARA,  Utilidades.CAMPO_ALTURAOIDOCAMARA,
                    Utilidades.CAMPO_OBSERVACIONESGENERALES,
                    Utilidades.CAMPO_OBSERVACIONADICIONAL,Utilidades.CAMPO_FECHA,Utilidades.CAMPO_DIRECCION,Utilidades.CAMPO_BARRIO, Utilidades.CAMPO_MH, Utilidades.CAMPO_IPID, Utilidades.CAMPO_SEPUDOABRIR, Utilidades.CAMPO_MOTIVO, Utilidades.CAMPO_TIPOCOTA, Utilidades.CAMPO_COTATAPA, Utilidades.CAMPO_TIPOALCANTARILLADO,Utilidades.CAMPO_TIPOPOZO, Utilidades.CAMPO_EXCENTRICIDAD, Utilidades.CAMPO_MEDEXCENTRICIDAD, Utilidades.CAMPO_ALTURA, Utilidades.CAMPO_SUMIDEROS, Utilidades.CAMPO_CANTIDADSUMIDEROS };

            Cursor cursordif = db.query(Utilidades.TABLA_ALCANTARILLADO,columsdif,null,null,null,null,null);

            if (cursordif.moveToFirst()) {
                    do {
                        Row row = sheet.createRow(cursordif.getPosition()+1);
                        int fechap = cursordif.getColumnIndex(Utilidades.CAMPO_FECHA);
                        int diereccionp = cursordif.getColumnIndex(Utilidades.CAMPO_DIRECCION);
                        int barriop = cursordif.getColumnIndex(Utilidades.CAMPO_BARRIO);
                        int mhp = cursordif.getColumnIndex(Utilidades.CAMPO_MH);
                        int ipidp = cursordif.getColumnIndex(Utilidades.CAMPO_IPID);
                        int sepudoabrirp= cursordif.getColumnIndex(Utilidades.CAMPO_SEPUDOABRIR);
                        int motivop = cursordif.getColumnIndex(Utilidades.CAMPO_MOTIVO);
                        int tipocotap = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOCOTA);
                        int cotatapap = cursordif.getColumnIndex(Utilidades.CAMPO_COTATAPA);
                        int tipoalcantarilladop= cursordif.getColumnIndex(Utilidades.CAMPO_TIPOALCANTARILLADO);
                        int tipopozop = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOPOZO);
                        int excenp = cursordif.getColumnIndex(Utilidades.CAMPO_EXCENTRICIDAD);
                        int medexcenp =cursordif.getColumnIndex(Utilidades.CAMPO_MEDEXCENTRICIDAD);
                        int alturap = cursordif.getColumnIndex(Utilidades.CAMPO_ALTURA);
                        int sumiderosp = cursordif.getColumnIndex(Utilidades.CAMPO_SUMIDEROS);
                        int cantidadsumiderosp = cursordif.getColumnIndex(Utilidades.CAMPO_CANTIDADSUMIDEROS);

                        int tapap= cursordif.getColumnIndex( Utilidades.CAMPO_TAPA);
                        int estadotapap= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOTAPA);
                        int tipotapap= cursordif.getColumnIndex( Utilidades.CAMPO_TIPOTAPA);
                        int observacionestapap= cursordif.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESTAPA);
                        int cuellop= cursordif.getColumnIndex( Utilidades.CAMPO_CUELLO);
                        int estadocuellop= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOCUELLO);
                        int observacionescuellop= cursordif.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESCUELLO);
                        int conop= cursordif.getColumnIndex( Utilidades.CAMPO_CONO);
                        int estadoconop= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOCONO);
                        int observacionesconop= cursordif.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESCONO);
                        int cilindrop= cursordif.getColumnIndex( Utilidades.CAMPO_CILINDRO);
                        int estadocilindrop= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOCILINDRO);
                        int materialcilindrop= cursordif.getColumnIndex( Utilidades.CAMPO_MATERIALCILINDRO);
                        int diamcilindrop= cursordif.getColumnIndex( Utilidades.CAMPO_DIAMETROCILINDRO);
                        int escalonesp= cursordif.getColumnIndex( Utilidades.CAMPO_ESCALONES);
                        int estadoescalonesp= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOESCALONES);
                        int tipoescalonesp= cursordif.getColumnIndex( Utilidades.CAMPO_TIPOESCALONES);
                        int cantidadescalonesp= cursordif.getColumnIndex( Utilidades.CAMPO_CANTIDADESCALONES);
                        int cañuelap= cursordif.getColumnIndex( Utilidades.CAMPO_CAÑUELA);
                        int estadocañuelap= cursordif.getColumnIndex( Utilidades.CAMPO_ESTADOCAÑUELA);
                        int anchocañuelap= cursordif.getColumnIndex( Utilidades.CAMPO_ANCHOCAÑUELA);
                        int camarap= cursordif.getColumnIndex( Utilidades.CAMPO_CAMARA);
                        int dimoidocamarap= cursordif.getColumnIndex( Utilidades.CAMPO_DIAMETROOIDOCAMARA);
                        int alturaoidocamarap= cursordif.getColumnIndex( Utilidades.CAMPO_ALTURAOIDOCAMARA);
                        int observacionesgeneralesp= cursordif.getColumnIndex( Utilidades.CAMPO_OBSERVACIONESGENERALES);
                        int observacionesadionalesp= cursordif.getColumnIndex( Utilidades.CAMPO_OBSERVACIONADICIONAL);

                        int entra1p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA1);
                        int entra2p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA2);
                        int entra3p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA3);
                        int entra4p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA4);
                        int entra5p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA5);
                        int entra6p = cursordif.getColumnIndex(Utilidades.CAMPO_ENTRA6);

                        int heje1p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE1);
                        int heje2p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE2);
                        int heje3p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE3);
                        int heje4p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE4);
                        int heje5p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE5);
                        int heje6p = cursordif.getColumnIndex(Utilidades.CAMPO_HEJE6);

                        int conecta1p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA1);
                        int conecta2p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA2);
                        int conecta3p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA3);
                        int conecta4p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA4);
                        int conecta5p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA5);
                        int conecta6p = cursordif.getColumnIndex(Utilidades.CAMPO_CONECTA6);

                        int diam1p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM1);
                        int diam2p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM2);
                        int diam3p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM3);
                        int diam4p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM4);
                        int diam5p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM5);
                        int diam6p = cursordif.getColumnIndex(Utilidades.CAMPO_DIAM6);

                        int hcaja1p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA1);
                        int hcaja2p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA2);
                        int hcaja3p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA3);
                        int hcaja4p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA4);
                        int hcaja5p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA5);
                        int hcaja6p = cursordif.getColumnIndex(Utilidades.CAMPO_HCAJA6);

                        int hbatea1p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA1);
                        int hbatea2p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA2);
                        int hbatea3p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA3);
                        int hbatea4p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA4);
                        int hbatea5p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA5);
                        int hbatea6p = cursordif.getColumnIndex(Utilidades.CAMPO_HBATEA6);

                        int material1p = cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL1);
                        int material2p = cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL2);
                        int material3p =cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL3);
                        int material4p = cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL4);
                        int material5p = cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL5);
                        int material6p = cursordif.getColumnIndex(Utilidades.CAMPO_MATERIAL6);

                        int estado1p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO1);
                        int estado2p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO2);
                        int estado3p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO3);
                        int estado4p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO4);
                        int estado5p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO5);
                        int estado6p = cursordif.getColumnIndex(Utilidades.CAMPO_ESTADO6);

                        int deformacion1p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION1);
                        int deformacion2p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION2);
                        int deformacion3p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION3);
                        int deformacion4p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION4);
                        int deformacion5p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION5);
                        int deformacion6p = cursordif.getColumnIndex(Utilidades.CAMPO_DEFORMACION6);

                        int tipodeformacion1p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION1);
                        int tipodeformacion2p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION2);
                        int tipodeformacion3p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION3);
                        int tipodeformacion4p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION4);
                        int tipodeformacion5p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION5);
                        int tipodeformacion6p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPODEFORMACION6);

                        int tipoagua1p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA1);
                        int tipoagua2p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA2);
                        int tipoagua3p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA3);
                        int tipoagua4p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA4);
                        int tipoagua5p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA5);
                        int tipoagua6p = cursordif.getColumnIndex(Utilidades.CAMPO_TIPOAGUA6);

                        int campoentradap = cursordif.getColumnIndex(Utilidades.CAMPO_CAMPOENTRADA);
                        int distanciabatea1p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA1);
                        int hinclinada1p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA1);
                        int distanciabase1p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE1);
                        int calculo1p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO1);
                        int distanciabatea2p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA2);
                        int hinclinada2p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA2);
                        int distanciabase2p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE2);
                        int calculo2p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO3);
                        int distanciabatea3p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA3);
                        int hinclinada3p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA3);
                        int distanciabase3p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE3);
                        int calculo3p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO4);
                        int distanciabatea4p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA4);
                        int hinclinada4p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA4);
                        int distanciabase4p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE4);
                        int calculo4p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO4);
                        int distanciabatea5p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA5);
                        int hinclinada5p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA5);
                        int distanciabase5p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE5);
                        int calculo5p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO5);
                        int distanciabatea6p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABATEA6);
                        int hinclinada6p = cursordif.getColumnIndex(Utilidades.CAMPO_HINCLINADA6);
                        int distanciabase6p = cursordif.getColumnIndex(Utilidades.CAMPO_DISTANCIABASE6);
                        int calculo6p = cursordif.getColumnIndex(Utilidades.CAMPO_CALCULO6);
                        int gelocalizacionp = cursordif.getColumnIndex(Utilidades.CAMPO_GEOLOCALIZACION);




                           geolicalizacion = cursordif.getString(gelocalizacionp);
                           campoentrada = cursordif.getString(campoentradap);
                           distanciabatea1 = cursordif.getString(distanciabatea1p);
                           hinclinada1 = cursordif.getDouble(hinclinada1p);
                           distanciabase1 = cursordif.getDouble(distanciabase1p);
                           calculo1 = cursordif.getDouble(calculo1p);
                           distanciabatea2 = cursordif.getString(distanciabatea2p);
                           hinclinada2 = cursordif.getDouble(hinclinada2p);
                           distanciabase2 = cursordif.getDouble(distanciabase2p);
                           calculo2 = cursordif.getDouble(calculo2p);
                           distanciabatea3 = cursordif.getString(distanciabatea3p);
                           hinclinada3 = cursordif.getDouble(hinclinada3p);
                           distanciabase3 = cursordif.getDouble(distanciabase3p);
                           calculo3 = cursordif.getDouble(calculo3p);
                           distanciabatea4 = cursordif.getString(distanciabatea4p);
                           hinclinada4 = cursordif.getDouble(hinclinada4p);
                           distanciabase4 = cursordif.getDouble(distanciabase4p);
                           calculo4 = cursordif.getDouble(calculo4p);
                           distanciabatea5 = cursordif.getString(distanciabatea5p);
                           hinclinada5 = cursordif.getDouble(hinclinada5p);
                           distanciabase5 = cursordif.getDouble(distanciabase5p);
                           calculo5 = cursordif.getDouble(calculo5p);
                           distanciabatea6 = cursordif.getString(distanciabatea6p);
                           hinclinada6 = cursordif.getDouble(hinclinada6p);
                           distanciabase6 = cursordif.getDouble(distanciabase6p);
                           calculo6 = cursordif.getDouble(calculo6p);


                           fecha =cursordif.getString(fechap);
                           fecharespuesta = cursordif.getString(fechap);
                           direccion = cursordif.getString(diereccionp);
                           barrio = cursordif.getString(barriop);
                           mh = cursordif.getInt(mhp);
                           ipid = cursordif.getString(ipidp);
                           sepudoabrir = cursordif.getString(sepudoabrirp);
                           motivo = cursordif.getString(motivop);
                           tipocota = cursordif.getString(tipocotap);
                           cotatapa = cursordif.getDouble(cotatapap);
                           tipoalcantarillado = cursordif.getString(tipoalcantarilladop);
                           tipopozo = cursordif.getString(tipopozop);
                           excen = cursordif.getString(excenp);
                           medexcen = cursordif.getDouble(medexcenp);
                           altura = cursordif.getDouble(alturap);
                           sumideros = cursordif.getString(sumiderosp);
                           cantidadsumideros = cursordif.getInt(cantidadsumiderosp);


                           tapa = cursordif.getString(tapap);
                           cuello = cursordif.getString(cuellop);
                           cono = cursordif.getString(conop);
                           cilindro = cursordif.getString(cilindrop);
                           escalones = cursordif.getString(escalonesp);
                           cañuela = cursordif.getString(cañuelap);
                           camara = cursordif.getString(camarap);
                           estadotapa = cursordif.getString(estadotapap);
                           estadocuello = cursordif.getString(estadocuellop);
                           estadocono = cursordif.getString(estadoconop);
                           estadocilindro = cursordif.getString(estadocilindrop);
                           estadoescalones = cursordif.getString(estadoescalonesp);
                           estadocañuela = cursordif.getString(estadocañuelap);
                           tipotapa = cursordif.getString(tipotapap);
                           materialcilindro = cursordif.getString(materialcilindrop);
                           tipoescalones = cursordif.getString(tipoescalonesp);
                           observacionestapa = cursordif.getString(observacionestapap);
                           observacionescuello = cursordif.getString(observacionescuellop);
                           observacionescono = cursordif.getString(observacionesconop);

                           observacionesgenerales = cursordif.getString(observacionesgeneralesp);
                           observacionescamara = cursordif.getString(observacionesadionalesp);
                           diamcilindro = cursordif.getDouble(diamcilindrop);
                           cantidadescalones = cursordif.getInt(cantidadescalonesp);
                           anchocañuela = cursordif.getDouble(anchocañuelap);
                           diaoidocamara = cursordif.getDouble(dimoidocamarap);
                           alturaoidocamara = cursordif.getDouble(alturaoidocamarap);

                           entra1 = cursordif.getString(entra1p);
                           entra2 = cursordif.getString(entra2p);
                           entra3 = cursordif.getString(entra3p);
                           entra4 = cursordif.getString(entra4p);
                           entra5 = cursordif.getString(entra5p);
                           entra6 = cursordif.getString(entra6p);

                           heje1 = cursordif.getDouble(heje1p);
                           heje2 = cursordif.getDouble(heje2p);
                           heje3 = cursordif.getDouble(heje3p);
                           heje4 = cursordif.getDouble(heje4p);
                           heje5 = cursordif.getDouble(heje5p);
                           heje6 = cursordif.getDouble(heje6p);

                           conecta1 = cursordif.getString(conecta1p);
                           conecta2 = cursordif.getString(conecta2p);
                           conecta3 = cursordif.getString(conecta3p);
                           conecta4 = cursordif.getString(conecta4p);
                           conecta5 = cursordif.getString(conecta5p);
                           conecta6 = cursordif.getString(conecta6p);

                           diam1 = cursordif.getDouble(diam1p);
                           diam2 = cursordif.getDouble(diam2p);
                           diam3 = cursordif.getDouble(diam3p);
                           diam4 = cursordif.getDouble(diam4p);
                           diam5 = cursordif.getDouble(diam5p);
                           diam6 = cursordif.getDouble(diam6p);

                           hcaja1 = cursordif.getDouble(hcaja1p);
                           hcaja2 = cursordif.getDouble(hcaja2p);
                           hcaja3 = cursordif.getDouble(hcaja3p);
                           hcaja4 = cursordif.getDouble(hcaja4p);
                           hcaja5 = cursordif.getDouble(hcaja5p);
                           hcaja6 = cursordif.getDouble(hcaja6p);

                           hbatea1 = cursordif.getDouble(hbatea1p);
                           hbatea2 = cursordif.getDouble(hbatea2p);
                           hbatea3 = cursordif.getDouble(hbatea3p);
                           hbatea4 = cursordif.getDouble(hbatea4p);
                           hbatea5 = cursordif.getDouble(hbatea5p);
                           hbatea6 = cursordif.getDouble(hbatea6p);

                           material1 = cursordif.getString(material1p);
                           material2 = cursordif.getString(material2p);
                           material3 = cursordif.getString(material3p);
                           material4 = cursordif.getString(material4p);
                           material5 = cursordif.getString(material5p);
                           material6 = cursordif.getString(material6p);

                           estado1 = cursordif.getString(estado1p);
                           estado2 = cursordif.getString(estado2p);
                           estado3 = cursordif.getString(estado3p);
                           estado4 = cursordif.getString(estado4p);
                           estado5 = cursordif.getString(estado5p);
                           estado6 = cursordif.getString(estado6p);

                           deformacion1 = cursordif.getString(deformacion1p);
                           deformacion2 = cursordif.getString(deformacion2p);
                           deformacion3 = cursordif.getString(deformacion3p);
                           deformacion4 = cursordif.getString(deformacion4p);
                           deformacion5 = cursordif.getString(deformacion5p);
                           deformacion6 = cursordif.getString(deformacion6p);

                           tipodeformacion1 = cursordif.getString(tipodeformacion1p);
                           tipodeformacion2 = cursordif.getString(tipodeformacion2p);
                           tipodeformacion3 = cursordif.getString(tipodeformacion3p);
                           tipodeformacion4 = cursordif.getString(tipodeformacion4p);
                           tipodeformacion5 = cursordif.getString(tipodeformacion5p);
                           tipodeformacion6 = cursordif.getString(tipodeformacion6p);

                           tipoagua1 = cursordif.getString(tipoagua1p);
                           tipoagua2 = cursordif.getString(tipoagua2p);
                           tipoagua3 = cursordif.getString(tipoagua3p);
                           tipoagua4 = cursordif.getString(tipoagua4p);
                           tipoagua5 = cursordif.getString(tipoagua5p);
                           tipoagua6 = cursordif.getString(tipoagua6p);


                        Cell celda1 = row.createCell(0); Cell celda31= row.createCell(30); Cell celda63 = row.createCell(62); Cell celda94 = row.createCell(93); Cell celda125 = row.createCell(124);
                        Cell celda62 = row.createCell(61); Cell celda32= row.createCell(31); Cell celda64 = row.createCell(63); Cell celda95 = row.createCell(94); Cell celda126 = row.createCell(125);
                        Cell celda2 = row.createCell(1); Cell celda33= row.createCell(32); Cell celda65 = row.createCell(64); Cell celda96 = row.createCell(95); Cell celda127 = row.createCell(126);
                        Cell celda3 = row.createCell(2); Cell celda34= row.createCell(33); Cell celda66 = row.createCell(65); Cell celda97 = row.createCell(96); Cell celda128 = row.createCell(127);
                        Cell celda4 = row.createCell(3); Cell celda35= row.createCell(34); Cell celda67 = row.createCell(66); Cell celda98 = row.createCell(97); Cell celda129 = row.createCell(128);
                        Cell celda5 = row.createCell(4); Cell celda36= row.createCell(35); Cell celda68= row.createCell(67); Cell celda99 = row.createCell(98); Cell celda130 = row.createCell(129);
                        Cell celda6 = row.createCell(5); Cell celda37= row.createCell(36); Cell celda69= row.createCell(68); Cell celda100 = row.createCell(99); Cell celda131 = row.createCell(130);
                        Cell celda7 = row.createCell(6); Cell celda38= row.createCell(37); Cell celda70 = row.createCell(69); Cell celda101 = row.createCell(100); Cell celda132 = row.createCell(131);
                        Cell celda8 = row.createCell(7); Cell celda39= row.createCell(38); Cell celda71 = row.createCell(70); Cell celda102 = row.createCell(101); Cell celda133 = row.createCell(132);
                        Cell celda9 = row.createCell(8); Cell celda40= row.createCell(39); Cell celda72 = row.createCell(71); Cell celda103 = row.createCell(102); Cell celda134 = row.createCell(133);
                        Cell celda10 = row.createCell(9); Cell celda41= row.createCell(40); Cell celda73 = row.createCell(72); Cell celda104 = row.createCell(103); Cell celda135 = row.createCell(134);
                        Cell celda11 = row.createCell(10); Cell celda42= row.createCell(41); Cell celda74 = row.createCell(73); Cell celda105 = row.createCell(104); Cell celda136 = row.createCell(135);
                        Cell celda12 = row.createCell(11); Cell celda43= row.createCell(42); Cell celda75 = row.createCell(74); Cell celda106 = row.createCell(105); Cell celda137 = row.createCell(136);
                        Cell celda13 = row.createCell(12); Cell celda44= row.createCell(43); Cell celda76= row.createCell(75); Cell celda107 = row.createCell(106); Cell celda138 = row.createCell(137);
                        Cell celda14 = row.createCell(13); Cell celda45= row.createCell(44); Cell celda77 = row.createCell(76); Cell celda108 = row.createCell(107); Cell celda139 = row.createCell(138);
                        Cell celda15 = row.createCell(14); Cell celda46= row.createCell(45); Cell celda78 = row.createCell(77); Cell celda109 = row.createCell(108); Cell celda140 = row.createCell(139);
                        Cell celda16 = row.createCell(15); Cell celda47= row.createCell(46); Cell celda79 = row.createCell(78); Cell celda110 = row.createCell(109); Cell celda141 = row.createCell(140);
                        Cell celda17 = row.createCell(16); Cell celda48= row.createCell(47); Cell celda80 = row.createCell(79); Cell celda111 = row.createCell(110); Cell celda142 = row.createCell(141);
                        Cell celda18 = row.createCell(17); Cell celda49= row.createCell(48); Cell celda81 = row.createCell(80); Cell celda112 = row.createCell(111); Cell celda143 = row.createCell(142);
                        Cell celda19 = row.createCell(18); Cell celda50= row.createCell(49); Cell celda82 = row.createCell(81); Cell celda113 = row.createCell(112); Cell celda144 = row.createCell(143);
                        Cell celda20 = row.createCell(19); Cell celda51= row.createCell(50); Cell celda83 = row.createCell(82); Cell celda114 = row.createCell(113); Cell celda145 = row.createCell(144);
                        Cell celda21 = row.createCell(20); Cell celda52= row.createCell(51); Cell celda84 = row.createCell(83); Cell celda115 = row.createCell(114); Cell celda146 = row.createCell(145);
                        Cell celda22 = row.createCell(21); Cell celda53= row.createCell(52); Cell celda85= row.createCell(84); Cell celda116 = row.createCell(115); Cell celda147 = row.createCell(146);
                        Cell celda23 = row.createCell(22); Cell celda54 = row.createCell(53); Cell celda86 = row.createCell(85); Cell celda117 = row.createCell(116); Cell celda148 = row.createCell(147);
                        Cell celda24 = row.createCell(23); Cell celda55= row.createCell(55); Cell celda87 = row.createCell(86); Cell celda118 = row.createCell(117); Cell celda149 = row.createCell(148);
                        Cell celda25 = row.createCell(24); Cell celda56= row.createCell(55); Cell celda88 = row.createCell(87); Cell celda119 = row.createCell(118); Cell celda150 = row.createCell(149);
                        Cell celda26 = row.createCell(25); Cell celda57= row.createCell(56); Cell celda89= row.createCell(88); Cell celda120 = row.createCell(119); Cell celda151 = row.createCell(150);
                        Cell celda27 = row.createCell(26); Cell celda58= row.createCell(57); Cell celda90 = row.createCell(89); Cell celda121 = row.createCell(120); Cell celda152 = row.createCell(151);
                        Cell celda28 = row.createCell(27); Cell celda59= row.createCell(58); Cell celda91 = row.createCell(90); Cell celda122 = row.createCell(121); Cell celda153 = row.createCell(152);
                        Cell celda29 = row.createCell(28); Cell celda60= row.createCell(59); Cell celda92= row.createCell(91); Cell celda123 = row.createCell(122); Cell celda154 = row.createCell(153);
                        Cell celda30 = row.createCell(29); Cell celda61= row.createCell(60); Cell celda93 = row.createCell(92); Cell celda124 = row.createCell(123); Cell celda155 = row.createCell(154);


                        celda1.setCellValue(apellidos);
                        celda2.setCellValue(nombres);
                        celda3.setCellValue(fecharespuesta);
                        celda4.setCellValue(fecha);
                        celda7.setCellValue(mh);
                        celda8.setCellValue(ipid);
                        celda9.setCellValue(direccion);
                        celda10.setCellValue(barrio);
                        celda11.setCellValue(geolicalizacion);
                        celda12.setCellValue(sepudoabrir);
                        celda13.setCellValue(motivo);
                        celda14.setCellValue(tipocota);
                        celda15.setCellValue(cotatapa);
                        celda18.setCellValue(tipoalcantarillado);
                        celda19.setCellValue(tipopozo);
                        celda20.setCellValue(excen);
                        celda21.setCellValue(medexcen);
                        celda22.setCellValue(altura);
                        celda23.setCellValue(tramo1);
                        celda24.setCellValue(heje1);
                        celda25.setCellValue(entra1);
                        celda26.setCellValue(conecta1);
                        celda27.setCellValue(diam1);
                        celda28.setCellValue(hcaja1);
                        celda29.setCellValue(distanciabatea1);
                        celda30.setCellValue(hinclinada1);
                        celda31.setCellValue(distanciabase1);
                        celda32.setCellValue(calculo1);
                        celda33.setCellValue(hbatea1);
                        celda34.setCellValue(material1);
                        celda35.setCellValue(estado1);
                        celda36.setCellValue(deformacion1);
                        celda37.setCellValue(tipodeformacion1);
                        celda38.setCellValue(tipoagua1);
                        celda39.setCellValue(tramo2);
                        celda40.setCellValue(heje2);
                        celda41.setCellValue(entra2);
                        celda42.setCellValue(conecta2);
                        celda43.setCellValue(diam2);
                        celda44.setCellValue(hcaja2);
                        celda45.setCellValue(distanciabatea2);
                        celda46.setCellValue(hinclinada2);
                        celda47.setCellValue(distanciabase2);
                        celda48.setCellValue(calculo2);
                        celda49.setCellValue(hbatea2);
                        celda50.setCellValue(material2);
                        celda51.setCellValue(estado2);
                        celda52.setCellValue(deformacion2);
                        celda53.setCellValue(tipodeformacion2);
                        celda54.setCellValue(tipoagua2);
                        celda55.setCellValue(tramo3);
                        celda56.setCellValue(heje3);
                        celda57.setCellValue(entra3);
                        celda58.setCellValue(conecta3);
                        celda59.setCellValue(diam3);
                        celda60.setCellValue(hcaja3);
                        celda61.setCellValue(distanciabatea3);
                        celda62.setCellValue(hinclinada3);
                        celda63.setCellValue(distanciabase3);
                        celda64.setCellValue(calculo3);
                        celda65.setCellValue(hbatea3);
                        celda66.setCellValue(material3);
                        celda67.setCellValue(estado3);
                        celda68.setCellValue(deformacion3);
                        celda69.setCellValue(tipodeformacion3);
                        celda70.setCellValue(tipoagua3);
                        celda71.setCellValue(tramo4);
                        celda72.setCellValue(heje4);
                        celda73.setCellValue(entra4);
                        celda74.setCellValue(conecta4);
                        celda75.setCellValue(diam4);
                        celda76.setCellValue(hcaja4);
                        celda77.setCellValue(distanciabatea4);
                        celda78.setCellValue(hinclinada4);
                        celda79.setCellValue(distanciabase4);
                        celda80.setCellValue(calculo4);
                        celda81.setCellValue(hbatea4);
                        celda82.setCellValue(material4);
                        celda83.setCellValue(estado4);
                        celda84.setCellValue(deformacion4);
                        celda85.setCellValue(tipodeformacion4);
                        celda86.setCellValue(tipoagua4);
                        celda87.setCellValue(tramo5);
                        celda88.setCellValue(heje5);
                        celda89.setCellValue(entra5);
                        celda90.setCellValue(conecta5);
                        celda91.setCellValue(diam5);
                        celda92.setCellValue(hcaja5);
                        celda93.setCellValue(distanciabatea5);
                        celda94.setCellValue(hinclinada5);
                        celda95.setCellValue(distanciabase5);
                        celda96.setCellValue(calculo5);
                        celda97.setCellValue(hbatea5);
                        celda98.setCellValue(material5);
                        celda99.setCellValue(estado5);
                        celda100.setCellValue(deformacion5);
                        celda101.setCellValue(tipodeformacion5);
                        celda102.setCellValue(tipoagua5);
                        celda103.setCellValue(tramo6);
                        celda104.setCellValue(heje6);
                        celda105.setCellValue(entra6);
                        celda106.setCellValue(conecta6);
                        celda107.setCellValue(diam6);
                        celda108.setCellValue(hcaja6);
                        celda109.setCellValue(distanciabatea6);
                        celda110.setCellValue(hinclinada6);
                        celda111.setCellValue(distanciabase6);
                        celda112.setCellValue(calculo6);
                        celda113.setCellValue(hbatea6);
                        celda114.setCellValue(material6);
                        celda115.setCellValue(estado6);
                        celda116.setCellValue(deformacion6);
                        celda117.setCellValue(tipodeformacion6);
                        celda118.setCellValue(tipoagua6);
                        celda119.setCellValue(tapa);
                        celda120.setCellValue(estadotapa);
                        celda121.setCellValue(tipotapa);
                        celda122.setCellValue(observacionestapa);
                        celda123.setCellValue(cuello);
                        celda124.setCellValue(estadocuello);
                        celda125.setCellValue(observacionescuello);
                        celda126.setCellValue(cono);
                        celda127.setCellValue(estadocono);
                        celda128.setCellValue(observacionescono);
                        celda129.setCellValue(cilindro);
                        celda130.setCellValue(materialcilindro);
                        celda131.setCellValue(diamcilindro);
                        celda132.setCellValue(estadocilindro);
                        celda133.setCellValue(escalones);
                        celda134.setCellValue(tipoescalones);
                        celda135.setCellValue(estadoescalones);
                        celda136.setCellValue(cantidadescalones);
                        celda137.setCellValue(cañuela);
                        celda138.setCellValue(estadocañuela);
                        celda139.setCellValue(anchocañuela);
                        celda140.setCellValue(camara);
                        celda141.setCellValue(alturaoidocamara);
                        celda142.setCellValue(diaoidocamara);
                        celda143.setCellValue(observacionesgenerales);
                        celda144.setCellValue(observacionescamara);
                        celda149.setCellValue(sumideros);
                        celda150.setCellValue(cantidadsumideros);
                        celda151.setCellValue(campoentrada);

                    }while (cursordif.moveToNext());
                    }
                cursordif.close();
        db.close();

            if (imagenes==1) {
                SQLiteDatabase db1 = dbHelper.getReadableDatabase();
                Drawing drawing = sheet.createDrawingPatriarch();


                Picture picture;
                String[] columsexterior = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOEXTERIOR};
                Cursor cursorexterior = db1.query(Utilidades.TABLA_ALCANTARILLADO, columsexterior, null, null, null, null, null);

                if (cursorexterior.moveToFirst()) {
                    do {


                        bytearrayExterior = cursorexterior.getBlob(1);

                        if (bytearrayExterior != null) {
                            ClientAnchor anchor1 = helper.createClientAnchor();


                            anchor1.setCol1(4);
                            anchor1.setRow1(cursorexterior.getPosition() + 1);
                            anchor1.setCol2(5);
                            anchor1.setRow2(cursorexterior.getPosition() + 2);
                            int pictureId1 = workbook.addPicture(bytearrayExterior, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor1, pictureId1);


                        }


                    } while (cursorexterior.moveToNext());

                }
                cursorexterior.close();
                db1.close();
                bytearrayExterior=null;
                SQLiteDatabase db2 = dbHelper.getReadableDatabase();

                String[] columspanoramica = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOPANORAMICA};
                Cursor cursorpannoramica = db2.query(Utilidades.TABLA_ALCANTARILLADO, columspanoramica, null, null, null, null, null);

                if (cursorpannoramica.moveToFirst()) {
                    do {


                        bytearrayPanoramica = cursorpannoramica.getBlob(1);

                        if (bytearrayPanoramica != null) {
                            ClientAnchor anchor2 = helper.createClientAnchor();


                            anchor2.setCol1(5);
                            anchor2.setRow1(cursorpannoramica.getPosition() + 1);
                            anchor2.setCol2(6);
                            anchor2.setRow2(cursorpannoramica.getPosition() + 2);
                            int pictureId2 = workbook.addPicture(bytearrayPanoramica, Workbook.PICTURE_TYPE_PNG);
                             picture = drawing.createPicture(anchor2, pictureId2);

                        }


                    } while (cursorpannoramica.moveToNext());
                }
                cursorpannoramica.close();
                db2.close();
                SQLiteDatabase db3 = dbHelper.getReadableDatabase();
                bytearrayPanoramica = null;
                String[] columsesquema = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOESQUEMA};
                Cursor cursoresquema = db3.query(Utilidades.TABLA_ALCANTARILLADO, columsesquema, null , null,null,null,null);

                if (cursoresquema.moveToFirst()) {
                    do {


                        bytearrayEsquema = cursoresquema.getBlob(1);

                        if (bytearrayEsquema != null) {
                            ClientAnchor anchor3 = helper.createClientAnchor();

                            anchor3.setCol1(15);
                            anchor3.setRow1(cursoresquema.getPosition() + 1);
                            anchor3.setCol2(16);
                            anchor3.setRow2(cursoresquema.getPosition() + 2);
                            int pictureId2 = workbook.addPicture(bytearrayEsquema, Workbook.PICTURE_TYPE_PNG);
                             picture = drawing.createPicture(anchor3, pictureId2);

                        }


                    } while (cursoresquema.moveToNext());
                }
                cursoresquema.close();
                db3.close();
                SQLiteDatabase db4 = dbHelper.getReadableDatabase();
                bytearrayEsquema = null;
                String[] columstapa = new String[]{ Utilidades.CAMPO_ID,Utilidades.CAMPO_FOTOTAPA};
                Cursor cursortapa = db4.query(Utilidades.TABLA_ALCANTARILLADO, columstapa, null, null,null,null,null);

                if (cursortapa.moveToFirst()) {
                    do {


                        bytearrayTapa = cursortapa.getBlob(1);

                        if (bytearrayTapa != null) {
                            ClientAnchor anchor4 = helper.createClientAnchor();

                            anchor4.setCol1(16);
                            anchor4.setRow1(cursortapa.getPosition() + 1);
                            anchor4.setCol2(17);
                            anchor4.setRow2(cursortapa.getPosition() + 2);
                            int pictureId4 = workbook.addPicture(bytearrayTapa, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor4, pictureId4);

                        }


                    } while (cursortapa.moveToNext());
                }
                cursortapa.close();
                db4.close();
                SQLiteDatabase db5 = dbHelper.getReadableDatabase();
                bytearrayTapa = null;
                String[] columsint1 = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOINTERIOR1};
                Cursor cursorint1 = db5.query(Utilidades.TABLA_ALCANTARILLADO, columsint1, null , null,null,null,null);

                if (cursorint1.moveToFirst()) {
                    do {


                        bytearrayInterior1 = cursorint1.getBlob(1);

                        if (bytearrayInterior1 != null) {
                            ClientAnchor anchor5 = helper.createClientAnchor();


                            anchor5.setCol1(144);
                            anchor5.setRow1(cursorint1.getPosition() + 1);
                            anchor5.setCol2(145);
                            anchor5.setRow2(cursorint1.getPosition() + 2);
                            int pictureId5 = workbook.addPicture(bytearrayInterior1, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor5, pictureId5);

                        }


                    } while (cursorint1.moveToNext());
                }
                cursorint1.close();
                db5.close();
                SQLiteDatabase db6 = dbHelper.getReadableDatabase();
                bytearrayInterior1 = null;
                String[] columsint2 = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOINTERIOR2};
                Cursor cursorint2 = db6.query(Utilidades.TABLA_ALCANTARILLADO, columsint2, null ,null,null,null,null);

                if (cursorint2.moveToFirst()) {
                    do {


                        bytearrayInterior2 = cursorint2.getBlob(1);

                        if (bytearrayInterior2 != null) {
                            ClientAnchor anchor6 = helper.createClientAnchor();

                            anchor6.setCol1(145);
                            anchor6.setRow1(cursorint2.getPosition() + 1);
                            anchor6.setCol2(146);
                            anchor6.setRow2(cursorint2.getPosition() + 2);
                            int pictureId6 = workbook.addPicture(bytearrayInterior2, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor6, pictureId6);

                        }


                    } while (cursorint2.moveToNext());
                }
                cursorint2.close();
                db6.close();
                SQLiteDatabase db7 = dbHelper.getReadableDatabase();
                bytearrayInterior2 = null;
                String[] columsint3 = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOINTERIOR3};
                Cursor cursorint3 = db7.query(Utilidades.TABLA_ALCANTARILLADO, columsint3, null , null,null,null,null);

                if (cursorint3.moveToFirst()) {
                    do {


                        bytearrayInterior3 = cursorint3.getBlob(1);

                        if (bytearrayInterior3 != null) {
                            ClientAnchor anchor7 = helper.createClientAnchor();

                            anchor7.setCol1(146);
                            anchor7.setRow1(cursorint3.getPosition() + 1);
                            anchor7.setCol2(147);
                            anchor7.setRow2(cursorint3.getPosition() + 2);
                            int pictureId7 = workbook.addPicture(bytearrayInterior3, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor7, pictureId7);

                        }


                    } while (cursorint3.moveToNext());
                }
                cursorint3 .close();
                db7.close();
                SQLiteDatabase db8 = dbHelper.getReadableDatabase();
                bytearrayInterior3 = null;
                String[] columsint4 = new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_FOTOINTERIOR4};
                Cursor cursorint4 = db8.query(Utilidades.TABLA_ALCANTARILLADO, columsint4, null ,null,null,null,null);

                if (cursorint4.moveToFirst()) {
                    do {


                        bytearrayInterior4 = cursorint4.getBlob(1);

                        if (bytearrayInterior4 != null) {
                            ClientAnchor anchor8 = helper.createClientAnchor();

                            anchor8.setCol1(147);
                            anchor8.setRow1(cursorint4.getPosition() + 1);
                            anchor8.setCol2(148);
                            anchor8.setRow2(cursorint4.getPosition() + 2);
                            int pictureId8 = workbook.addPicture(bytearrayInterior4, Workbook.PICTURE_TYPE_PNG);
                            picture = drawing.createPicture(anchor8, pictureId8);

                        }


                    } while (cursorint4.moveToNext());
                }
                cursorint4.close();
                db8.close();

                bytearrayInterior4=null;
            }





            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                Toast.makeText(context,
                        "Data Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}


