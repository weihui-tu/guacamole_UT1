/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Controleur;
import Models.Machine;
import Models.Salle;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silu
 */
public class ListMachine extends javax.swing.JFrame {
    
    private Controleur c=new Controleur();

    /**
     * Creates new form ListMachine
     */
    public ListMachine() {
        initComponents();
    }
    
    public ListMachine(String name){
        initComponents();
        this.lblNameR.setText(name);
        ArrayList<Machine> touslesMachines=new ArrayList<Machine>();
        
        touslesMachines = c.touslesMachine();
        
        DefaultTableModel model =(DefaultTableModel)tableMachine.getModel();
        Object rowData[]=new Object[touslesMachines.size()];
        for(int i =0;i<touslesMachines.size();i++){
            rowData[0] = touslesMachines.get(i).getIdM();
            rowData[1] = touslesMachines.get(i).getEtatM();
            rowData[2] = touslesMachines.get(i).getIdS();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        retourAccResp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMachine = new javax.swing.JTable();
        modifierMachine = new javax.swing.JButton();
        supprimerMachine = new javax.swing.JButton();
        ajouterMachine = new javax.swing.JButton();
        lblNameR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenue");

        retourAccResp.setText("Retour Accueil");
        retourAccResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourAccRespActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Liste des Machines");

        tableMachine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Machine", "Etat Machine", "Id Salle"
            }
        ));
        jScrollPane1.setViewportView(tableMachine);

        modifierMachine.setText("Modifier Machine");
        modifierMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierMachineActionPerformed(evt);
            }
        });

        supprimerMachine.setText("Supprimer Machine");
        supprimerMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerMachineActionPerformed(evt);
            }
        });

        ajouterMachine.setText("Ajouter Machine");
        ajouterMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterMachineActionPerformed(evt);
            }
        });

        lblNameR.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(lblNameR)
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(modifierMachine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supprimerMachine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ajouterMachine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(retourAccResp)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNameR))
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifierMachine)
                    .addComponent(supprimerMachine)
                    .addComponent(retourAccResp)
                    .addComponent(ajouterMachine))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retourAccRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourAccRespActionPerformed
        // TODO add your handling code here:
    
        AcueilResponsable ar=new AcueilResponsable(this.lblNameR.getText());
        ar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retourAccRespActionPerformed

    private void modifierMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierMachineActionPerformed
        // TODO add your handling code here:
        int row = tableMachine.getSelectedRow();
        String idm=(String)tableMachine.getValueAt(row, 0);
        Machine m = c.afficherUneMachine(idm);
        ModifierMachine mm=new ModifierMachine(this.lblNameR.getText(),m);
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modifierMachineActionPerformed

    private void ajouterMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterMachineActionPerformed
        // TODO add your handling code here:
        AjouterMachine am=new AjouterMachine(this.lblNameR.getText());
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ajouterMachineActionPerformed

    private void supprimerMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerMachineActionPerformed
        // TODO add your handling code here:
        int row = tableMachine.getSelectedRow();
        String idm=(String)tableMachine.getValueAt(row, 0);
       
        int count=c.supprimerMachine(idm);
        if(count==1){
            ListMachine lm=new ListMachine(this.lblNameR.getText());
            lm.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "echec de supprimer");
        }
    }//GEN-LAST:event_supprimerMachineActionPerformed

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
            java.util.logging.Logger.getLogger(ListMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterMachine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNameR;
    private javax.swing.JButton modifierMachine;
    private javax.swing.JButton retourAccResp;
    private javax.swing.JButton supprimerMachine;
    private javax.swing.JTable tableMachine;
    // End of variables declaration//GEN-END:variables
}
