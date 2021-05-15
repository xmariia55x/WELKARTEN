/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.servlet;

import GestorEventos2021.dao.ConversacionFacade;
import GestorEventos2021.dao.MensajeFacade;
import GestorEventos2021.entity.Conversacion;
import GestorEventos2021.entity.Mensaje;
import GestorEventos2021.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/async-servlet/async-servlets.html
 */
@WebServlet(urlPatterns = {"/shoutServlet"}, asyncSupported=true)
public class ShoutServlet extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

    @EJB
    private ConversacionFacade conversacionFacade;
    
    
    private List<AsyncContext> contexts = new LinkedList<>();
    private static final Logger LOG = Logger.getLogger(ShoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(10 * 60 * 1000);
        contexts.add(asyncContext);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AsyncContext> asyncContexts = new ArrayList<>(this.contexts);
        this.contexts.clear();
        
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        Usuario user = (Usuario)session.getAttribute("usuario");
        String idC = request.getParameter("id");
        
        
        
        
        Conversacion c=this.conversacionFacade.find(new Integer(idC));
        
        Mensaje m = new Mensaje();
        m.setConversacion(c);
        m.setCuerpo(message);
        m.setEmisor(user);
        m.setFecha(new Date());
        m.setHora(new Date());
        
        this.mensajeFacade.create(m);
        
        c.getMensajeList().add(m);
        this.conversacionFacade.edit(c);
        
        String hora = new SimpleDateFormat("hh:mm").format(m.getHora());
        
        
        
        //String htmlMessage = "<div class=\"card text-dark bg-light mb-3\" style=\"max-width: 18rem;\"><div class=\"card-header\">" + hora + "</div> <div class=\"card-body\"> <h5 class=\"card-title\">" + name + "</h5><p class=\"card-text\">" + message + "</p></div></div>";
        
        String htmlMessage;
        if(m.getEmisor().getNombre().equals(name)) {
            htmlMessage = "<div class=\"card text-dark bg-light mb-3\" style=\"max-width: 18rem;\"><div class=\"card-header\">" + hora + "</div> <div class=\"card-body\"> <h5 class=\"card-title\">" + name + "</h5><p class=\"card-text\">" + message + "</p></div></div>";
        } else {
            htmlMessage = "<div style=\"text-align:right\"><div class=\"card text-dark bg-light mb-3\" style=\"max-width: 18rem;\"><div class=\"card-header\">" + hora + "</div> <div class=\"card-body\"> <h5 class=\"card-title\">" + name + "</h5><p class=\"card-text\">" + message + "</p></div></div></div>";
        }
        
        ServletContext application = request.getServletContext();
        
        if (application.getAttribute("messages") == null) {
            application.setAttribute("messages", htmlMessage);
        } else {
            String currentMessages = (String) application.getAttribute("messages");
            application.setAttribute("messages", htmlMessage + currentMessages);
        }
        
        for (AsyncContext asyncContext : asyncContexts) {
            try (PrintWriter writer = asyncContext.getResponse().getWriter()) {
                writer.println(htmlMessage);
                writer.flush();
                asyncContext.complete();
            } catch (Exception ex) {
                LOG.severe("Se ha producido la siguiente excepcion: " + ex.getMessage());
            }
        }

    }
}
