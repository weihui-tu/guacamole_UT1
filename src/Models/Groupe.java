/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author tutu
 */
public class Groupe {
    private String idG;
    private String nomG;
    private ArrayList<Etudiant> lstEtudiants = new ArrayList();

    public Groupe() {
    }

    
    public Groupe(String nomG) {
        this.nomG = nomG;
    }
    
    public Groupe(String idG, String nomG) {
        this.idG = idG;
        this.nomG = nomG;
    }

    public String getIdG() {
        return idG;
    }

    public void setIdG(String idG) {
        this.idG = idG;
    }

    public String getNomG() {
        return nomG;
    }

    public void setNomG(String nomG) {
        this.nomG = nomG;
    }

    public ArrayList<Etudiant> getLstEtudiants() {
        return lstEtudiants;
    }

    public void setLstEtudiants(ArrayList<Etudiant> lstEtudiants) {
        this.lstEtudiants = lstEtudiants;
    }
    
    
    
}
