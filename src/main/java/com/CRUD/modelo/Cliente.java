/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author GeracaoNet
 */


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    private String endereco;
    private String email;
    private String planoContratado;
    
    public Cliente(){}
    
    public Cliente(int id, String nome, String endereco, String email, String planoContratado){
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.email = email;
    this.planoContratado = planoContratado;
    }
    //GETTERS
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getEmail(){
        return email;
    }
    public String getPlanoContratado(){
        return planoContratado;
    }
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlanoContratado(String planoContratado) {
        this.planoContratado = planoContratado;
    }
    
    
    
    

}








