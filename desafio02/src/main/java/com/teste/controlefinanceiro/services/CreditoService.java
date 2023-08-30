package com.teste.controlefinanceiro.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.controlefinanceiro.model.Credito;
import com.teste.controlefinanceiro.respository.CreditoRepository_old;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository_old creditoRepository;

    /**
     * Metodo para retornar receitas
     * 
     * @return Lista de receitas
     */
    public List<Credito> obterTodos() {
        return creditoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * 
     * @param id do crédito que será localizado.
     * @return Retorna uma receita caso tenha sido localizado.
     */
    public Optional<Credito> obterPorid(Integer id) {
        return creditoRepository.obterPorid(id);
    }

    /**
     * Metodo para adicionar credito
     * 
     * @param credito a que será adicionado
     * @return retorna o produto que foi adicionado.
     */
    public Credito adicionar(Credito credito) {
        return creditoRepository.adicionar(credito);
    }

    /**
     * Metodo para deletar o credito por id.
     * 
     * @param id credito a ser deletado
     */
    public void deletar(Integer id) {
        creditoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o crédito na lista
     * 
     * @param credito que será aatulizado
     * @return retorna o crédito após atualizar a lista
     */
    public Credito atualizar(Integer id, Credito credito) {

        credito.setId(id);
        return creditoRepository.atualizar(credito);

    }
}
