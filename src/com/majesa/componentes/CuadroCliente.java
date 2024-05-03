package com.majesa.componentes;

import javax.swing.*;
import java.awt.*;

public class CuadroCliente extends JTextField {

    // Constructor para cada cuadro de cliente

    public CuadroCliente(String texto, int x, int y) {

        this.setText(texto);
        this.setBounds(x, y, 185, 25);
        this.setFont(new Font("Tahoma", Font.PLAIN, 13));

    }

}
