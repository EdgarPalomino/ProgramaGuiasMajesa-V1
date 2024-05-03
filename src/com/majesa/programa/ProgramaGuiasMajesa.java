package com.majesa.programa;

import com.majesa.componentes.*;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static com.majesa.programa.MetodosAyuda.*;
import static com.majesa.programa.MetodosTxt.*;
import static com.majesa.programa.MetodosPdf.*;

public class ProgramaGuiasMajesa {

    // Definiendo el arraylist que va a contener todas las guías gaurdadas

    private ArrayList<Guia> guias;

    // Definiendo el arraylist que va a contener todos los artículos

    private ArrayList<String> articulos;

    // Definiendo el hashmap que va a contener todos los colores de cada artículo

    private HashMap<String, String[]> colores;

    // Definiendo la ventana y el panel contenedor

    private JFrame ventana;
    private JPanel panelContenedor;

    // Definiendo los componentes del panel home

    private JPanel homePanel;
    private TextoBienvenida homeBienvenida;
    private TextoMensaje homeMensaje;
    private LogoMajesa homeLogo;
    private BotonNavegacion homeSalir;
    private BotonOpcion homeCrearGuia;
    private BotonOpcion homeVerGuias;

    // Definiendo el arreglo que va a contener el encabezado de las tablas

    private String[] encabezadoTablas;

    // Definiendo los componentes del panel crear

    private JPanel crearPanel;
    private TextoCuadro crearClienteTexto;
    private TextoCuadro crearPesoTexto;
    private TextoCuadro crearArticuloTexto;
    private TextoCuadro crearPrecioTexto;
    private TextoCuadro crearColorTexto;
    private TextoCuadro crearRollosTexto;
    private TextoCuadro crearImporteTotalTexto;
    private TextoCuadro crearCanceladoTexto;
    private TextoCuadro crearSaldoClienteTexto;
    private TextoCuadro crearPesoTotalTexto;
    private TextoCuadro crearRollosTotalTexto;
    private TextoCuadro crearBolsasTotalTexto;
    private CuadroCliente crearClienteCuadro;
    private CuadroTextoGrande crearPesoCuadro;
    private CuadroTextoGrande crearPrecioCuadro;
    private CuadroCombinado crearArticuloCuadro;
    private CuadroCombinado crearColorCuadro;
    private CuadroSpinner crearRollosCuadro;
    private CuadroTextoGrande crearImporteTotalCuadro;
    private CuadroTextoGrande crearCanceladoCuadro;
    private CuadroTextoGrande crearSaldoClienteCuadro;
    private CuadroTextoGrande crearPesoTotalCuadro;
    private CuadroTextoPequeño crearRollosTotalCuadro;
    private CuadroTextoPequeño crearBolsasTotalCuadro;
    private Alerta crearAlerta;
    private BotonNavegacion crearAtras;
    private BotonFuncion crearAñadir;
    private BotonFuncion crearQuitar;
    private BotonFuncion crearGuardar;
    private BotonFuncion crearResetear;
    private Tabla crearTabla;
    private BarraTabla crearBarraTabla;

    // Definiendo los componentes del panel ver

