package com.teste.controlefinanceiro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.controlefinanceiro.model.Credito;
import com.teste.controlefinanceiro.model.exception.ResourceNotFoundException;
import com.teste.controlefinanceiro.respository.CreditoRepository_old;
import com.teste.controlefinanceiro.shared.CreditoDTO;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository_old creditoRepository;

    /**
     * Metodo para retornar receitas
     * 
     * @return Lista de receitas
     */
    public List<CreditoDTO> obterTodos() {
        List<Credito> creditos = creditoRepository.obterTodos();

        return creditos.stream()
                .map(credito -> new ModelMapper().map(credito, CreditoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * 
     * @param id do crédito que será localizado.
     * @return Retorna uma receita caso tenha sido localizado.
     */
    public Optional<CreditoDTO> obterPorid(Integer id) {
        Optional<Credito> credito = creditoRepository.obterPorid(id);

        if (credito.isEmpty()) {
            throw new ResourceNotFoundException("Credito com id: " + id + "não encontrado");
        }

        CreditoDTO dto = new ModelMapper().map(credito.get(), CreditoDTO.class);
        return Optional.of(dto);

    }

    /**
     * Metodo para adicionar credito
     * 
     * @param credito a que será adicionado
     * @return retorna o credito que foi adicionado.
     */
    public CreditoDTO adicionar(CreditoDTO creditoDto) {
        creditoDto.setId(null);

        ModelMapper mapper = new ModelMapper();
        Credito credito = mapper.map(creditoDto, Credito.class);
        credito = creditoRepository.save(credito);
        creditoDto.setId(credito.getId());

        return creditoDto;
    }

    /**
     * Metodo para deletar o credito por id.
     * 
     * @param id credito a ser deletado
     */
    public void deletar(Integer id) {
        Optional<Credito> credito = creditoRepository.findById(id);
        if (credito.isEmpty()) {
            throw new ResourceNotFoundException(
                    " Não foi possível deletar o produto com o id: " + id + " - Credito não encontrado");
        }

        creditoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o crédito na lista
     * 
     * @param credito que será atualizado
     * @return retorna o crédito após atualizar a lista
     */
    public CreditoDTO atualizar(Integer id, CreditoDTO creditodDto) {
        creditodDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Credito credito = mapper.map(creditodDto, Credito.class);
        creditoRepository.save(credito);
        return creditodDto;

    }
}
