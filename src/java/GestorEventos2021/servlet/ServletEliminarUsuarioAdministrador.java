/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.dao.UsuarioeventosFacade;
import GestorEventos2021.entity.Usuario;
import GestorEventos2021.entity.Usuarioeventos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(name = "ServletEliminarUsuarioAdministrador", urlPatterns = {"/ServletEliminarUsuarioAdministrador"})
public class ServletEliminarUsuarioAdministrador extends HttpServlet {

    @EJB
    private UsuarioeventosFacade usuarioeventosFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null && !id.isEmpty()){
            Usuario user = this.usuarioFacade.find(new Integer(id));
            if(user.getUsuarioeventos() != null){
                //estamos eliminando a un usuario de eventos
                Usuarioeventos uEventos = this.usuarioeventosFacade.find(new Integer(id));
                this.usuarioeventosFacade.remove(uEventos);
            }
            this.usuarioFacade.remove(user);
        }
        
        response.sendRedirect("ServletListarEventosUsuariosAdministrador");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
