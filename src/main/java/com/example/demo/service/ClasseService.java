package com.example.demo.service;

import com.example.demo.DTO.ClasseDTO;
import com.example.demo.DTO.GitaDTO;
import com.example.demo.entity.Classe;
import com.example.demo.entity.Docente;
import com.example.demo.entity.Gita;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.repository.GitaRepository;
import com.example.demo.utils.ClasseConverter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;
    private final DocenteRepository docenteRepository;
    private final GitaRepository gitaRepository;

    public ClasseService(ClasseRepository classeRepository,DocenteRepository docenteRepository, GitaRepository gitaRepository) {
        this.classeRepository = classeRepository;
        this.docenteRepository = docenteRepository;
        this.gitaRepository = gitaRepository;
    }

    @Transactional
    public ClasseDTO getClasseById(Integer id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.map(ClasseConverter::ConvertToDTO).orElse(null);
    }
    @Transactional
    public List<ClasseDTO> getAllClassi() {
        List<Classe> listaClasse = classeRepository.findAll();
        List<ClasseDTO> listaClasseDTO = new ArrayList<>();

        for (Classe classe : listaClasse) {
            ClasseDTO classeDTO = ClasseConverter.ConvertToDTO(classe);


            listaClasseDTO.add(classeDTO);
        }
        return listaClasseDTO;
    }
    @Transactional
    public ClasseDTO insertClasse(ClasseDTO classeDTO) {
        Optional<Docente> doc = docenteRepository.findById(classeDTO.getDocenteDTO().getId());
        Classe classe = ClasseConverter.convertToEntity(classeDTO);
        if(doc.isPresent()){
            classe.setDocente(doc.get());
        }
        Classe classeSaved = classeRepository.save(classe);
        return ClasseConverter.ConvertToDTO(classeSaved);
    }
    @Transactional
    public ClasseDTO updateClasse(Integer id,ClasseDTO classeDTO){

        Optional<Classe> classeOPT = classeRepository.findById(id);

        if (classeOPT.isPresent()){
            classeDTO.setId(id);
            Classe classe = ClasseConverter.convertToEntity(classeDTO);
            //Docente docente = classe.getDocente();
            Classe classeSaved = classeRepository.save(classe);
            return ClasseConverter.ConvertToDTO(classeSaved);

        }
        return null;
    }
    @Transactional
    public ClasseDTO deleteClasseById(Integer id) {
        Optional<Classe> classeOPT = classeRepository.findById(id);

        if(classeOPT.isPresent()){
            Classe classe = classeOPT.get();
            Docente docente = classe.getDocente();
            docente.setClasse(null);
            ClasseDTO classeDeleted = ClasseConverter.ConvertToDTO(classe);
             classeRepository.delete(classe);

            return classeDeleted;

        }
        return null;
    }

    public ClasseDTO associateClasseGita(Integer idClasse , Integer idGita) {

        Optional<Classe> classeOpt = classeRepository.findById(idClasse);
        Optional<Gita> gitaOpt = gitaRepository.findById(idGita);
        if (classeOpt.isPresent() && gitaOpt.isPresent() ){
            if( !classeOpt.get().getListaGite().contains(gitaOpt.get())){
                gitaOpt.get().getListaClassi().add(classeOpt.get());
                classeOpt.get().getListaGite().add(gitaOpt.get());

                gitaRepository.save(gitaOpt.get());
                classeRepository.save(classeOpt.get());

                return  ClasseConverter.ConvertToDTO(classeOpt.get());
            }else {
                throw new EntityNotFoundException("L'array gia contiene oggetto");
            }

        }else  {
            throw new EntityNotFoundException("Classe or Gita Not Found");
        }

    }



}
