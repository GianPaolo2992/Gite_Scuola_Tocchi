package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Gita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String destinazione;

    @Column(name = "datapartenza")
    private LocalDate dataPartenza;

    @Column(name = "dataritorno")
    private LocalDate dataRitorno;
    @OneToOne
    @JoinColumn(name = "id_docente", unique = true)
    private Docente docente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "destinazione",
            joinColumns = @JoinColumn(name = "id_gita"),//lista
            inverseJoinColumns = @JoinColumn(name = "id_classe")//lista
    )
    private List<Classe> listaClassi;

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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Classe> getListaClassi() {
        return listaClassi;
    }

    public void setListaClassi(List<Classe> listaClassi) {
        this.listaClassi = listaClassi;
    }
}
