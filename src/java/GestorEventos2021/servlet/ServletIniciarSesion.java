/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author adric
 */
@WebServlet(name = "ServletIniciarSesion", urlPatterns = {"/ServletIniciarSesion"})


public class ServletIniciarSesion extends HttpServlet {

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
            String strUsuario = request.getParameter("email");
            String strClave = request.getParameter("password");
            Usuario usuario;
            String strError;
            String strTo = "";
            HttpSession session = request.getSession();
            
            if(strUsuario == null || strClave == null || strUsuario.isEmpty() || strClave.isEmpty()) {
                strTo = "InicioSesion.jsp";
                strError = "v";
                request.setAttribute("error", strError);
            } else {
                usuario = this.usuarioFacade.findByEmailAndPassword(strUsuario, strClave);
                
                if(usuario == null) {
                    strError = "n";
                    request.setAttribute("error", strError);
                    strTo = "InicioSesion.jsp";
                } else {
                    if(usuario.getRol() == 1) {
                        strTo = "ServletListarEventosUsuariosAdministrador";
                    } else if(usuario.getRol() == 2) {
                        strTo = "CreadorEventos.jsp";
                    } else if(usuario.getRol() == 3) {
                        strTo = "ServletListarEstudios";
                    } else if(usuario.getRol() == 4) {
                        //Aquí debe ir el usuario de eventos
                        strTo = "ServletInicio";
                    } else{ 
                        strTo = "ServletListarConversaciones";
                    }
                    session.setAttribute("usuario",usuario);
                }
            }
            
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
