/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EtiquetaFacade;
import GestorEventos2021.dao.EtiquetaseventoFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.entity.Etiqueta;
import GestorEventos2021.entity.Etiquetasevento;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
@WebServlet(name = "ServletCrearEditarEvento", urlPatterns = {"/ServletCrearEditarEvento"})
public class ServletCrearEditarEvento extends HttpServlet {

    @EJB
    private EventoFacade eventoFacade;

    @EJB
    private EtiquetaseventoFacade etiquetaseventoFacade;

    @EJB
    private EtiquetaFacade etiquetaFacade;

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
        Usuario creador = (Usuario)session.getAttribute("usuario");
        
        String nombre, descripcion, costeEntrada, numMaxEntradas, aforo, lugar, asientos,
                filasDeAsientos = null, asientosPorFila = null, error;
        String[] etiquetas;
        List<Etiqueta> etiquetasSeleccionadas = new ArrayList<>();
        Evento nuevoEvento = new Evento();
        Date fechaEvento, fechaLimiteCompraEntradas, hora;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        try {
            nombre = request.getParameter("nombre_evento");
            descripcion = request.getParameter("descripcion_evento");
            fechaEvento = formatoFecha.parse(request.getParameter("fecha_evento"));
            hora = formatoHora.parse(request.getParameter("hora_evento"));
            fechaLimiteCompraEntradas = formatoFecha.parse(request.getParameter("fecha_limite_entradas"));
            lugar = request.getParameter("lugar_evento");
            costeEntrada = request.getParameter("coste_entrada_evento");
            numMaxEntradas = request.getParameter("maximo_entradas");
            aforo = request.getParameter("aforo_evento");
            etiquetas = request.getParameterValues("etiquetas_evento");
            if (etiquetas.length < 1 || etiquetas.length > 2) {
                //error = "etiquetasIncorrectas";
                //request.setAttribute("error", error);
                response.sendRedirect("ServletCargarEtiquetasEventos?error=etiquetasIncorrectas");
            } else if(fechaLimiteCompraEntradas.compareTo(fechaEvento) > 0 ){
                //Si la fecha limite es posterior a la fecha del evento: ERROOOR!!!
                response.sendRedirect("ServletCargarEtiquetasEventos?error=fechasIncorrectas");
            } else {
                
                asientos = request.getParameter("seleccion_asientos");
                if (asientos.equals("S")) {
                    filasDeAsientos = request.getParameter("filas_evento");
                    asientosPorFila = request.getParameter("asientos_fila_evento");
                }
                
                nuevoEvento.setFechaInicio(fechaEvento);
                nuevoEvento.setFechaReserva(fechaLimiteCompraEntradas);
                nuevoEvento.setFilas(new Integer(filasDeAsientos));
                nuevoEvento.setHora(hora);
                nuevoEvento.setLugar(lugar);
                nuevoEvento.setTitulo(nombre);
                nuevoEvento.setAforo(new Integer(aforo));
                nuevoEvento.setAsientosFila(new Integer(asientosPorFila));
                nuevoEvento.setCosteEntrada(new Double(costeEntrada));
                nuevoEvento.setCreador(creador); 
                nuevoEvento.setDescripcion(descripcion);
                nuevoEvento.setEntradaList(new ArrayList<>());
                nuevoEvento.setEntradasMax(new Integer(numMaxEntradas));
                
                this.eventoFacade.create(nuevoEvento);
                
                for (String tag : etiquetas) {
                    etiquetasSeleccionadas.add(this.etiquetaFacade.find(new Integer(tag)));
                }
                List<Etiquetasevento> etiquetasEventoList = new ArrayList<>();
                for(Etiqueta etiqueta : etiquetasSeleccionadas){
                    Etiquetasevento etiquetaEvento = new Etiquetasevento();
                    etiquetaEvento.setEtiqueta(etiqueta);
                    etiquetaEvento.setEvento(nuevoEvento);
                    this.etiquetaseventoFacade.create(etiquetaEvento);
                    etiquetasEventoList.add(etiquetaEvento);
                }

                nuevoEvento.setEtiquetaseventoList(etiquetasEventoList);
                this.eventoFacade.edit(nuevoEvento);
                
                //Ya tenemos el evento creado y ahora hay que volver a la pantalla principal del admin
                if(creador.getRol() == 1){
                    response.sendRedirect("ServletListarEventosUsuariosAdministrador");
                } else if(creador.getRol() == 2){
                    //INSERTAR EL SERVLET DEL CREADOR DE EVENTOS
                }
            }

        } catch (ParseException ex) {
            
        }

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
