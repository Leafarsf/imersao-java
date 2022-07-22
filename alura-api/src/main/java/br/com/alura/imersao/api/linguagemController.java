package br.com.alura.imersao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class linguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;

    
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem adicionarLinguagem(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }
    





}
