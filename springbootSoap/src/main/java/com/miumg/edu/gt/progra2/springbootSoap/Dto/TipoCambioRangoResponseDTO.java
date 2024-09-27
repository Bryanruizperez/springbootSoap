package com.miumg.edu.gt.progra2.springbootSoap.Dto;

import java.util.List;

public class TipoCambioRangoResponseDTO {
    private List<Var> vars;
    private int totalItems;

    // Getters y Setters

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public static class Var {
        private int moneda;
        private String fecha;
        private float venta;
        private float compra;

        // Getters and Setters
        public int getMoneda() {
            return moneda;
        }

        public void setMoneda(int moneda) {
            this.moneda = moneda;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public float getVenta() {
            return venta;
        }

        public void setVenta(float venta) {
            this.venta = venta;
        }

        public float getCompra() {
            return compra;
        }

        public void setCompra(float compra) {
            this.compra = compra;
        }
    }
}
