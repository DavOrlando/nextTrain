package roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.model;

import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder.RichiestaTreno;
import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder.RichiestaTrenoViaggiaTreno;

/**
 * Created by davideorlando on 07/03/17.
 */

public class OrarioTreni {

    private RichiestaTreno richiestaTreno;

    public OrarioTreni() {
        this.richiestaTreno = new RichiestaTrenoViaggiaTreno();
    }

    public Treno getTreno(String stazionePartenza, String stazioneArrivo){
        return richiestaTreno.getInformazioni(stazionePartenza,stazioneArrivo);
    }

}
