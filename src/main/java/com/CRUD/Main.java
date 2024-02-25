package com.CRUD;


import com.CRUD.dao.ClienteDAO;
import com.CRUD.gui.LoginView;
import com.CRUD.modelo.Cliente;
import com.CRUD.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GeracaoNet
 */
public class Main {
    public static void main(String[] args) {
                 SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                loginView.setVisible(true); // Ou outro método que você usa para mostrar a view
            }
         });
        
    }

}
    
    

