package com.example.demo.DTO;

import java.util.List;

public class ClasseDTOString {
    private Integer id;

    private String sezione;

    private DocenteDTO docenteDTO;

    private List<String> listaGiteDTOString;

    public ClasseDTOString() {
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
    public List<String> getListaGiteDTOString() {
        return listaGiteDTOString;
    }

    public void setListaGiteDTOString(List<String> listaGiteDTOString){
        this.listaGiteDTOString = listaGiteDTOString;
    }
}
