package com.majesa.programa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MetodosAyuda {

    // Metodos de ayuda

    public static void cambiarPaneles(JPanel panelViejo, JPanel panelNuevo) {

        panelViejo.setVisible(false);
        panelNuevo.setVisible(true);

    }

    public static boolean textoValido(JTextField cuadroTexto) {

        String texto = cuadroTexto.getText();

        if (texto.matches("(\\d+)\\.\\d\\d")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean textoElegidoValido(JComboBox cuadroCombinado) {

        String textoElegido = cuadroCombinado.getSelectedItem().toString();

        if (textoElegido.equals("Seleccionar") || textoElegido.equals("Mas Colores")) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean valorElegidoValido(JSpinner cuadroSpinner) {

        String valorElegido = cuadroSpinner.getValue().toString();

        if (cuadroSpinner.isEnabled() && valorElegido.equals("0")) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean clienteValido(JTextField cuadroCliente) {

        String cliente = cuadroCliente.getText();

        if (cliente.matches("(\\s*)")) {
            return false;
        } else {
            return true;
        }

    }

    public static String crearDescripcion(String articulo, String color, String rollos) {

        if (Integer.parseInt(rollos) > 0) {
            return "<html> " + articulo + " <br> " + color + " (" + rollos + " rollo/s) </html>";
        } else {
            return "<html> " + articulo + " <br> " + color + " </html>";
        }

    }

    public static String calcularImporte(String peso, String precio) {

        BigDecimal pesoPreciso = new BigDecimal(peso);
        BigDecimal precioPreciso = new BigDecimal(precio);
        BigDecimal importePreciso = pesoPreciso.multiply(precioPreciso);
        importePreciso = importePreciso.scaleByPowerOfTen(1);
        importePreciso = importePreciso.setScale(0, BigDecimal.ROUND_HALF_UP);
        importePreciso = importePreciso.setScale(1, BigDecimal.ROUND_HALF_UP);
        importePreciso = importePreciso.scaleByPowerOfTen(-1);

        return importePreciso.toString();

    }

    public static void actualizarTabla(JTable tabla, String[][] contenido, String[] encabezado) {

        DefaultTableModel nuevoModeloTabla = new DefaultTableModel(contenido, encabezado);
        tabla.setModel(nuevoModeloTabla);
        tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tabla.getColumnModel().getColumn(1).setMaxWidth(60);
        tabla.getColumnModel().getColumn(2).setMaxWidth(205);
        tabla.getColumnModel().getColumn(3).setMaxWidth(55);
        tabla.getColumnModel().getColumn(4).setMaxWidth(70);

    }

    public static void resetearTabla(JTable tabla) {

        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

    }

    public static void resetearCuadros(JTextField pesoCuadro, JTextField precioCuadro, JComboBox articuloCuadro) {

        pesoCuadro.setText("");
        precioCuadro.setText("");
        articuloCuadro.setSelectedIndex(0);

    }

    public static void resetearAlerta(JLabel alerta) {

        Timer contador = new Timer(5000, e -> alerta.setText(""));
        contador.setRepeats(false);
        contador.start();

    }

    public static String obtenerFecha() {

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaTexto = fecha.format(formateador);

        return fechaTexto;

    }

}
