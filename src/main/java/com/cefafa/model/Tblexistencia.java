/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programador4
 */
@Entity
@Table(name = "tblexistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblexistencia.findAll", query = "SELECT t FROM Tblexistencia t")
    , @NamedQuery(name = "Tblexistencia.findByCodSucursal", query = "SELECT t FROM Tblexistencia t WHERE t.tblexistenciaPK.codSucursal = :codSucursal")
    , @NamedQuery(name = "Tblexistencia.findByCodProducto", query = "SELECT t FROM Tblexistencia t WHERE t.tblexistenciaPK.codProducto = :codProducto")
    , @NamedQuery(name = "Tblexistencia.findByExistencia", query = "SELECT t FROM Tblexistencia t WHERE t.existencia = :existencia")})
public class Tblexistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblexistenciaPK tblexistenciaPK;
    @Column(name = "existencia")
    private Integer existencia;
    @JoinColumn(name = "codProducto", referencedColumnName = "codProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblproductos tblproductos;
    @JoinColumn(name = "codSucursal", referencedColumnName = "codSucursal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblsucursal tblsucursal;

    public Tblexistencia() {
    }

    public Tblexistencia(TblexistenciaPK tblexistenciaPK) {
        this.tblexistenciaPK = tblexistenciaPK;
    }

    public Tblexistencia(int codSucursal, int codProducto) {
        this.tblexistenciaPK = new TblexistenciaPK(codSucursal, codProducto);
    }

    public TblexistenciaPK getTblexistenciaPK() {
        return tblexistenciaPK;
    }

    public void setTblexistenciaPK(TblexistenciaPK tblexistenciaPK) {
        this.tblexistenciaPK = tblexistenciaPK;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Tblproductos getTblproductos() {
        return tblproductos;
    }

    public void setTblproductos(Tblproductos tblproductos) {
        this.tblproductos = tblproductos;
    }

    public Tblsucursal getTblsucursal() {
        return tblsucursal;
    }

    public void setTblsucursal(Tblsucursal tblsucursal) {
        this.tblsucursal = tblsucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblexistenciaPK != null ? tblexistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblexistencia)) {
            return false;
        }
        Tblexistencia other = (Tblexistencia) object;
        if ((this.tblexistenciaPK == null && other.tblexistenciaPK != null) || (this.tblexistenciaPK != null && !this.tblexistenciaPK.equals(other.tblexistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblexistencia[ tblexistenciaPK=" + tblexistenciaPK + " ]";
    }
    
}
