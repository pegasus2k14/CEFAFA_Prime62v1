/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programador4
 */
@Entity
@Table(name = "tblsucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblsucursal.findAll", query = "SELECT t FROM Tblsucursal t")
    , @NamedQuery(name = "Tblsucursal.findByCodSucursal", query = "SELECT t FROM Tblsucursal t WHERE t.codSucursal = :codSucursal")
    , @NamedQuery(name = "Tblsucursal.findByNomSucursal", query = "SELECT t FROM Tblsucursal t WHERE t.nomSucursal = :nomSucursal")})
public class Tblsucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codSucursal")
    private Integer codSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomSucursal")
    private String nomSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSucursal")
    private List<Tblvendedores> tblvendedoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSucursal")
    private List<Tblfactura> tblfacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblsucursal")
    private List<Tblexistencia> tblexistenciaList;

    public Tblsucursal() {
    }

    public Tblsucursal(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Tblsucursal(Integer codSucursal, String nomSucursal) {
        this.codSucursal = codSucursal;
        this.nomSucursal = nomSucursal;
    }

    public Integer getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    @XmlTransient
    public List<Tblvendedores> getTblvendedoresList() {
        return tblvendedoresList;
    }

    public void setTblvendedoresList(List<Tblvendedores> tblvendedoresList) {
        this.tblvendedoresList = tblvendedoresList;
    }

    @XmlTransient
    public List<Tblfactura> getTblfacturaList() {
        return tblfacturaList;
    }

    public void setTblfacturaList(List<Tblfactura> tblfacturaList) {
        this.tblfacturaList = tblfacturaList;
    }

    @XmlTransient
    public List<Tblexistencia> getTblexistenciaList() {
        return tblexistenciaList;
    }

    public void setTblexistenciaList(List<Tblexistencia> tblexistenciaList) {
        this.tblexistenciaList = tblexistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSucursal != null ? codSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblsucursal)) {
            return false;
        }
        Tblsucursal other = (Tblsucursal) object;
        if ((this.codSucursal == null && other.codSucursal != null) || (this.codSucursal != null && !this.codSucursal.equals(other.codSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblsucursal[ codSucursal=" + codSucursal + " ]";
    }
    
}
