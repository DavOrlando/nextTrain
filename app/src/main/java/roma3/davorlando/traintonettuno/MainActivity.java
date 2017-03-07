package roma3.davorlando.traintonettuno;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.model.OrarioTreni;

public class MainActivity extends AppCompatActivity {

    public static final String NETTUNO = "NETTUNO";
    public static final String ROMA_TERMINI = "ROMA TERMINI";
    private OrarioTreni orarioTreni;
    private TextView trenoAndata;
    private TextView trenoRitorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orarioTreni = new OrarioTreni();
        trenoAndata = (TextView) findViewById(R.id.andata);
        trenoRitorno = (TextView) findViewById(R.id.ritorno) ;

    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            trenoAndata.setText(orarioTreni.getTreno(NETTUNO, ROMA_TERMINI).toString());
            trenoRitorno.setText(orarioTreni.getTreno(ROMA_TERMINI, NETTUNO).toString());
        }
        catch (Exception e){
            e.printStackTrace();
            trenoAndata.setText("Nessuna connessione alla rete");
            trenoRitorno.setText("");
        }
    }

    public void refresh(View view){
        CharSequence text = "Aggiornamento dati...";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        onResume();
        }
    }

