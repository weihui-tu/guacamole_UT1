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
public class Formation {
    private int idF;
    private String nomF;
    private ArrayList<Groupe> lstGroupes = new ArrayList();

    public Formation() {
    }

    public Formation(String nomF) {
        this.nomF = nomF;
    }

    public Formation(int idF, String nomF) {
        this.idF = idF;
        this.nomF = nomF;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public ArrayList<Groupe> getLstGroupes() {
        return lstGroupes;
    }

    public void setLstGroupes(ArrayList<Groupe> lstGroupes) {
        this.lstGroupes = lstGroupes;
    }
    
   
}
