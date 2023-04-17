package com.ap.ap.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidades {
    @NotBlank
    private String nombreHabilidad;
    @NotBlank
    private int porcentaje;

    //Constructores

    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombreHabilidad, int porcentaje) {
        this.nombreHabilidad = nombreHabilidad;
        this.porcentaje = porcentaje;
    }

    //Getter y Setters

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
