package roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.model.Treno;

/**
 * Created by davideorlando on 07/03/17.
 */
public class RichiestaTrenoViaggiaTreno extends RichiestaTreno {


    public static final String GET_VIAGGIATRENO = "http://viaggiatreno.it/viaggiatrenonew/" +
            "resteasy/viaggiatreno/partenze/";
    public static final String GET_ID_STAZIONE = "http://viaggiatreno.it/viaggiatrenonew/" +
            "resteasy/viaggiatreno/autocompletaStazione/";
    public static final String SLASH_QUERY = "/";
    public static final String PARAMETER_DIVISOR = "%20";
    public static final String DESTINAZIONE = "destinazione";
    public static final String NUMERO_TRENO = "numeroTreno";
    public static final String BINARIO = "binarioEffettivoPartenzaDescrizione";
    public static final String ORARIO_PARTENZA = "compOrarioPartenza";
    public static final String RITARDO = "ritardo";

    public RichiestaTrenoViaggiaTreno() {
    }

    @Override
    public Treno getInformazioni(String stazionePartenza, String stazioneArrivo) {
        Treno treno = new Treno();
        treno.setStazionePartenza(stazionePartenza);
        String response = searchInfo(stazionePartenza);
        try {
            parseInfoTreno(treno,filterInfo(stazioneArrivo, response));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treno;
    }

    private void parseInfoTreno(Treno treno, String response) throws JSONException {
        JSONObject trenoJSON = new JSONObject(response);
        treno.setNumero(trenoJSON.getString(NUMERO_TRENO));
        treno.setBinario(trenoJSON.getString(BINARIO));
        treno.setStazioneDestinazione(trenoJSON.getString(DESTINAZIONE));
        treno.setPartenza(trenoJSON.getString(ORARIO_PARTENZA));
        treno.setRitardo(trenoJSON.getString(RITARDO));
    }

    private String searchInfo(String stazionePartenza) {
        String urlRequest = GET_VIAGGIATRENO+ getUrlRequest(stazionePartenza);
        String response = HttpRequest.doRequest(urlRequest);
        System.out.print(response);
        return response;
    }

    private String filterInfo(String stazioneArrivo, String response){
        String treno = null;
        try {
            JSONArray treni = new JSONArray(response);
            for(int i = 0; i < treni.length(); i++){
                JSONObject current = treni.getJSONObject(i);
                if(current.get(DESTINAZIONE).equals(stazioneArrivo)) {
                    treno = current.toString();
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treno;
    }

    @NonNull
    private String getUrlRequest(String stazionePartenza) {
        Calendar cal = Calendar.getInstance();
        String month = new SimpleDateFormat("MMM").format(cal.getTime());
        String day = new SimpleDateFormat("dd").format(cal.getTime());
        String year = new SimpleDateFormat("yyyy").format(cal.getTime());
        String time = new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
        String urlRequest = getIdentificativoStazione(stazionePartenza) + SLASH_QUERY +
                month + PARAMETER_DIVISOR + day + PARAMETER_DIVISOR + year
                +PARAMETER_DIVISOR + time;
        System.out.println("sad");
        return urlRequest;
    }

    public String getIdentificativoStazione(String stazionePartenza){
        String urlRequest = GET_ID_STAZIONE + stazionePartenza.replaceAll(" ",PARAMETER_DIVISOR);
        String response = HttpRequest.doRequest(urlRequest);
        return response.substring(response.indexOf("|")+1);
    }
}
