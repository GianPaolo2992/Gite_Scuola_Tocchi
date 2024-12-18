package com.example.demo.service;

import com.example.demo.DTO.DocenteDTO;
import com.example.demo.entity.Docente;
import com.example.demo.entity.Gita;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.repository.GitaRepository;
import com.example.demo.utils.DocenteConverter;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.TransientObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private GitaRepository gitaRepository;
    @Transactional
    public DocenteDTO getDocenteById(Integer id){
        Optional<Docente> docente = docenteRepository.findById(id);
        if (docente.isPresent()){
            return DocenteConverter.convertToDTO(docente.get());
        } else {
            throw new EntityNotFoundException("Entity Not Found");
        }

    }

    @Transactional
    public List<DocenteDTO> getAllDocenti(){
        List<Docente>  listaDocente = docenteRepository.findAll();
        List<DocenteDTO> listaDocenteDTO = new ArrayList<>();
            for (Docente doc : listaDocente){
                DocenteDTO docenteDTO = DocenteConverter.convertToDTO(doc);

                listaDocenteDTO.add(docenteDTO);
            }
            return listaDocenteDTO;
    }

    @Transactional
    public DocenteDTO insertDocente(DocenteDTO docenteDTO) {

        Docente docente = DocenteConverter.convertToEntity(docenteDTO);
        Docente docenteSaved = docenteRepository.save(docente);
        return DocenteConverter.convertToDTO(docenteSaved);

    }

    @Transactional
    public DocenteDTO updateDocente(Integer id, DocenteDTO docenteDTO){
        Optional<Docente> docenteOPT = docenteRepository.findById(id);

        if (docenteOPT.isPresent()){
            docenteDTO.setId(id);
            Docente docenteUpdated = DocenteConverter.convertToEntity(docenteDTO);
            return DocenteConverter.convertToDTO(docenteUpdated);
        }else {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Transactional
    public DocenteDTO deleteDocente(Integer id){
        Optional<Docente> docenteOPT = docenteRepository.findById(id);

        if (docenteOPT.isPresent()){
            Docente docenteDeleted = docenteOPT.get();

            if (docenteDeleted.getGita() != null) {
                Gita gita = docenteDeleted.getGita();
                gita.setDocente(null);
                gitaRepository.save(gita);
            }
            if(docenteDeleted.getClasse() != null) {

                throw new TransientObjectException("non è possibile eliminare un docente con una perche referenziato in classe");

            }

            docenteRepository.delete(docenteOPT.get());
            return  DocenteConverter.convertToDTO(docenteDeleted);
        }else {
            throw new EntityNotFoundException("Docente Not Found");
        }
    }

}
