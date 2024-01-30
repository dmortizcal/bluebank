/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmortizcal.bluebank.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")
        , @NamedQuery(name = "Ciudades.findByCiuId", query = "SELECT c FROM Ciudades c WHERE c.ciuId = :ciuId")
        , @NamedQuery(name = "Ciudades.findByCiuNombre", query = "SELECT c FROM Ciudades c WHERE c.ciuNombre = :ciuNombre")
        , @NamedQuery(name = "Ciudades.findByCiuCodpost", query = "SELECT c FROM Ciudades c WHERE c.ciuCodpost = :ciuCodpost")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciu_id")
    private Long ciuId;
    @Basic(optional = false)
    @Column(name = "ciu_nombre")
    private String ciuNombre;
    @Column(name = "ciu_codpost")
    private String ciuCodpost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciuId")
    private Collection<Cuenta> cuentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciuId")
    private Collection<Movimientos> movimientosCollection;

    public Ciudades() {
    }

    public Ciudades(Long ciuId) {
        this.ciuId = ciuId;
    }

    public Ciudades(Long ciuId, String ciuNombre) {
        this.ciuId = ciuId;
        this.ciuNombre = ciuNombre;
    }

    public Long getCiuId() {
        return ciuId;
    }

    public void setCiuId(Long ciuId) {
        this.ciuId = ciuId;
    }

    public String getCiuNombre() {
        return ciuNombre;
    }

    public void setCiuNombre(String ciuNombre) {
        this.ciuNombre = ciuNombre;
    }

    public String getCiuCodpost() {
        return ciuCodpost;
    }

    public void setCiuCodpost(String ciuCodpost) {
        this.ciuCodpost = ciuCodpost;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
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
        hash += (ciuId != null ? ciuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.ciuId == null && other.ciuId != null) || (this.ciuId != null && !this.ciuId.equals(other.ciuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dmortizcal.bluebank.Ciudades[ ciuId=" + ciuId + " ]";
    }

}