    private JPanel verPanel;
    private TextoCuadro verGuiaTexto;
    private TextoCuadro verImporteTotalTexto;
    private TextoCuadro verCanceladoTexto;
    private TextoCuadro verSaldoClienteTexto;
    private TextoCuadro verPesoTotalTexto;
    private TextoCuadro verRollosTotalTexto;
    private TextoCuadro verBolsasTotalTexto;
    private TextoCuadro verVentasTotalesTexto;
    private TextoCuadro verIngresosTotalesTexto;
    private TextoCuadro verCreditoOtorgadoTexto;
    private TextoCuadro verKilosVendidosTexto;
    private TextoCuadro verRollosVendidosTexto;
    private TextoCuadro verBolsasVendidasTexto;
    private CuadroCombinado verGuiaCuadro;
    private CuadroTextoGrande verImporteTotalCuadro;
    private CuadroTextoGrande verCanceladoCuadro;
    private CuadroTextoGrande verSaldoClienteCuadro;
    private CuadroTextoGrande verPesoTotalCuadro;
    private CuadroTextoPequeño verRollosTotalCuadro;
    private CuadroTextoPequeño verBolsasTotalCuadro;
    private CuadroTextoGrande verVentasTotalesCuadro;
    private CuadroTextoGrande verIngresosTotalesCuadro;
    private CuadroTextoGrande verCreditoOtorgadoCuadro;
    private CuadroTextoGrande verKilosVendidosCuadro;
    private CuadroTextoPequeño verRollosVendidosCuadro;
    private CuadroTextoPequeño verBolsasVendidasCuadro;
    private Alerta verAlerta;
    private BotonNavegacion verAtras;
    private BotonFuncion verBorrar;
    private BotonFuncion verDescargar;
    private BotonFuncion verImprimir;
    private Tabla verTabla;
    private BarraTabla verBarraTabla;


    public ProgramaGuiasMajesa() {

        // Creando el arraylist que va a contener todas las guías guardadas

        guias = new ArrayList<>();

        // Creando el arraylist que va a contener todos los artículos

        articulos = new ArrayList<>();

        // Creando el hashmap que va a contener los colores de cada artículo

        colores = new HashMap<>();

        obtenerArticulosyColores(articulos, colores);
        obtenerGuias(guias);

        // Creando la ventana

        ventana = new JFrame();

        // Creando el panel contenedor

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new CardLayout());

        //--------------------------------------------------\\

        // Creando el panel home y organizando sus componentes

        homePanel = new JPanel();
        homePanel.setLayout(null);

        homeBienvenida = new TextoBienvenida("Hola Lizeth!", 360, 60);
        homePanel.add(homeBienvenida);

        homeMensaje = new TextoMensaje("Selecciona la opcion que deseas para empezar", 190, 185);
        homePanel.add(homeMensaje);

        homeLogo = new LogoMajesa("./imagenes/Logo Majesa.png", 730, 0);
        homePanel.add(homeLogo);

        homeSalir = new BotonNavegacion("Salir", 20, 20);
        homeSalir.addActionListener(e -> ventana.dispose());
        homePanel.add(homeSalir);

        homeCrearGuia = new BotonOpcion("Crear Guia", 250, 325);
        homeCrearGuia.addActionListener(e -> cambiarPaneles(homePanel, crearPanel));
        homePanel.add(homeCrearGuia);

        homeVerGuias = new BotonOpcion("Ver Guias", 500, 325);
        homeVerGuias.addActionListener(e -> {
            cambiarPaneles(homePanel, verPanel);
            editarGuiasCuadro();
            actualizarTotalesDia();
        });
        homePanel.add(homeVerGuias);

        //--------------------------------------------------\\

        // Creando el arreglo que va a contener el encabezado de las tablas

        encabezadoTablas = new String[]{"Item", "Peso", "Descripcion", "P/Kg", "Importe"};

        // Creando el panel crear y organizando sus componentes

        crearPanel = new JPanel();
        crearPanel.setLayout(null);

        crearClienteTexto = new TextoCuadro("Cliente:", 540, 100);
        crearPanel.add(crearClienteTexto);

        crearPesoTexto = new TextoCuadro("Peso:", 540, 140);
        crearPanel.add(crearPesoTexto);

        crearPrecioTexto = new TextoCuadro("Precio:", 540, 210);
        crearPanel.add(crearPrecioTexto);

        crearArticuloTexto = new TextoCuadro("Articulo:", 670, 140);
        crearPanel.add(crearArticuloTexto);

        crearColorTexto = new TextoCuadro("Color:", 670, 210);
        crearPanel.add(crearColorTexto);

        crearRollosTexto = new TextoCuadro("Rollos:", 540, 280);
        crearPanel.add(crearRollosTexto);

        crearImporteTotalTexto = new TextoCuadro("Importe Total:", 280, 370);
        crearPanel.add(crearImporteTotalTexto);

