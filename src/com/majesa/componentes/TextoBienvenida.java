package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class TextoBienvenida extends JLabel {

    // Constructor para el texto de bienvenida

    public TextoBienvenida(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 180, 140);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Tahoma", Font.PLAIN, 28));

    }

}
