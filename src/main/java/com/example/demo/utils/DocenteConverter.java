package com.example.demo.utils;

import com.example.demo.DTO.DocenteDTO;

import com.example.demo.entity.Docente;

public class DocenteConverter {

    public static Docente convertToEntityXGita( DocenteDTO docenteDTO) {

        Docente docente = new Docente();
        docente.setId(docenteDTO.getId());
        docente.setNome(docenteDTO.getNome());
        docente.setCognome(docenteDTO.getCognome());
        docente.setMateria(docenteDTO.getMateria());

        return docente;
    }
    public static DocenteDTO convertToDTOXGita(Docente docente) {

        DocenteDTO docenteDTO = new DocenteDTO();
        docenteDTO.setId(docente.getId());
        docenteDTO.setNome(docente.getNome());
        docenteDTO.setCognome(docente.getCognome());
        docenteDTO.setMateria(docente.getMateria());

        return docenteDTO;
    }

    public static DocenteDTO convertToDTO(Docente docente) {

        DocenteDTO docenteDTO = new DocenteDTO();
        docenteDTO.setId(docente.getId());
        docenteDTO.setNome(docente.getNome());
        docenteDTO.setCognome(docente.getCognome());
        docenteDTO.setMateria(docente.getMateria());

        if (docente.getClasse() != null){
            docenteDTO.setClasseDTO(ClasseConverter.ConvertToDTOXDoc(docente.getClasse()));

        }

        if (docente.getGita() != null){
            docenteDTO.setGitaDTO(GitaConverter.convertListToDTOXDoc(docente.getGita()));
        }

        return docenteDTO;
    }
    public static Docente convertToEntity(DocenteDTO docenteDTO) {

        Docente docente = new Docente();
        docente.setId(docenteDTO.getId());
        docente.setNome(docenteDTO.getNome());
        docente.setCognome(docenteDTO.getCognome());
        docente.setMateria(docenteDTO.getMateria());


        return docente;
    }
    public static DocenteDTO convertToDTOXClasse(Docente docente) {

        DocenteDTO docenteDTO = new DocenteDTO();
        docenteDTO.setId(docente.getId());
        docenteDTO.setNome(docente.getNome());
        docenteDTO.setCognome(docente.getCognome());
        docenteDTO.setMateria(docente.getMateria());
        return docenteDTO;
    }

    public static Docente convertToEntityXClasse(DocenteDTO docenteDTO){
        Docente docente = new Docente();
        docente.setId(docenteDTO.getId());
        docente.setNome(docenteDTO.getNome());
        docente.setCognome(docenteDTO.getCognome());
        docente.setMateria(docenteDTO.getMateria());
        return docente;
    }
}
