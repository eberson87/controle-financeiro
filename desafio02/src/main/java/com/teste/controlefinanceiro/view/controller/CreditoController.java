package com.teste.controlefinanceiro.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.controlefinanceiro.services.CreditoService;
import com.teste.controlefinanceiro.shared.CreditoDTO;
import com.teste.controlefinanceiro.view.model.CreditoRequest;
import com.teste.controlefinanceiro.view.model.CreditoResponse;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping
    public ResponseEntity<List<CreditoResponse>> obterTodos() {
        List<CreditoDTO> creditos = creditoService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<CreditoResponse> resposta = creditos.stream()
                .map(creditoDto -> mapper.map(creditoDto, CreditoResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CreditoResponse>> obterPorId(@PathVariable Integer id) {
        Optional<CreditoDTO> dto = creditoService.obterPorid(id);

        CreditoResponse credito = new ModelMapper().map(dto.get(), CreditoResponse.class);

        return new ResponseEntity<>(Optional.of(credito), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreditoResponse> adicionar(@RequestBody CreditoRequest creditoReq) {
        ModelMapper mapper = new ModelMapper();

        CreditoDTO creditoDto = mapper.map(creditoReq, CreditoDTO.class);

        creditoDto = creditoService.adicionar(creditoDto);

        return new ResponseEntity<>(mapper.map(creditoDto, CreditoResponse.class), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        creditoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditoResponse> atualizar(@RequestBody CreditoRequest creditoReq, @PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        CreditoDTO creditoDto = mapper.map(creditoReq, CreditoDTO.class);

        creditoDto = creditoService.atualizar(id, creditoDto);

        return new ResponseEntity<>(
                mapper.map(creditoDto, CreditoResponse.class),
                HttpStatus.OK);
    }
}
