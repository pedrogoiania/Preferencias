package topicos_avancados.com.br.preferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    private static final String ARQ_PREFS = "SharedPreferencesOnApp";
    private static final String PREF_STR1 = "PREF_STR1";
    private static final String PREF_STR2 = "PREF_STR2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);



//        Obtendo objeto de preferencias
        SharedPreferences prefs = getSharedPreferences(ARQ_PREFS, 0);
        //
        et1.setText(prefs.getString(PREF_STR1, ""));
        et2.setText(prefs.getString(PREF_STR2, ""));

        //click para intent com a preferencesActivity

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Preferences.class);
                startActivity(i);
            }
        });

        // -- click para intent com a preferencesActivity @end

        final TextView tv = (TextView) findViewById(R.id.textView);
        final CheckBox cb = (CheckBox) findViewById(R.id.checkBox);

        prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        tv.setText(prefs.getString("et", ""));
        cb.setChecked(prefs.getBoolean("cb", false));

        prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key){
                if (key.equals("et")) {
                    tv.setText(sharedPreferences.getString(key, tv.getText().toString()));
                } else if (key.equals("cb")) {
                    cb.setChecked(sharedPreferences.getBoolean("cb", cb.isChecked()));
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        //Obtendo objeto de preferencias
        SharedPreferences prefs = getSharedPreferences(ARQ_PREFS, 0 );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_STR1, et1.getText().toString());
        editor.putString(PREF_STR2, et2.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Obtendo objeto de preferencias
        SharedPreferences prefs = getSharedPreferences(ARQ_PREFS, 0 );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_STR1, et1.getText().toString());
        editor.putString(PREF_STR2, et2.getText().toString());
        editor.commit();
    }

}
