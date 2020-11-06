/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author 21911890
 */
public class Machine {
    private String idM;
    private String etatM;

    private String idS;

    public Machine(String idM, String etatM, String idS) {
        this.idM = idM;
        this.etatM = etatM;
        this.idS = idS;
    }

    public String getIdM() {
        return idM;
    }

    public void setIdM(String idM) {
        this.idM = idM;
    }

    public String getEtatM() {
        return etatM;
    }

    public void setEtatM(String etatM) {
        this.etatM = etatM;
    }

    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }
    
    
    

    private Salle salle;
  
    public Machine(String idM) {
        this.idM = idM;
}

    public Salle getSalle() {
        return salle;
    }

    public Machine(String idM, Salle salle) {
        this.idM = idM;
        this.salle = salle;
    }

    

    public Machine(String idM, String etatM, Salle salle) {
        this.idM = idM;
        this.etatM = etatM;
        this.salle = salle;
    }

  
}
