package com.majesa.programa;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

import static com.majesa.programa.MetodosAyuda.obtenerFecha;

public class MetodosTxt {

    public static void obtenerArticulosyColores(ArrayList<String> articulos, HashMap<String, String[]> colores) {

        articulos.add("Seleccionar");
        colores.put("Seleccionar", new String[]{"Seleccionar"});

        try {

            FileReader archivo = new FileReader("./informacion/Articulos y Colores.txt");
            BufferedReader lector = new BufferedReader(archivo);

            ArrayList<String> articulosTemporal = new ArrayList<>();
            String[] coloresTemporal = new String[0];
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.equals("")) {

                    int numeroArticulos = articulosTemporal.size();

                    for (int i=0; i<numeroArticulos; i++) {
                        colores.put(articulosTemporal.get(i), coloresTemporal);
                    }

                    articulosTemporal.clear();
                    coloresTemporal = new String[0];

                } else if (linea.contains(":")) {
                    String articulo = linea.substring(0, linea.indexOf(":"));
                    articulosTemporal.add(articulo);
                    articulos.add(articulo);
                } else if (linea.contains(", ")) {
                    coloresTemporal = linea.split(", ");
                }
            }

            lector.close();

        } catch (Exception e) { }

    }

    public static void obtenerGuias(ArrayList<Guia> guias) {

        try {

            FileReader archivoLeer = new FileReader("./informacion/Guias.txt");
            BufferedReader lector = new BufferedReader(archivoLeer);
            String fecha = obtenerFecha();

            lector.readLine();
            lector.readLine();
            String lineaFecha = lector.readLine();

            if (lineaFecha == null) {
                lineaFecha = "";
            }

            if (lineaFecha.equals(fecha)) {

                lector.readLine();

                String clienteTemporal = "";
                String[] totalesTemporal = new String[0];
                String[][] contenidoTemporal = new String[0][5];
                String linea;

                while ((linea = lector.readLine()) != null) {
                    if (linea.equals("")) {

                        Guia guiaTemporal = new Guia(clienteTemporal, totalesTemporal, contenidoTemporal);
                        guias.add(guiaTemporal);

                        clienteTemporal = "";
                        totalesTemporal = new String[0];
                        contenidoTemporal = new String[0][5];

                    } else if (linea.contains(":")) {
                        clienteTemporal = linea.substring(0, linea.indexOf(":"));
                    } else if (linea.contains(" - ")) {
                        totalesTemporal = linea.split(" - ");
                    } else if (linea.contains(", ")) {

                        String[] items = linea.split("; ");

                        int numeroItems = items.length;
                        contenidoTemporal = new String[numeroItems][5];

                        for (int i=0; i<numeroItems; i++) {
                            contenidoTemporal[i] = items[i].split(", ");
                        }

                    }
                }

                lector.close();

            } else {

                lector.close();

                reemplazarArchivo();

                FileWriter archivoEscribir = new FileWriter("./informacion/Guias.txt", true);
                BufferedWriter escritor = new BufferedWriter(archivoEscribir);

                escritor.write("-------------");
                escritor.newLine();
                escritor.newLine();
                escritor.write(fecha);
                escritor.newLine();
                escritor.newLine();
                escritor.write("-------------");

                escritor.close();

            }

        } catch (Exception e) { }

    }

    public static void actualizarGuias(ArrayList<Guia> guias) {

        try {

            reemplazarArchivo();

            FileWriter archivoEscribir = new FileWriter("./informacion/Guias.txt", true);
            BufferedWriter escritor = new BufferedWriter(archivoEscribir);
            String fecha = obtenerFecha();

            escritor.write("-------------");
            escritor.newLine();
            escritor.newLine();
            escritor.write(fecha);
            escritor.newLine();
            escritor.newLine();

            int numeroGuias = guias.size();

            for (int i=0; i<numeroGuias; i++) {

                Guia guia = guias.get(i);

                String cliente = guia.getCliente();
                String[] totales = guia.getTotales();
                String[][] contenido = guia.getContenido();

                escritor.write(cliente + ":");

                escritor.newLine();
                escritor.write(crearFormatoCsv(totales, " - "));

                int numeroItems = contenido.length;
                String[] items = new String[numeroItems];

                for (int j=0; j<numeroItems; j++) {
                    items[j] = crearFormatoCsv(contenido[j], ", ");
                }

                escritor.newLine();
                escritor.write(crearFormatoCsv(items, "; "));

                escritor.newLine();
                escritor.newLine();

            }

            escritor.write("-------------");
            escritor.close();

        } catch (Exception e) { }

    }

    public static void reemplazarArchivo() {

        try {

            File archivoViejo = new File("./informacion/Guias.txt");
            archivoViejo.delete();

            File archivoNuevo = new File("./informacion/Guias.txt");
            archivoNuevo.createNewFile();

        } catch (Exception e) { }

    }

    public static String crearFormatoCsv(String[] arreglo, String delimitador) {

        StringJoiner joiner = new StringJoiner(delimitador);

        int numeroValores = arreglo.length;

        for (int i=0; i<numeroValores; i++) {
            joiner.add(arreglo[i]);
        }

        String textoFormatoCsv = joiner.toString();

        return textoFormatoCsv;

    }

}
