package com.majesa.programa;

public class Guia {

    // Atributos de cada guia

    private String cliente;
    private String[] totales;
    private String[][] contenido;

    // Constructor para cada guia

    public Guia(String cliente, String[] totales, String[][] contenido) {

        this.cliente = cliente;
        this.totales = totales;
        this.contenido = contenido;

    }

    // Metodos de cada guia

    public String getCliente() {
        return cliente;
    }

    public String[] getTotales() {
        return totales;
    }

    public String getImporteTotal() {
        return totales[0];
    }

    public String getMontoCancelado() {
        return totales[1];
    }

    public String getSaldoCliente() {
        return totales[2];
    }

    public String getPesoTotal() {
        return totales[3];
    }

    public String getRollosTotal() {
        return totales[4];
    }

    public String getBolsasTotal() {
        return totales[5];
    }

    public String[][] getContenido() {
        return contenido;
    }

}
