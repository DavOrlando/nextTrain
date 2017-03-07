package roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.model;

import java.util.Date;

/**
 * Created by davideorlando on 07/03/17.
 */

public class Treno {
    private String numero;
    private String stazioneDestinazione;
    private String stazionePartenza;
    private String partenza;
    private String ritardo;
    private String binario;


    public Treno() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getStazioneDestinazione() {
        return stazioneDestinazione;
    }

    public void setStazioneDestinazione(String stazioneDestinazione) {
        this.stazioneDestinazione = stazioneDestinazione;
    }

    public String getStazionePartenza() {
        return stazionePartenza;
    }

    public void setStazionePartenza(String stazionePartenza) {
        this.stazionePartenza = stazionePartenza;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getRitardo() {
        return ritardo;
    }

    public void setRitardo(String ritardo) {
        this.ritardo = ritardo;
    }

    public String getBinario() {
        return binario;
    }

    public void setBinario(String binario) {
        this.binario = binario;
    }

    @Override
    public String toString() {
        String treno = "Numero: " + numero +
                "\nStazione Destinazione: " + stazioneDestinazione +
                "\nStazione Partenza: " + stazionePartenza +
                "\nOra partenza: " + partenza +
                "\nMinuti di ritardo: " + ritardo;

                if(!binario.equals("null"))
                    treno += "\nBinario: " + binario;
                else treno += "\nBinario: Sconosciuto";
        return treno;

    }
}
