package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.*;

public class Registro_Evaluador extends javax.swing.JFrame {

    public Registro_Evaluador(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        registro = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        nombreEv = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        cedulaEv = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccionEv = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        yearEv = new javax.swing.JTextPane();

        jScrollPane5.setViewportView(jTextPane1);

        jScrollPane6.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de evaluador");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Cédula:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Año de ingreso:");

        registro.setText("Registrar");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(nombreEv);

        jScrollPane2.setViewportView(cedulaEv);

        jScrollPane1.setViewportView(direccionEv);

        jScrollPane4.setViewportView(yearEv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registro)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cancelar)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane4))))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registro)
                    .addComponent(cancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        String nombre = nombreEv.getText();
        String cedula = cedulaEv.getText();
        String direccion = direccionEv.getText();
        String yearIngresoStr = yearEv.getText();
        boolean cedulaPostu = false;
        for (Postulante postu : modelo.getListaPostulantes()) {
            if (postu.getCedula() == cedula) {
                cedulaPostu = true;
            }
        }

        //int numCedula = Integer.parseInt(cedula);
        if (cedulaPostu) {
            JOptionPane.showMessageDialog(null, "Existe un postulante registrado con esa cedula", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (!modelo.verificarCedula(cedula)) {
            JOptionPane.showMessageDialog(null, "La cedula debe ser un numero de 8 digitos y no debe contener ni  ``.``  ni  ``-`` ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
           
            if ( modelo.seRepiteCedula( cedula)) {
                JOptionPane.showMessageDialog(null, "Ya existe un evaluador o un postulante registrado con esa cedula", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (nombre.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || yearIngresoStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!yearIngresoStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Debe ser un numero", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int yearIngreso = Integer.parseInt(yearIngresoStr);
                Calendar calendario = Calendar.getInstance();
                int yearNow = calendario.get(Calendar.YEAR);
                if (yearIngreso > yearNow) {
                    JOptionPane.showMessageDialog(null, "El año no puede ser mayor al actual("+yearNow +")", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numCedula = Integer.parseInt(cedula);
                    Evaluador ev = new Evaluador(nombre, numCedula, direccion, yearIngreso);
                    modelo.agregarEvaluador(ev);
                    JOptionPane.showMessageDialog(null, "El evaluador fue agregado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
        }

    }//GEN-LAST:event_registroActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextPane cedulaEv;
    private javax.swing.JTextPane direccionEv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane nombreEv;
    private javax.swing.JButton registro;
    private javax.swing.JTextPane yearEv;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
