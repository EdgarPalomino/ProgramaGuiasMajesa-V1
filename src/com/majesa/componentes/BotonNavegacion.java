package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class BotonNavegacion extends JButton {

    // Constructor para cada boton de navegacion

    public BotonNavegacion(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 120, 60);
        this.setFont(new Font("Tahoma", Font.PLAIN, 16));

    }

}
