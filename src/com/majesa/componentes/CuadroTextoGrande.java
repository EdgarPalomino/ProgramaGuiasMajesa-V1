package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class CuadroTextoGrande extends JTextField {

    // Constructor para cada cuadro de texto grande

    public CuadroTextoGrande(String texto, int x, int y, Boolean habilitar) {

        this.setText(texto);
        this.setBounds(x, y, 70, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

        if (habilitar == false) {

            this.setEditable(false);
            this.setBackground(Color.WHITE);
            this.setOpaque(true);

        }

    }

}
