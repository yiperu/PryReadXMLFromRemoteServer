package com.example.PryReadXMLFromRemoteServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private EditText editTextUrl = null;
    private Button buttonSend = null;
    private ListView listViewDatos = null;
    // Datos necesario para obtener datos del WS
    private URL url=null;
    private String[] titulares=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //------------------------------
        editTextUrl = (EditText)findViewById(R.id.idEdtUrl);
        buttonSend = (Button)findViewById(R.id.idBtnSend);
        listViewDatos = (ListView)findViewById(R.id.idLstvDatos);

        buttonSend.setOnClickListener(this);


        try {
            url = new URL("http://apps4s.com/cursos.xml");
            leerXML();
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        ArrayAdapter adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titulares);
        listViewDatos.setAdapter(adaptador);
    }

    private void leerXML() {
        XmlPullParserFactory factory;
        XmlPullParser xml;

        int evento;
        // Ahora aqui empezaremos a parsear el archivo XML:
        boolean titulo;  // Flag para verificar si esta empezando un TAG titulo
        ArrayList<String> titulos;  // Array donde guardaremos los titulos

        titulo = false;  // Inicializamos con false
        titulos = new ArrayList<String>();  // Inicializamos nuestro arreglo

        try {
            factory = XmlPullParserFactory.newInstance();
            xml = factory.newPullParser();
            xml.setInput(url.openStream(),"UTF-8");

            evento = xml.getEventType();  // Obtenemos el evento 0(Inicio Doc),1(Fin Doc),2(Inicio Tag),(Fin Tag),4(Text)
            // aqui empezamos a parsear nuestro
            while (evento != XmlPullParser.END_DOCUMENT) {
                switch (evento) {
                    case XmlPullParser.START_TAG:
                        if (xml.getName().equals("titulo")) {
                            titulo=true;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if (titulo==true) {
                            titulos.add(xml.getText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (xml.getName().equals("titulo")) {
                            titulo=false;
                        }
                        break;
                }
                evento = xml.next();
            }
            titulares = new String[titulos.size()];
            for (int i=0;i<titulos.size();i++) {
                titulares[i] = titulos.get(i);
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
