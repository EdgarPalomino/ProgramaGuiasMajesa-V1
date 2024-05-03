package com.majesa.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tabla extends JTable {

    // Constructor para cada tabla

    public Tabla(String[][] contenido, String[] encabezado) {

        DefaultTableModel modeloTabla = new DefaultTableModel(contenido, encabezado);
        this.setModel(modeloTabla);
        this.setRowHeight(50);
        this.getColumnModel().getColumn(0).setMaxWidth(40);
        this.getColumnModel().getColumn(1).setMaxWidth(60);
        this.getColumnModel().getColumn(2).setMaxWidth(205);
        this.getColumnModel().getColumn(3).setMaxWidth(55);
        this.getColumnModel().getColumn(4).setMaxWidth(70);
        this.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 13));
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));
        this.setDefaultEditor(Object.class, null);

    }

}
