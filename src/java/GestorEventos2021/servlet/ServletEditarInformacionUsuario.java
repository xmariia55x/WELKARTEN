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
@WebServlet(name = "ServletEditarInformacionUsuario", urlPatterns = {"/ServletEditarInformacionUsuario"})
public class ServletEditarInformacionUsuario extends HttpServlet {

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
            throws ServletException, IOException {
        String nombre, apellidos, nif, sexo, domicilio, ciudad, correo, contrasena,
                contrasenaConfirmada, strTo, strError, idUsuario;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nacimiento = null;

        HttpSession session = request.getSession();
        
        nombre = request.getParameter("nombre_usuario");
        nif = request.getParameter("nif_usuario");
        correo = request.getParameter("correo_usuario");
        contrasena = request.getParameter("contrasena1_usuario");
        contrasenaConfirmada = request.getParameter("contrasena2_usuario");
        idUsuario = request.getParameter("idUsuario");
        
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        usuario.setNombre(nombre);
        usuario.setNif(nif);
        usuario.setCorreo(correo);
        if (contrasena.equals(contrasenaConfirmada)) {
            usuario.setPassword(contrasena);

            //ACTUALIZAR AL USUARIO EN LA BD
            this.usuarioFacade.edit(usuario);
            if (usuario.getUsuarioeventos() != null) {
                //estamos editando a un usuario de eventos
                //todos los campos estan rellenos por el REQUIRED
                apellidos = request.getParameter("apellidos_usuario");
                sexo = request.getParameter("radio_sexo");
                domicilio = request.getParameter("domicilio_usuario");
                ciudad = request.getParameter("ciudad_usuario");
                try {
                    fecha_nacimiento = formatoFecha.parse(request.getParameter("fecha_nacimiento_usuario"));
                    Usuarioeventos usuarioEventos = usuario.getUsuarioeventos();

                    usuarioEventos.setApellidos(apellidos);
                    usuarioEventos.setSexo(sexo);
                    usuarioEventos.setDomicilio(domicilio);
                    usuarioEventos.setCiudad(ciudad);
                    usuarioEventos.setFechaNacimiento(fecha_nacimiento);

                    //ACTUALIZAR USUARIO DE EVENTOS
                    this.usuarioeventosFacade.edit(usuarioEventos);
                } catch (ParseException e) {

                }
            }
            session.setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("VerPerfil.jsp");
            rd.forward(request, response);
        } else {
            //strTo = "EditarPerfil.jsp";
            strError = "contraseniaNoCoincide";
            request.setAttribute("error", strError);
            request.setAttribute("idUsuario", idUsuario);
            response.sendRedirect("ServletCargarPerfil");
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
