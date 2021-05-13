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
 * @author maria
 */
@WebServlet(name = "ServletCrearUsuarioAdministrador", urlPatterns = {"/ServletCrearUsuarioAdministrador"})
public class ServletCrearUsuarioAdministrador extends HttpServlet {

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
        String nombre, nif, correo, contrasena, contrasenaRepetida, rol,error, id, apellidos, domicilio, ciudad, sexo, fecha;
        Date fechaNacimiento;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        Usuario usuarioNuevo;
        
        id = request.getParameter("id");
        
        if(id == null || id.isEmpty()){
            //Crear usuario
            usuarioNuevo = new Usuario();
        } else {
            //editar usuario
            usuarioNuevo = this.usuarioFacade.find(new Integer(id));
        }
        nombre = request.getParameter("nombre_usuario");
        nif = request.getParameter("nif_usuario");
        rol = request.getParameter("rol");
        correo = request.getParameter("correo_usuario");
        contrasena = request.getParameter("contrasena1_usuario");
        contrasenaRepetida = request.getParameter("contrasena2_usuario");
        apellidos = request.getParameter("apellidos_usuario");
        domicilio = request.getParameter("domicilio_usuario");
        ciudad = request.getParameter("ciudad_usuario");
        sexo = request.getParameter("radio_sexo");
        fecha = request.getParameter("fecha_nacimiento_usuario");
        
        if(!contrasena.equals(contrasenaRepetida)){
            error = "contrasenaIncorrecta";
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("CrearUsuarioAdministrador.jsp");
            rd.forward(request, response);
        } else {
            //No se comprueban si los params son nulos o vacios porque son required
            //en el jsp por lo que no se envia el form hasta que todos estan rellenos
            
            usuarioNuevo.setCorreo(correo);
            usuarioNuevo.setNif(nif);
            usuarioNuevo.setNombre(nombre);
            usuarioNuevo.setPassword(contrasena);
            if(rol != null){
                usuarioNuevo.setRol(new Integer(rol)); //no es un usuario de eventos
            }else {
                usuarioNuevo.setRol(4);
            }
            
            
            if(id != null && usuarioNuevo.getUsuarioeventos() != null){
                
                try {
                    //Estamos editando a un usuario de eventos
                    Usuarioeventos usuarioEventos = usuarioNuevo.getUsuarioeventos();
                    usuarioEventos.setApellidos(apellidos);
                    usuarioEventos.setCiudad(ciudad);
                    usuarioEventos.setDomicilio(domicilio);
                    fechaNacimiento = formatoFecha.parse(fecha);
                    usuarioEventos.setFechaNacimiento(fechaNacimiento);
                    
                    this.usuarioeventosFacade.edit(usuarioEventos);
                    
                } catch (ParseException ex) {
                    
                }   
            }
            
            if (id == null || id.isEmpty()) { // Crear nuevo usuario        
                this.usuarioFacade.create(usuarioNuevo);
            } else { // Editar usuario existente
                this.usuarioFacade.edit(usuarioNuevo);
            }

            response.sendRedirect("ServletListarEventosUsuariosAdministrador");
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