        crearCanceladoTexto = new TextoCuadro("A Cuenta:", 280, 410);
        crearPanel.add(crearCanceladoTexto);

        crearSaldoClienteTexto = new TextoCuadro("Saldo:", 280, 450);
        crearPanel.add(crearSaldoClienteTexto);

        crearPesoTotalTexto = new TextoCuadro("Peso Total:", 35, 370);
        crearPanel.add(crearPesoTotalTexto);

        crearRollosTotalTexto = new TextoCuadro("Rollos Total:", 35, 410);
        crearPanel.add(crearRollosTotalTexto);

        crearBolsasTotalTexto = new TextoCuadro("Bolsas Total:", 35, 450);
        crearPanel.add(crearBolsasTotalTexto);

        crearAlerta = new Alerta("", 545, 370);
        crearPanel.add(crearAlerta);

        crearClienteCuadro = new CuadroCliente("", 600, 100);
        crearPanel.add(crearClienteCuadro);

        crearPesoCuadro = new CuadroTextoGrande("", 540, 170, true);
        crearPanel.add(crearPesoCuadro);

        crearPrecioCuadro = new CuadroTextoGrande("", 540, 240, true);
        crearPanel.add(crearPrecioCuadro);

        crearArticuloCuadro = new CuadroCombinado(articulos.toArray(new String[0]), 670, 170);
        crearArticuloCuadro.addActionListener(e -> {
            editarColorCuadro();
            editarRollosCuadro();
        });
        crearPanel.add(crearArticuloCuadro);

        crearColorCuadro = new CuadroCombinado(new String[]{"Seleccionar"}, 670, 240);
        crearColorCuadro.addActionListener(e -> editarRollosCuadro());
        crearPanel.add(crearColorCuadro);

        crearRollosCuadro = new CuadroSpinner(540, 310);
        crearPanel.add(crearRollosCuadro);

        crearImporteTotalCuadro = new CuadroTextoGrande("0.00", 380, 370, false);
        crearPanel.add(crearImporteTotalCuadro);

        crearCanceladoCuadro = new CuadroTextoGrande("", 380, 410, true);
        crearCanceladoCuadro.addActionListener(e -> actualizarSaldo());
        crearPanel.add(crearCanceladoCuadro);

        crearSaldoClienteCuadro = new CuadroTextoGrande("0.00", 380, 450, false);
        crearPanel.add(crearSaldoClienteCuadro);

        crearPesoTotalCuadro = new CuadroTextoGrande("0.00", 115, 370, false);
        crearPanel.add(crearPesoTotalCuadro);

        crearRollosTotalCuadro = new CuadroTextoPequeño("0", 150, 410, false);
        crearPanel.add(crearRollosTotalCuadro);

        crearBolsasTotalCuadro = new CuadroTextoPequeño("0", 150, 450, false);
        crearPanel.add(crearBolsasTotalCuadro);

        crearAtras = new BotonNavegacion("Atras", 20, 20);
        crearAtras.addActionListener(e -> cambiarPaneles(crearPanel, homePanel));
        crearPanel.add(crearAtras);

        crearAñadir = new BotonFuncion("Añadir Item", 630, 290);
        crearAñadir.addActionListener(e -> añadirItem());
        crearPanel.add(crearAñadir);

        crearQuitar = new BotonFuncion("Quitar Item", 750, 290);
        crearQuitar.addActionListener(e -> quitarItem());
        crearPanel.add(crearQuitar);

        crearResetear = new BotonFuncion("Resetear", 750, 370);
        crearResetear.addActionListener(e -> resetearGuia());
        crearPanel.add(crearResetear);

        crearGuardar = new BotonFuncion("Guardar", 750, 425);
        crearGuardar.addActionListener(e -> guardarGuia());
        crearPanel.add(crearGuardar);

        crearTabla = new Tabla(new String[0][5], encabezadoTablas);
        crearBarraTabla = new BarraTabla(crearTabla, 30, 100);
        crearPanel.add(crearBarraTabla);

