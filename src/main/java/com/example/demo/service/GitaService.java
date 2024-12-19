package com.example.demo.service;

import com.example.demo.DTO.GitaDTO;
import com.example.demo.entity.Classe;
import com.example.demo.entity.Docente;
import com.example.demo.entity.Gita;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.repository.GitaRepository;
import com.example.demo.utils.GitaConverter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GitaService {

    @Autowired
    private GitaRepository gitaRepository;
    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private ClasseRepository classeRepository;

    @Transactional
    public GitaDTO getGitaById(Integer id) {
        Optional<Gita> gitaOPT = gitaRepository.findById(id);

        if (gitaOPT.isPresent()) {
            return GitaConverter.convertToDTO(gitaOPT.get());
        } else {
            throw new EntityNotFoundException("Gita Not Found");
        }
    }

    @Transactional
    public List<GitaDTO> getAllGite() {
        List<Gita> listaGite = gitaRepository.findAll();
        List<GitaDTO> listaGiteDTO = new ArrayList<>();

        for (Gita gita : listaGite) {
            GitaDTO gitaDTO = GitaConverter.convertToDTO(gita);

            listaGiteDTO.add(gitaDTO);
        }

        return listaGiteDTO;
    }

    @Transactional
    public GitaDTO insertGita(GitaDTO gitaDTO) {
        Optional<Docente> doc = docenteRepository.findById(gitaDTO.getDocenteDTO().getId());
        Gita gita = GitaConverter.convertToEntity(gitaDTO);
        doc.ifPresent(gita::setDocente);
        Gita gitaSaved = gitaRepository.save(gita);
        return GitaConverter.convertToDTO(gitaSaved);

    }

    @Transactional
    public GitaDTO updateGita(Integer id, GitaDTO gitaDTO) {
        Optional<Gita> gitaOPT = gitaRepository.findById(id);
        if (gitaOPT.isPresent()) {
            gitaDTO.setId(id);
            Gita gita = GitaConverter.convertToEntity(gitaDTO);

            Gita gitaUpdated = gitaRepository.save(gita);

            return GitaConverter.convertToDTO(gitaUpdated);

        } else {
            throw new EntityNotFoundException("Gita Not Found");
        }
    }

    @Transactional
    public GitaDTO deleteGita(Integer id) {
        Optional<Gita> gitaOpt = gitaRepository.findById(id);

        if (gitaOpt.isPresent()) {

            Gita gitaDeleted = gitaOpt.get();
            Docente docente = gitaDeleted.getDocente();
            docente.setGita(null);

            if (!gitaDeleted.getListaClassi().isEmpty()) {

                for (Classe classeToDelete : gitaDeleted.getListaClassi()) {
                    classeToDelete.getListaGite().remove(gitaDeleted);
                    classeRepository.save(classeToDelete);
                }
                gitaDeleted.getListaClassi().clear();
            }
            gitaRepository.delete(gitaOpt.get());
            return GitaConverter.convertToDTO(gitaDeleted);

        } else {
            throw new EntityNotFoundException("Gita Not Found");
        }
    }


}
