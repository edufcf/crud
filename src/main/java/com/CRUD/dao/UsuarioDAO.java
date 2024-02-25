/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.dao;

import com.CRUD.modelo.Usuario;
import com.CRUD.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author GeracaoNet
 */
public class UsuarioDAO {
    
        public boolean autenticarUsuario(String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class)
                                .setParameter("login", login)
                                .setParameter("senha", senha)
                                .getSingleResult();
            return usuario != null;
        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

    
}
