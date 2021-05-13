/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EntradaFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.dao.UsuarioeventosFacade;
import GestorEventos2021.entity.Entrada;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author yeray
 */
@WebServlet(name = "ServletGuardarTicket", urlPatterns = {"/ServletGuardarTicket"})
public class ServletGuardarTicket extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade; 
    
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
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        String idEvento = request.getParameter("idEvento");
        Integer nEntradas = new Integer(request.getParameter("nEntradas"));
        String[] seleccionadas = request.getParameterValues("asientosSeleccionados");
        List<Entrada> listaEntradas = new ArrayList<>();
        Evento evento;
        Entrada e;
        Integer numero;
        
        evento = this.eventoFacade.find(new Integer(idEvento));
        
        if (seleccionadas == null) {        //Evento sin asientos
            Integer maxIndice = this.entradaFacade.maxNumeroDeUnEvento(evento);
            
            if (maxIndice == null) maxIndice = 1;
            
            for (int i=0; i < nEntradas; i++){
                e = new Entrada();
                e.setEvento(evento);
                e.setUsuario(u);
                e.setNumero(maxIndice);
                
                this.entradaFacade.create(e);
                evento.getEntradaList().add(e);
                u.getEntradaList().add(e);
                
                listaEntradas.add(e);
                maxIndice++;
            }
            
        } else {                            //Evento con asientos
            for (int i=0; i < seleccionadas.length; i++){
                numero = new Integer(seleccionadas[i]);
                
                e = new Entrada();
                e.setEvento(evento);
                e.setUsuario(u);
                e.setNumero(numero);
                e.setFila((numero - 1) / evento.getAsientosFila() + 1);
                e.setAsiento(numero);
                
                this.entradaFacade.create(e);
                evento.getEntradaList().add(e);
                u.getEntradaList().add(e);

                listaEntradas.add(e);
            }
            
            this.eventoFacade.edit(evento);
            this.usuarioFacade.edit(u);
        }
        
        request.setAttribute("listaEntradas", listaEntradas);
        request.setAttribute("compra", 1);
        RequestDispatcher rd = request.getRequestDispatcher("ImprimirTicket.jsp");
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
