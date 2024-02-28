/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.dao;

import com.CRUD.modelo.Cliente;
import com.CRUD.modelo.Servico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeracaoNet
 */
public class ServicoDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco");
    
    public void adicionarServico(Servico servico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(servico);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void editarServico(Servico servico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(servico);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void excluirServico(int servicoId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Servico servico = em.find(Servico.class, servicoId);
            if (servico != null) {
                em.remove(servico);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Servico carregarServico(int servicoId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Servico.class, servicoId);
        } finally {
            em.close();
        }
    }

    public List<Servico> listarServicos() {
        EntityManager em = emf.createEntityManager();
        try {           
            return em.createQuery("SELECT s FROM Servico s", Servico.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void carregarServicoNoModelo(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpa o modelo

        List<Servico> servicos = listarServicos(); // Usa o método existente para buscar os clientes

        // Preenche o modelo com os dados dos clientes
        for (Servico servico : servicos) {
            modelo.addRow(new Object[]{
                servico.getId(),
                servico.getNome(),
                "R$" + String.format("%.2f", servico.getPreco()),
                servico.getTipo(),
                servico.getVelocidadeDownload(),
                servico.getVelocidadeUpload(),
                servico.getLimiteDados()
            });
        }
    }
    
        public List<Servico> pesquisarPorNomeOuTipo(String texto) {
        EntityManager em = emf.createEntityManager();
        List<Servico> resultados = null;
        try {
            // Consulta que busca por correspondência no nome ou tipo do serviço
            String jpql = "SELECT s FROM Servico s WHERE LOWER(s.nome) LIKE LOWER(:texto) OR LOWER(s.tipo) LIKE LOWER(:texto)";
            Query query = em.createQuery(jpql, Servico.class);
            query.setParameter("texto", "%" + texto + "%");
            resultados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }
    
    
    
}
