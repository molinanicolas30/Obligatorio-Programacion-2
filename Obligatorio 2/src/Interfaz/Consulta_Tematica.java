package Interfaz;

import Dominio.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Consulta_Tematica extends javax.swing.JFrame implements Observer{

    private DefaultListModel modelTema = new DefaultListModel();

    public Consulta_Tematica(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        for (Tematica tema : modelo.getListaTemas()) {
            String nombre = tema.getNombre();
            String tematica = nombre;
            modelTema.addElement(tematica);
        }
        listaT.setModel(modelTema);
        listaT.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Manejar el evento de selección aquí
                if (!e.getValueIsAdjusting()) {
                    // Obtener el índice seleccionado
                    int index = listaT.getSelectedIndex();
                    if (index != -1) {
                        String tema = listaT.getSelectedValue();
                        int cantidadPo = 0;
                        int cantidadPu = 0;
                        for (Postulante postulante : modelo.getListaPostulantes()) {
                            String nombre = postulante.getNombre();
                            ArrayList<String> postuExp = postulante.getExperiencia();

                            for (int i = 0; i < postulante.getExperiencia().size(); i++) {
                                String postuTema = postulante.getExperiencia().get(i);
                                int nivel = postulante.getNivelExperiencia().get(i);
                                if (postuTema.equals(tema)) {
                                    if (nivel > 5) {
                                        cantidadPo++;
                                    }
                                }

                            }
                        }
                        String strCantidadPo = String.valueOf(cantidadPo);
                        cantPo.setText(strCantidadPo);
                        for (Puesto puesto : modelo.getListaPuestos()) {
                            ArrayList<String> temasPuesto = puesto.getTema();
                            for (String temaPu : temasPuesto) {
                                if (temaPu.equals(tema)) {
                                    cantidadPu++;
                                }

                            }
                        }
                        String strCantidadPu = String.valueOf(cantidadPu);
                        System.out.println(strCantidadPu);
                        cantPu.setText(strCantidadPu);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaT = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cantPo = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cantPu = new javax.swing.JTextPane();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta por tematica");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de Tematicas");

        jScrollPane1.setViewportView(listaT);

        jLabel3.setText("Postulates con un nivel mayor a 5:");

        cantPo.setEditable(false);
        jScrollPane2.setViewportView(cantPo);

        jLabel4.setText("Puestos que cumplen con la tematica:");

        cantPu.setEditable(false);
        jScrollPane3.setViewportView(cantPu);

        cancelar.setText("Volver");
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
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        modelTema.removeAllElements();
         for (Tematica tema : modelo.getListaTemas()) {
            String nombre = tema.getNombre();
            String tematica = nombre;
            modelTema.addElement(tematica);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextPane cantPo;
    private javax.swing.JTextPane cantPu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaT;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
