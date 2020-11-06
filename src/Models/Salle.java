/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author 21911890
 */
public class Salle {
    private String numeroSalle ;
    private String etatSalle ;
    private int  nbMachineMax;
    private ArrayList <Machine> listeMachine;
    

    public Salle(String numeroSalle,int  nbMachineMax,String etatSalle){
        this.numeroSalle = numeroSalle;
        this.etatSalle = etatSalle;
        this.nbMachineMax = nbMachineMax;
    }

    
     public Salle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public Salle(String numeroSalle, String etatSalle, int nbMachineMax, ArrayList<Machine> listeMachine) {
        this.numeroSalle = numeroSalle;
        this.etatSalle = etatSalle;
        this.nbMachineMax = nbMachineMax;
        this.listeMachine = listeMachine;
    }

   
 
    
    public String getNumeroSalle() {
        return numeroSalle;
    }

    public String getEtatSalle() {
        return etatSalle;
    }

    public int getNbMachineMax() {
        return nbMachineMax;
    }

    public ArrayList<Machine> getListeMachine() {
        return listeMachine;
    }
    
    
    
}
