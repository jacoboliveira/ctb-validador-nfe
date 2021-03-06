/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigDialog.java
 *
 * Created on 26/11/2012, 21:46:22
 */

package br.com.ctb.validador.nfe.view;

import br.com.ctb.validador.nfe.util.AbstractDialog;
import br.com.ctb.validador.nfe.util.Constants;
import br.com.ctb.validador.nfe.util.JMessageUtil;
import br.com.ctb.validador.nfe.util.PropertiesUtil;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacoboliveira
 */
public class ConfigSisDialog extends AbstractDialog implements Constants{
    private PropertiesUtil propsUtil;
    /** Creates new form ConfigDialog */
    public ConfigSisDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        propsUtil = new PropertiesUtil();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configSisHeader = new org.jdesktop.swingx.JXHeader();
        salvarAltCBox = new javax.swing.JCheckBox();
        fecharButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações Interface");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        configSisHeader.setDescription(""); // NOI18N
        configSisHeader.setTitle("Configurações do Sistema"); // NOI18N
        configSisHeader.setName("configSisHeader"); // NOI18N

        salvarAltCBox.setText("salvar minhas alterações feitas  na tela");
        salvarAltCBox.setName("salvarAltCBox"); // NOI18N
        salvarAltCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAltCBoxActionPerformed(evt);
            }
        });

        fecharButton.setText("Fechar");
        fecharButton.setName("fecharButton"); // NOI18N
        fecharButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(configSisHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(salvarAltCBox)
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(fecharButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(configSisHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salvarAltCBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fecharButton)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-153)/2, 416, 153);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharButtonActionPerformed
        
        dispose();

    }//GEN-LAST:event_fecharButtonActionPerformed

    private void salvarAltCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAltCBoxActionPerformed

        try{
            propsUtil.lerArqProps(PATH_RECURSO_CONFIG);
            Properties props = propsUtil.getProperties();
            props.setProperty(PROP_CSD_SALVAR_CHECK, String.valueOf(salvarAltCBox.isSelected()));
            propsUtil.escreverArqProps(props, PATH_RECURSO_CONFIG);
            Logger.getLogger(ConfigSisDialog.class.getName()).log(Level.INFO, "Salvando opção p/ salvar alterações");
        }catch(Exception ex){
            logSis.erro(ex.getMessage(), ex);
            JMessageUtil.showWarningMessage(this, ex.getMessage());
        }

    }//GEN-LAST:event_salvarAltCBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            propsUtil.lerArqProps(PATH_RECURSO_CONFIG);
            salvarAltCBox.setSelected(Boolean.parseBoolean(propsUtil.getString(PROP_CSD_SALVAR_CHECK)));
        }catch(Exception ex){
            logSis.erro(ex.getMessage(), ex);
            JMessageUtil.showWarningMessage(this, ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConfigSisDialog dialog = new ConfigSisDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHeader configSisHeader;
    private javax.swing.JButton fecharButton;
    private javax.swing.JCheckBox salvarAltCBox;
    // End of variables declaration//GEN-END:variables

}