        //--------------------------------------------------\\

        // Creando el panel crear y organizando sus componentes

        verPanel = new JPanel();
        verPanel.setLayout(null);

        verGuiaTexto = new TextoCuadro("Guia:", 30, 100);
        verPanel.add(verGuiaTexto);

        verImporteTotalTexto = new TextoCuadro("Importe Total:", 675, 370);
        verPanel.add(verImporteTotalTexto);

        verCanceladoTexto = new TextoCuadro("A Cuenta:", 675, 410);
        verPanel.add(verCanceladoTexto);

        verSaldoClienteTexto = new TextoCuadro("Saldo:", 675, 450);
        verPanel.add(verSaldoClienteTexto);

        verPesoTotalTexto = new TextoCuadro("Peso Total:", 430, 370);
        verPanel.add(verPesoTotalTexto);

        verRollosTotalTexto = new TextoCuadro("Rollos Total:", 430, 410);
        verPanel.add(verRollosTotalTexto);

        verBolsasTotalTexto = new TextoCuadro("Bolsas Total:", 430, 450);
        verPanel.add(verBolsasTotalTexto);

        verVentasTotalesTexto = new TextoCuadro("Ventas Totales:", 60, 170);
        verPanel.add(verVentasTotalesTexto);

        verIngresosTotalesTexto = new TextoCuadro("Cobranzas:", 210, 170);
        verPanel.add(verIngresosTotalesTexto);

        verCreditoOtorgadoTexto = new TextoCuadro("Credito Otorgado:", 210, 240);
        verPanel.add(verCreditoOtorgadoTexto);

        verKilosVendidosTexto = new TextoCuadro("Kilos Vendidos:", 60, 240);
        verPanel.add(verKilosVendidosTexto);

        verRollosVendidosTexto = new TextoCuadro("Rollos Vendidos:", 30, 310);
        verPanel.add(verRollosVendidosTexto);

        verBolsasVendidasTexto = new TextoCuadro("Bolsas Vendidas:", 200, 310);
        verPanel.add(verBolsasVendidasTexto);

        verAlerta = new Alerta("", 35, 370);
        verPanel.add(verAlerta);

        verGuiaCuadro = new CuadroCombinado(new String[]{"Seleccionar"}, 30, 130);
        verGuiaCuadro.addActionListener(e -> mostrarGuia());
        verPanel.add(verGuiaCuadro);

        verImporteTotalCuadro = new CuadroTextoGrande("0.00", 775, 370, false);
        verPanel.add(verImporteTotalCuadro);

        verCanceladoCuadro = new CuadroTextoGrande("0.00", 775, 410, false);
        verPanel.add(verCanceladoCuadro);

        verSaldoClienteCuadro = new CuadroTextoGrande("0.00", 775, 450, false);
        verPanel.add(verSaldoClienteCuadro);

        verPesoTotalCuadro = new CuadroTextoGrande("0.00", 510, 370, false);
        verPanel.add(verPesoTotalCuadro);

        verRollosTotalCuadro = new CuadroTextoPequeño("0", 545, 410, false);
        verPanel.add(verRollosTotalCuadro);

        verBolsasTotalCuadro = new CuadroTextoPequeño("0", 545, 450, false);
        verPanel.add(verBolsasTotalCuadro);

        verVentasTotalesCuadro = new CuadroTextoGrande("0.00", 60, 200, false);
        verPanel.add(verVentasTotalesCuadro);

        verIngresosTotalesCuadro = new CuadroTextoGrande("0.00", 210, 200, false);
        verPanel.add(verIngresosTotalesCuadro);

        verCreditoOtorgadoCuadro = new CuadroTextoGrande("0.00", 210, 270, false);
        verPanel.add(verCreditoOtorgadoCuadro);

        verKilosVendidosCuadro = new CuadroTextoGrande("0.00", 60, 270, false);
        verPanel.add(verKilosVendidosCuadro);

