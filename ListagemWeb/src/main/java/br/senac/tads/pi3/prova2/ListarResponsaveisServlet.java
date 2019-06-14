/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.prova2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priscyla.poliveira
 */
@WebServlet(name = "ListarResponsaveisServlet", urlPatterns = {"/listar"})
public class ListarResponsaveisServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Responsavel> responsaveis;
        ResponsavelDAO dao = new ResponsavelDAO();
        
        responsaveis = dao.listar();
        
        request.setAttribute("listaResponsaveis", responsaveis);
        request.getRequestDispatcher("/listar-responsaveis.jsp").forward(request, response);
    }

}
