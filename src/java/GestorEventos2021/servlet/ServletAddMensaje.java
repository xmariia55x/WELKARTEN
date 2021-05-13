/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.ConversacionFacade;
import GestorEventos2021.dao.MensajeFacade;
import GestorEventos2021.entity.Conversacion;
import GestorEventos2021.entity.Mensaje;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adric
 */
@WebServlet(name = "ServletAddMensaje", urlPatterns = {"/ServletAddMensaje"})
public class ServletAddMensaje extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

    @EJB
    private ConversacionFacade conversacionFacade;

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
        HttpSession session = request.getSession();
        Usuario user = (Usuario)session.getAttribute("usuario");
        Conversacion c = this.conversacionFacade.find(new Integer(id));
        Mensaje m = new Mensaje();
        m.setConversacion(c);
        m.setCuerpo("Buenas, le atiene un teleoperador de Welkarten");
        m.setEmisor(user);
        m.setFecha(new Date());
        m.setHora(new Date());
        this.mensajeFacade.create(m);
        
        c.getMensajeList().add(m);
        this.conversacionFacade.edit(c);
        
        response.sendRedirect("ServletListarConversaciones");
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
