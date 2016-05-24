/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;
import java.util.ArrayList;

/**
 *
 * @author Simone
 */
public class Venditore extends Utente {
    /* Attributi */
    private ArrayList<Disco> dischiInVendita = new ArrayList<Disco>(); 
    
    /* Costruttore */
    public Venditore(){
        super();
    }
    
    /* Metodi */

    /**
     * @return the dischiInVendita
     */
    public ArrayList<Disco> getDischiInVendita() {
        return dischiInVendita;
    }

    /**
     * @param inVendita the dischiInVendita to set
     */
    public void setDischiInVendita(ArrayList<Disco> inVendita) {
        this.dischiInVendita = inVendita;
    }
}
