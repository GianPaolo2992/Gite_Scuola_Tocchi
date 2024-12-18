package com.example.demo.DTO;

import com.example.demo.entity.Docente;
import com.example.demo.entity.Gita;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.List;
@JsonPropertyOrder({ "id", "sezione", "docenteDTO", "listaGiteDTO" })//per ordinare gli attributi in stampa
public class ClasseDTO {

        private Integer id;

        private String sezione;

        private DocenteDTO docenteDTO;

        private List<GitaDTO> listaGiteDTO;

        public ClasseDTO() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSezione() {
            return sezione;
        }

        public void setSezione(String sezione) {
            this.sezione = sezione;
        }

        public DocenteDTO getDocenteDTO() {
            return docenteDTO;
        }

        public void setDocenteDTO(DocenteDTO docenteDTO) {
            this.docenteDTO = docenteDTO;
        }
        public List<GitaDTO> getListaGiteDTO() {
            return listaGiteDTO;
        }

        public void setListaGiteDTO(List<GitaDTO> listaGiteDTO){
            this.listaGiteDTO = listaGiteDTO;
        }
    }


