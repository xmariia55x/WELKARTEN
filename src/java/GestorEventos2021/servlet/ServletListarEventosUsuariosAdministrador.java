/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EtiquetaFacade;
import GestorEventos2021.dao.EtiquetaseventoFacade;
import GestorEventos2021.dao.EventoFacade;
import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.entity.Etiqueta;
import GestorEventos2021.entity.Etiquetasevento;
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
 * @author maria
 */
@WebServlet(name = "ServletListarEventosUsuariosAdministrador", urlPatterns = {"/ServletListarEventosUsuariosAdministrador"})
public class ServletListarEventosUsuariosAdministrador extends HttpServlet {

    @EJB
    private EtiquetaseventoFacade etiquetaseventoFacade;

    @EJB
    private EtiquetaFacade etiquetaFacade;

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
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        List<Usuario> usuarios;
        List<Evento> eventos;
        String nombreUsuario = null;
        String nombreEvento = null;
        String[] roles = null;
        String[] categorias = null;
        if(request.getParameter("buscarUsuarios") != null && request.getParameter("buscarUsuarios").equals("S")){
            nombreUsuario = request.getParameter("nombreUsuario");
        } 
        if(request.getParameter("filtrarUsuarios") != null && request.getParameter("filtrarUsuarios").equals("S")){
            roles = request.getParameterValues("rolUsuario");
        }
        if(request.getParameter("buscarEvento") != null && request.getParameter("buscarEvento").equals("S")){
            nombreEvento = request.getParameter("nombreEvento");
        }
        if(request.getParameter("filtrarEvento") != null && request.getParameter("filtrarEvento").equals("S")){
            categorias = request.getParameterValues("etiquetaEvento");
        }

        if (usuario != null) {
            if (roles != null && roles.length != 0) { //Hay filtro por roles
                Integer[] rolesFiltro = new Integer[roles.length];
                for (int i = 0; i < roles.length; i++) {
                    rolesFiltro[i] = Integer.parseInt(roles[i]);
                }

                usuarios = this.usuarioFacade.findByRol(rolesFiltro);
               
            } else if(nombreUsuario != null && !nombreUsuario.isEmpty()){
                //Filtrar por el nombre del usuario
                usuarios = this.usuarioFacade.findByNombreSimilar(nombreUsuario);
            } else {
                usuarios = this.usuarioFacade.findAll();
            }
            
            if (categorias != null && categorias.length > 0){
                //Hay filtro por categorias
                Integer[] categoriasFiltro = new Integer[categorias.length];
                for (int i = 0; i < categorias.length; i++) {
                    categoriasFiltro[i] = Integer.parseInt(categorias[i]);
                }
                
                eventos = this.eventoFacade.findByEtiquetas(categoriasFiltro);
            } else if(nombreEvento != null && !nombreEvento.isEmpty()){
                //buscar por el nombre del evento
                eventos = this.eventoFacade.findByNombreSimilar(nombreEvento);
            } else {
                eventos = this.eventoFacade.findAll();
            }
            List<Etiqueta> etiquetas = this.etiquetaFacade.findAll();
            
            request.setAttribute("listaUsuarios", usuarios);
            request.setAttribute("listaEventos", eventos);
            request.setAttribute("listaEtiquetas",etiquetas);
        }

        RequestDispatcher rd = request.getRequestDispatcher("Administrador.jsp");
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
