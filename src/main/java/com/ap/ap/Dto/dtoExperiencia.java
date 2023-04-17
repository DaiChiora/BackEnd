package com.ap.ap.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String tituloExp;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String descExp;
    @NotBlank
    private String imgExp;

    //Constructores


    public dtoExperiencia() {
    }

    public dtoExperiencia(String tituloExp, String fechaExp, String descExp, String imgExp) {
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
        this.imgExp = imgExp;
    }

    //Getters y Setters

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }
}
