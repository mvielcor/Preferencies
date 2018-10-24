package com.pmdm.mviel.preferncies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_preferencies;
    SharedPreferences lesMeuesPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_preferencies = (Button) findViewById(R.id.btn_preferencies);

         //Carreguem Les preferencies!!
        carrega_preferencies();
        //Afegim un listener al botó
        btn_preferencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PreferenciesActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //Carreguem Les preferencies!!
        carrega_preferencies();
    }

    protected void carrega_preferencies(){
         //Podem llegir l'arxiu de preferencies de les dues maneres

         //Utilitzant el PreferentManager
         //lesMeuesPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

         //Indicant el nom de l'arxiu a llegir
         lesMeuesPref = getSharedPreferences("com.pmdm.mviel.preferncies_preferences",Context.MODE_PRIVATE);

         String color= lesMeuesPref.getString("color_de_fons","cap");
         boolean aplicar_color = lesMeuesPref.getBoolean("aplicar_background",false);
         //Log.d("Manel","--"+color+"--");
         if(aplicar_color) {
             switch (color) {
                 case "Blanc":
                     btn_preferencies.setBackgroundColor(Color.WHITE);
                     break;
                 case "Roig":
                     btn_preferencies.setBackgroundColor(Color.RED);
                     break;
                 case "Verd":
                     btn_preferencies.setBackgroundColor(Color.GREEN);
                     break;
                 case "Blau":
                     btn_preferencies.setBackgroundColor(Color.BLUE);
                     break;

             }
         }
    }
}
