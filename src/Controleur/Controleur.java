
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;


import ConnectionBD.ConnectionBD;
import Models.AvoirCours;
import Models.Machine;

import Models.Machine;
import Models.Etudiant;
import Models.Formation;
import Models.Groupe;
import Models.Reclamation;

import Models.Salle;
import Models.User;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author 21911890
 */
public class Controleur extends AbstractControleur{

    private Connection conn= ConnectionBD.getConnection();
    
    public static User connexionE(Connection conn, User user)throws Exception{
        User resultUser = null;
        String sql = "Select * from etudiant where idE =? and mdpE = ? ";       
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getIdentifiantUser());
        pstmt.setString(2,user.getMdpUser());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new User();
            resultUser.setIdentifiantUser(rs.getString("idE"));
            resultUser.setMdpUser(rs.getString("mdpE")); 
            resultUser.setNomUser(rs.getString("nomE"));
            resultUser.setPrenomUser(rs.getString("prenomE"));
}
        
        return resultUser;
    }
    public static User connexionR(Connection conn, User user)throws Exception{
        User resultUser = null;
        String sql = "Select * from responsable where idR =? and mdpR = ? ";       
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getIdentifiantUser());
        pstmt.setString(2,user.getMdpUser());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new User();
            resultUser.setIdentifiantUser(rs.getString("idR"));
            resultUser.setMdpUser(rs.getString("mdpR"));  
            
        }
        
        return resultUser;
    }
    
   public static String selectedById(Connection conn, User user)throws Exception{
        String result = null;
        String sql = "Select prenomE, nomE from etudiant where idE =" + user.getIdentifiantUser();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String prenomE = rs.getString("prenomE");
            String nomE = rs.getString("nomE");
            result = prenomE + "  " + nomE;
            //System.out.println(prenomE + "," + nomE);
        }
        return result;
       
        
    }
   
   public static String selectedByIdResp(Connection conn, User user)throws Exception{
        String result = null;
        String sql = "Select prenomR, nomR from responsable where idR = '" + user.getIdentifiantUser() + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String prenomR = rs.getString("prenomR");
            String nomR = rs.getString("nomR");
            result = prenomR + "  " + nomR;
            //System.out.println(prenomR + "," + nomR);
        }
        return result;
       
        
    }
   

    @Override
    public  ArrayList<Salle> tousLesSalle(){
        ArrayList res=new ArrayList();
        String sql ="select * from salle";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String ids=rs.getString("idS");
                Integer nbM=Integer.valueOf(rs.getString("nbMachine"));
                String etatS=rs.getString("etatS");
                Salle s=new Salle(ids,nbM,etatS);
                res.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    // get la liste des groupes 
    public  ArrayList<Groupe> tousLesGroupes(){
        ArrayList res=new ArrayList();
        String sql ="select idG,nomG from groupe";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String idG=rs.getString("idG");
                String nomG=rs.getString("nomG");
                Groupe g=new Groupe(idG,nomG);
                res.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public ArrayList<Machine> touslesMachine() {
        ArrayList res=new ArrayList();
        String sql ="select * from machine";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String idm=rs.getString("idM");
                String etatm=rs.getString("etatM");
                String ids=rs.getString("idS");
                Machine m=new Machine(idm,etatm,ids);
                res.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }

    @Override
    public void ajouterSalle(String ids, int nbMachineMax, String etats) {
        String sql="insert into salle values(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ids);
            pstmt.setInt(2, nbMachineMax);
            pstmt.setString(3, etats);
            pstmt.executeUpdate();       
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterMachine(String idm, String etatm, String ids) {
        String sql="insert into machine values(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idm);
            pstmt.setString(2, etatm);
            pstmt.setString(3, ids);
            pstmt.executeUpdate();       
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public int supprimerSalle(String idS) {
        int count=0;
        String sql="delete from salle where idS=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idS);
            count=pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int supprimerMachine(String idM) {
        int count=0;
        String sql="delete from machine where idM=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idM);
            count=pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
       
    }

    @Override
    public Salle afficherUneSalle(String idS) {
        Salle s=null;
        String sql ="select * from salle where idS=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idS);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                String ids=rs.getString("idS");
                Integer nbM=Integer.valueOf(rs.getString("nbMachine"));
                String etatS=rs.getString("etatS");
                s=new Salle(ids,nbM,etatS);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
        
    }

    @Override
    public Machine afficherUneMachine(String idM) {
        Machine m=null;
        String sql ="select * from machine where idM=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idM);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
            String idm=rs.getString("idM");
            String etatm=rs.getString("etatM");
            String ids=rs.getString("idS");
            m=new Machine(idm,etatm,ids);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return m;
    }             
    public static ResultSet listEtudiant(Connection conn, Etudiant etudiant)throws Exception{
       StringBuffer sb = new StringBuffer("select * from etudiant e, groupe g, formation f where e.idG = g.idG and f.idF = g.idF ");
       PreparedStatement pstmt = conn.prepareStatement(sb.toString());
       return pstmt.executeQuery();
    }
    
    public static ResultSet listFormation(Connection conn, Formation formation)throws Exception{
       StringBuffer sb = new StringBuffer("select nomF from formation");
       PreparedStatement pstmt = conn.prepareStatement(sb.toString());
       return pstmt.executeQuery();
    }
    
    public static ResultSet listGroupe(Connection conn, Groupe groupe)throws Exception{
       StringBuffer sb = new StringBuffer("select nomG from groupe");
       PreparedStatement pstmt = conn.prepareStatement(sb.toString());
       return pstmt.executeQuery();
    }
   
   public static int addCompteEtudiant(Connection conn, Etudiant etudiant, int idG)throws Exception{
       String sql = "insert into etudiant values(?,?,?,?,?)";
       PreparedStatement pstmt = conn.prepareStatement(sql);
       pstmt.setString(1,etudiant.getIdentifiantUser());
       pstmt.setString(2,etudiant.getNomUser());
       pstmt.setString(3,etudiant.getPrenomUser());
       pstmt.setString(4,etudiant.getMdpUser());
       pstmt.setInt(5,idG);
       return pstmt.executeUpdate();
   }
   
   public static int chercherIdGroupeByNomGNomF(Connection conn, Groupe groupe,Formation formation)throws Exception{
        int result = 0;
        
        //System.out.println(groupe.getNomG());
        //System.out.println(formation.getNomF());
        
        String sql ="Select g.idG from groupe g, formation f where g.idF = f.IdF and g.nomG = '" + groupe.getNomG() + "' and f.nomF = '"+ formation.getNomF()+"'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
       
        while(rs.next()){
            int idG= rs.getInt("idG");           
            result = idG;
            
          
        }
        return result;
   }
   
   public static int deleteCompteEtudiant(Connection con,String idE)throws Exception{
       String sql ="delete from etudiant where idE = ?";
       PreparedStatement pstmt = con.prepareStatement(sql);
       pstmt.setString(1,idE);
       return pstmt.executeUpdate();
   }

   
   
   
   
    public static ArrayList<String[]> getListeReservations(Connection conn, String identifiant){
        ArrayList<String[]> resultatM = new ArrayList<String[]>();
        String stringSQL = "SELECT reserver.date, reserver.heureDeb, reserver.heureFin, salle.idS, machine.idM FROM reserver, machine, salle WHERE reserver.idE = ? AND reserver.idM = machine.idM AND machine.idS = salle.idS";
        try {
            PreparedStatement pr = conn.prepareStatement(stringSQL);
            pr.setString(1, identifiant);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                String[] resultatLigne = new String[5];
                resultatLigne[0] = rs.getString("reserver.date");
                resultatLigne[1] = rs.getString("reserver.heureDeb");
                resultatLigne[2] = rs.getString("reserver.heureFin");
                resultatLigne[3] = rs.getString("salle.idS");
                resultatLigne[4] = rs.getString("machine.idM");
                resultatM.add(resultatLigne);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return resultatM;
        
    }

    @Override
    public int modifierMachine(String idm, String etatm, String ids) {
        int count=0;
        String sql="update machine set etatM=?, idS=? where idM=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, etatm);
            pstmt.setString(2, ids);
            pstmt.setString(3, idm);
            count=pstmt.executeUpdate();       
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
    }

    @Override
    public int modifierSalle(String ids, int nbMachineMax, String etats) {
        int count=0;
        String sql="update salle set nbMachine=?, etatS=? where idS=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nbMachineMax);
            pstmt.setString(2, etats);
            pstmt.setString(3, ids);
            count=pstmt.executeUpdate();       
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
        
    }

    @Override
    public boolean verifierNbMachine(String ids) {
        boolean b= true;
        String sql1="select * from salle where idS=?";
        String sql2="Select count(*) from machine where idS=?";
        try {
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setString(1,ids);
            pstmt2.setString(1, ids);
            ResultSet rs1= pstmt1.executeQuery();
            ResultSet rs2=pstmt2.executeQuery();
            rs1.next();
            Integer nbM=Integer.valueOf(rs1.getString("nbMachineMax"));
            rs2.next();
            Integer nbMEx=rs2.getInt(1);
            if(nbMEx<nbM){
                b=true;
            }else{
                b=false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

   // Ajouter une réclamation 
   public static int addReclamation (Connection conn, Reclamation reclamation)throws Exception{
      int nbRowUpdate=0;
        
            String sqlQuery ="INSERT INTO `reclamer`(`idE`, `IdM`, `DateRec`, `ObjetRec`, `ContenuRec`)"
                    + " VALUES (?,?,?,?,?)"; 
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, reclamation.getEtudiant().getIdentifiantUser());
            ps.setString(2, reclamation.getMachine().getIdM());
            ps.setDate(3, reclamation.getDateRec());
            ps.setString(4, reclamation.getObjetRec());
            ps.setString(5, reclamation.getContenuRec());
            nbRowUpdate=ps.executeUpdate();
            ps.close();    
     return nbRowUpdate;
   }
   // Envoyé un email au responsable des réclamations
    public static void  sendEmail(String recepient) throws MessagingException{
       System.out.println("message en preparation ");
       Properties properties = new Properties();
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable","true");
       properties.put("mail.smtp.host","smtp.gmail.com");
       properties.put("mail.smtp.port","587");
       
       String myAccountEmail= "ucapitole@gmail.com";
       String myAccountPassword= "capitole2020";
       Session session= Session.getInstance(properties,new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(myAccountEmail,myAccountPassword); 
           }     
    });
       Message message = prepareMessage(session,myAccountEmail,recepient);
       Transport.send(message);
       System.out.println("message envoyé");
   }
    // Preparer le message 
   private static Message prepareMessage(Session session,String myAccountEmail,String recepient){
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
           message.setSubject("Nouvelle réclamation ");
           message.setText("Bonjour,\n Vous a une nouvelle réclamation sur "
                   + "la plate-forme de réservation des salles.");
           return message ;
       } catch (Exception ex) {
           Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   //Liste des réclamations   
  public static ArrayList<Reclamation> getListReclamtions(Connection conn) throws SQLException{
      ArrayList<Reclamation> listReclamtions=new ArrayList<Reclamation>();
      String sqlQuery = "SELECT idE ,m.idS,r.idM,ObjetRec, ContenuRec FROM reclamer r, machine m WHERE r.idM = m.idM";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
         while(rs.next()){
           User etu = new User(rs.getString("idE"));
           Salle sal = new Salle (rs.getString("idS"));
           Machine mac = new Machine(rs.getString("IdM"),sal);
            Reclamation rec = new Reclamation(etu, mac, rs.getString("ObjetRec"), rs.getString("ContenuRec"));
            listReclamtions.add(rec);
        }
         return listReclamtions;  
  }
  // Ajouter un planning 
  public int AjouterPlanning(AvoirCours aCours) {
      int nbRowUpdate=0;
      String sql= "INSERT INTO avoircours(idG,idS,date,heureDeb,heureFin) "
              + "VALUES (?,?,?,?,?)";
      try {
          PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aCours.getGroupe().getIdG());
            pstmt.setString(2, aCours.getSalle().getNumeroSalle());
            pstmt.setDate(3, (Date) aCours.getDateCours());
            pstmt.setTime(4, aCours.getHeureDebut());
            pstmt.setTime(5, aCours.getHeureFin());
           nbRowUpdate= pstmt.executeUpdate(); 
      } catch (Exception ex) {
           Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
       }
            
      return nbRowUpdate;
  }
   
  //Salle de TP planifié pour un étudiant. On peut le faire aussi avec le idGroup
    public static String SallesReserveesPourGroupe(String idE, String dateReserve, String heureDeb, String heureFin) throws Exception{
     String sql = "SELECT idS FROM etudiant, avoircours WHERE etudiant.idG=avoircours.idG and "
      + "date ='"+dateReserve+"' and idE='"+idE+"' and heureDeb='"+heureDeb+"' and heureFin='"+heureFin+"';"; 
        ResultSet rt = executerSelect(sql);
        String ids=null;
        while (rt.next()){
            ids=rt.getString(1);
        }
        return ids;
    }
    //Executer une requete SELECT à partir du String sql
    private static ResultSet executerSelect(String requete)throws Exception{
                Connection conn = ConnectionBD.getConnection();
		String sql=requete;
               PreparedStatement pstmt = conn.prepareStatement(sql);              
                return pstmt.executeQuery();
    }
    //il pourrait avoir plusieurs reservation en même temps. Il faut gérer ce cas
    public static String MachineReserveeParEtudiant (String idE, String dateSaisie, 
            String heureDeb, String heureFin) throws Exception {
        String sql = "SELECT idM FROM reserver where idE='"+idE+"' and date='"+dateSaisie+"'"
                + " and ((heureDeb<='"+heureDeb+"' and heureFin>'"+heureDeb+"') or "
                + "(heureDeb<'"+heureFin+"' and heureFin>='"+heureFin+"'))";
        ResultSet rt = executerSelect(sql);
        String machine=null;
        while (rt.next()){
            machine = rt.getString(1);
         
        }
        return machine;  
    }
    public static Salle RetrouverSalle(String machine) throws Exception{
        String sql = "SELECT idS FROM `machine` WHERE idM='"+machine+"';";                                                
        ResultSet rt = executerSelect(sql);
        String idS=null;
        while (rt.next()){
            idS = rt.getString(1);          
        }  
        Salle salle = new Salle(idS);
        return salle;
    }
     public static void faireUneReservation(String idE, String machine, String dateSaisie, String heureDeb, String heureFin) throws Exception {
    Connection conn = ConnectionBD.getConnection();       
        String sql = "INSERT INTO reserver (idE, idM, date, heureDeb, heureFin) VALUES (?,?,?,?,?);";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,idE);
        pst.setString(2,machine);
        pst.setString(3,dateSaisie);
        pst.setString(4,heureDeb);
        pst.setString(5,heureFin);

        pst.executeUpdate();           
    }
      public static ArrayList<String> MachinesLibre(String salle, String dateReserve, 
              String heureDeb, String heureFin) throws Exception {  
        String sql = "SELECT idM FROM `machine` WHERE idS='"+salle+"' and idM NOT IN "
                + "(SELECT idM from reserver WHERE date='"+dateReserve+"' and ((heureDeb<='"+heureDeb+"'"
                + " and heureFin>'"+heureDeb+"') or (heureDeb<'"+heureFin+"'"
                + " and heureFin>='"+heureFin+"')));";
             
        ResultSet rt = executerSelect(sql);
        int i=1; 
        ArrayList<String> listeMachinesDispo = new ArrayList<>();
        while (rt.next()){
            listeMachinesDispo.add(rt.getString(1));
                  
        }  
        return listeMachinesDispo;
    }
 //Vérifier si une salle est déjà reservé à une date et heure donnée
    public static Boolean SalleEstReserve(String idS, String dateSaisie, String heureDeb, String heureFin) throws Exception{
       String sql = "SELECT idS FROM `avoircours` WHERE idS='"+idS+"' and idS IN "
               + "(SELECT idS from `avoircours` WHERE date='"+dateSaisie+"' and "
               + "((heureDeb<='"+heureDeb+"' and heureFin>'"+heureDeb+"') or (heureDeb<'"+heureFin+"' "
               + "and heureFin>='"+heureFin+"')));";
        ResultSet rt = executerSelect(sql);
       String salle = null;
        Boolean EstReserve = false;
        while (rt.next()){           
             salle = rt.getString(1);   
        }
        if (salle!=null){
            EstReserve = true;
        }
        else{
            EstReserve = false;
            
        }       
          return EstReserve;      
        
    }
    
}
