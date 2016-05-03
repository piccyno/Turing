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
public class Cliente extends Utente{
    /* Attributi */
    private ArrayList<Disco> dischiAcquistati = new ArrayList<Disco>();
    
    /* Costruttore */
    public Cliente(){
        super();
    }
            
    /* Metodi */

    /**
     * @return the dischiAcquistati
     */
    public ArrayList<Disco> getDischiAcquistati() {
        return dischiAcquistati;
    }

    /**
     * @param dischiAcquistati the dischiAcquistati to set
     */
    public void setDischiAcquistati(ArrayList<Disco> dischiAcquistati) {
        this.dischiAcquistati = dischiAcquistati;
    }
    
}