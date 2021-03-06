/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EtiquetaFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.entity.Etiqueta;
import GestorEventos2021.entity.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(name = "ServletCargarEventoEditarAdministrador", urlPatterns = {"/ServletCargarEventoEditarAdministrador"})
public class ServletCargarEventoEditarAdministrador extends HttpServlet {

    @EJB
    private EtiquetaFacade etiquetaFacade;

    @EJB
    private EventoFacade eventoFacade;

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
       
        String error = request.getParameter("error");
        String idEvento = request.getParameter("id");
        if(error != null && !error.isEmpty()) request.setAttribute("error", error);
        if(idEvento != null && !idEvento.isEmpty()){
            Evento evento = this.eventoFacade.find(new Integer(idEvento));
            request.setAttribute("evento", evento);
        }
        List<Etiqueta> etiquetas = this.etiquetaFacade.findAll();
        request.setAttribute("listaEtiquetas", etiquetas);
        
        RequestDispatcher rd = request.getRequestDispatcher("CrearEditarEvento.jsp");
        rd.forward(request, response);
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
