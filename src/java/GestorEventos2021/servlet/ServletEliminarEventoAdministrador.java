/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EtiquetaseventoFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.entity.Etiquetasevento;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maria
 */
@WebServlet(name = "ServletEliminarEventoAdministrador", urlPatterns = {"/ServletEliminarEventoAdministrador"})
public class ServletEliminarEventoAdministrador extends HttpServlet {

    @EJB
    private EtiquetaseventoFacade etiquetaseventoFacade;

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
        String id = request.getParameter("id");
        String strTo = "ServletListarEventosUsuariosAdministrador";
        HttpSession session = request.getSession();
        Usuario creador = (Usuario)session.getAttribute("usuario");

        if(creador.getRol() == 2){
            strTo = "ServletCargarCreadorEventos";
        }
        
        if(id != null && !id.isEmpty()){
            Evento evento = this.eventoFacade.find(new Integer(id));
            if(evento.getEtiquetaseventoList() != null){
                //hay que eliminar las asociaciones entre el evento y las etiquetas
                List<Etiquetasevento> etiquetas = this.etiquetaseventoFacade.findByEventoId(new Integer(id));
                for(Etiquetasevento tag : etiquetas){
                    this.etiquetaseventoFacade.remove(tag);
                }
                
            }
            this.eventoFacade.remove(evento);
        }
        response.sendRedirect(strTo);
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
