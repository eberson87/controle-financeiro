package com.teste.controlefinanceiro.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.controlefinanceiro.model.Debito;
import com.teste.controlefinanceiro.respository.DebitoRepository_old;

@Service
public class DebitoService {

    @Autowired
    private DebitoRepository_old debitoRepository;

    /**
     * Metodo para retornar despesas
     * 
     * @return Lista de despesas
     */
    public List<Debito> obterTodos() {
        return debitoRepository.obterTodos();
    }

    /**
     * Metodo que retorna a despesa encontrado pelo seu Id.
     * 
     * @param id do debito que será localizado.
     * @return Retorna uma despesa caso tenha sido localizado.
     */
    public Optional<Debito> obterPorid(Integer id) {
        return debitoRepository.obterPorid(id);
    }

    /**
     * Metodo para adicionar debito
     * 
     * @param debito a que será adicionado
     * @return retorna o debito que foi adicionado.
     */
    public Debito adicionar(Debito debito) {
        return debitoRepository.adicionar(debito);
    }

    /**
     * Metodo para deletar o debito por id.
     * 
     * @param id debito a ser deletado
     */
    public void deletar(Integer id) {
        debitoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o debito na lista
     * 
     * @param debito que será atulizado
     * @return retorna o debito após atualizar a lista
     */
    public Debito atualizar(Integer id, Debito debito) {

        debito.setId(id);
        return debitoRepository.atualizar(debito);

    }
}
