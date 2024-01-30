/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmortizcal.bluebank.entitys;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author mario
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
        , @NamedQuery(name = "Cuenta.findByCueId", query = "SELECT c FROM Cuenta c WHERE c.cueId = :cueId")
        , @NamedQuery(name = "Cuenta.findByCueTipo", query = "SELECT c FROM Cuenta c WHERE c.cueTipo = :cueTipo")
        , @NamedQuery(name = "Cuenta.findByCueNumero", query = "SELECT c FROM Cuenta c WHERE c.cueNumero = :cueNumero")
        , @NamedQuery(name = "Cuenta.findByCueSaldo", query = "SELECT c FROM Cuenta c WHERE c.cueSaldo = :cueSaldo")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cue_id")
    private Long cueId;
    @Basic(optional = false)
    @Column(name = "cue_tipo")
    private String cueTipo;
    @Basic(optional = false)
    @Column(name = "cue_numero")
    private String cueNumero;
    @Basic(optional = false)
    @Column(name = "cue_saldo")
    private BigInteger cueSaldo;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    @ManyToOne(optional = false)
    private Ciudades ciuId;
    @JoinColumn(name = "cli_id", referencedColumnName = "cli_id")
    @ManyToOne(optional = false)
    private Cliente cliId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cueId")
    private Collection<Movimientos> movimientosCollection;

    public Cuenta() {
    }

    public Cuenta(Long cueId) {
        this.cueId = cueId;
    }

    public Cuenta(Long cueId, String cueTipo, String cueNumero, BigInteger cueSaldo) {
        this.cueId = cueId;
        this.cueTipo = cueTipo;
        this.cueNumero = cueNumero;
        this.cueSaldo = cueSaldo;
    }

    public Long getCueId() {
        return cueId;
    }

    public void setCueId(Long cueId) {
        this.cueId = cueId;
    }

    public String getCueTipo() {
        return cueTipo;
    }

    public void setCueTipo(String cueTipo) {
        this.cueTipo = cueTipo;
    }

    public String getCueNumero() {
        return cueNumero;
    }

    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }

    public BigInteger getCueSaldo() {
        return cueSaldo;
    }

    public void setCueSaldo(BigInteger cueSaldo) {
        this.cueSaldo = cueSaldo;
    }

    public Ciudades getCiuId() {
        return ciuId;
    }

    public void setCiuId(Ciudades ciuId) {
        this.ciuId = ciuId;
    }

    public Cliente getCliId() {
        return cliId;
    }

    public void setCliId(Cliente cliId) {
        this.cliId = cliId;
    }

    @XmlTransient
    public Collection<Movimientos> getMovimientosCollection() {
        return movimientosCollection;
    }

    public void setMovimientosCollection(Collection<Movimientos> movimientosCollection) {
        this.movimientosCollection = movimientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cueId != null ? cueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cueId == null && other.cueId != null) || (this.cueId != null && !this.cueId.equals(other.cueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dmortizcal.bluebank.Cuenta[ cueId=" + cueId + " ]";
    }

}
