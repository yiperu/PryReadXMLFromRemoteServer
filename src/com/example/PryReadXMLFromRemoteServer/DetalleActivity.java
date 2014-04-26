package com.example.PryReadXMLFromRemoteServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
    }
}