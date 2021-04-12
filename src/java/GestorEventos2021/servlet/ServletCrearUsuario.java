/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.dao.UsuarioeventosFacade;
import GestorEventos2021.entity.Usuario;
import GestorEventos2021.entity.Usuarioeventos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletCrearUsuario", urlPatterns = {"/ServletCrearUsuario"})
public class ServletCrearUsuario extends HttpServlet {

    @EJB
    private UsuarioeventosFacade usuarioeventosFacade;

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
            throws ServletException, IOException, ParseException {
        
        String nombre, apellidos, nif, sexo, domicilio, ciudad, correo, contrasena;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha_nacimiento;
        
        nombre = request.getParameter("nombre_usuario");
        apellidos = request.getParameter("apellidos_usuario");
        nif = request.getParameter("nif_usuario");
        sexo = request.getParameter("radio_sexo");
        domicilio = request.getParameter("domicilio_usuario");
        ciudad = request.getParameter("ciudad_usuario");
        correo = request.getParameter("correo_usuario");
        contrasena = request.getParameter("contrasena1_usuario");
        fecha_nacimiento = formatoFecha.parse(request.getParameter("fecha_nacimiento_usuario"));
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setNif(nif);
        usuario.setPassword(contrasena);
        usuario.setRol(4);
        
        this.usuarioFacade.create(usuario);
        
        Usuarioeventos uEventos = new Usuarioeventos();
        uEventos.setId(usuario.getId());
        uEventos.setApellidos(apellidos);
        uEventos.setDomicilio(domicilio);
        uEventos.setCiudad(ciudad);
        uEventos.setFechaNacimiento(fecha_nacimiento);
        uEventos.setSexo(sexo);
        
        this.usuarioeventosFacade.create(uEventos);
        
        System.out.println(usuario.getId());
        request.setAttribute("registrado", 1);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
