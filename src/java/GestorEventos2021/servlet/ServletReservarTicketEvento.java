/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EntradaFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.entity.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeray
 */
@WebServlet(name = "ServletReservarTicketEvento", urlPatterns = {"/ServletReservarTicketEvento"})
public class ServletReservarTicketEvento extends HttpServlet {

    @EJB
    private EntradaFacade entradaFacade;

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
        String eventoId = request.getParameter("idEvento");
        String nEntradas = request.getParameter("nEntradas");
        Evento evento;
        String strTo = "";
        
        evento = this.eventoFacade.find(new Integer(eventoId));
        
        if (evento.getFilas() == null){         //No se seleccionan asientos
            strTo = "ComprarTicketEventoSinAsientos.jsp";
        } else {                                //Selecciona asientos
            strTo = "ComprarTicketEvento.jsp";
        }
        
        request.setAttribute("listaEntradas", this.entradaFacade.findByEntradasCompradaDeUnEvento(evento));
        request.setAttribute("evento", evento);
        request.setAttribute("nEntradas", nEntradas);
        RequestDispatcher rd = request.getRequestDispatcher(strTo);
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
