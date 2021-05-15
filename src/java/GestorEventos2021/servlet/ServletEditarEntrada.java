/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EntradaFacade;
import GestorEventos2021.entity.Entrada;
import GestorEventos2021.entity.Evento;
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
 * @author yeray
 */
@WebServlet(name = "ServletEditarEntrada", urlPatterns = {"/ServletEditarEntrada"})
public class ServletEditarEntrada extends HttpServlet {

    @EJB
    private EntradaFacade entradaFacade;
    
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
        String[] entradasId = request.getParameterValues("entradas");
        String[] seleccionadas = request.getParameterValues("asientosSeleccionados");
        Entrada e;
        Integer numero;
        
        for (int i=0; i < entradasId.length; i++){
            e = this.entradaFacade.find(new Integer(entradasId[i]));
            
            numero = new Integer(seleccionadas[i]);
            e.setNumero(numero);
            e.setFila((numero - 1) / e.getEvento().getAsientosFila() + 1);
            e.setAsiento(numero);
            
            this.entradaFacade.edit(e);
        }
        
        response.sendRedirect("ServletMisEventos");
        
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
