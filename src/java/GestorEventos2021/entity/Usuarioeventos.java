/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yeray
 */
@Entity
@Table(name = "USUARIOEVENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioeventos.findAll", query = "SELECT u FROM Usuarioeventos u")
    , @NamedQuery(name = "Usuarioeventos.findById", query = "SELECT u FROM Usuarioeventos u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarioeventos.findByApellidos", query = "SELECT u FROM Usuarioeventos u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarioeventos.findByDomicilio", query = "SELECT u FROM Usuarioeventos u WHERE u.domicilio = :domicilio")
    , @NamedQuery(name = "Usuarioeventos.findByCiudad", query = "SELECT u FROM Usuarioeventos u WHERE u.ciudad = :ciudad")
    , @NamedQuery(name = "Usuarioeventos.findByFechaNacimiento", query = "SELECT u FROM Usuarioeventos u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuarioeventos.findBySexo", query = "SELECT u FROM Usuarioeventos u WHERE u.sexo = :sexo")})
public class Usuarioeventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "APELLIDOS", nullable = false, length=50)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "DOMICILIO", nullable = false, length=100)
    private String domicilio;
    @Basic(optional = false)
    @Column(name = "CIUDAD", nullable = false, length=50)
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "SEXO", nullable = false, length=50)
    private String sexo;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Usuarioeventos() {
    }

    public Usuarioeventos(Integer id) {
        this.id = id;
    }

    public Usuarioeventos(Integer id, String apellidos, String domicilio, String ciudad, Date fechaNacimiento, String sexo) {
        this.id = id;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioeventos)) {
            return false;
        }
        Usuarioeventos other = (Usuarioeventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GestorEventos2021.entity.Usuarioeventos[ id=" + id + " ]";
    }
    
}
