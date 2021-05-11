/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Entrada;
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
    
}
