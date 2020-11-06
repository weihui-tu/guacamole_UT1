/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author 21911890
 */
public class Reclamation {
    private User etudiant;
    private Machine machine ;
    private String objetRec;
    private String ContenuRec;
    private Date dateRec;

      public Reclamation(User etudiant, Machine machine, String objetRec, String ContenuRec, Date dateRec) {
        this.etudiant = etudiant;
        this.machine = machine;
        this.objetRec = objetRec;
        this.ContenuRec = ContenuRec;
        this.dateRec = dateRec;
    }

    public Reclamation(User etudiant, Machine machine, String objetRec, String ContenuRec) {
        this.etudiant = etudiant;
        this.machine = machine;
        this.objetRec = objetRec;
        this.ContenuRec = ContenuRec;
    }
       
    
    
    
    public User getEtudiant() {
        return etudiant;
    }

    public Machine getMachine() {
        return machine;
    }

    public String getObjetRec() {
        return objetRec;
    }

    public String getContenuRec() {
        return ContenuRec;
    }

    public Date getDateRec() {
        return dateRec;
    }

       
    
}
