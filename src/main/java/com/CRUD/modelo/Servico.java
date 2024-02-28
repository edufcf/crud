/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author GeracaoNet
 */
@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "preco")
    private double preco;

    @Column(name = "velocidade_download", length = 50)
    private String velocidadeDownload;

    @Column(name = "velocidade_upload", length = 50)
    private String velocidadeUpload;

    @Column(name = "limite_dados", length = 50)
    private String limiteDados;

    @Column(name = "duracao_contrato", length = 255)
    private String duracaoContrato;

    @Column(name = "ativo")
    private boolean ativo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getVelocidadeDownload() {
        return velocidadeDownload;
    }

    public void setVelocidadeDownload(String velocidadeDownload) {
        this.velocidadeDownload = velocidadeDownload;
    }

    public String getVelocidadeUpload() {
        return velocidadeUpload;
    }

    public void setVelocidadeUpload(String velocidadeUpload) {
        this.velocidadeUpload = velocidadeUpload;
    }

    public String getLimiteDados() {
        return limiteDados;
    }

    public void setLimiteDados(String limiteDados) {
        this.limiteDados = limiteDados;
    }

    public String getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(String duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {    
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                ", velocidadeDownload='" + velocidadeDownload + '\'' +
                ", velocidadeUpload='" + velocidadeUpload + '\'' +
                ", limiteDados='" + limiteDados + '\'' +
                ", duracaoContrato='" + duracaoContrato + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
