package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class CuadroSpinner extends JSpinner {

    // Constructor para cada cuadro spinner

    public CuadroSpinner(int x, int y) {

        SpinnerNumberModel contenidoCuadroSpinner = new SpinnerNumberModel(0, 0, 99, 1);
        this.setModel(contenidoCuadroSpinner);
        this.setBounds(x, y, 50, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));
        this.setEnabled(false);

    }

}
