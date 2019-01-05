/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tblproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproductos.findAll", query = "SELECT t FROM Tblproductos t")
    , @NamedQuery(name = "Tblproductos.findByCodProducto", query = "SELECT t FROM Tblproductos t WHERE t.codProducto = :codProducto")
    , @NamedQuery(name = "Tblproductos.findByNomProducto", query = "SELECT t FROM Tblproductos t WHERE t.nomProducto = :nomProducto")
    , @NamedQuery(name = "Tblproductos.findByCostoUnitario", query = "SELECT t FROM Tblproductos t WHERE t.costoUnitario = :costoUnitario")
    , @NamedQuery(name = "Tblproductos.findByPrecioVenta", query = "SELECT t FROM Tblproductos t WHERE t.precioVenta = :precioVenta")})
public class Tblproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codProducto")
    private Integer codProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomProducto")
    private String nomProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoUnitario")
    private BigDecimal costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioVenta")
    private BigDecimal precioVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblproductos")
    private List<Tbldetfactura> tbldetfacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblproductos")
    private List<Tblexistencia> tblexistenciaList;

    public Tblproductos() {
    }

    public Tblproductos(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Tblproductos(Integer codProducto, String nomProducto, BigDecimal costoUnitario, BigDecimal precioVenta) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.costoUnitario = costoUnitario;
        this.precioVenta = precioVenta;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    @XmlTransient
    public List<Tbldetfactura> getTbldetfacturaList() {
        return tbldetfacturaList;
    }

    public void setTbldetfacturaList(List<Tbldetfactura> tbldetfacturaList) {
        this.tbldetfacturaList = tbldetfacturaList;
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
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblproductos)) {
            return false;
        }
        Tblproductos other = (Tblproductos) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblproductos[ codProducto=" + codProducto + " ]";
    }
    
}
