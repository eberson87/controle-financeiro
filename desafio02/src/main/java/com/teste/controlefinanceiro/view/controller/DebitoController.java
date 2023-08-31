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

import com.teste.controlefinanceiro.services.DebitoService;
import com.teste.controlefinanceiro.shared.DebitoDTO;
import com.teste.controlefinanceiro.view.model.DebitoRequest;
import com.teste.controlefinanceiro.view.model.DebitoResponse;

@RestController
@RequestMapping("/api/debitos")

public class DebitoController {
    @Autowired
    private DebitoService debitoService;

    @GetMapping
    public ResponseEntity<List<DebitoResponse>> obterTodos() {
        List<DebitoDTO> debitos = debitoService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<DebitoResponse> resposta = debitos.stream()
                .map(debitoDto -> mapper.map(debitoDto, DebitoResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DebitoResponse>> obterPorId(@PathVariable Integer id) {

        Optional<DebitoDTO> dto = debitoService.obterPorid(id);

        DebitoResponse debito = new ModelMapper().map(dto.get(), DebitoResponse.class);

        return new ResponseEntity<>(Optional.of(debito), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DebitoResponse> adicionar(@RequestBody DebitoRequest debitoReq) {
        ModelMapper mapper = new ModelMapper();

        DebitoDTO debitoDto = mapper.map(debitoReq, DebitoDTO.class);

        debitoDto = debitoService.adicionar(debitoDto);

        return new ResponseEntity<>(mapper.map(debitoDto, DebitoResponse.class), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        debitoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DebitoResponse> atualizar(@RequestBody DebitoRequest debitoReq, @PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        DebitoDTO debitoDto = mapper.map(debitoReq, DebitoDTO.class);

        debitoDto = debitoService.atualizar(id, debitoDto);

        return new ResponseEntity<>(
                mapper.map(debitoDto, DebitoResponse.class),
                HttpStatus.OK);
    }
}
