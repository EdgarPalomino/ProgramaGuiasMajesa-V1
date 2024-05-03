package com.majesa.componentes;

import javax.swing.*;

public class LogoMajesa extends JLabel {

    // Constructor para el logo

    public LogoMajesa(String ruta, int x, int y) {

        this.setIcon(new ImageIcon(ruta));
        this.setBounds(x, y, 160, 160);

    }

}
