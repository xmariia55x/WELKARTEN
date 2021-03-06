/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorEventos2021.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yeray
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id")
    , @NamedQuery(name = "Evento.findByTitulo", query = "SELECT e FROM Evento e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Evento.findByDescripcion", query = "SELECT e FROM Evento e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Evento.findByFechaInicio", query = "SELECT e FROM Evento e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Evento.findByFechaReserva", query = "SELECT e FROM Evento e WHERE e.fechaReserva = :fechaReserva")
    , @NamedQuery(name = "Evento.findByCosteEntrada", query = "SELECT e FROM Evento e WHERE e.costeEntrada = :costeEntrada")
    , @NamedQuery(name = "Evento.findByAforo", query = "SELECT e FROM Evento e WHERE e.aforo = :aforo")
    , @NamedQuery(name = "Evento.findByEntradasMax", query = "SELECT e FROM Evento e WHERE e.entradasMax = :entradasMax")
    , @NamedQuery(name = "Evento.findByFilas", query = "SELECT e FROM Evento e WHERE e.filas = :filas")
    , @NamedQuery(name = "Evento.findByAsientosFila", query = "SELECT e FROM Evento e WHERE e.asientosFila = :asientosFila")
    , @NamedQuery(name = "Evento.findByHora", query = "SELECT e FROM Evento e WHERE e.hora = :hora")
    , @NamedQuery(name = "Evento.findByCreador", query = "SELECT e FROM Evento e WHERE e.creador = :creador")
    , @NamedQuery(name = "Evento.findByLugar", query = "SELECT e FROM Evento e WHERE e.lugar = :lugar")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITULO", nullable = false, length=200)
    private String titulo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length=2000)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FECHA_RESERVA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Basic(optional = false)
    @Column(name = "COSTE_ENTRADA", nullable = false)
    private double costeEntrada;
    @Basic(optional = false)
    @Column(name = "AFORO", nullable = false)
    private int aforo;
    @Basic(optional = false)
    @Column(name = "ENTRADAS_MAX", nullable = false)
    private int entradasMax;
    @Column(name = "FILAS")
    private Integer filas;
    @Column(name = "ASIENTOS_FILA")
    private Integer asientosFila;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "LUGAR", length=200)
    private String lugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Etiquetasevento> etiquetaseventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Entrada> entradaList;
    @JoinColumn(name = "CREADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario creador;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String titulo, String descripcion, Date fechaInicio, Date fechaReserva, double costeEntrada, int aforo, int entradasMax) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaReserva = fechaReserva;
        this.costeEntrada = costeEntrada;
        this.aforo = aforo;
        this.entradasMax = entradasMax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getCosteEntrada() {
        return costeEntrada;
    }

    public void setCosteEntrada(double costeEntrada) {
        this.costeEntrada = costeEntrada;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getEntradasMax() {
        return entradasMax;
    }

    public void setEntradasMax(int entradasMax) {
        this.entradasMax = entradasMax;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getAsientosFila() {
        return asientosFila;
    }

    public void setAsientosFila(Integer asientosFila) {
        this.asientosFila = asientosFila;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlTransient
    public List<Etiquetasevento> getEtiquetaseventoList() {
        return etiquetaseventoList;
    }

    public void setEtiquetaseventoList(List<Etiquetasevento> etiquetaseventoList) {
        this.etiquetaseventoList = etiquetaseventoList;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GestorEventos2021.entity.Evento[ id=" + id + " ]";
    }
    
}
