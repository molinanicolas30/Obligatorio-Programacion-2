package Interfaz;

import Dominio.*;
import java.io.*;
import javax.swing.*;

public class Inicio extends javax.swing.JFrame {

    public Inicio(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guardado = new javax.swing.JRadioButton();
        vacio = new javax.swing.JRadioButton();
        siguiente_inicio = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Personal");

        jLabel2.setText("Bienvenido, seleccione una opcion:");

        buttonGroup1.add(guardado);
        guardado.setText("Iniciar usando los datos guardados");

        buttonGroup1.add(vacio);
        vacio.setText("Iniciar con el sistema vacio (elimina datos anteriores)");
        vacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vacioActionPerformed(evt);
            }
        });

        siguiente_inicio.setText("Siguiente");
        siguiente_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente_inicioActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(siguiente_inicio)
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vacio)
                    .addComponent(guardado))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(vacio)
                .addGap(28, 28, 28)
                .addComponent(guardado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente_inicio)
                    .addComponent(cancelar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vacioActionPerformed

    private void siguiente_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente_inicioActionPerformed
        JFrame menu;
        if (vacio.isSelected()) {
            // Continuar sin cargar datos, eliminar el archivo si existe
            File archivoDatos = new File("datos.dat");
            if (archivoDatos.exists()) {
                archivoDatos.delete();
            }
            menu = new Menu(modelo);
        } else if (guardado.isSelected()) {
            // Continuar con datos precargados
            File archivoDatos = new File("datos.dat");
            if (archivoDatos.exists()) {
                modelo = Persistencia.cargarDatos("datos.dat");
            }else{
                JOptionPane.showMessageDialog(null, "Error al cargar datos. Iniciando con sistema vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                modelo = new Sistema(); // Iniciar con sistema vacío en caso de error
            }
           
           
            menu = new Menu(modelo);
        } else {
            // Ningún radio button seleccionado, manejar según tus necesidades
            // Por ejemplo, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Seleccione una opción antes de continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // No continúes si no hay una opción seleccionada
        }
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_siguiente_inicioActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton guardado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton siguiente_inicio;
    private javax.swing.JRadioButton vacio;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
