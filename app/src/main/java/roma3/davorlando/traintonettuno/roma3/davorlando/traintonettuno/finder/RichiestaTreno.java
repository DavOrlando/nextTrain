package roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder;

import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.model.Treno;

/**
 * Created by davideorlando on 07/03/17.
 */

public abstract class RichiestaTreno {
    public abstract Treno getInformazioni(String stazionePartenza, String stazioneArrivo);
}
