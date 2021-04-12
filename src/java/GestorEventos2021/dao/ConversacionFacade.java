/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Conversacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yeray
 */
@Stateless
public class ConversacionFacade extends AbstractFacade<Conversacion> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConversacionFacade() {
        super(Conversacion.class);
    }
    
}
