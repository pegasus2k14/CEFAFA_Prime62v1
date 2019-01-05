/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programador4
 */
@Entity
@Table(name = "tblfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblfactura.findAll", query = "SELECT t FROM Tblfactura t")
    , @NamedQuery(name = "Tblfactura.findByNoFactura", query = "SELECT t FROM Tblfactura t WHERE t.noFactura = :noFactura")
    , @NamedQuery(name = "Tblfactura.findByTipo", query = "SELECT t FROM Tblfactura t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tblfactura.findByFecha", query = "SELECT t FROM Tblfactura t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Tblfactura.findBySubTotal", query = "SELECT t FROM Tblfactura t WHERE t.subTotal = :subTotal")
    , @NamedQuery(name = "Tblfactura.findByIva", query = "SELECT t FROM Tblfactura t WHERE t.iva = :iva")
    , @NamedQuery(name = "Tblfactura.findByTotal", query = "SELECT t FROM Tblfactura t WHERE t.total = :total")})
public class Tblfactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "noFactura")
    private Integer noFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "subTotal")
    private BigDecimal subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private BigDecimal iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "codVendedor", referencedColumnName = "codVendedor")
    @ManyToOne(optional = false)
    private Tblvendedores codVendedor;
    @JoinColumn(name = "codCliente", referencedColumnName = "codCliente")
    @ManyToOne(optional = false)
    private Tblclientes codCliente;
    @JoinColumn(name = "codSucursal", referencedColumnName = "codSucursal")
    @ManyToOne(optional = false)
    private Tblsucursal codSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblfactura")
    private List<Tbldetfactura> tbldetfacturaList;

    public Tblfactura() {
    }

    public Tblfactura(Integer noFactura) {
        this.noFactura = noFactura;
    }

    public Tblfactura(Integer noFactura, int tipo, Date fecha, BigDecimal subTotal, BigDecimal iva, BigDecimal total) {
        this.noFactura = noFactura;
        this.tipo = tipo;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public Integer getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Integer noFactura) {
        this.noFactura = noFactura;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Tblvendedores getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Tblvendedores codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Tblclientes getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Tblclientes codCliente) {
        this.codCliente = codCliente;
    }

    public Tblsucursal getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Tblsucursal codSucursal) {
        this.codSucursal = codSucursal;
    }

    @XmlTransient
    public List<Tbldetfactura> getTbldetfacturaList() {
        return tbldetfacturaList;
    }

    public void setTbldetfacturaList(List<Tbldetfactura> tbldetfacturaList) {
        this.tbldetfacturaList = tbldetfacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noFactura != null ? noFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblfactura)) {
            return false;
        }
        Tblfactura other = (Tblfactura) object;
        if ((this.noFactura == null && other.noFactura != null) || (this.noFactura != null && !this.noFactura.equals(other.noFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblfactura[ noFactura=" + noFactura + " ]";
    }
    
}
