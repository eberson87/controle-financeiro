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

import com.teste.controlefinanceiro.model.Credito;
import com.teste.controlefinanceiro.services.CreditoService;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping
    public List<Credito> obterTodos() {
        return creditoService.obterTodos();
    }

    @GetMapping("/:{id}")
    public Optional<Credito> obterPorId(@PathVariable Integer id) {
        return creditoService.obterPorid(id);
    }

    @PostMapping
    public Credito adicionar(@RequestBody Credito credito) {
        return creditoService.adicionar(credito);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        creditoService.deletar(id);
        return "Credito com id" + id + " deletado com sucesso!";
    }

    @PutMapping("/id")
    public Credito atualizar(@RequestBody Credito credito, @PathVariable Integer id) {
        return creditoService.atualizar(id, credito);
    }
}
