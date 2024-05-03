package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class TextoCuadro extends JLabel {

    // Constructor para el texto de cada cuadro

    public TextoCuadro(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 105, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

    }

}
