/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.prova2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * CLASSE EXECUTADA QUANDO A APLICAÇÃO WEB INICIALIZA NO SERVIDOR
 * IRÁ CRIAR A TABELA NO BANCO DE DADOS
 * NÃO PRECISA SER ALTERADA
 * @author ftsuda-senac
 */
@WebListener
public class DatabaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	ResponsavelDAO dao = new ResponsavelDAO();
	dao.criarTabela();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