        verRollosVendidosCuadro = new CuadroTextoPequeño("0", 140, 310, false);
        verPanel.add(verRollosVendidosCuadro);

        verBolsasVendidasCuadro = new CuadroTextoPequeño("0", 310, 310, false);
        verPanel.add(verBolsasVendidasCuadro);

        verAtras = new BotonNavegacion("Atras", 20, 20);
        verAtras.addActionListener(e -> cambiarPaneles(verPanel, homePanel));
        verPanel.add(verAtras);

        verBorrar = new BotonFuncion("Borrar Guia", 240, 110);
        verBorrar.addActionListener(e -> borrarGuia());
        verPanel.add(verBorrar);

        verDescargar = new BotonFuncion("Descargar", 240, 370);
        verDescargar.addActionListener(e -> descargarResumenDia());
        verPanel.add(verDescargar);

        verImprimir = new BotonFuncion("Imprimir", 240, 425);
        verImprimir.addActionListener(e -> imprimirGuia());
        verPanel.add(verImprimir);

        verTabla = new Tabla(new String[0][5], encabezadoTablas);
        verBarraTabla = new BarraTabla(verTabla, 425, 100);
        verPanel.add(verBarraTabla);

        //--------------------------------------------------\\

        // Organizando todos los paneles y configurando la ventana

        ventana.add(panelContenedor);
        panelContenedor.add(homePanel);
        panelContenedor.add(crearPanel);
        panelContenedor.add(verPanel);
        crearPanel.setVisible(false);
        verPanel.setVisible(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(900, 600);
        ventana.setResizable(false);
        ventana.setTitle("Programa Guias Majesa");
        ventana.setVisible(true);

    }

    //--------------------------------------------------\\

    // Metodos para el panel crear

    public void editarColorCuadro() {

        String articuloElegido = crearArticuloCuadro.getSelectedItem().toString();
        String[] nuevoContenidoColorCuadro = colores.get(articuloElegido);
        DefaultComboBoxModel nuevoModeloColorCuadro = new DefaultComboBoxModel(nuevoContenidoColorCuadro);
        crearColorCuadro.setModel(nuevoModeloColorCuadro);

    }

    public void editarRollosCuadro() {

        String articuloElegido = crearArticuloCuadro.getSelectedItem().toString();
        int colorElegido = crearColorCuadro.getSelectedIndex();

        if (articuloElegido.equals("Seleccionar") || (articuloElegido.equals("Rib Algodon") && colorElegido < 6) ||
                (articuloElegido.equals("Rib Jaspeado") && colorElegido < 3)) {
            crearRollosCuadro.setValue(0);
            crearRollosCuadro.setEnabled(false);
        } else {
            crearRollosCuadro.setEnabled(true);
        }

    }

    public void añadirItem() {

        if (textoValido(crearPesoCuadro) && textoValido(crearPrecioCuadro) && textoElegidoValido(crearArticuloCuadro) &&
                textoElegidoValido(crearColorCuadro) && valorElegidoValido(crearRollosCuadro)) {

            int numeroFilas = crearTabla.getRowCount();
            int numeroColumnas = crearTabla.getColumnCount();
            String[][] nuevoContenidoTabla = new String[numeroFilas+1][numeroColumnas];

            for (int i=0; i<numeroFilas; i++) {
                for (int j=0; j<numeroColumnas; j++) {
                    nuevoContenidoTabla[i][j] = crearTabla.getValueAt(i, j).toString();
                }
            }

            String peso = crearPesoCuadro.getText();
            String precio = crearPrecioCuadro.getText();
            String articulo = crearArticuloCuadro.getSelectedItem().toString();
            String color = crearColorCuadro.getSelectedItem().toString();
            String rollos = crearRollosCuadro.getValue().toString();

            nuevoContenidoTabla[numeroFilas][0] = Integer.toString(numeroFilas+1);
            nuevoContenidoTabla[numeroFilas][1] = peso;
            nuevoContenidoTabla[numeroFilas][2] = crearDescripcion(articulo, color, rollos);
            nuevoContenidoTabla[numeroFilas][3] = precio;
            nuevoContenidoTabla[numeroFilas][4] = calcularImporte(peso, precio);

            actualizarTabla(crearTabla, nuevoContenidoTabla, encabezadoTablas);
            actualizarTotales();
            actualizarSaldo();

            resetearCuadros(crearPesoCuadro, crearPrecioCuadro, crearArticuloCuadro);
            crearAlerta.setText("<html><center> Item añadido!!! </center></html>");
            resetearAlerta(crearAlerta);

        } else {
            crearAlerta.setText("<html><center> Revisa los valores <br> ingresados... </center></html>");
            resetearAlerta(crearAlerta);
        }

    }

