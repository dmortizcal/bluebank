/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmortizcal.bluebank.entitys;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mario
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m")
        , @NamedQuery(name = "Movimientos.findByMovId", query = "SELECT m FROM Movimientos m WHERE m.movId = :movId")
        , @NamedQuery(name = "Movimientos.findByMovFecha", query = "SELECT m FROM Movimientos m WHERE m.movFecha = :movFecha")
        , @NamedQuery(name = "Movimientos.findByMovTipo", query = "SELECT m FROM Movimientos m WHERE m.movTipo = :movTipo")
        , @NamedQuery(name = "Movimientos.findByMovValor", query = "SELECT m FROM Movimientos m WHERE m.movValor = :movValor")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mov_id")
    private Long movId;
    @Basic(optional = false)
    @Column(name = "mov_fecha")
    @Temporal(TemporalType.DATE)
    private Date movFecha;
    @Basic(optional = false)
    @Column(name = "mov_tipo")
    private String movTipo;
    @Basic(optional = false)
    @Column(name = "mov_valor")
    private BigInteger movValor;
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    @ManyToOne(optional = false)
    private Ciudades ciuId;
    @JoinColumn(name = "cue_id", referencedColumnName = "cue_id")
    @ManyToOne(optional = false)
    private Cuenta cueId;

    public Movimientos() {
    }

    public Movimientos(Long movId) {
        this.movId = movId;
    }

    public Movimientos(Long movId, Date movFecha, String movTipo, BigInteger movValor) {
        this.movId = movId;
        this.movFecha = movFecha;
        this.movTipo = movTipo;
        this.movValor = movValor;
    }

    public Long getMovId() {
        return movId;
    }

    public void setMovId(Long movId) {
        this.movId = movId;
    }

    public Date getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(Date movFecha) {
        this.movFecha = movFecha;
    }

    public String getMovTipo() {
        return movTipo;
    }

    public void setMovTipo(String movTipo) {
        this.movTipo = movTipo;
    }

    public BigInteger getMovValor() {
        return movValor;
    }

    public void setMovValor(BigInteger movValor) {
        this.movValor = movValor;
    }

    public Ciudades getCiuId() {
        return ciuId;
    }

    public void setCiuId(Ciudades ciuId) {
        this.ciuId = ciuId;
    }

    public Cuenta getCueId() {
        return cueId;
    }

    public void setCueId(Cuenta cueId) {
        this.cueId = cueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dmortizcal.bluebank.Movimientos[ movId=" + movId + " ]";
    }

}
