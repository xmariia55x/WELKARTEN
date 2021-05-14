/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.*;
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
public class EstudioFacade extends AbstractFacade<Estudio> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudioFacade() {
        super(Estudio.class);
    }

    public Integer resultado(String signo, Integer edad, Evento ev) {
        Query q ;
        q= this.em.createQuery("SELECT u from Usuarioeventos u, Entrada e where e.evento = :ev");
        q.setParameter("ev", ev);
        List<Usuarioeventos> users = q.getResultList();
        Date d = new Date();
        long l = d.getTime();
        for(Usuarioeventos u : users){
            if(signo.equals("<")){
            if(!((u.getFechaNacimiento().getTime()- l) < edad)){
                users.remove(u);
            }    
            }else if(signo.equals("=")){
            if(!((u.getFechaNacimiento().getTime()- l) == edad)){
                users.remove(u);
            } else if(signo.equals(">")){
            if(!((u.getFechaNacimiento().getTime()- l) > edad)){
                users.remove(u);
            } 
            
            }       
    }
        }
         return users.size();
    }
}
