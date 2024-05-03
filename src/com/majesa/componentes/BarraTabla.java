package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class BarraTabla extends JScrollPane {

    // Constructor para la barra de desplazamiento de cada tabla

    public BarraTabla (JTable tabla, int x, int y) {

        this.getViewport().add(tabla);
        this.setBounds(x, y, 430, 250);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));

    }

}
