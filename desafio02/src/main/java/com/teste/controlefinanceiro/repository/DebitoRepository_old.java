package com.teste.controlefinanceiro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.controlefinanceiro.model.Debito;
import com.teste.controlefinanceiro.model.exception.ResourceNotFoundException;

@Repository
public class DebitoRepository_old {
    private List<Debito> debitos = new ArrayList<Debito>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retorna uma lista de Despesas
     * 
     * @return Lista de Receitas
     */
    public List<Debito> obterTodos() {
        return debitos;
    }

    /**
     * Metodo que retorna o debito encontrado pelo seu Id.
     * 
     * @param id do debito que será localizado.
     * @return Retorna uma despesas caso tenha sido localizado.
     */
    public Optional<Debito> obterPorid(Integer id) {
        return debitos
                .stream()
                .filter(debito -> debito.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar debito
     * 
     * @param debito a que será adicionado
     * @return retorna o debito que foi adicionado.
     */
    public Debito adicionar(Debito debito) {

        ultimoId++;
        debito.setId(ultimoId);
        debitos.add(debito);
        return debito;
    }

    /**
     * Metodo para deletar o debito por id.
     * 
     * @param id debito a ser deletado
     */
    public void deletar(Integer id) {
        debitos.removeIf(debito -> debito.getId() == id);

    }

    /**
     * Metodo para atualizar o debito na lista
     * 
     * @param debito que será atulizado
     * @return retorna o debito após atualizar a lista
     */
    public Debito atualizar(Debito debito) {
        Optional<Debito> debitoEncontrado = obterPorid(debito.getId());

        if (debitoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Despesa não encontrado");
        }

        deletar(debito.getId());
        debitos.add(debito);
        return debito;

    }

    public Debito save(Debito debito) {
        return null;
    }

    public Optional<Debito> findById(Integer id) {
        return null;
    }
}
