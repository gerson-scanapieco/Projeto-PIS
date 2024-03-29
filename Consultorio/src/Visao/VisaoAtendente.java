/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VisaoAtendente.java
 *
 * Created on Nov 30, 2011, 12:39:40 AM
 */
package Visao;

import Controle.Controler;
import Modelo.SessaoAtendente;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author Gerson
 */
public class VisaoAtendente extends javax.swing.JFrame {

    /** Creates new form VisaoAtendente */
   // public VisaoAtendente() {
   //     initComponents();
   // }    
    public VisaoAtendente() {
        this.myControler = Controler.getInstance();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        deslogarMenuItem = new javax.swing.JMenuItem();
        sairMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cadastrarPacienteMenuItem = new javax.swing.JMenuItem();
        editarPacienteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        marcarConsultaMenuItem = new javax.swing.JMenuItem();
        editarConsultaMenuItem = new javax.swing.JMenuItem();
        verificarPagamentoMenuItem = new javax.swing.JMenuItem();
        efetuarPagamentoMenuItem = new javax.swing.JMenuItem();
        funcionarioMenu = new javax.swing.JMenu();
        cadastrarAtendenteMenuItem = new javax.swing.JMenuItem();
        cadastrarMedicoMenuItem = new javax.swing.JMenuItem();
        editarAtendenteMenuItem = new javax.swing.JMenuItem();
        editarMedicoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeMenu.setMnemonic('f');
        homeMenu.setText("Home");

        deslogarMenuItem.setMnemonic('o');
        deslogarMenuItem.setText("Deslogar");
        deslogarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deslogarMenuItemActionPerformed(evt);
            }
        });
        homeMenu.add(deslogarMenuItem);

        sairMenuItem.setMnemonic('s');
        sairMenuItem.setText("Sair");
        sairMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuItemActionPerformed(evt);
            }
        });
        homeMenu.add(sairMenuItem);

        menuBar.add(homeMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Paciente");

        cadastrarPacienteMenuItem.setMnemonic('t');
        cadastrarPacienteMenuItem.setText("Cadastrar Paciente");
        cadastrarPacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPacienteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cadastrarPacienteMenuItem);

        editarPacienteMenuItem.setMnemonic('y');
        editarPacienteMenuItem.setText("Editar Paciente");
        editarPacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPacienteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editarPacienteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Consulta");

        marcarConsultaMenuItem.setMnemonic('c');
        marcarConsultaMenuItem.setText("Marcar Consulta");
        marcarConsultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarConsultaMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(marcarConsultaMenuItem);

        editarConsultaMenuItem.setMnemonic('a');
        editarConsultaMenuItem.setText("Editar Consulta");
        editarConsultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarConsultaMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(editarConsultaMenuItem);

        verificarPagamentoMenuItem.setText("Verificar Pagamento");
        verificarPagamentoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarPagamentoMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(verificarPagamentoMenuItem);

        efetuarPagamentoMenuItem.setText("Efetuar Pagamento");
        efetuarPagamentoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efetuarPagamentoMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(efetuarPagamentoMenuItem);

        menuBar.add(helpMenu);

        funcionarioMenu.setText("Funcionario");

        cadastrarAtendenteMenuItem.setText("Cadastrar Atendente");
        cadastrarAtendenteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAtendenteMenuItemActionPerformed(evt);
            }
        });
        funcionarioMenu.add(cadastrarAtendenteMenuItem);

        cadastrarMedicoMenuItem.setText("Cadastrar Medico");
        cadastrarMedicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMedicoMenuItemActionPerformed(evt);
            }
        });
        funcionarioMenu.add(cadastrarMedicoMenuItem);

        editarAtendenteMenuItem.setText("Editar Atendente");
        editarAtendenteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAtendenteMenuItemActionPerformed(evt);
            }
        });
        funcionarioMenu.add(editarAtendenteMenuItem);

        editarMedicoMenuItem.setText("Editar Medico");
        editarMedicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMedicoMenuItemActionPerformed(evt);
            }
        });
        funcionarioMenu.add(editarMedicoMenuItem);

        menuBar.add(funcionarioMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarPacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPacienteMenuItemActionPerformed
        // TODO add your handling code here:
        TelaCadastrarPaciente frame = new TelaCadastrarPaciente();
        frame.setVisible(true);
    }//GEN-LAST:event_cadastrarPacienteMenuItemActionPerformed

    private void editarPacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPacienteMenuItemActionPerformed
        // TODO add your handling code here:
        TelaEditarPaciente frame = new TelaEditarPaciente();
        frame.setVisible(true);
    }//GEN-LAST:event_editarPacienteMenuItemActionPerformed

    private void marcarConsultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarConsultaMenuItemActionPerformed
        // TODO add your handling code here:
        TelaMarcarConsulta frame = new TelaMarcarConsulta();
        frame.setVisible(true);
        
    }//GEN-LAST:event_marcarConsultaMenuItemActionPerformed

    private void editarConsultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarConsultaMenuItemActionPerformed
        // TODO add your handling code here:
        TelaEditarConsulta frame = new TelaEditarConsulta();
        frame.setVisible(true);
        
    }//GEN-LAST:event_editarConsultaMenuItemActionPerformed

    private void verificarPagamentoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarPagamentoMenuItemActionPerformed
        // TODO add your handling code here:
        TelaVerificarPagamento frame = new TelaVerificarPagamento();
        frame.setVisible(true);
    }//GEN-LAST:event_verificarPagamentoMenuItemActionPerformed

    private void efetuarPagamentoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efetuarPagamentoMenuItemActionPerformed
        // TODO add your handling code here:
        TelaEfetuarPagamento frame = new TelaEfetuarPagamento();
        frame.setVisible(true);
    }//GEN-LAST:event_efetuarPagamentoMenuItemActionPerformed

    private void cadastrarAtendenteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAtendenteMenuItemActionPerformed
        // TODO add your handling code here:
        TelaCadastrarAtendente frame = new TelaCadastrarAtendente();
        frame.setVisible(true);
    }//GEN-LAST:event_cadastrarAtendenteMenuItemActionPerformed

    private void cadastrarMedicoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMedicoMenuItemActionPerformed
        // TODO add your handling code here:
        TelaCadastrarMedico frame = new TelaCadastrarMedico();
        frame.setVisible(true);
    }//GEN-LAST:event_cadastrarMedicoMenuItemActionPerformed

    private void editarAtendenteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAtendenteMenuItemActionPerformed
        // TODO add your handling code here:
        TelaEditarAtendente frame = new TelaEditarAtendente();
        frame.setVisible(true);
    }//GEN-LAST:event_editarAtendenteMenuItemActionPerformed

    private void editarMedicoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMedicoMenuItemActionPerformed
        // TODO add your handling code here:
        TelaEditarMedico frame = new TelaEditarMedico();
        frame.setVisible(true);
    }//GEN-LAST:event_editarMedicoMenuItemActionPerformed

    private void sairMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMenuItemActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairMenuItemActionPerformed

    private void deslogarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deslogarMenuItemActionPerformed
        // TODO add your handling code here:
        VisaoLogin frame = new VisaoLogin();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deslogarMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(VisaoAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VisaoAtendente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrarAtendenteMenuItem;
    private javax.swing.JMenuItem cadastrarMedicoMenuItem;
    private javax.swing.JMenuItem cadastrarPacienteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem deslogarMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editarAtendenteMenuItem;
    private javax.swing.JMenuItem editarConsultaMenuItem;
    private javax.swing.JMenuItem editarMedicoMenuItem;
    private javax.swing.JMenuItem editarPacienteMenuItem;
    private javax.swing.JMenuItem efetuarPagamentoMenuItem;
    private javax.swing.JMenu funcionarioMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu homeMenu;
    private javax.swing.JMenuItem marcarConsultaMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem sairMenuItem;
    private javax.swing.JMenuItem verificarPagamentoMenuItem;
    // End of variables declaration//GEN-END:variables
    public Controler myControler;
}
