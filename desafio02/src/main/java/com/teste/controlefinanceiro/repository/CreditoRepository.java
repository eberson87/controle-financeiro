package com.teste.controlefinanceiro.repository;

import com.teste.controlefinanceiro.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoRepository extends JpaRepository<Credito, Integer> {

}
