/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Conversacion;
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

    public List<Conversacion> findByFiltro(String filtroTeleoperador, String filtroUsuario) {
        Query q;
        List<Conversacion> res;
        if(filtroUsuario == null || filtroUsuario.isEmpty()) {
            q = this.em.createQuery("select c from Conversacion c where c.teleoperador.nombre like :filtroTeleoperador");
            q.setParameter("filtroTeleoperador", "%" + filtroTeleoperador + "%");
        } else if(filtroTeleoperador == null || filtroTeleoperador.isEmpty()) {
            q = this.em.createQuery("select c from Conversacion c where c.usuario.nombre like :filtroUsuario");
            q.setParameter("filtroUsuario", "%" + filtroUsuario + "%");
        } else {
            q = this.em.createQuery("select c from Conversacion c where c.teleoperador.nombre like :filtroTeleoperador and c.usuario.nombre like :filtroUsuario");
            q.setParameter("filtroTeleoperador", "%" + filtroTeleoperador + "%");
            q.setParameter("filtroUsuario", "%" + filtroUsuario + "%");
        }
        
        res = q.getResultList();
        
        return res;
    }
    
}
