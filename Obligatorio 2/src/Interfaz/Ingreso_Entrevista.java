package Interfaz;

import Dominio.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Ingreso_Entrevista extends javax.swing.JFrame implements Observer {

    private DefaultListModel modelEvalu = new DefaultListModel();
    private DefaultListModel modelPostu = new DefaultListModel();

    public Ingreso_Entrevista(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        for (Postulante postulante : modelo.getListaPostulantes()) {
            modelPostu.addElement(postulante.toString());
        }
        for (Evaluador evaluador : modelo.getListaEvaluadores()) {
            modelEvalu.addElement(evaluador.toString());
        }
        lista_evaluadores.setModel(modelEvalu);
        lista_postulantes.setModel(modelPostu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_postulantes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_evaluadores = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTextArea();
        registrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        puntaje = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso de entrevista");

        jScrollPane1.setViewportView(lista_postulantes);

        jScrollPane2.setViewportView(lista_evaluadores);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Postulante");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Evaluador");

        jLabel4.setText("Puntaje (0-100):");

        jLabel5.setText("Comentarios:");

        comentarios.setColumns(20);
        comentarios.setRows(5);
        jScrollPane3.setViewportView(comentarios);

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

        puntaje.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(puntaje)))
                            .addComponent(cancelar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(puntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar)
                    .addComponent(cancelar))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String elemEvalu = lista_evaluadores.getSelectedValue();
        try {
            int inicioE = elemEvalu.indexOf("(") + 1;
            int finE = elemEvalu.indexOf(")");
            String evalu = elemEvalu.substring(inicioE, finE);
            int cedula = Integer.parseInt(evalu);
            String elemPostu = lista_postulantes.getSelectedValue();
            int inicioP = elemPostu.indexOf("(") + 1;
            int finP = elemPostu.indexOf(")");
            String postu = elemPostu.substring(inicioP, finP);
            if (elemEvalu == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un evaluador", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (elemPostu == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un postulante", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                Evaluador evaluador = modelo.devolverEvaluador(cedula);
                Postulante postulante = modelo.devolverPostulante(postu);
                int puntos = (int) puntaje.getValue();
                String coments = comentarios.getText();
                if (coments.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe agregar un comentario", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numeroEntrevista = modelo.devolverNumEntrevista();
                    Entrevista entrevista = new Entrevista(numeroEntrevista, postulante, evaluador, puntos, coments);
                    modelo.agregarEntrevista(entrevista);
                    JOptionPane.showMessageDialog(null, "La entrevista fue agregada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Asegurese que en ambas listas halla un postulante y un evaluador seleccionados.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed
    @Override
    public void update(Observable o, Object arg) {
        // Asegurarse de que la actualización se realiza en el hilo de despacho de eventos (event dispatch thread)
        SwingUtilities.invokeLater(() -> {
            // Actualizar la lista de postulantes en la interfaz
            updatePostulantesYEvaluadores();
        });
    }

    private void updatePostulantesYEvaluadores() {
        modelPostu.removeAllElements();
        modelEvalu.removeAllElements();
        for (Postulante postulante : modelo.getListaPostulantes()) {
            modelPostu.addElement(postulante.toString());
        }
        for (Evaluador evaluador : modelo.getListaEvaluadores()) {
            modelEvalu.addElement(evaluador.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextArea comentarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lista_evaluadores;
    private javax.swing.JList<String> lista_postulantes;
    private javax.swing.JSpinner puntaje;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
