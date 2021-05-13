/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author yeray
 */
@Stateless
public class EventoFacade extends AbstractFacade<Evento> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoFacade() {
        super(Evento.class);
    }
    
    public List<Evento> filtrarByTituloOrLugar (String filtro){
        Query q;
        List<Evento> lista;
        
        if (filtro == null || filtro.isEmpty()) {
            lista = this.findAll();
        } else {
            q = this.em.createQuery("SELECT DISTINCT e FROM Evento e WHERE e.titulo LIKE :filtro OR e.lugar LIKE :filtro");
            q.setParameter("filtro", "%"+filtro+"%");
            lista = q.getResultList();
        }
        
        return lista;
    }
    
    public List<Evento> filtrarByEventosNoCaducados (){
        Query q;
        List<Evento> lista;
        
        q = this.em.createQuery("SELECT e FROM Evento e WHERE e.fechaReserva >= :fecha ORDER BY e.fechaInicio ASC");
        q.setParameter("fecha", new Date());
        lista = q.getResultList();
        
        return lista;
    }
    
    public List<Evento> filtrarByFechaDeHoy (){
        Query q;
        List<Evento> lista;
        
        q = this.em.createQuery("SELECT e FROM Evento e WHERE e.fechaInicio = :fecha");
        q.setParameter("fecha", new Date());
        lista = q.getResultList();
        
        return lista;
    }
    
    public List<Evento> filtrarByFechaDeEstaSemana (){
        Query q;
        List<Evento> lista;
        Date fechaSemana = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(fechaSemana);
        c.add(Calendar.DATE, 7);
        fechaSemana = c.getTime();
        
        
        q = this.em.createQuery("SELECT e FROM Evento e WHERE e.fechaInicio >= :fechaHoy AND e.fechaInicio <= :fechaSemana ORDER BY e.fechaInicio ASC");
        q.setParameter("fechaSemana", fechaSemana);
        q.setParameter("fechaHoy", new Date());
        lista = q.getResultList();
        
        return lista;
    }
     
    public List<Evento> filtrarByNombrePrecioAforoCreador(String nombre, Integer precio, Integer aforo, Usuario creador){
        Query q;
        
        String query = "SELECT e FROM Evento e WHERE ";
        Boolean primeroPuesto= false;
        Boolean nombreFiltrado = false;
        Boolean precioFiltrado = false;
        Boolean aforoFiltrado = false;
        Boolean creadorFiltrado = false;
        
        if((nombre == null || nombre.equals(""))  && precio == null  && aforo == null  && creador == null){
            return this.findAll();
        }else{
            if(nombre != null && !nombre.equals("")){             
                query += " e.titulo LIKE :titulo ";
                primeroPuesto = true;   
                nombreFiltrado = true;
            }
            if(precio != null && precio >= 0){
                if(primeroPuesto) query += " AND ";
                query += " e.costeEntrada <= :costeEntrada ";
                primeroPuesto = true;
                precioFiltrado = true;
            }
            if(aforo != null && aforo > 0){
                if(primeroPuesto) query += " AND ";
                query += " e.aforo <= :aforo ";
                primeroPuesto = true; 
                aforoFiltrado = true;
            }
            if(creador != null){
                if(primeroPuesto) query += " AND ";
                query += " e.creador = :creador ";
                primeroPuesto = true; 
                creadorFiltrado = true;
            }                               
        }
        
        q = this.em.createQuery(query);
        
        if(nombreFiltrado) q.setParameter("titulo", "%" + nombre + "%");
        if(precioFiltrado) q.setParameter("costeEntrada", precio);
        if(aforoFiltrado) q.setParameter("aforo", aforo);
        if(creadorFiltrado) q.setParameter("creador", creador);
        
        
        return q.getResultList();
    }
    
    
}