    public void quitarItem() {

        if (crearTabla.getSelectedRow() >= 0) {

            int numeroFilas = crearTabla.getRowCount();
            int numeroColumnas = crearTabla.getColumnCount();
            int filaSeleccionada = crearTabla.getSelectedRow();
            String[][] nuevoContenidoTabla = new String[numeroFilas-1][numeroColumnas];

            for (int i=0; i<filaSeleccionada; i++) {
                for (int j=0; j<numeroColumnas; j++) {
                    nuevoContenidoTabla[i][j] = crearTabla.getValueAt(i, j).toString();
                }
            }

            for (int i=filaSeleccionada; i<numeroFilas-1; i++) {
                for (int j=0; j<numeroColumnas; j++) {
                    if (j == 0) {
                        nuevoContenidoTabla[i][j] = Integer.toString(i+1);
                    } else {
                        nuevoContenidoTabla[i][j] = crearTabla.getValueAt(i+1, j).toString();
                    }
                }
            }

            actualizarTabla(crearTabla, nuevoContenidoTabla, encabezadoTablas);
            actualizarTotales();
            actualizarSaldo();

            crearTabla.getSelectionModel().clearSelection();
            crearAlerta.setText("<html><center> Item quitado!!! </center></html>");
            resetearAlerta(crearAlerta);

        } else {
            crearAlerta.setText("<html><center> Selecciona un item <br> para quitarlo... </center></html>");
            resetearAlerta(crearAlerta);
        }

    }

    public void resetearGuia() {

        resetearTabla(crearTabla);
        actualizarTotales();
        crearCanceladoCuadro.setText("");
        crearSaldoClienteCuadro.setText("0.00");

        crearClienteCuadro.setText("");
        resetearCuadros(crearPesoCuadro, crearPrecioCuadro, crearArticuloCuadro);
        crearAlerta.setText("<html><center> Guia reseteada!!! </center></html>");
        resetearAlerta(crearAlerta);

    }

    public void guardarGuia() {

        if (crearTabla.getRowCount() > 0 && clienteValido(crearClienteCuadro) && textoValido(crearCanceladoCuadro)) {

            actualizarSaldo();

            int numeroFilas = crearTabla.getRowCount();
            int numeroColumnas = crearTabla.getColumnCount();
            String cliente = crearClienteCuadro.getText();
            String[] totales = {crearImporteTotalCuadro.getText(), crearCanceladoCuadro.getText(),
                                crearSaldoClienteCuadro.getText(), crearPesoTotalCuadro.getText(),
                                crearRollosTotalCuadro.getText(), crearBolsasTotalCuadro.getText()};
            String[][] contenido = new String[numeroFilas][numeroColumnas];

            for (int i=0; i<numeroFilas; i++) {
                for (int j=0; j<numeroColumnas; j++) {
                    contenido[i][j] = crearTabla.getValueAt(i, j).toString();
                }
            }

            Guia nuevaGuia = new Guia(cliente, totales, contenido);
            guias.add(nuevaGuia);
            actualizarGuias(guias);

            crearAlerta.setText("<html><center> Guia guardada!!! </center></html>");
            resetearAlerta(crearAlerta);

        } else {
            crearAlerta.setText("<html><center> Revisa los valores <br> ingresados... </center></html>");
            resetearAlerta(crearAlerta);
        }

    }

