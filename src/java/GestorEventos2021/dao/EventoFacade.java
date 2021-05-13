/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Evento;
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
    
}
