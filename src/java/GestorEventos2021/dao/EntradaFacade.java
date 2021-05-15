/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Entrada;
import GestorEventos2021.entity.Evento;
import GestorEventos2021.entity.Usuario;
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
public class EntradaFacade extends AbstractFacade<Entrada> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntradaFacade() {
        super(Entrada.class);
    }
    
    public List<Integer> findByEntradasCompradaDeUnEvento (Evento evento){
        Query q;
        q = em.createQuery("SELECT e.numero FROM Entrada e WHERE e.evento.id = :eventoId");
        q.setParameter("eventoId", evento.getId());
        return q.getResultList();
    }
    
    public Integer maxNumeroDeUnEvento (Evento evento){
        Query q;
        List<Integer> lista;
        
        q = em.createQuery("SELECT MAX(e.numero) FROM Entrada e WHERE e.evento.id = :eventoid");
        q.setParameter("eventoid", evento.getId());
        lista = q.getResultList();
        
        if (lista != null) return lista.get(0);
        else return null;
    }
    
    public List<Evento> findByEventosDeUsuarioRecientes (Usuario u){
        Query q;
        List<Evento> listaEventos;
        
        q = em.createQuery("SELECT DISTINCT e.evento FROM Entrada e WHERE e.usuario = :usuario AND :fecha <= e.evento.fechaInicio ORDER BY e.evento.fechaInicio ASC");
        q.setParameter("usuario", u);
        q.setParameter("fecha", new Date());
        listaEventos = q.getResultList();
        return q.getResultList();
    }
    
    public List<Evento> findByEventosDeUsuarioFinalizados (Usuario u){
        Query q;
        List<Evento> listaEventos;
        
        q = em.createQuery("SELECT DISTINCT e.evento FROM Entrada e WHERE e.usuario = :usuario AND :fecha > e.evento.fechaInicio ORDER BY e.evento.fechaInicio ASC");
        q.setParameter("usuario", u);
        q.setParameter("fecha", new Date());
        listaEventos = q.getResultList();
        return q.getResultList();
    }
    
    public List<Entrada> findByEntradasDeUnUsuarioDeUnEvento (Usuario u, Evento e){
        Query q;
        List<Entrada> listaEntradas;
        
        q = em.createQuery("SELECT DISTINCT e FROM Entrada e WHERE e.usuario = :usuario AND e.evento = :evento ORDER BY e.numero ASC");
        q.setParameter("usuario", u);
        q.setParameter("evento", e);
        listaEntradas = q.getResultList();
        return q.getResultList();
    }
}
