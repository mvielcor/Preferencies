package com.pmdm.mviel.preferncies;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferenciesActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{


    SharedPreferences preferenciesDUsuari;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencies);

        //Cal llegir les preferencies i actualitzar tots els valor de summaries
        actualitzaSummaries();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("email")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Cap").toString());
        }
        if(key.equals("color_de_fons")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Cap").toString());
        }
        if(key.equals("aplicar_background")) {
            Preference pref = findPreference(key);
            boolean aplicar = sharedPreferences.getBoolean(key, false);
            pref.setSummary(aplicar?getString(R.string.etiqueta_si):getString(R.string.etiqueta_no));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void actualitzaSummaries(){
        preferenciesDUsuari  = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Preference pref;
        //email
            pref = findPreference("email");
            pref.setSummary(preferenciesDUsuari.getString("email","Cap"));
        //color de fons
            pref = findPreference("color_de_fons");
            pref.setSummary(preferenciesDUsuari.getString("color_de_fons", "Cap").toString());

       //aplicar_background
            pref = findPreference("aplicar_background");
            boolean aplicar = preferenciesDUsuari.getBoolean("aplicar_background", false);
            pref.setSummary(aplicar?getString(R.string.etiqueta_si):getString(R.string.etiqueta_no));

    }
}
