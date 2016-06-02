package liittyma;

import java.util.HashSet;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import logiikka.*;

public class MyyOsakeGUI extends javax.swing.JFrame {
    OsakesalkkuGUI vanhempi;

    public MyyOsakeGUI() {
        initComponents();
    }

    public MyyOsakeGUI(OsakesalkkuGUI aThis) {
        super("MyyOsakettaGUI");
        this.vanhempi = aThis;
        initComponents();
        listModel = new DefaultListModel();
        osakkeetList.setModel(listModel);
        luoLista();
    }
    
    public void luoLista() {
        for (Osake o : vanhempi.getSalkku().getOsakkeet()) {
            listModel.addElement(o.getNimi());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        osakkeetList = new javax.swing.JList<>();
        maaraTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maaraLabel = new javax.swing.JLabel();
        hintaLabel = new javax.swing.JLabel();
        myyKaikkiCheckBox = new javax.swing.JCheckBox();
        myyButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        alkuhintaLabel = new javax.swing.JLabel();
        osakeLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hintaTextField = new javax.swing.JTextField();
        paluuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        osakkeetList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                osakkeetListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(osakkeetList);

        maaraTextField.setText("määrä");
        maaraTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maaraTextFieldActionPerformed(evt);
            }
        });
        maaraTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maaraTextFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("Valitse osake");

        jLabel2.setText("Osakkeiden määrä tällä hetkellä");

        jLabel3.setText("Kuinka monta osaketta haluat myydä?");

        jLabel4.setText("Osakkeen hinta: ");

        maaraLabel.setText("-");

        hintaLabel.setText("-");

        myyKaikkiCheckBox.setText("Myydään kaikki");
        myyKaikkiCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myyKaikkiCheckBoxActionPerformed(evt);
            }
        });

        myyButton.setText("Myy");
        myyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myyButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Osakkeen hinta alussa:");

        alkuhintaLabel.setText("-");

        osakeLabel.setText("Osake:   ");

        jLabel7.setText("Myyntihinta");

        hintaTextField.setText("hinta");

        paluuButton.setText("Paluu");
        paluuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paluuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(maaraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(hintaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(osakeLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(alkuhintaLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(37, 37, 37)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(myyKaikkiCheckBox)
                                                .addComponent(maaraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel7)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(myyButton)
                                    .addGap(45, 45, 45)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(paluuButton)
                                    .addComponent(hintaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(139, 139, 139))))
                    .addComponent(jLabel1))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(maaraLabel)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(hintaLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(alkuhintaLabel))
                            .addComponent(osakeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(maaraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(myyKaikkiCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hintaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(199, 199, 199)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(myyButton)
                                            .addComponent(paluuButton)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maaraTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maaraTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maaraTextFieldActionPerformed

    private void myyKaikkiCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myyKaikkiCheckBoxActionPerformed
        maaraTextField.setText(String.valueOf(osake.getMaara()));
    }//GEN-LAST:event_myyKaikkiCheckBoxActionPerformed

    private void osakkeetListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_osakkeetListMouseClicked
        JList lista = (JList) evt.getSource();
        int index = lista.locationToIndex(evt.getPoint());
        if (index >= 0) {
            Object o = lista.getModel().getElementAt(index);
            String osakkeenNimi = o.toString();
            osake = vanhempi.getSalkku().osakeNimenPerusteella(osakkeenNimi);
        }
        
        osakeLabel.setText("Osake: " + osake.getNimi());
        maaraLabel.setText(String.valueOf(osake.getMaara()));
        hintaLabel.setText(String.valueOf(osake.getHinta()));
        alkuhintaLabel.setText(String.valueOf(osake.getAlkuArvo()));
    }//GEN-LAST:event_osakkeetListMouseClicked

    private void maaraTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maaraTextFieldKeyPressed
        if (myyKaikkiCheckBox.isSelected()) {
            myyKaikkiCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_maaraTextFieldKeyPressed

    private void myyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myyButtonActionPerformed
        String nimi = osake.getNimi();
        int hinta = Integer.parseInt(hintaTextField.getText());
        int maara = Math.negateExact(Integer.parseInt(maaraTextField.getText()));
        
        vanhempi.myyOsake(new Osake(nimi, hinta, maara));
        
        super.dispose();
    }//GEN-LAST:event_myyButtonActionPerformed

    private void paluuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paluuButtonActionPerformed
        super.dispose();
    }//GEN-LAST:event_paluuButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(MyyOsakeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyyOsakeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyyOsakeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyyOsakeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyyOsakeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alkuhintaLabel;
    private javax.swing.JLabel hintaLabel;
    private javax.swing.JTextField hintaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maaraLabel;
    private javax.swing.JTextField maaraTextField;
    private javax.swing.JButton myyButton;
    private javax.swing.JCheckBox myyKaikkiCheckBox;
    private javax.swing.JLabel osakeLabel;
    private javax.swing.JList<String> osakkeetList;
    private javax.swing.JButton paluuButton;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel listModel;
    private Osake osake;
}
