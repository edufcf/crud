/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.dao;
import com.CRUD.modelo.Cliente;
import java.util.List;
//import com.CRUD.util.Conexao;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

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
    
    public List<Cliente> getTodosClientes() {
    EntityManager em = emf.createEntityManager();
    try {
        // Cria uma consulta para buscar todos os clientes
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    } finally {
        em.close(); // Sempre feche o EntityManager após o uso
    }
    
    
}
    //Carrega os clientes
        public void carregarClientesNoModelo(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpa o modelo

        List<Cliente> clientes = getTodosClientes(); // Usa o método existente para buscar os clientes

        // Preenche o modelo com os dados dos clientes
        for (Cliente cliente : clientes) {
            modelo.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getEmail(),
                cliente.getPlanoContratado()
            });
        }
    }
        
    public List<Cliente> pesquisarPorNome(String texto) {
    List<Cliente> resultados;
    EntityManager em = emf.createEntityManager();
    try {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:texto) OR LOWER(c.endereco) LIKE LOWER(:texto)", Cliente.class);
        query.setParameter("texto", "%" + texto + "%");
        resultados = query.getResultList();
    } finally {
        em.close();
    }
    return resultados;
}
    
}
