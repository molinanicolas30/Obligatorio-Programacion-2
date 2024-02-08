package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Alta_Postulante_2 extends javax.swing.JFrame implements Observer {

    DefaultListModel modelLista = new DefaultListModel();
    ArrayList<String> experienciaLista = new ArrayList();
    ArrayList<Integer> nivelExperienciaLista = new ArrayList();

    public Alta_Postulante_2(Sistema sistema, String nombreInfo, String cedulaInfo, String direccionInfo, String telefonoInfo, String mailInfo, String linkInfo, String formatoInfo) {
        initComponents();
        lista.setModel(modelLista);
        nivel.setValue(1);
        modelo = sistema;
        modelo.addObserver(this);
        nombre = nombreInfo;
        cedula = cedulaInfo;
        direccion = direccionInfo;
        telefono = telefonoInfo;
        mail = mailInfo;
        linkedin = linkInfo;
        formato = formatoInfo;
        modelLista.removeAllElements();
        for (Tematica tema : modelo.getListaTemas()) {

            String item = tema.getNombre().toString();
            tema_combo.addItem(item);
        }
    }

    public void mostrarVentanaAltaPostulante2() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nivel = new javax.swing.JSpinner();
        agregar = new javax.swing.JButton();
        tema_combo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        registrar_postulante = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Tema:");

        jLabel2.setText("Nivel");

        nivel.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        nivel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nivelStateChanged(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        tema_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tema_comboActionPerformed(evt);
            }
        });

        jLabel3.setText("Experiencia:");

        jScrollPane1.setViewportView(lista);

        registrar_postulante.setText("Registrar");
        registrar_postulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_postulanteActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
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
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registrar_postulante))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(eliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tema_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tema_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(eliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(registrar_postulante))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        String combo = tema_combo.getSelectedItem().toString(); // Esto trae lo de adentro del combo

        if (experienciaLista.contains(combo)) {
            JOptionPane.showMessageDialog(null, "El tema ya fue agregado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int level = (int) nivel.getValue();

            nivelExperienciaLista.add(level);
            experienciaLista.add(combo);

            modelLista.removeAllElements();
            for (int i = 0; i < experienciaLista.size(); i++) {
                String exp = experienciaLista.get(i);
                int numero = nivelExperienciaLista.get(i);
                modelLista.addElement(exp + "(" + numero + ")");
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void registrar_postulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_postulanteActionPerformed
        ArrayList<String> experiencia = new ArrayList<>();
        if (modelLista.size() > 0) {
            Postulante postu = new Postulante(nombre, cedula, direccion, telefono, mail, linkedin, formato, experienciaLista, nivelExperienciaLista);
            modelo.agregarPostulante(postu);
            JOptionPane.showMessageDialog(null, "El postulante fue agregado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un tema", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_registrar_postulanteActionPerformed


    private void tema_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tema_comboActionPerformed

    }//GEN-LAST:event_tema_comboActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String elemList = lista.getSelectedValue();
        try {
            int inicio = elemList.indexOf("(");
            String tema = elemList.substring(0, inicio);
            int posicioneliminar = experienciaLista.indexOf(tema);
            experienciaLista.remove(posicioneliminar);
            nivelExperienciaLista.remove(posicioneliminar);
            modelLista.removeAllElements();
            for (int i = 0; i < experienciaLista.size(); i++) {
                String exp = experienciaLista.get(i);
                int numero = nivelExperienciaLista.get(i);
                modelLista.addElement(exp + "(" + numero + ")");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Asegurese que  halla un tema seleccionado.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void nivelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nivelStateChanged
        int numero = (int) nivel.getValue();
        if (numero < 1) {
            nivel.setValue(1);
        }
        if (numero > 10) {
            nivel.setValue(10);
        }
    }//GEN-LAST:event_nivelStateChanged

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        modelLista.removeAllElements();
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
        tema_combo.removeAllItems();
        for (Tematica tema : modelo.getListaTemas()) {
            tema_combo.addItem(tema.getNombre());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> lista;
    private javax.swing.JSpinner nivel;
    private javax.swing.JButton registrar_postulante;
    private javax.swing.JComboBox<String> tema_combo;
    // End of variables declaration//GEN-END:variables

    private Sistema modelo;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String mail;
    private String linkedin;
    private String formato;
}
