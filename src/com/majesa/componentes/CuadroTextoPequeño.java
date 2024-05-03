package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class CuadroTextoPequeño extends JTextField {

    // Constructor para cada cuadro de texto pequeño

    public CuadroTextoPequeño(String texto, int x, int y, Boolean habilitar) {

        this.setText(texto);
        this.setBounds(x, y, 35, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

        if (habilitar == false) {

            this.setEditable(false);
            this.setBackground(Color.WHITE);
            this.setOpaque(true);

        }

    }

}
