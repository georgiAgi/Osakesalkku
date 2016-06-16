package liittyma;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import tiedostonkasittely.TiedostonLukija;

/**
 * Käyttöliittymä toimii ohjelman aloitusikkunana. Käyttäjä voi valita tiedoston
 * tai aloittaa uuden salkun.
 *
 * @author gexgex
 */
public class AloitusGUI extends javax.swing.JFrame {

    /**
     * Creates new form AloitusGUI
     */
    public AloitusGUI() {
        initComponents();
        tLukija = new TiedostonLukija();
        valittuTextField.setEditable(false);
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
        valitseTiedostoButton = new javax.swing.JButton();
        aloitaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        valittuTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Osakesalkku");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Lataa salkku");

        valitseTiedostoButton.setText("Valitse...");
        valitseTiedostoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valitseTiedostoButtonActionPerformed(evt);
            }
        });

        aloitaButton.setText("Aloita!");
        aloitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aloitaButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel2.setText("Tai aloita uusi salkku jättämällä tekstikenttä tyhjäksi");

        valittuTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valittuTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(valitseTiedostoButton)
                        .addGap(18, 18, 18)
                        .addComponent(valittuTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aloitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(valitseTiedostoButton)
                    .addComponent(valittuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aloitaButton)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void valittuTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valittuTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valittuTextFieldActionPerformed

    private void aloitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aloitaButtonActionPerformed
        OsakesalkkuGUI salkku = null;

        if (valittuTextField.getText().isEmpty()) {
            salkku = new OsakesalkkuGUI();
        } else {
            try {
                tLukija.lue(f);
                salkku = new OsakesalkkuGUI(tLukija.getSalkku());
                salkku.setSalkunNimiLabel(f.getName().replaceFirst("[.][^.]+$", ""));
                salkku.setTiedosto(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AloitusGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        salkku.setVisible(true);

        super.dispose();
    }//GEN-LAST:event_aloitaButtonActionPerformed

    private void valitseTiedostoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valitseTiedostoButtonActionPerformed
        Path path = Paths.get("/home/gexgex/Osakesalkku/Osakesalkku");
        JFileChooser tiedostonAvaus = new JFileChooser();
        if (Files.exists(path)) {
            tiedostonAvaus = new JFileChooser(path.toString());
        }
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".salkku", "salkku");
        tiedostonAvaus.setFileFilter(filter);

        tiedostonAvaus.showOpenDialog(null);
        f = tiedostonAvaus.getSelectedFile();
        valittuTextField.setText(f.getName());
    }//GEN-LAST:event_valitseTiedostoButtonActionPerformed
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
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AloitusGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aloitaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton valitseTiedostoButton;
    private javax.swing.JTextField valittuTextField;
    // End of variables declaration//GEN-END:variables
    private TiedostonLukija tLukija;
    private File f;
}