    public void actualizarTotales() {

        int numeroFilas = crearTabla.getRowCount();
        BigDecimal importeTotal = new BigDecimal("0.00");
        BigDecimal pesoTotal = new BigDecimal("0.00");
        int rollosTotal = 0;
        double bolsasPesoTotal = 0;
        int pesoPorBolsa = 20;

        for (int i=0; i<numeroFilas; i++) {

            BigDecimal importe = new BigDecimal(crearTabla.getValueAt(i, 4).toString());
            BigDecimal peso = new BigDecimal(crearTabla.getValueAt(i, 1).toString());
            importeTotal = importeTotal.add(importe);
            pesoTotal = pesoTotal.add(peso);

            String descripcion = crearTabla.getValueAt(i, 2).toString();

            if (descripcion.contains("rollo/s")) {
                String rollos = descripcion.substring(descripcion.indexOf("(")+1, descripcion.indexOf(" rollo/s)"));
                rollosTotal += Integer.parseInt(rollos);
            } else {
                String bolsasPeso = crearTabla.getValueAt(i, 1).toString();
                bolsasPesoTotal += Double.parseDouble(bolsasPeso);
            }

        }

        int bolsasTotal = (int) Math.ceil(bolsasPesoTotal/pesoPorBolsa);

        crearImporteTotalCuadro.setText(importeTotal.toString());
        crearPesoTotalCuadro.setText(pesoTotal.toString());
        crearRollosTotalCuadro.setText(Integer.toString(rollosTotal));
        crearBolsasTotalCuadro.setText(Integer.toString(bolsasTotal));

    }

    public void actualizarSaldo() {

        if (textoValido(crearCanceladoCuadro)) {

            BigDecimal importeTotal = new BigDecimal(crearImporteTotalCuadro.getText());
            BigDecimal montoCancelado = new BigDecimal(crearCanceladoCuadro.getText());

            BigDecimal saldoCliente = importeTotal.subtract(montoCancelado);
            crearSaldoClienteCuadro.setText(saldoCliente.toString());

            crearAlerta.setText("<html><center> Saldo calculado!!! </center></html>");
            resetearAlerta(crearAlerta);

        } else {
            crearAlerta.setText("<html><center> Revisa el monto <br> ingresado... </center></html>");
            resetearAlerta(crearAlerta);
        }

    }

    //--------------------------------------------------\\

    // Metodos para el panel ver

    public void editarGuiasCuadro() {

        int numeroGuias = guias.size();
        String[] nuevoContenidoGuia = new String[numeroGuias+1];
        nuevoContenidoGuia[0] = "Seleccionar";

        for (int i=0; i<numeroGuias; i++) {
            String cliente = guias.get(i).getCliente();
            nuevoContenidoGuia[i+1] = "Nº" + (i+1) + " " + cliente;
        }

        DefaultComboBoxModel nuevoModeloGuia = new DefaultComboBoxModel(nuevoContenidoGuia);
        verGuiaCuadro.setModel(nuevoModeloGuia);

    }

    public void mostrarGuia() {

        int guiaElegida = verGuiaCuadro.getSelectedIndex();

        if (guiaElegida > 0) {

            Guia guia = guias.get(guiaElegida-1);
            String[][] nuevoContenidoTabla = guia.getContenido();

            actualizarTabla(verTabla, nuevoContenidoTabla, encabezadoTablas);

            verImporteTotalCuadro.setText(guia.getImporteTotal());
            verCanceladoCuadro.setText(guia.getMontoCancelado());
            verSaldoClienteCuadro.setText(guia.getSaldoCliente());
            verPesoTotalCuadro.setText(guia.getPesoTotal());
            verRollosTotalCuadro.setText(guia.getRollosTotal());
            verBolsasTotalCuadro.setText(guia.getBolsasTotal());

        } else {

            resetearTabla(verTabla);

            verImporteTotalCuadro.setText("0.00");
            verCanceladoCuadro.setText("0.00");
            verSaldoClienteCuadro.setText("0.00");
            verPesoTotalCuadro.setText("0.00");
            verRollosTotalCuadro.setText("0");
            verBolsasTotalCuadro.setText("0");

        }

    }

