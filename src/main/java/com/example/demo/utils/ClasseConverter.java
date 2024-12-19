package com.example.demo.utils;

import com.example.demo.DTO.ClasseDTO;
import com.example.demo.DTO.GitaDTO;
import com.example.demo.entity.Classe;
import com.example.demo.entity.Gita;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import jakarta.persistence.Converter;
//
//@Converter
public class ClasseConverter {
    public static ClasseDTO ConvertToDTOXDoc(Classe classe) {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setId(classe.getId());
        classeDTO.setSezione(classe.getSezione());

        return classeDTO;
    }

    public static ClasseDTO ConvertToDTO(Classe classe) {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setId(classe.getId());
        classeDTO.setSezione(classe.getSezione());
        if (classe.getDocente() != null) {
            classeDTO.setDocenteDTO(DocenteConverter.convertToDTOXClasse(classe.getDocente()));
        }
        if (classe.getListaGite() != null) {
            classeDTO.setListaGiteDTO(GitaConverter.convertListToDTOXClasse(classe.getListaGite()));//crea converter di lista gite in gita converter

        }

        return classeDTO;
    }

    public static Classe convertToEntity(ClasseDTO classeDTO) {
        Classe classe = new Classe();
        classe.setId(classeDTO.getId());
        classe.setSezione(classeDTO.getSezione());
        classe.setDocente(DocenteConverter.convertToEntityXClasse(classeDTO.getDocenteDTO()));
        return classe;
    }

    public static List<ClasseDTO> ConvertListToDTOXGita(List<Classe> listaClassi) {
        List<ClasseDTO> listaGiteDTO = new ArrayList<>();

        for (Classe classe : listaClassi) {
            ClasseDTO classeDTO = new ClasseDTO();
            classeDTO.setId(classe.getId());
            classeDTO.setSezione(classe.getSezione());
            //classeDTO.setDocenteDTO(DocenteConverter.convertToDTOXClasse(classe.getDocente()));

            listaGiteDTO.add(classeDTO);
        }
        return listaGiteDTO;
    }


}
