package com.teste.controlefinanceiro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.controlefinanceiro.model.Debito;
import com.teste.controlefinanceiro.model.exception.ResourceNotFoundException;
import com.teste.controlefinanceiro.respository.DebitoRepository_old;
import com.teste.controlefinanceiro.shared.DebitoDTO;

@Service
public class DebitoService {

    @Autowired
    private DebitoRepository_old debitoRepository;

    /**
     * Metodo para retornar despesas
     * 
     * @return Lista de despesas
     */
    public List<DebitoDTO> obterTodos() {
        List<Debito> debitos = debitoRepository.obterTodos();

        return debitos.stream()
                .map(debito -> new ModelMapper().map(debito, DebitoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna a despesa encontrado pelo seu Id.
     * 
     * @param id do debito que será localizado.
     * @return Retorna uma despesa caso tenha sido localizado.
     */
    public Optional<DebitoDTO> obterPorid(Integer id) {
        Optional<Debito> debito = debitoRepository.obterPorid(id);

        if (debito.isEmpty()) {
            throw new ResourceNotFoundException("Debito com id: " + id + "não encontrado");
        }

        DebitoDTO dto = new ModelMapper().map(debito.get(), DebitoDTO.class);
        return Optional.of(dto);

    }

    /**
     * Metodo para adicionar debito
     * 
     * @param debito a que será adicionado
     * @return retorna o debito que foi adicionado.
     */
    public DebitoDTO adicionar(DebitoDTO debitoDto) {
        debitoDto.setId(null);

        ModelMapper mapper = new ModelMapper();
        Debito debito = mapper.map(debitoDto, Debito.class);
        debito = debitoRepository.save(debito);
        debitoDto.setId(debito.getId());

        return debitoDto;
    }

    /**
     * Metodo para deletar o debito por id.
     * 
     * @param id debito a ser deletado
     */
    public void deletar(Integer id) {
        Optional<Debito> debito = debitoRepository.findById(id);
        if (debito.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Não foi possível deletar o debito com o id " + id + " - Debito não encontrado");
        }
        debitoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o debito na lista
     * 
     * @param debito que será atulizado
     * @return retorna o debito após atualizar a lista
     */
    public DebitoDTO atualizar(Integer id, DebitoDTO debitoDto) {
        debitoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Debito debito = mapper.map(debitoDto, Debito.class);
        debitoRepository.save(debito);
        return debitoDto;

    }
}
