package com.teste.controlefinanceiro.shared;

import java.sql.Date;

import com.teste.controlefinanceiro.model.Debito;

public class DebitoDTO {
    // #region Atributos

    private Integer id;

    private String descricao;

    private Date datadereferencia;

    private Date datadepagamento;

    private Double valordodebito;

    private Double valorpago;

    private Double valordediferenca;

    private String tipodedespesa;

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

    public void setDatadereferencia(Date dataderefencia) {
        this.datadereferencia = dataderefencia;
    }

    public Date getDatadepagamento() {
        return datadepagamento;
    }

    public void setDatadepagamento(Date datadepagamento) {
        this.datadepagamento = datadepagamento;
    }

    public Double getValordodebito() {
        return valordodebito;
    }

    public void setValordodebito(Double valododebito) {
        this.valordodebito = valododebito;
    }

    public Double getValorpago() {
        return valorpago;
    }

    public void setValorpago(Double valorpago) {
        this.valorpago = valorpago;
    }

    public Double getValordediferenca() {
        return valordediferenca;
    }

    public void setValordediferenca(Double valordediferenca) {
        this.valordediferenca = valordediferenca;
    }

    public String getTipodedespesa() {
        return tipodedespesa;
    }

    public void setTipodedespesa(String tipodedespesa) {
        this.tipodedespesa = tipodedespesa;
    }
    // #endregion

    public void add(Debito debito) {
    }
}
