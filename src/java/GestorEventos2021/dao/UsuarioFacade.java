/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.dao;

import GestorEventos2021.entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WELKARTENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByEmailAndPassword(String email, String password) {
        Query q;
        List<Usuario> lista;
        
        q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :email AND u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        lista = q.getResultList();
        if(lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
        
    }
    

    public List<Usuario> findByRol (Integer rol){
        
        Query q;
        
        q = this.em.createNamedQuery("Usuario.findByRol");
        q.setParameter("rol", rol);
        
        return q.getResultList();
    }
    
    public List<Usuario> findByRol (Integer[] rol){
        
        Query q;
        
        q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.rol IN :roles");
        q.setParameter("roles", Arrays.asList(rol));
        
        return q.getResultList();
    }
    
    public List<Usuario> findByNombreSimilar (String nombre){
        Query q;
        
        q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre");
        q.setParameter("nombre", "%" + nombre + "%");
        return q.getResultList();
    }

     public Usuario findByEmail(String email) {
        Query q;
        List<Usuario> lista;
        
        q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :email");
        q.setParameter("email", email);
        lista = q.getResultList();
        if(lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
        
    }

}
