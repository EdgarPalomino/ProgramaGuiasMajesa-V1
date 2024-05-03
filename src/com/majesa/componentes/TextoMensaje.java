package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class TextoMensaje extends JLabel {

    public TextoMensaje(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 520, 80);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Tahoma", Font.PLAIN, 18));

    }

}
