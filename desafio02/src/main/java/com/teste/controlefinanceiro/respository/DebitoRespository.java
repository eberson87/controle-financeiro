package com.teste.controlefinanceiro.respository;

import com.teste.controlefinanceiro.model.Debito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitoRespository extends JpaRepository<Debito, Integer> {

}