    public void borrarGuia() {

        int guiaEscogida = verGuiaCuadro.getSelectedIndex();

        if (guiaEscogida > 0) {

            guias.remove(guiaEscogida-1);
            actualizarGuias(guias);
            editarGuiasCuadro();
            verGuiaCuadro.setSelectedIndex(0);

            actualizarTotalesDia();
            verAlerta.setText("<html><center> Guia borrada!!! </center></html>");
            resetearAlerta(verAlerta);

        } else {
            verAlerta.setText("<html><center> Selecciona una guia <br> para eliminarla... </center></html>");
            resetearAlerta(verAlerta);
        }

    }

    public void actualizarTotalesDia() {

        int numeroGuias = guias.size();
        BigDecimal ventasTotales = new BigDecimal("0.00");
        BigDecimal ingresosTotales = new BigDecimal("0.00");
        BigDecimal creditoOtorgado = new BigDecimal("0.00");
        BigDecimal kilosVendidos = new BigDecimal("0.00");
        int rollosVendidos = 0;
        int bolsasVendidas = 0;

        for (int i=0; i<numeroGuias; i++) {

            Guia guia = guias.get(i);

            BigDecimal importeTotal = new BigDecimal(guia.getImporteTotal());
            BigDecimal montoCancelado = new BigDecimal(guia.getMontoCancelado());
            BigDecimal saldoCliente = new BigDecimal(guia.getSaldoCliente());
            BigDecimal pesoTotal = new BigDecimal(guia.getPesoTotal());
            ventasTotales = ventasTotales.add(importeTotal);
            ingresosTotales = ingresosTotales.add(montoCancelado);
            creditoOtorgado = creditoOtorgado.add(saldoCliente);
            kilosVendidos = kilosVendidos.add(pesoTotal);

            String rollosTotal = guia.getRollosTotal();
            String bolsasTotal = guia.getBolsasTotal();
            rollosVendidos += Integer.parseInt(rollosTotal);
            bolsasVendidas += Integer.parseInt(bolsasTotal);

        }

        verVentasTotalesCuadro.setText(ventasTotales.toString());
        verIngresosTotalesCuadro.setText(ingresosTotales.toString());
        verCreditoOtorgadoCuadro.setText(creditoOtorgado.toString());
        verKilosVendidosCuadro.setText(kilosVendidos.toString());
        verRollosVendidosCuadro.setText(Integer.toString(rollosVendidos));
        verBolsasVendidasCuadro.setText(Integer.toString(bolsasVendidas));

    }

    public void descargarResumenDia() {

        String[] totalesDia = {verVentasTotalesCuadro.getText(), verIngresosTotalesCuadro.getText(),
                                verCreditoOtorgadoCuadro.getText(), verKilosVendidosCuadro.getText(),
                                verRollosVendidosCuadro.getText(), verBolsasVendidasCuadro.getText()};
        descargarResumenDiaPdf(guias, totalesDia);

        verAlerta.setText("<html><center> Resumen del dia <br> descargado!!! </center></html>");
        resetearAlerta(verAlerta);

    }

    public void imprimirGuia() {

        int guiaElegida = verGuiaCuadro.getSelectedIndex();

        if (guiaElegida > 0) {

            Guia guia = guias.get(guiaElegida-1);
            imprimirGuiaPdf(guia, guiaElegida);

            verAlerta.setText("<html><center> Guia impresa!!! </center></html>");
            resetearAlerta(verAlerta);

        } else {
            verAlerta.setText("<html><center> Selecciona una guia <br> para imprimirla... </center></html>");
            resetearAlerta(verAlerta);
        }

    }

    //--------------------------------------------------\\

    public static void main(String[] args) {

        // Configurando el look and feel del programa

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        // Iniciando el programa

        new ProgramaGuiasMajesa();

    }

}
