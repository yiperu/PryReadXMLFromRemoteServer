package com.example.PryReadXMLFromRemoteServer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Henry AT
 * Date: 26-04-14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetalleActivity extends Activity {
    private TextView txtTitulo = null;
    private TextView txtPrecio = null;
    private ImageView imgImagen = null;
    private TextView txtDetalle = null;

    // Declaramos las variables necesarias para trabajar las imagenes:
    private Bitmap imagenCargada;
    private String direccionImagen = "http://apps4s.com/android-xml/";



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtTitulo = (TextView)findViewById(R.id.idTxtvTitulo);
        txtPrecio = (TextView)findViewById(R.id.idTxtvPrecio);
        imgImagen = (ImageView)findViewById(R.id.idImgvImagen);
        txtDetalle = (TextView)findViewById(R.id.idTxtvDetalle);

        obtenerCursos();
    }

    private void obtenerCursos() {
        //
        Intent intent = getIntent();
        ElCurso unCurso = (ElCurso)intent.getSerializableExtra("CURSO");
        txtTitulo.setText(unCurso.getTitulo());
        txtPrecio.setText(unCurso.getPrecio()+" Dolares");
        txtDetalle.setText(unCurso.getDetalle());
        // Obtenemos el nombre del archivo de la imagen almacenada en el servidor remoto:
        direccionImagen = direccionImagen + unCurso.getImagen();
        descargarImagen(direccionImagen);
    }

    private void descargarImagen(String dirImagen) {
        URL imagenURL = null;
        try {
            imagenURL = new URL(dirImagen);
            HttpURLConnection conn = (HttpURLConnection)imagenURL.openConnection();
            conn.connect();
            imagenCargada = BitmapFactory.decodeStream(conn.getInputStream());
            imgImagen.setImageBitmap(imagenCargada);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}