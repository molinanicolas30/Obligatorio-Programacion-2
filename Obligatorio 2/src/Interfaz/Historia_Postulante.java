package Interfaz;

import Dominio.*;
import java.awt.*;
import java.net.URI;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class Historia_Postulante extends javax.swing.JFrame implements Observer {

    private DefaultListModel modelPostu = new DefaultListModel();
    private DefaultListModel modelExpPostu = new DefaultListModel();
    private DefaultTableModel tabla_entrevistas_model;
    ArrayList<Postulante> ordenadoPostu;

    public Historia_Postulante(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        ordenadoPostu = new ArrayList<>(modelo.getListaPostulantes());
        Collections.sort(ordenadoPostu, Comparator.comparingInt(postulante -> Integer.parseInt(postulante.getCedula())));
        for (Postulante postu : ordenadoPostu) {
            modelPostu.addElement(postu.getNombre() + "(" + postu.getCedula() + ")");
        }
        listaPostulantes.setModel(modelPostu);
        String[] columnas_entrevistas = {"Nro", "Evaluador", "Puntaje", "Comentarios"};
        tabla_entrevistas_model = new DefaultTableModel(columnas_entrevistas, 0);
        tabla_entrevistas.setModel(tabla_entrevistas_model);
        int[] anchos = {60, 700, 200, 2900}; // Tamaños deseados para cada columna
        for (int i = 0; i < columnas_entrevistas.length; i++) {
            tabla_entrevistas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        // Agregar ListSelectionListener al JList
        listaPostulantes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Manejar el evento de selección aquí

                if (!e.getValueIsAdjusting()) {
                    // Obtener el índice seleccionado
                    int index = listaPostulantes.getSelectedIndex();
                    if (index != -1) {
                        String elemSelected = listaPostulantes.getSelectedValue();
                        int inicio = elemSelected.indexOf("(") + 1;
                        int fin = elemSelected.indexOf(")");
                        String postuNombre;
                        String cedula = elemSelected.substring(inicio, fin);
                        String direccion;
                        String telefono;
                        String mail;
                        String linkedin;
                        String formato;
                        ArrayList<Entrevista> entrevistas = new ArrayList<>(buscaEntrevistaDePostulante(cedula));
                        for (Postulante postulante : modelo.getListaPostulantes()) {
                            String cedulaPostu = postulante.getCedula();
                            if (cedula.equalsIgnoreCase(cedulaPostu)) {
                                postuNombre = postulante.getNombre();
                                direccion = postulante.getDireccion();
                                telefono = postulante.getTelefono();
                                mail = postulante.getMail();
                                linkedin = postulante.getLinkedin();
                                formato = postulante.getFormato();
                                ArrayList<String> experiencia = postulante.getExperiencia();
                                ArrayList<Integer> nivelExp = postulante.getNivelExperiencia();
                                nombreP.setText(postuNombre);
                                cedulaP.setText(cedula);
                                direccionP.setText(direccion);
                                telefonoP.setText(telefono);
                                mailP.setText(mail);
                                linkedinP.setText("<html><u><font color='blue'>" + linkedin + "</font></u></html>");
                                linkedinP.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                linkedinP.setEnabled(true);
                                formatoP.setText(formato);
                                modelExpPostu.clear();
                                for (int i = 0; i < experiencia.size(); i++) {
                                    String experienciaPostu = experiencia.get(i);
                                    int nivel = nivelExp.get(i);

                                    modelExpPostu.addElement(experienciaPostu + "(" + nivel + ")");
                                }

                                break;
                            }
                        }
                        listaExp.setModel(modelExpPostu);
                        tabla_entrevistas_model.setRowCount(0);
                        for (Entrevista entre : entrevistas) {
                            Evaluador evaluad = entre.getEvaluador();
                            String nombreEvalu = evaluad.getNombre();
                            Object[] fila = {entre.getNumeroEntrevista(), nombreEvalu + "(" + evaluad.getCedula() + ")", entre.getNivel(), entre.getComentarios()};
                            tabla_entrevistas_model.addRow(fila);
                        }

                    }
                }
            }

        });
    }

    private ArrayList<Entrevista> buscaEntrevistaDePostulante(String cedula) {
        ArrayList<Entrevista> entrevistas = new ArrayList<>();
        for (Entrevista entre : modelo.getListaEntrevistas()) {
            Postulante poss = entre.getPostualnte();
            String ci = poss.getCedula();
            if (ci.equals(cedula)) {
                entrevistas.add(entre);
            }
        }
        return entrevistas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPostulantes = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        loquebusco = new javax.swing.JTextPane();
        buscar = new javax.swing.JButton();
        resetear = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabla_entrevistas = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        listaExp = new javax.swing.JList<>();
        nombreP = new javax.swing.JLabel();
        cedulaP = new javax.swing.JLabel();
        direccionP = new javax.swing.JLabel();
        telefonoP = new javax.swing.JLabel();
        linkedinP = new javax.swing.JLabel();
        mailP = new javax.swing.JLabel();
        formatoP = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane12.setHorizontalScrollBar(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel1.setEnabled(false);

        jLabel7.setText("Mail:");

        jScrollPane1.setViewportView(listaPostulantes);

        jLabel6.setText("Teléfono:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Postulantes:");

        jLabel5.setText("Dirección:");

        jLabel4.setText("Cédula:");

        jLabel3.setText("Nombre:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial Postulante");

        jLabel8.setText("Linkedin:");

        jLabel9.setText("Formato:");

        jLabel11.setText("Experiencia:");

        jLabel10.setText("Buscar:");

        jScrollPane10.setViewportView(loquebusco);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        resetear.setText("Resetear");
        resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearActionPerformed(evt);
            }
        });

        tabla_entrevistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro", "Evaluador", "Puntaje", "Comentarios"
            }
        ));
        tabla_entrevistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tabla_entrevistas);
        if (tabla_entrevistas.getColumnModel().getColumnCount() > 0) {
            tabla_entrevistas.getColumnModel().getColumn(0).setResizable(false);
            tabla_entrevistas.getColumnModel().getColumn(1).setResizable(false);
            tabla_entrevistas.getColumnModel().getColumn(2).setResizable(false);
        }

        listaExp.setBackground(jPanel1.getBackground());
        listaExp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane13.setViewportView(listaExp);

        nombreP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nombreP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nombrePPropertyChange(evt);
            }
        });

        cedulaP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cedulaP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        direccionP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        direccionP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        telefonoP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        telefonoP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        linkedinP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        linkedinP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        linkedinP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                linkedinPMousePressed(evt);
            }
        });

        mailP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mailP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        formatoP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        formatoP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formatoP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        formatoP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formatoPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formatoPMousePressed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cedulaP, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                    .addComponent(direccionP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telefonoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(linkedinP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mailP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(formatoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane11))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(buscar)
                                .addGap(49, 49, 49)
                                .addComponent(resetear))
                            .addComponent(jButton3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(cedulaP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(direccionP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(telefonoP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(mailP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(linkedinP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(formatoP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar)
                        .addComponent(resetear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombrePPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nombrePPropertyChange

    }//GEN-LAST:event_nombrePPropertyChange

    private void formatoPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formatoPMouseClicked

    }//GEN-LAST:event_formatoPMouseClicked

    private void formatoPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formatoPMousePressed

    }//GEN-LAST:event_formatoPMousePressed

    private void linkedinPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkedinPMousePressed
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // Obtén la URL real eliminando las etiquetas HTML del texto del JLabel
                String labelText = linkedinP.getText();
                String url = labelText.replaceAll("<.*?>", ""); // Elimina las etiquetas HTML
                desktop.browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al intentar abrir el enlace
        }
    }//GEN-LAST:event_linkedinPMousePressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String elemSelected = listaPostulantes.getSelectedValue();
        try {
            int inicio = elemSelected.indexOf("(") + 1;
            int fin = elemSelected.indexOf(")");
            String cedula = elemSelected.substring(inicio, fin);
            ArrayList<Entrevista> entrevistas = new ArrayList<>(buscaEntrevistaDePostulante(cedula));
            String textBusco = loquebusco.getText();
            tabla_entrevistas_model.setRowCount(0);
            for (Entrevista entre : entrevistas) {
                Evaluador evaluad = entre.getEvaluador();
                String nombreEvalu = evaluad.getNombre();
                String comentario = entre.getComentarios();
                int index = comentario.toLowerCase().indexOf(textBusco.toLowerCase());
                if (index != -1) {
                    String comentarioRojo = "<html>" + comentario.substring(0, index)
                            + "<font color='red'>" + comentario.substring(index, index + textBusco.length()) + "</font>"
                            + comentario.substring(index + textBusco.length()) + "</html>";
                    Object[] fila = {entre.getNumeroEntrevista(), nombreEvalu, entre.getNivel(), comentarioRojo};
                    tabla_entrevistas_model.addRow(fila);
                }

            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Asegurese que  halla un postulante seleccionado.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buscarActionPerformed


    private void resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearActionPerformed
        tabla_entrevistas_model.setRowCount(0);
        String elemSelected = listaPostulantes.getSelectedValue();
        try {
            int inicio = elemSelected.indexOf("(") + 1;
            int fin = elemSelected.indexOf(")");
            String cedula = elemSelected.substring(inicio, fin);
            ArrayList<Entrevista> entrevistas = new ArrayList<>(buscaEntrevistaDePostulante(cedula));
            for (Entrevista entre : entrevistas) {
                Evaluador evaluad = entre.getEvaluador();
                String nombreEvalu = evaluad.getNombre();
                Object[] fila = {entre.getNumeroEntrevista(), nombreEvalu, entre.getNivel(), entre.getComentarios()};
                tabla_entrevistas_model.addRow(fila);
            }
            loquebusco.setText("");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Asegurese que  halla un postulante seleccionado.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_resetearActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        // Asegurarse de que la actualización se realiza en el hilo de despacho de eventos (event dispatch thread)
        SwingUtilities.invokeLater(() -> {
            // Actualizar la lista de postulantes en la interfaz
            updatePostulantes();

        });
    }

    private void updatePostulantes() {
        modelPostu.removeAllElements();
        ordenadoPostu = new ArrayList<>(modelo.getListaPostulantes());
        Collections.sort(ordenadoPostu, Comparator.comparingInt(postulante -> Integer.parseInt(postulante.getCedula())));
        for (Postulante postu : ordenadoPostu) {
            modelPostu.addElement(postu.getNombre() + "(" + postu.getCedula() + ")");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cedulaP;
    private javax.swing.JLabel direccionP;
    private javax.swing.JLabel formatoP;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel linkedinP;
    private javax.swing.JList<String> listaExp;
    private javax.swing.JList<String> listaPostulantes;
    private javax.swing.JTextPane loquebusco;
    private javax.swing.JLabel mailP;
    private javax.swing.JLabel nombreP;
    private javax.swing.JButton resetear;
    private javax.swing.JTable tabla_entrevistas;
    private javax.swing.JLabel telefonoP;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

}
