/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
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
 * @author Javi
 */
@WebServlet(name = "ServletBusquedaAvanzadaEventos", urlPatterns = {"/ServletBusquedaAvanzadaEventos"})
public class ServletBusquedaAvanzadaEventos extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

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

        String nombre = request.getParameter("nombre");
        String strprecio = request.getParameter("precio");
        String straforo = request.getParameter("aforo");
        String strcreador = request.getParameter("creador");

        Integer precio;
        Integer aforo;
        Usuario creador;

        if (strprecio == null || strprecio.equals("")) {
            precio = null;
        }else{
            precio = new Integer(strprecio);
        }

         if (straforo == null || straforo.equals("")) {
            aforo = null;
        }else{
            aforo = new Integer(straforo);
        }
         
          if (strcreador == null || strcreador.equals("")) {
            creador = null;
        }else{
            creador = this.usuarioFacade.find(new Integer(strcreador));
        }
        
        
        List<Evento> eventosFiltrados = this.eventoFacade.filtrarByNombrePrecioAforoCreador(nombre, precio, aforo, creador);
        
        request.setAttribute("eventosFiltrados", eventosFiltrados);
        
        response.sendRedirect("ServletCargarCreadorEventos");
        
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
