package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class CuadroCombinado extends JComboBox {

    // Constructor para cada cuadro combinado

    public CuadroCombinado (String[] contenido, int x, int y) {

        DefaultComboBoxModel contenidoCuadroCombinado = new DefaultComboBoxModel(contenido);
        this.setModel(contenidoCuadroCombinado);
        this.setBounds(x, y, 185, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

    }

}
