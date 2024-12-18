package com.example.demo.utils;

import com.example.demo.DTO.GitaDTO;
import com.example.demo.entity.Gita;

import java.util.ArrayList;
import java.util.List;

public class GitaConverter {
    public static Gita convertToEntity(GitaDTO gitaDTO) {

        Gita gita = new Gita();
        gita.setId(gitaDTO.getId());
        gita.setDestinazione(gitaDTO.getDestinazione());
        gita.setDataPartenza(gitaDTO.getDataPartenza());
        gita.setDataRitorno(gitaDTO.getDataRitorno());
        if (gitaDTO.getDocenteDTO() != null) {
            gita.setDocente(DocenteConverter.convertToEntityXGita(gitaDTO.getDocenteDTO()));
        } else {
            gita.setDocente(null);
        }

//        if (gitaDTO.getListaClassi() != null) {
//            gita.setListaClassi(ClasseConverter.ConvertListToDTOXGita(gita.getListaClassi()));
//        }
        return gita;
    }
    public static GitaDTO convertToDTO(Gita gita) {

        GitaDTO gitaDTO = new GitaDTO();
        gitaDTO.setId(gita.getId());
        gitaDTO.setDestinazione(gita.getDestinazione());
        gitaDTO.setDataPartenza(gita.getDataPartenza());
        gitaDTO.setDataRitorno(gita.getDataRitorno());
        if (gita.getDocente() != null) {
            gitaDTO.setDocenteDTO(DocenteConverter.convertToDTOXGita(gita.getDocente()));
        }

        if (gita.getListaClassi() != null) {
            gitaDTO.setListaClassi(ClasseConverter.ConvertListToDTOXGita(gita.getListaClassi()));
        }
        return gitaDTO;
    }
    public static GitaDTO convertListToDTOXDoc(Gita gita) {

            GitaDTO gitaDTO = new GitaDTO();
            gitaDTO.setId(gita.getId());
            gitaDTO.setDestinazione(gita.getDestinazione());
            gitaDTO.setDataPartenza(gita.getDataPartenza());
            gitaDTO.setDataRitorno(gita.getDataRitorno());
            return gitaDTO;
        }



    public static List<GitaDTO> convertListToDTOXClasse(List<Gita> listagite) {
        List<GitaDTO> listagiteDTO = new ArrayList<>();
        for (Gita gita : listagite){
            GitaDTO gitaDTO = new GitaDTO();
            gitaDTO.setId(gita.getId());
            gitaDTO.setDestinazione(gita.getDestinazione());
            gitaDTO.setDataPartenza(gita.getDataPartenza());
            gitaDTO.setDataRitorno(gita.getDataRitorno());
            if(gita.getDocente() != null){
                gitaDTO.setDocenteDTO(DocenteConverter.convertToDTOXClasse(gita.getDocente()));
            }

            listagiteDTO.add(gitaDTO);
        }
        return listagiteDTO;
    }
}
