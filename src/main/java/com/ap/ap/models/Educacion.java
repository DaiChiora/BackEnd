package com.ap.ap.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Educacion {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idEdu;
        private String tituloEdu;
        private String fechaEdu;
        private String descEdu;
        private String imgEdu;


        public Educacion() {

        }

        public Educacion(Long idEdu, String tituloEdu, String fechaEdu, String descEdu, String imgEdu) {
            this.idEdu = idEdu;
            this.tituloEdu = tituloEdu;
            this.fechaEdu = fechaEdu;
            this.descEdu = descEdu;
            this.imgEdu = imgEdu;
        }

        public Long getIdEdu() {
            return idEdu;
        }

        public void setIdEdu(Long idEdu) {
            this.idEdu = idEdu;
        }

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


