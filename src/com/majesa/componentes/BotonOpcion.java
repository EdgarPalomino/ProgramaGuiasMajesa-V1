package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class BotonOpcion extends JButton {

    // Constructor para cada boton de opcion

    public BotonOpcion(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 150, 90);
        this.setFont(new Font("Tahoma", Font.PLAIN, 16));

    }

}
