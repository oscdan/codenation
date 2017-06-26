package com.codenation.vivediabetes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.codenation.vivediabetes.beans.Catalog;
import com.codenation.vivediabetes.control.ControlCatalog;
import com.codenation.vivediabetes.database.DataBaseHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;

public class ActivitySplashScreen extends AppCompatActivity {

    public static final String CATALOG_CONTENT = "[{\"id\":1,\"type\":2,\"idtype\":0,\"name\":\"Poco o ningún ejercicio\",\"visible\":1,\"orderNo\":1},{\"id\":2,\"type\":2,\"idtype\":1,\"name\":\"Deporte 1 a 3 días/semana\",\"visible\":1,\"orderNo\":3},{\"id\":3,\"type\":2,\"idtype\":2,\"name\":\"Deporte 3 a 5 días/semana\",\"visible\":1,\"orderNo\":5},{\"id\":4,\"type\":2,\"idtype\":3,\"name\":\"Deporte 6 a 7 días/semana\",\"visible\":1,\"orderNo\":7},{\"id\":5,\"type\":2,\"idtype\":4,\"name\":\"Deporte y Actividad Física Adicional\",\"visible\":1,\"orderNo\":9},{\"id\":6,\"type\":3,\"idtype\":1,\"name\":\"Preescolar\",\"visible\":1,\"orderNo\":1},{\"id\":7,\"type\":3,\"idtype\":2,\"name\":\"Escolar\",\"visible\":1,\"orderNo\":3},{\"id\":8,\"type\":3,\"idtype\":3,\"name\":\"Preadolescente y Adolescente\",\"visible\":1,\"orderNo\":5},{\"id\":9,\"type\":3,\"idtype\":4,\"name\":\"Adulto\",\"visible\":1,\"orderNo\":7},{\"id\":10,\"type\":3,\"idtype\":1,\"name\":\"Adulto Mayor\",\"visible\":1,\"orderNo\":9},{\"id\":11,\"type\":4,\"idtype\":1,\"name\":\"Gramos\",\"visible\":1,\"orderNo\":1},{\"id\":12,\"type\":4,\"idtype\":2,\"name\":\"Ración (10g)\",\"visible\":1,\"orderNo\":3},{\"id\":13,\"type\":4,\"idtype\":3,\"name\":\"Bread Units BU (12g)\",\"visible\":1,\"orderNo\":5},{\"id\":14,\"type\":4,\"idtype\":4,\"name\":\"Ración(15g)\",\"visible\":1,\"orderNo\":7},{\"id\":15,\"type\":6,\"idtype\":1,\"name\":\"Diabetes tipo 1\",\"visible\":1,\"orderNo\":1},{\"id\":16,\"type\":6,\"idtype\":2,\"name\":\"Diabetes tipo 2\",\"visible\":1,\"orderNo\":3},{\"id\":17,\"type\":7,\"idtype\":1,\"name\":\"Tratamiento sin insulina\",\"visible\":1,\"orderNo\":1},{\"id\":18,\"type\":7,\"idtype\":2,\"name\":\"Tratamiento con insulina\",\"visible\":1,\"orderNo\":3},{\"id\":19,\"type\":8,\"idtype\":1,\"name\":\"Hipoglucemiantes orales\",\"visible\":1,\"orderNo\":1},{\"id\":20,\"type\":8,\"idtype\":2,\"name\":\"Antihiperglucemiantes orales\",\"visible\":1,\"orderNo\":3},{\"id\":21,\"type\":9,\"idtype\":3,\"name\":\"Insulina de acción rápida - Lispro\",\"visible\":1,\"orderNo\":1},{\"id\":22,\"type\":9,\"idtype\":4,\"name\":\"Insulina de acción rápida - Aspart\",\"visible\":1,\"orderNo\":3},{\"id\":23,\"type\":9,\"idtype\":5,\"name\":\"Insulina de acción rápida - Glulisina\",\"visible\":1,\"orderNo\":5},{\"id\":24,\"type\":9,\"idtype\":6,\"name\":\"Insulina de acción corta (regular) - Insulina Regular\",\"visible\":1,\"orderNo\":7},{\"id\":25,\"type\":9,\"idtype\":7,\"name\":\"Insulina de acción corta (regular) - Insulina R\",\"visible\":1,\"orderNo\":9},{\"id\":26,\"type\":9,\"idtype\":8,\"name\":\" Insulina de acción intermedia - Insulina Intermedia\",\"visible\":1,\"orderNo\":11},{\"id\":27,\"type\":9,\"idtype\":9,\"name\":\"Insulina de acción intermedia - Insulina NPH\",\"visible\":1,\"orderNo\":13},{\"id\":28,\"type\":9,\"idtype\":10,\"name\":\"Insulina de acción lenta - Detemir\",\"visible\":1,\"orderNo\":15},{\"id\":29,\"type\":9,\"idtype\":11,\"name\":\"Insulina de acción lenta - Glargina\",\"visible\":1,\"orderNo\":17},{\"id\":30,\"type\":9,\"idtype\":12,\"name\":\"Insulinas premezcladas - Insulina Mix 75/25\",\"visible\":1,\"orderNo\":19},{\"id\":31,\"type\":9,\"idtype\":13,\"name\":\"Insulinas premezcladas - Insulina Mix 50/50\",\"visible\":1,\"orderNo\":21},{\"id\":32,\"type\":9,\"idtype\":14,\"name\":\"Insulinas premezcladas - Insulina Mix 70/30\",\"visible\":1,\"orderNo\":23}]";

    String url = "http://my-json-feed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //This is How to call by a traditional way with an AsyncTask
        GetInfoFromServer getInfoFromServer = new GetInfoFromServer();
        getInfoFromServer.execute();

        // ************  This is how to do it with a VolleyCall **************
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //Process JSON Object or JSON Array

                        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                        ArrayList<Catalog> catalogs = gson.fromJson(CATALOG_CONTENT, new TypeToken<ArrayList<Catalog>>(){}.getType());
                        ControlCatalog controlCatalog = new ControlCatalog();
                        for(Catalog catalog : catalogs){
                            controlCatalog.insertCatalog(catalog, DataBaseHandler.getInstance(getApplicationContext()));
                        }

                        Intent intent = new Intent(getApplicationContext(),
                                ActivityMain.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_CLEAR_TOP
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });

        // Access the RequestQueue through your singleton class.


        //MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    private class GetInfoFromServer extends AsyncTask<Void, Void, Void> {

        ArrayList<Catalog> catalogs;
        @Override
        protected Void doInBackground(Void... voids) {


            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            catalogs = gson.fromJson(CATALOG_CONTENT, new TypeToken<ArrayList<Catalog>>(){}.getType());
            ControlCatalog controlCatalog = new ControlCatalog();
            for(Catalog catalog : catalogs){
                controlCatalog.insertCatalog(catalog, DataBaseHandler.getInstance(getApplicationContext()));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.e("SAMPLE", catalogs.toString());
            Intent intent = new Intent(getApplicationContext(),
                    ActivityMain.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
