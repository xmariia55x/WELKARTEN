/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.EstudioFacade;
import GestorEventos2021.dao.UsuarioFacade;
import GestorEventos2021.entity.Estudio;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author david
 */
@WebServlet(name = "ServletGuardarEstudio", urlPatterns = {"/ServletGuardarEstudio"})
public class ServletGuardarEstudio extends HttpServlet {

    @EJB
    private EstudioFacade estudioFacade;
    
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
        Estudio e = (Estudio)session.getAttribute("estudio");
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        if(e !=null){ //Modificar estudio
            String analista = request.getParameter("nombre_analista");
            String descripcion = request.getParameter("descripcion_estudio");
            String resultado = request.getParameter("resultado_estudio");
            
            if(!analista.equals(e.getAnalista().getCorreo())){
                e.setAnalista(this.usuarioFacade.findByEmail(analista));
                this.estudioFacade.edit(e);
            }
            if(!descripcion.equals(e.getDescripcion())){
                e.setDescripcion(descripcion);
                this.estudioFacade.edit(e);
            }
            if(!resultado.equals(e.getResultado())){
                e.setResultado(resultado);
                this.estudioFacade.edit(e);
                      
            }
           
            
        }else{ //Crear estudio
            
        }
        
         response.sendRedirect("ServletIniciarSesion?email="+usuario.getCorreo()+"&password="+usuario.getPassword());
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
