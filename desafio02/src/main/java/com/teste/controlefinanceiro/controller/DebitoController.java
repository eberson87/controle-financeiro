package com.teste.controlefinanceiro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.controlefinanceiro.model.Debito;
import com.teste.controlefinanceiro.services.DebitoService;

@RestController
@RequestMapping("/api/debitos")

public class DebitoController {
    @Autowired
    private DebitoService debitoService;

    @GetMapping
    public List<Debito> obterTodos() {
        return debitoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Debito> obterPorId(@PathVariable Integer id) {
        return debitoService.obterPorid(id);
    }

    @PostMapping
    public Debito adicionar(@RequestBody Debito debito) {
        return debitoService.adicionar(debito);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        debitoService.deletar(id);
        return "Debito com id" + id + " deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Debito atualizar(@RequestBody Debito debito, @PathVariable Integer id) {
        return debitoService.atualizar(id, debito);
    }
}
