package com.ap.ap.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String descEdu;
    @NotBlank
    private String imgEdu;

    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloEdu, String fechaEdu, String descEdu, String imgEdu) {
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descEdu = descEdu;
        this.imgEdu = imgEdu;
    }

    //Getters y Setters

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }
}
