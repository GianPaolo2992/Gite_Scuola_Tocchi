package com.example.demo.controller;

import com.example.demo.DTO.GitaDTO;
import com.example.demo.service.GitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gita")
public class GitaController {

    @Autowired
    private GitaService gitaService;

    @GetMapping("/getGitaById/{id}")
    public GitaDTO getGitaById(@PathVariable("id") Integer id) {
        return gitaService.getGitaById(id);
    }

    @GetMapping("/getAllGite")
    public List<GitaDTO> getAllGite() {
        return gitaService.getAllGite();
    }

    @PostMapping("/insertGita")
    public GitaDTO insertGita(@RequestBody GitaDTO gitaDTO) {
        return gitaService.insertGita(gitaDTO);
    }

    @PutMapping("/updateGita/{id}")
    public GitaDTO updateGita(@PathVariable("id") Integer id, @RequestBody GitaDTO gitaDTO) {
        return gitaService.updateGita(id, gitaDTO);
    }

    @DeleteMapping("/deleteGita/{id}")
    public GitaDTO deleteGita(@PathVariable("id") Integer id) {
        return gitaService.deleteGita(id);
    }
}
