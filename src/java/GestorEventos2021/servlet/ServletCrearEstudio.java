/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EstudioFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.entity.Estudio;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author david
 */
@WebServlet(name = "ServletCrearEstudio", urlPatterns = {"/ServletCrearEstudio"})
public class ServletCrearEstudio extends HttpServlet {

    
    @EJB
    private EstudioFacade estudioFacade;
    
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
        HttpSession session = request.getSession();
        Usuario u = (Usuario)session.getAttribute("usuario");
        Estudio e = new Estudio();
        
        String descripcion = request.getParameter("descripcion");
        String signo = request.getParameter("selectSigno");
        Integer edad  = new Integer(request.getParameter("edad")) ;
        String evento = request.getParameter("selectEvento");
        Evento ev = this.eventoFacade.findByTitulo(evento);
        
        
        Integer resultado = this.estudioFacade.resultado(signo,edad,ev);
        e.setAnalista(u);
        e.setResultado("El número de usuarios que cumple la condición son: "+resultado);
        e.setDescripcion(descripcion);
        
        this.estudioFacade.create(e);
        
        u.getEstudioList().add(e);
        this.usuarioFacade.edit(u);
        
        response.sendRedirect("ServletIniciarSesion?email="+u.getCorreo()+"&password="+u.getPassword());
                
                
        
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
