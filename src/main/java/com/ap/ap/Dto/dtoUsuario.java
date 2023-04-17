package com.ap.ap.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class dtoUsuario {
   @NotBlank
    private String nombre;
   @NotBlank
    private String apellido;

   @NotBlank
    private String titulo;
    @NotBlank
    private String img;
    @NotBlank
    private String descripcion;

    public dtoUsuario() {
    }

    public dtoUsuario(String nombre, String apellido, String titulo, String img, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.img = img;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
