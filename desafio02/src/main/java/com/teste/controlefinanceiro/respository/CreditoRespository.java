package com.teste.controlefinanceiro.respository;

import com.teste.controlefinanceiro.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoRespository extends JpaRepository<Credito, Integer> {

}
