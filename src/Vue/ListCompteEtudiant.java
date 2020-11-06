/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import ConnectionBD.ConnectionBD;
import Controleur.Controleur;
import Models.Etudiant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silu
 */
public class ListCompteEtudiant extends javax.swing.JFrame {
     private String text ="";
     private DefaultTableModel dtm;
    /**
     * Creates new form ListCompteEtudiant
     * @param name
     */
    
    
    public ListCompteEtudiant(String name){
        initComponents();
        this.setAlwaysOnTop(true);
        this.text = name;
        this.lblName.setText(text);
        this.fillTable(new Etudiant());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEtudiantTable = new javax.swing.JTable();
        ajouterEtudiant = new javax.swing.JButton();
        retourAccResp = new javax.swing.JButton();
        supprimerEtudiant = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Liste des Etudiants");

        lstEtudiantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identifiant", "Nom", "Prenom", "Mot de passe", "Formation", "Groupe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        lstEtudiantTable.setMinimumSize(new java.awt.Dimension(100, 64));
        lstEtudiantTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstEtudiantTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstEtudiantTable);

        ajouterEtudiant.setText("Ajouter Etudiant");
        ajouterEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterEtudiantActionPerformed(evt);
            }
        });

        retourAccResp.setText("Retour Accueil");
        retourAccResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourAccRespActionPerformed(evt);
            }
        });

        supprimerEtudiant.setText("Supprimer");
        supprimerEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerEtudiantActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenue");

        lblName.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblName))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(ajouterEtudiant)
                .addGap(42, 42, 42)
                .addComponent(supprimerEtudiant)
                .addGap(38, 38, 38)
                .addComponent(retourAccResp))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(239, 239, 239))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterEtudiant)
                    .addComponent(supprimerEtudiant)
                    .addComponent(retourAccResp))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void fillTable(Etudiant etudiant){
        dtm = (DefaultTableModel) lstEtudiantTable.getModel();
        dtm.setRowCount(0);
        
        Connection conn =null;
        try{
            conn = ConnectionBD.getConnection();
            ResultSet rs = Controleur.listEtudiant(conn, etudiant);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("idE"));
                v.add(rs.getString("nomE"));
                v.add(rs.getString("prenomE"));
                v.add(rs.getString("mdpE"));
                v.add(rs.getString("nomF"));
                v.add(rs.getString("nomG"));
                dtm.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                ConnectionBD.closeConn(conn);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }
    private void retourAccRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourAccRespActionPerformed
        // TODO add your handling code here:
        
        new AcueilResponsable(text).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retourAccRespActionPerformed

    private void ajouterEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterEtudiantActionPerformed
        // TODO add your handling code here:
        AjouterEtudiant ae=new AjouterEtudiant(this.lblName.getText());
        ae.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ajouterEtudiantActionPerformed

    public void deleteLigne(){
        int count[]= lstEtudiantTable.getSelectedRows();
        if (count.length<=0) {
            return;
        }else {
         for (int i = count.length; i > 0; i--) {
          dtm.removeRow(lstEtudiantTable.getSelectedRow());
         }
        }
    }
    
    private void supprimerEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerEtudiantActionPerformed
        // TODO add your handling code here:
        
        int row = lstEtudiantTable.getSelectedRow();
        String idE = (String) lstEtudiantTable.getValueAt(row, 0);
        System.out.println(idE);
        Connection conn =null;
        try{
            conn = ConnectionBD.getConnection();
            int deleteNum = Controleur.deleteCompteEtudiant(conn, idE);
            
            if(deleteNum ==1){
                JOptionPane.showMessageDialog(null, "delete un compte etudiant succes");
                this.deleteLigne();
            }else{
                JOptionPane.showMessageDialog(null, "delete un compte etudiant echec");
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "delete un compte etudiant echec");
        }finally{
            try{
                ConnectionBD.closeConn(conn);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_supprimerEtudiantActionPerformed

    private void lstEtudiantTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEtudiantTableMousePressed
        // TODO add your handling code here:
        int row = lstEtudiantTable.getSelectedRow();
        
    }//GEN-LAST:event_lstEtudiantTableMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListCompteEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCompteEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCompteEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCompteEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ListCompteEtudiant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterEtudiant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable lstEtudiantTable;
    private javax.swing.JButton retourAccResp;
    private javax.swing.JButton supprimerEtudiant;
    // End of variables declaration//GEN-END:variables
}