/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.dao;
import com.CRUD.modelo.Cliente;
//import com.CRUD.util.Conexao;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GeracaoNet
 */
public class ClienteDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco");
    
     public void adicionarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void atualizarCliente(Cliente cliente) {
        // Código para atualizar um cliente
     EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(cliente); // Atualiza o cliente se ele já existe
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
    }
    }

    public void deletarCliente(int id) {
        // Código para deletar um cliente pelo ID
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id); // Encontra o cliente pelo ID
        if (cliente != null) {
            em.remove(cliente); // Deleta o cliente se ele existe
        }
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
    }
    }

    public Cliente buscarCliente(int id) {
        // Código para buscar um cliente pelo ID
        EntityManager em = emf.createEntityManager();
    Cliente cliente = null;
    try {
        cliente = em.find(Cliente.class, id); // Busca o cliente pelo ID
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        em.close();
    }
    return cliente;

    }
    
}
