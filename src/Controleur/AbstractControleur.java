/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Models.Machine;
import Models.Salle;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author 21911890
 */
public abstract class AbstractControleur {

    public AbstractControleur() {
        
    }

    public abstract ArrayList<Salle> tousLesSalle();
    
    public abstract ArrayList<Machine> touslesMachine();
    
    public abstract void ajouterSalle(String ids,int nbMachineMax,String etats);
    
    public abstract void ajouterMachine(String idm,String etatm,String ids);
    
    public abstract int supprimerSalle(String idS);
    
    public abstract int supprimerMachine(String idM);
    
    public abstract Salle afficherUneSalle(String idS);
    
    public abstract Machine afficherUneMachine(String idM)throws Exception;
    
    public abstract int modifierMachine(String idm,String etatm,String ids );
    
    public abstract int modifierSalle(String ids,int nbMachineMax,String etats);
   
    public abstract boolean verifierNbMachine(String ids);
    
    

}
