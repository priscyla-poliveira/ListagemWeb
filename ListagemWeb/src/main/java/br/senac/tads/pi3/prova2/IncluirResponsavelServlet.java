/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.prova2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priscyla.poliveira
 */
@WebServlet(name = "IncluirResponsavelServlet", urlPatterns = {"/incluir"})
public class IncluirResponsavelServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ResponsavelDAO dao = new ResponsavelDAO();
        
        Responsavel resp = new Responsavel(request.getParameter("name"));

        int linhasAfetadas = dao.salvar(resp);

        if(linhasAfetadas >= 0){
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/incluir-responsaveis.jsp").forward(request, response);
        }
    }

}
