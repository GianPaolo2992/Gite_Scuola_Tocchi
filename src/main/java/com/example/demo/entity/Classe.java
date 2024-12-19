package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sezione;


    @OneToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToMany(
            mappedBy = "listaClassi", cascade = CascadeType.ALL
    )
    private List<Gita> listaGite;


    public Classe() {
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Gita> getListaGite() {
        return listaGite;
    }

    public void setListaGite(List<Gita> listaGite) {
        this.listaGite = listaGite;
    }
}
