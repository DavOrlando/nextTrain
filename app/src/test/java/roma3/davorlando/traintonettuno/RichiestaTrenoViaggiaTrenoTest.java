package roma3.davorlando.traintonettuno;

import org.junit.Before;
import org.junit.Test;

import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder.HttpRequest;
import roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder.RichiestaTrenoViaggiaTreno;

import static org.junit.Assert.assertEquals;

/**
 * Created by davideorlando on 07/03/17.
 */

public class RichiestaTrenoViaggiaTrenoTest {

    private RichiestaTrenoViaggiaTreno richiesta;

    @Before
    public void setUp(){
        richiesta = new RichiestaTrenoViaggiaTreno();
    }
    @Test
    public void getIdentificativoStazioneTest() throws Exception {
        assertEquals("S08409", richiesta.getIdentificativoStazione("Roma Ter"));
    }

}
