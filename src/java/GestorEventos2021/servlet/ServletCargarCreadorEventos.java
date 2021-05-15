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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javi
 */
@WebServlet(name = "ServletCargarCreadorEventos", urlPatterns = {"/ServletCargarCreadorEventos"})
public class ServletCargarCreadorEventos extends HttpServlet {

    @EJB
    private EventoFacade eventoFacade;

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
      
        
        HttpSession session = request.getSession();  
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        
        List<Evento> eventosFiltrados = (List)request.getAttribute("eventosFiltrados");
        List<Evento> eventosProximos = this.eventoFacade.filtrarByFechaDeEstaSemana();
        List<Evento> misEventos = this.eventoFacade.filtrarByNombrePrecioAforoCreador(null, null, null, usuario);
        
        if(eventosFiltrados != null && !eventosFiltrados.isEmpty()){
            request.setAttribute("eventosFiltrados", eventosFiltrados);
        }
        
        if(eventosProximos != null && !eventosProximos.isEmpty()){
            request.setAttribute("eventosProximos", eventosProximos);
        }
        
        if(misEventos != null && !misEventos.isEmpty()){
            request.setAttribute("misEventos", misEventos);
        }
  
        String error = request.getParameter("error");
        if(error != null && !error.isEmpty()) request.setAttribute("error", error);
        
        List<Usuario> creadores = this.usuarioFacade.findByRol(2);
        
        
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("creadores", creadores);
        
               
        RequestDispatcher rd = request.getRequestDispatcher("CreadorEventos.jsp");
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
