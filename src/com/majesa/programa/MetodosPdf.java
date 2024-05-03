package com.majesa.programa;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static com.majesa.programa.MetodosAyuda.obtenerFecha;

public class MetodosPdf {

    public static void descargarResumenDiaPdf(ArrayList<Guia> guias, String[] totalesDia) {

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Documento PDF", "pdf");
        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            try {

                String ruta = fileChooser.getSelectedFile().getPath();
                PdfWriter escritorPdf = new PdfWriter(crearExtensionPdf(ruta));
                PdfDocument documentoPdf = new PdfDocument(escritorPdf);

                Document documento = new Document(documentoPdf, PageSize.A4);
                documento.setMargins(72, 72, 72, 72);

                Paragraph titulo = new Paragraph("Reporte del Dia: " + obtenerFecha());
                titulo.setTextAlignment(TextAlignment.CENTER);
                titulo.setUnderline(1, -1);
                titulo.setFontSize(16);
                documento.add(titulo);

                documento.add(new Paragraph(""));
                documento.add(new Paragraph(""));

                Paragraph resumen = new Paragraph("Resumen:");
                resumen.setUnderline(1, -1);
                documento.add(resumen);

                documento.add(new Paragraph(""));

                Table tablaResumen = crearTablaResumen(totalesDia, 12);
                documento.add(tablaResumen);

                int numeroGuias = guias.size();

                for (int i=0; i<numeroGuias; i++) {
                    Guia guia = guias.get(i);
                    documento.add(new AreaBreak());
                    crearPaginaGuia(documento, guia, i+1, 12);
                }

                documento.close();

            } catch (Exception e) { }

        }

    }

    public static void imprimirGuiaPdf(Guia guia, int numeroGuia) {

            try {

                ByteArrayOutputStream documentoOutputBytes = new ByteArrayOutputStream();
                PdfWriter escritorPdf = new PdfWriter(documentoOutputBytes);
                PdfDocument documentoPdf = new PdfDocument(escritorPdf);

                Document documento = new Document(documentoPdf, PageSize.A5);
                documento.setMargins(36, 36, 36, 36);

                crearPaginaGuia(documento, guia, numeroGuia, 10);

                documento.close();

                ByteArrayInputStream documentoInputBytes = new ByteArrayInputStream(documentoOutputBytes.toByteArray());
                PDDocument documentoPD = PDDocument.load(documentoInputBytes);

                PrinterJob trabajoImpresion = PrinterJob.getPrinterJob();
                trabajoImpresion.setPageable(new PDFPageable(documentoPD));

                if (trabajoImpresion.printDialog()) {
                    trabajoImpresion.print();
                }

            } catch (Exception e) { }

    }

    public static String crearExtensionPdf(String ruta) {

        if (ruta.endsWith(".pdf")) {
            return ruta;
        } else {
            return ruta + ".pdf";
        }

    }

    public static void crearPaginaGuia(Document documento, Guia guia, int numeroGuia, int tamañoLetra) {

        Paragraph titulo = new Paragraph("Guia Nº" + numeroGuia + ":");
        titulo.setUnderline(1, -1);
        titulo.setFontSize(tamañoLetra);
        documento.add(titulo);

        documento.add(new Paragraph(""));

        Paragraph cliente = new Paragraph("Cliente: " + guia.getCliente());
        cliente.setFontSize(tamañoLetra);
        documento.add(cliente);

        Paragraph fecha = new Paragraph("Fecha: " + obtenerFecha());
        fecha.setFontSize(tamañoLetra);
        documento.add(fecha);

        documento.add(new Paragraph(""));

        Table tablaGuia = crearTablaGuia(guia, tamañoLetra);
        documento.add(tablaGuia);

        documento.add(new Paragraph(""));
        documento.add(new Paragraph(""));

        List totales = new List();
        totales.setListSymbol("•");
        totales.setSymbolIndent(tamañoLetra);
        totales.setFontSize(tamañoLetra);
        totales.add("Importe Total: S/ " + guia.getImporteTotal());
        totales.add("A Cuenta: S/ " + guia.getMontoCancelado());
        totales.add("Saldo: S/ " + guia.getSaldoCliente());
        totales.add("Peso Total: " + guia.getPesoTotal() + " kg");
        totales.add("Rollos Total: " + guia.getRollosTotal() + " rollos");
        totales.add("Bolsas Total: " + guia.getBolsasTotal() + " bolsas");
        documento.add(totales);

    }

    public static Table crearTablaResumen(String[] totalesDia, int tamañoLetra) {

        float[] dimensionesTablaResumen = new float[]{125, 105};
        Table tablaResumen = new Table(dimensionesTablaResumen);

        Cell encabezadoVentasTotales = crearCelda("Ventas Totales:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoVentasTotales);
        Cell celdaVentasTotales = crearCelda("S/ " + totalesDia[0], tamañoLetra, false);
        tablaResumen.addCell(celdaVentasTotales);

        Cell encabezadoIngresosTotales = crearCelda("Cobranzas:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoIngresosTotales);
        Cell celdaIngresosTotales = crearCelda("S/ " + totalesDia[1], tamañoLetra, false);
        tablaResumen.addCell(celdaIngresosTotales);

        Cell encabezadoCreditoOtorgado = crearCelda("Credito Otorgado:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoCreditoOtorgado);
        Cell celdaCreditoOtorgado = crearCelda("S/ " + totalesDia[2], tamañoLetra, false);
        tablaResumen.addCell(celdaCreditoOtorgado);

        Cell encabezadoKilosVendidos = crearCelda("Kilos Vendidos:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoKilosVendidos);
        Cell celdaKilosVendidos = crearCelda(totalesDia[3] + " kilos", tamañoLetra, false);
        tablaResumen.addCell(celdaKilosVendidos);

        Cell encabezadoRollosVendidos = crearCelda("Rollos Vendidos:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoRollosVendidos);
        Cell celdaRollosVendidos = crearCelda(totalesDia[4] + " rollos", tamañoLetra, false);
        tablaResumen.addCell(celdaRollosVendidos);

        Cell encabezadoBolsasVendidas = crearCelda("Bolsas Vendidas:", tamañoLetra, true);
        tablaResumen.addCell(encabezadoBolsasVendidas);
        Cell celdaBolsasVendidas = crearCelda(totalesDia[5] + " bolsas", tamañoLetra, false);
        tablaResumen.addCell(celdaBolsasVendidas);

        return tablaResumen;

    }

    public static Table crearTablaGuia(Guia guia, int tamañoLetra) {

        float[] dimensionesTablaGuia = new float[]{40, 60, 205, 55, 70};
        Table tablaGuia = new Table(dimensionesTablaGuia);

        Cell encabezadoItem = crearCelda("Item", tamañoLetra, true);
        tablaGuia.addHeaderCell(encabezadoItem);
        Cell encabezadoPeso = crearCelda("Peso", tamañoLetra, true);
        tablaGuia.addHeaderCell(encabezadoPeso);
        Cell encabezadoDescripcion = crearCelda("Descripcion", tamañoLetra, true);
        tablaGuia.addHeaderCell(encabezadoDescripcion);
        Cell encabezadoPrecio = crearCelda("P/Kg", tamañoLetra, true);
        tablaGuia.addHeaderCell(encabezadoPrecio);
        Cell encabezadoImporte = crearCelda("Importe", tamañoLetra, true);
        tablaGuia.addHeaderCell(encabezadoImporte);

        String[][] contenido = guia.getContenido();
        int numeroFilas = contenido.length;
        int numeroColumnas = tablaGuia.getNumberOfColumns();

        for (int j=0; j<numeroFilas; j++) {
            for (int k=0; k<numeroColumnas; k++) {
                if (k == 2) {
                    Cell celdaDescripcion = crearCeldaDescripcion(contenido[j][k], tamañoLetra);
                    tablaGuia.addCell(celdaDescripcion);
                } else {
                    Cell celda = crearCelda(contenido[j][k], tamañoLetra, false);
                    tablaGuia.addCell(celda);
                }
            }
        }

        return tablaGuia;

    }

    public static Cell crearCelda(String texto, int tamañoLetra, Boolean encabezado) {

        Cell celda = new Cell();
        Paragraph textoCelda = new Paragraph(texto);
        textoCelda.setFontSize(tamañoLetra);
        celda.add(textoCelda);

        if (encabezado == true) {
            celda.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        }

        return celda;

    }

    public static Cell crearCeldaDescripcion(String texto, int tamañoLetra) {

        Cell celdaDescripcion = new Cell();

        String articulo = texto.substring(texto.indexOf("<html>")+7, texto.indexOf(" <br>"));
        Paragraph textoCeldaPrimeraParte = new Paragraph(articulo);
        textoCeldaPrimeraParte.setFontSize(tamañoLetra);
        celdaDescripcion.add(textoCeldaPrimeraParte);

        String color = texto.substring(texto.indexOf("<br>")+5, texto.indexOf(" </html>"));
        Paragraph textoCeldaSegundaParte = new Paragraph(color);
        textoCeldaSegundaParte.setFontSize(tamañoLetra);
        celdaDescripcion.add(textoCeldaSegundaParte);

        return celdaDescripcion;

    }

}
