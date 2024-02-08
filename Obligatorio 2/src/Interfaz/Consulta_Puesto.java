package Interfaz;

import Dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Consulta_Puesto extends javax.swing.JFrame implements Observer {

    private DefaultListModel modelPuesto = new DefaultListModel();
    private DefaultListModel modelPostu = new DefaultListModel();

    public Consulta_Puesto(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        for (Puesto pu : modelo.getListaPuestos()) {
            String nombre = pu.getNombre();
            String puesto = nombre;
            modelPuesto.addElement(puesto);
        }
        listaPuestos.setModel(modelPuesto);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPuestos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPostulantes = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        nivel = new javax.swing.JSpinner();
        consultar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        exportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta para Puestos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Puestos");

        jScrollPane1.setViewportView(listaPuestos);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Postulantes");

        jScrollPane2.setViewportView(listaPostulantes);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nivel:");

        nivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        nivel.setFocusCycleRoot(true);

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        exportar.setText("Exportar");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
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
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(108, 108, 108)
                                    .addComponent(consultar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(exportar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(exportar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        modelPostu.removeAllElements();
        int nivelSpinner = (int) nivel.getValue();
        String elemPuesto = listaPuestos.getSelectedValue();
        try {
            // Obtener temas requeridos por el puesto
            ArrayList<String> temasRequeridos = modelo.devolverTemasRequePuesto(elemPuesto);

            // Filtrar postulantes
            ArrayList<Postulante> postulantesCoinciden = new ArrayList<>();
            for (int i = 0; i < modelo.devolverPostulantesConEntrevista().size(); i++) {
                Entrevista entrevista = modelo.devolverPostulantesConEntrevista().get(i);
                Postulante postulante = entrevista.getPostualnte();
                if (cumpleRequisitos(postulante, temasRequeridos, nivelSpinner) == temasRequeridos.size()) {
                    postulantesCoinciden.add(postulante);
                    System.out.println("Se agregó el postulante a coinciden: " + postulante.getNombre());
                }
            }

            // Mostrar postulantes en el JList
            for (int i = postulantesCoinciden.size() - 1; i >= 0; i--) {
                Postulante siCumple = postulantesCoinciden.get(i);
                modelPostu.addElement(siCumple.getNombre());
            }

            listaPostulantes.setModel(modelPostu);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento de la lista.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_consultarActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        String nombrePuesto = listaPuestos.getSelectedValue();
        if (nombrePuesto == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un puesto antes de exportar", "Exportar", JOptionPane.WARNING_MESSAGE);
            return;  // Salir del método si no hay puesto seleccionado
        }
        // Crear el archivo "Consulta.txt" en la misma carpeta del proyecto
        File fileToSave = new File("Consulta.txt");

        try (PrintWriter writer = new PrintWriter(fileToSave)) {
            // Obtener el nombre del puesto seleccionado

            writer.println(nombrePuesto);  // Escribir el nombre del puesto en la primera línea

            // Obtener los elementos de la lista de postulantes
            ListModel<String> model = listaPostulantes.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                String nombrePostulante = model.getElementAt(i);
                // Obtener el postulante correspondiente al nombre
                Postulante postulante = obtenerPostulantePorNombre(nombrePostulante);

                // Escribir los datos del postulante en el archivo
                writer.println(postulante.getNombre() + ", " + postulante.getCedula() + ", " + postulante.getMail());
            }
            JOptionPane.showMessageDialog(this, "Datos exportados exitosamente", "Exportar", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al exportar datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exportarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private int cumpleRequisitos(Postulante postulante, ArrayList<String> temasRequeridos, int nivelSpinner) {
        int cumple = 0;
        for (int i = 0; i < postulante.getExperiencia().size(); i++) {
            String tema = postulante.getExperiencia().get(i);
            int nivelExp = postulante.getNivelExperiencia().get(i);

            // Verificar si el postulante cumple con los requisitos de tema y nivel
            if (temasRequeridos.contains(tema) && nivelExp >= nivelSpinner) {
                cumple++;
            }
        }
        return cumple;
    }

    private Postulante obtenerPostulantePorNombre(String nombrePostulante) {
        for (Entrevista entrevista : modelo.devolverPostulantesConEntrevista()) {
            Postulante postulante = entrevista.getPostualnte();
            if (postulante.getNombre().equals(nombrePostulante)) {
                return postulante;
            }
        }
        return null;  // Devolver null si no se encuentra el postulante
    }

    @Override
    public void update(Observable o, Object arg) {
        // Asegurarse de que la actualización se realiza en el hilo de despacho de eventos (event dispatch thread)
        SwingUtilities.invokeLater(() -> {
            // Actualizar la lista de postulantes en la interfaz
            updatePostulantes();
        });
    }

    private void updatePostulantes() {
        modelPuesto.removeAllElements();
        for (Puesto pu : modelo.getListaPuestos()) {
            String nombre = pu.getNombre();
            String puesto = nombre;
            modelPuesto.addElement(puesto);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton consultar;
    private javax.swing.JButton exportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listaPostulantes;
    private javax.swing.JList<String> listaPuestos;
    private javax.swing.JSpinner nivel;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
