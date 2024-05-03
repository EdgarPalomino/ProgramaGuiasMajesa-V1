package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class BotonFuncion extends JButton {

    // Constructor para cada boton de funcion

    public BotonFuncion(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 100, 50);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

    }

}
