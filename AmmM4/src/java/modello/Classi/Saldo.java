/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;

/**
 *
 * @author Simone
 */
public class Saldo {
    private double saldo=0.0;

    /**
     * @return the saldo
     */
    public double getSaldo() {
        saldo = Math.floor(saldo*100);
        saldo = saldo/100;
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean aggiungi(double soldi){
        if (soldi > 0) {
            this.saldo = this.saldo + soldi;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean sottrai(double soldi){
        if ((soldi > 0)&&(soldi <= this.saldo)){
            this.saldo = this.saldo - soldi;
            return true;
        }else{
            return false;
        }
        
    
    }
    
}
