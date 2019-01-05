/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programador4
 */
@Entity
@Table(name = "tbldetfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldetfactura.findAll", query = "SELECT t FROM Tbldetfactura t")
    , @NamedQuery(name = "Tbldetfactura.findByNofactura", query = "SELECT t FROM Tbldetfactura t WHERE t.tbldetfacturaPK.nofactura = :nofactura")
    , @NamedQuery(name = "Tbldetfactura.findByCodProducto", query = "SELECT t FROM Tbldetfactura t WHERE t.tbldetfacturaPK.codProducto = :codProducto")
    , @NamedQuery(name = "Tbldetfactura.findByPrecioVenta", query = "SELECT t FROM Tbldetfactura t WHERE t.precioVenta = :precioVenta")
    , @NamedQuery(name = "Tbldetfactura.findByCantidad", query = "SELECT t FROM Tbldetfactura t WHERE t.cantidad = :cantidad")})
public class Tbldetfactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbldetfacturaPK tbldetfacturaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioVenta")
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "nofactura", referencedColumnName = "noFactura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblfactura tblfactura;
    @JoinColumn(name = "codProducto", referencedColumnName = "codProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblproductos tblproductos;

    public Tbldetfactura() {
    }

    public Tbldetfactura(TbldetfacturaPK tbldetfacturaPK) {
        this.tbldetfacturaPK = tbldetfacturaPK;
    }

    public Tbldetfactura(TbldetfacturaPK tbldetfacturaPK, BigDecimal precioVenta, int cantidad) {
        this.tbldetfacturaPK = tbldetfacturaPK;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    public Tbldetfactura(int nofactura, int codProducto) {
        this.tbldetfacturaPK = new TbldetfacturaPK(nofactura, codProducto);
    }

    public TbldetfacturaPK getTbldetfacturaPK() {
        return tbldetfacturaPK;
    }

    public void setTbldetfacturaPK(TbldetfacturaPK tbldetfacturaPK) {
        this.tbldetfacturaPK = tbldetfacturaPK;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Tblfactura getTblfactura() {
        return tblfactura;
    }

    public void setTblfactura(Tblfactura tblfactura) {
        this.tblfactura = tblfactura;
    }

    public Tblproductos getTblproductos() {
        return tblproductos;
    }

    public void setTblproductos(Tblproductos tblproductos) {
        this.tblproductos = tblproductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbldetfacturaPK != null ? tbldetfacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldetfactura)) {
            return false;
        }
        Tbldetfactura other = (Tbldetfactura) object;
        if ((this.tbldetfacturaPK == null && other.tbldetfacturaPK != null) || (this.tbldetfacturaPK != null && !this.tbldetfacturaPK.equals(other.tbldetfacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tbldetfactura[ tbldetfacturaPK=" + tbldetfacturaPK + " ]";
    }
    
}
