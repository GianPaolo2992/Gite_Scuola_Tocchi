package com.example.demo.DTO;

import com.example.demo.entity.Classe;
import com.example.demo.entity.Docente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class GitaDTO {

    private Integer id;

    private String destinazione;


    private LocalDate dataPartenza;


    private LocalDate dataRitorno;

    private DocenteDTO docenteDTO;


    private List<ClasseDTO> listaClassiDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public LocalDate getDataRitorno() {
        return dataRitorno;
    }

    public void setDataRitorno(LocalDate dataRitorno) {
        this.dataRitorno = dataRitorno;
    }

    public DocenteDTO getDocenteDTO() {
        return docenteDTO;
    }

    public void setDocenteDTO(DocenteDTO docenteDTO) {
        this.docenteDTO = docenteDTO;
    }

    public List<ClasseDTO> getListaClassiDTO() {
        return listaClassiDTO;
    }

    public void setListaClassi(List<ClasseDTO> listaClassiDTO) {
        this.listaClassiDTO = listaClassiDTO;
    }
}
