package topicos_avancados.com.br.preferencias;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by PedroPaulo on 27/02/17.
 */

public class Preferences extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.preferences);
    }

}
