/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author tutu
 */
public class User {
    private String nomUser;
    private String prenomUser;
    private String identifiantUser;
    private String MdpUser;

    public User() {
    }
    

    public User(String identifiantUser, String MdpUser) {
        this.identifiantUser = identifiantUser;
        this.MdpUser = MdpUser;
    }

    
    public User(String nomUser, String prenomUser, String identifiantUser, String MdpUser) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.identifiantUser = identifiantUser;
        this.MdpUser = MdpUser;
    }

    public User(String identifiantUser) {
        this.identifiantUser = identifiantUser;
    }
    
    
    
    public String getNomUser() {
        return nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public String getIdentifiantUser() {
        return identifiantUser;
    }

    public String getMdpUser() {
        return MdpUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public void setIdentifiantUser(String identifiantUser) {
        this.identifiantUser = identifiantUser;
    }

    public void setMdpUser(String MdpUser) {
        this.MdpUser = MdpUser;
    }

  
    
}
