package com.example.demo.controller;


import com.example.demo.DTO.ClasseDTO;

import com.example.demo.DTO.GitaDTO;
import com.example.demo.service.ClasseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    private final ClasseService classeService;

    public ClasseController(ClasseService classeService){
        this.classeService = classeService;
    }

    @GetMapping("/getClasseById/{id}")
    public ClasseDTO getClasseById(@PathVariable("id") Integer id){
        return classeService.getClasseById(id);
    }

    @GetMapping("/getAllClassi")
    public List<ClasseDTO> getAllClassi(){
        return classeService.getAllClassi();
    }

    @PostMapping("/InsertClasse")
    public ClasseDTO insertClasse(@RequestBody ClasseDTO classeDto){
        return classeService.insertClasse(classeDto);
    }

    @PutMapping("/updateClasseById/{id}")
    public ClasseDTO updateClasse(@PathVariable("id") Integer id , @RequestBody ClasseDTO classeDTO){
        return classeService.updateClasse(id,classeDTO);
    }

    @DeleteMapping("/deleteClasse/{id}")
    public ClasseDTO deleteClasse(@PathVariable("id") Integer id ){
        return classeService.deleteClasseById(id);
    }

    @PostMapping("/associateClasseGita/classe{id_classe}/gita{id_gita}")
    public ClasseDTO associateClasseGita(@PathVariable("id_classe") Integer idClasse,@PathVariable("id_gita") Integer idGita){
        return classeService.associateClasseGita(idClasse,idGita);
    }

}
