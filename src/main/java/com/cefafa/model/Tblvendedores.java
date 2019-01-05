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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblvendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvendedores.findAll", query = "SELECT t FROM Tblvendedores t")
    , @NamedQuery(name = "Tblvendedores.findByCodVendedor", query = "SELECT t FROM Tblvendedores t WHERE t.codVendedor = :codVendedor")
    , @NamedQuery(name = "Tblvendedores.findByNomVendedor", query = "SELECT t FROM Tblvendedores t WHERE t.nomVendedor = :nomVendedor")})
public class Tblvendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codVendedor")
    private Integer codVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomVendedor")
    private String nomVendedor;
    @JoinColumn(name = "codSucursal", referencedColumnName = "codSucursal")
    @ManyToOne(optional = false)
    private Tblsucursal codSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVendedor")
    private List<Tblfactura> tblfacturaList;

    public Tblvendedores() {
    }

    public Tblvendedores(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Tblvendedores(Integer codVendedor, String nomVendedor) {
        this.codVendedor = codVendedor;
        this.nomVendedor = nomVendedor;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getNomVendedor() {
        return nomVendedor;
    }

    public void setNomVendedor(String nomVendedor) {
        this.nomVendedor = nomVendedor;
    }

    public Tblsucursal getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Tblsucursal codSucursal) {
        this.codSucursal = codSucursal;
    }

    @XmlTransient
    public List<Tblfactura> getTblfacturaList() {
        return tblfacturaList;
    }

    public void setTblfacturaList(List<Tblfactura> tblfacturaList) {
        this.tblfacturaList = tblfacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVendedor != null ? codVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblvendedores)) {
            return false;
        }
        Tblvendedores other = (Tblvendedores) object;
        if ((this.codVendedor == null && other.codVendedor != null) || (this.codVendedor != null && !this.codVendedor.equals(other.codVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblvendedores[ codVendedor=" + codVendedor + " ]";
    }
    
}
