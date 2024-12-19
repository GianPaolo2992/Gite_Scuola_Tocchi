package com.example.demo.controller;

import com.example.demo.DTO.DocenteDTO;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/getDocenteByid/{id}")
    public DocenteDTO getDocenteByid(@PathVariable("id") Integer id) {
        return docenteService.getDocenteById(id);
    }

    @GetMapping("/getAllDocenti")
    public List<DocenteDTO> getAllDocenti() {
        return docenteService.getAllDocenti();
    }

    @PostMapping("/insertDocente")
    public DocenteDTO insertDocente(@RequestBody DocenteDTO docenteDTO) {
        return docenteService.insertDocente(docenteDTO);
    }

    @PutMapping("/updateDocente/{id}")
    public DocenteDTO updateDocente(@PathVariable("id") Integer id, @RequestBody DocenteDTO docenteDTO) {
        return docenteService.updateDocente(id, docenteDTO);
    }

    @DeleteMapping("/deleteDocente/{id}")
    public DocenteDTO deleteDocente(@PathVariable("id") Integer id) {
        return docenteService.deleteDocente(id);
    }

}
