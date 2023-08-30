package com.teste.controlefinanceiro.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credito {

    // #region Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private Date datadereferencia;

    private Date dataderecebimento;

    private Double valordocredito;

    private Double valorrecebido;

    private Double valordediferenca;

    private String tipoderecebimento;
    // #endregion

    // #region Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatadereferencia() {
        return datadereferencia;
    }

    public void setDatadereferencia(Date datadereferencia) {
        this.datadereferencia = datadereferencia;
    }

    public Date getDataderecebimento() {
        return dataderecebimento;
    }

    public void setDataderecebimento(Date dataderecebimento) {
        this.dataderecebimento = dataderecebimento;
    }

    public Double getValordocredito() {
        return valordocredito;
    }

    public void setValordocredito(Double valordocredito) {
        this.valordocredito = valordocredito;
    }

    public Double getValorrecebido() {
        return valorrecebido;
    }

    public void setValorrecebido(Double valorrecebido) {
        this.valorrecebido = valorrecebido;
    }

    public Double getValordediferenca() {
        return valordediferenca;
    }

    public void setValordediferenca(Double valordediferenca) {
        this.valordediferenca = valordediferenca;
    }

    public String getTipoderecebimento() {
        return tipoderecebimento;
    }

    public void setTipoderecebimento(String tipoderecebimento) {
        this.tipoderecebimento = tipoderecebimento;
    }

    public void add(Credito credito) {
    }

    // #endregion
}
