/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author 21911890
 */
public class AvoirCours {
    Groupe groupe;
    Salle salle ;
    Date dateCours;
    Time heureDebut;
    Time heureFin;

    public AvoirCours(Groupe groupe, Salle salle, Date dateCours, Time heureDebut, Time heureFin) {
        this.groupe = groupe;
        this.salle = salle;
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Salle getSalle() {
        return salle;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }
    
}
