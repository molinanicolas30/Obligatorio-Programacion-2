package Interfaz;

import Dominio.*;
import Interfaz.Alta_Postulante;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Menu extends javax.swing.JFrame {

    public Menu(Sistema sistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = sistema;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes realizar acciones antes de que el JFrame se cierre
                Persistencia.guardarDatos(sistema, "datos.dat");

                // Asegurarse de que la aplicación se cierre correctamente
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        regis_postu = new javax.swing.JMenuItem();
        regis_temat = new javax.swing.JMenuItem();
        regis_evalu = new javax.swing.JMenuItem();
        regis_puesto = new javax.swing.JMenuItem();
        ingre_entrevista = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        consul_puesto = new javax.swing.JMenuItem();
        consul_tema = new javax.swing.JMenuItem();
        hist_postu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        baja_postu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(getBackground());
        setLocation(new java.awt.Point(400, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 410));

        jMenu1.setText("Registrar");

        regis_postu.setText("Registrar Postulante");
        regis_postu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regis_postuActionPerformed(evt);
            }
        });
        jMenu1.add(regis_postu);

        regis_temat.setText("Registrar Tematica");
        regis_temat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regis_tematActionPerformed(evt);
            }
        });
        jMenu1.add(regis_temat);

        regis_evalu.setText("Registrar Evaluador");
        regis_evalu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regis_evaluActionPerformed(evt);
            }
        });
        jMenu1.add(regis_evalu);

        regis_puesto.setText("Registrar Puesto");
        regis_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regis_puestoActionPerformed(evt);
            }
        });
        jMenu1.add(regis_puesto);

        ingre_entrevista.setText("Ingresar Entrevista");
        ingre_entrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingre_entrevistaActionPerformed(evt);
            }
        });
        jMenu1.add(ingre_entrevista);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        consul_puesto.setText("Consultar Puesto");
        consul_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consul_puestoActionPerformed(evt);
            }
        });
        jMenu2.add(consul_puesto);

        consul_tema.setText("Consultar Tematica");
        consul_tema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consul_temaActionPerformed(evt);
            }
        });
        jMenu2.add(consul_tema);

        hist_postu.setText("Historia Postulante");
        hist_postu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hist_postuActionPerformed(evt);
            }
        });
        jMenu2.add(hist_postu);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Dar de Baja");

        baja_postu.setText("Baja Postulante");
        baja_postu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baja_postuActionPerformed(evt);
            }
        });
        jMenu3.add(baja_postu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regis_postuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regis_postuActionPerformed
        ArrayList<Tematica> verTemas = modelo.getListaTemas();
        if (verTemas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar una Tematica", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            JFrame Alta_Postulante = new Alta_Postulante(modelo);
            Alta_Postulante.setVisible(true);
            Alta_Postulante.setLocationRelativeTo(null);
            Alta_Postulante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_regis_postuActionPerformed

    private void regis_tematActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regis_tematActionPerformed
        JFrame Registrar_Tematica = new Registrar_Tematica(modelo);
        Registrar_Tematica.setVisible(true);
        Registrar_Tematica.setLocationRelativeTo(null);
        Registrar_Tematica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_regis_tematActionPerformed

    private void regis_evaluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regis_evaluActionPerformed
        JFrame Registro_Evaluador = new Registro_Evaluador(modelo);
        Registro_Evaluador.setVisible(true);
        Registro_Evaluador.setLocationRelativeTo(null);
        Registro_Evaluador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_regis_evaluActionPerformed

    private void consul_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consul_puestoActionPerformed
        ArrayList<Puesto> verPuestos = modelo.getListaPuestos();
        if (verPuestos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar un Puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            JFrame Consulta_Puesto = new Consulta_Puesto(modelo);
            Consulta_Puesto.setVisible(true);
            Consulta_Puesto.setLocationRelativeTo(null);
            Consulta_Puesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_consul_puestoActionPerformed

    private void consul_temaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consul_temaActionPerformed
        ArrayList<Tematica> verTemas = modelo.getListaTemas();
        if (verTemas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar una Tematica", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            JFrame Consulta_Tematica = new Consulta_Tematica(modelo);
            Consulta_Tematica.setVisible(true);
            Consulta_Tematica.setLocationRelativeTo(null);
            Consulta_Tematica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_consul_temaActionPerformed

    private void hist_postuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hist_postuActionPerformed
        ArrayList<Postulante> verPostus = modelo.getListaPostulantes();
        if (verPostus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar un Postulante", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            JFrame Historia_Postulante = new Historia_Postulante(modelo);
            Historia_Postulante.setVisible(true);
            Historia_Postulante.setLocationRelativeTo(null);
            Historia_Postulante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_hist_postuActionPerformed

    private void baja_postuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baja_postuActionPerformed
        ArrayList<Postulante> verPostus = modelo.getListaPostulantes();
        if (verPostus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar un Postulante", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            JFrame Baja_Postulante = new Baja_Postulante(modelo);
            Baja_Postulante.setVisible(true);
            Baja_Postulante.setLocationRelativeTo(null);
            Baja_Postulante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
    }//GEN-LAST:event_baja_postuActionPerformed

    private void regis_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regis_puestoActionPerformed
        ArrayList<Tematica> verTemas = modelo.getListaTemas();
        if (verTemas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar una Tematica", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            JFrame Registro_Puesto = new Registro_Puesto(modelo);
            Registro_Puesto.setVisible(true);
            Registro_Puesto.setLocationRelativeTo(null);
            Registro_Puesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_regis_puestoActionPerformed

    private void ingre_entrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingre_entrevistaActionPerformed
        ArrayList<Postulante> verPostus = modelo.getListaPostulantes();
        ArrayList<Evaluador> verEvalu = modelo.getListaEvaluadores();
        if (verPostus.isEmpty() || verEvalu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe registrar un Evaluador y un Postulante", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            JFrame Ingreso_Entrevista = new Ingreso_Entrevista(modelo);
            Ingreso_Entrevista.setVisible(true);
            Ingreso_Entrevista.setLocationRelativeTo(null);
            Ingreso_Entrevista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_ingre_entrevistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem baja_postu;
    private javax.swing.JMenuItem consul_puesto;
    private javax.swing.JMenuItem consul_tema;
    private javax.swing.JMenuItem hist_postu;
    private javax.swing.JMenuItem ingre_entrevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem regis_evalu;
    private javax.swing.JMenuItem regis_postu;
    private javax.swing.JMenuItem regis_puesto;
    private javax.swing.JMenuItem regis_temat;
    // End of variables declaration//GEN-END:variables
   private Sistema modelo;
}
