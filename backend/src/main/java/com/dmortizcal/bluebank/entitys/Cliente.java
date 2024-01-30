/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmortizcal.bluebank.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

/**
 * @author mario
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
        , @NamedQuery(name = "Cliente.findByCliId", query = "SELECT c FROM Cliente c WHERE c.cliId = :cliId")
        , @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre")
        , @NamedQuery(name = "Cliente.findByCliTipo", query = "SELECT c FROM Cliente c WHERE c.cliTipo = :cliTipo")
        , @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_id")
    private Long cliId;
    @Basic(optional = false)
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Basic(optional = false)
    @Column(name = "cli_tipo")
    private String cliTipo;
    @Basic(optional = false)
    @Column(name = "cli_telefono")
    private long cliTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliId")
    private Collection<Cuenta> cuentaCollection;

    public Cliente() {
    }

    public Cliente(Long cliId) {
        this.cliId = cliId;
    }

    public Cliente(Long cliId, String cliNombre, String cliTipo, long cliTelefono) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliTipo = cliTipo;
        this.cliTelefono = cliTelefono;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        this.cliTipo = cliTipo;
    }

    public long getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(long cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    @JsonIgnore
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dmortizcal.bluebank.Cliente[ cliId=" + cliId + " ]";
    }

}
