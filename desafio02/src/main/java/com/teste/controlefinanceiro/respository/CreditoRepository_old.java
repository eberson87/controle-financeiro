package com.teste.controlefinanceiro.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.controlefinanceiro.model.Credito;
import com.teste.controlefinanceiro.model.exception.ResourceNotFoundException;

@Repository
public class CreditoRepository_old {

    private List<Credito> creditos = new ArrayList<Credito>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retorna uma lista de Receitas
     * 
     * @return Lista de Receitas
     */
    public List<Credito> obterTodos() {
        return creditos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * 
     * @param id do crédito que será localizado.
     * @return Retorna uma receita caso tenha sido localizado.
     */
    public Optional<Credito> obterPorid(Integer id) {
        return creditos
                .stream()
                .filter(credito -> credito.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar credito
     * 
     * @param credito a que será adicionado
     * @return retorna o produto que foi adicionado.
     */
    public Credito adicionar(Credito credito) {

        ultimoId++;
        credito.setId(ultimoId);
        creditos.add(credito);
        return credito;
    }

    /**
     * Metodo para deletar o credito por id.
     * 
     * @param id credito a ser deletado
     */
    public void deletar(Integer id) {
        creditos.removeIf(credito -> credito.getId() == id);
    }

    /**
     * Metodo para atualizar o crédito na lista
     * 
     * @param credito que será aatulizado
     * @return retorna o crédito após atualizar a lista
     */
    public Credito atualizar(Credito credito) {
        Optional<Credito> creditoEncontrado = obterPorid(credito.getId());

        if (creditoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Receita não encontrado");
        }

        deletar(credito.getId());
        creditos.add(credito);
        return credito;

    }

}
