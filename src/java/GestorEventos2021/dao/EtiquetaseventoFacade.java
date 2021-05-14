/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Etiqueta;
import GestorEventos2021.entity.Etiquetasevento;
import java.util.Arrays;
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
public class EtiquetaseventoFacade extends AbstractFacade<Etiquetasevento> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtiquetaseventoFacade() {
        super(Etiquetasevento.class);
    }
    
    public List<Etiquetasevento> findByEventoId(Integer id){
       Query q = this.em.createQuery("SELECT et FROM Etiquetasevento et WHERE et.evento.id = :id");
       q.setParameter("id", id);
       
       return q.getResultList();
    }
}
