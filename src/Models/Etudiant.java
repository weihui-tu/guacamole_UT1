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
public class Etudiant extends User{
    
  
    
    public Etudiant(){
    };
    public Etudiant(String identifiantUser,String nomUser, String prenomUser, String MdpUser) {
        super(nomUser, prenomUser, identifiantUser, MdpUser);
    }

   
    
}
