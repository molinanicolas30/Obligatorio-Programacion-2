package Interfaz;

import Dominio.*;
import javax.swing.*;
import java.util.*;

public class Registro_Puesto extends javax.swing.JFrame implements Observer {

    DefaultListModel modelLista = new DefaultListModel();
    ArrayList<String> lista_temas = new ArrayList<>();

    public Registro_Puesto(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        temas_requeridos.setModel(modelLista);
        for (Tematica tema : modelo.getListaTemas()) {
            temas_combo.addItem(tema.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nom_puesto = new javax.swing.JTextPane();
        remoto = new javax.swing.JRadioButton();
        presencial = new javax.swing.JRadioButton();
        mixto = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        temas_requeridos = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        temas_combo = new javax.swing.JComboBox<>();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registo de Puesto");

        jLabel2.setText("Puesto:");

        jScrollPane1.setViewportView(nom_puesto);

        buttonGroup1.add(remoto);
        remoto.setText("Remoto");
        remoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remotoActionPerformed(evt);
            }
        });

        buttonGroup1.add(presencial);
        presencial.setText("Presencial");
        presencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presencialActionPerformed(evt);
            }
        });

        buttonGroup1.add(mixto);
        mixto.setText("Mixto");
        mixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mixtoActionPerformed(evt);
            }
        });

        jLabel3.setText("Temas requeridos:");

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        temas_requeridos.setAutoscrolls(false);
        temas_requeridos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        temas_requeridos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(temas_requeridos);

        jLabel4.setText("Temas :");

        temas_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temas_comboActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Formato");

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
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(registrar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(79, 79, 79)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(remoto)
                                                .addGap(18, 18, 18)
                                                .addComponent(presencial)
                                                .addGap(18, 18, 18)
                                                .addComponent(mixto)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jScrollPane1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(temas_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(eliminar))
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(agregar)))
                                .addGap(4, 30, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(remoto)
                    .addComponent(presencial)
                    .addComponent(mixto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(temas_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar)
                    .addComponent(cancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remotoActionPerformed

    private void presencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presencialActionPerformed

    private void mixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mixtoActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        ArrayList<String> tema = new ArrayList<>();
        String nombrePuesto = nom_puesto.getText();

        // Obtener el tipo de puesto seleccionado
        String tipoPuesto = "";
        if (remoto.isSelected()) {
            tipoPuesto = "Remoto";
        } else if (presencial.isSelected()) {
            tipoPuesto = "Presencial";
        } else if (mixto.isSelected()) {
            tipoPuesto = "Mixto";
        }
        if (nombrePuesto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar registrar un puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (modelo.seRepitePuesto(nombrePuesto)) {
            JOptionPane.showMessageDialog(null, "Ya existe este Puesto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (tipoPuesto.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Formato", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (modelLista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un tema", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            ListModel<String> model = temas_requeridos.getModel();
            int size = model.getSize();

            for (int i = 0; i < size; i++) {
                String elem = model.getElementAt(i);
                tema.add(elem);
            }
            Puesto puesto = new Puesto(nombrePuesto, tipoPuesto, tema);
            modelo.agregarPuesto(puesto);
            JOptionPane.showMessageDialog(null, "El puesto fue agregado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }

    }//GEN-LAST:event_registrarActionPerformed

    private void temas_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temas_comboActionPerformed

    }//GEN-LAST:event_temas_comboActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String elemList = temas_requeridos.getSelectedValue();
        if(elemList != null){
            lista_temas.remove(elemList);
            modelLista.removeAllElements();
            for (String elem : lista_temas) {
                modelLista.addElement(elem);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Asegurese que  halla un tema seleccionado.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        String combo = temas_combo.getSelectedItem().toString(); // Esto trae lo de adentro del combo

        if (lista_temas.contains(combo)) {
            JOptionPane.showMessageDialog(null, "El tema ya fue agregado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            lista_temas.add(combo);
            modelLista.removeAllElements();
            for (String tema : lista_temas) {
                modelLista.addElement(tema);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed
    @Override
    public void update(Observable o, Object arg) {
        // Asegurarse de que la actualización se realiza en el hilo de despacho de eventos (event dispatch thread)
        SwingUtilities.invokeLater(() -> {
            // Actualizar la lista de postulantes en la interfaz
            updatePostulantes();
        });
    }

    private void updatePostulantes() {
        temas_combo.removeAllItems();
        for (Tematica tema : modelo.getListaTemas()) {
            temas_combo.addItem(tema.getNombre());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton mixto;
    private javax.swing.JTextPane nom_puesto;
    private javax.swing.JRadioButton presencial;
    private javax.swing.JButton registrar;
    private javax.swing.JRadioButton remoto;
    private javax.swing.JComboBox<String> temas_combo;
    private javax.swing.JList<String> temas_requeridos;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
