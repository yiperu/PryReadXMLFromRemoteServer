package com.example.PryReadXMLFromRemoteServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.net.URL;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private EditText editTextUrl = null;
    private Button buttonSend = null;
    private ListView listViewDatos=null;
    // Datos necesario para obtener datos del WS
    private URL url=null;
    private String[] titulares=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //------------------------------
        editTextUrl = (EditText)findViewById(R.id.idEdtUrl);
        buttonSend = (Button)findViewById(R.id.idBtnSend);
        listViewDatos = (ListView)findViewById(R.id.idLstvDatos);

        buttonSend.setOnClickListener(this);


        url = new URL();
        leerXML();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idBtnSend:
                Intent i = new Intent(this,DetalleActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
