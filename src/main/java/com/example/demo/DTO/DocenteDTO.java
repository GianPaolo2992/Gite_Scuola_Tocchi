package com.example.demo.DTO;

import com.example.demo.entity.Classe;
import com.example.demo.entity.Gita;
import jakarta.persistence.OneToOne;

public class DocenteDTO {

    private Integer id;

    private String nome;

    private String cognome;

    private String materia;

    private ClasseDTO classeDTO;


    private GitaDTO gitaDTO;

    public DocenteDTO(){}

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public ClasseDTO getClasseDTO() {
        return classeDTO;
    }

    public void setClasseDTO(ClasseDTO classeDTO){
        this.classeDTO = classeDTO;
    }

    public GitaDTO getGitaDTO() {
        return gitaDTO;
    }

    public void setGitaDTO(GitaDTO gitaDTO) {
        this.gitaDTO = gitaDTO;
    }
}
