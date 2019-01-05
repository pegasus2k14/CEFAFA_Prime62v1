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
@Table(name = "tblclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblclientes.findAll", query = "SELECT t FROM Tblclientes t")
    , @NamedQuery(name = "Tblclientes.findByCodCliente", query = "SELECT t FROM Tblclientes t WHERE t.codCliente = :codCliente")
    , @NamedQuery(name = "Tblclientes.findByNomcliente", query = "SELECT t FROM Tblclientes t WHERE t.nomcliente = :nomcliente")})
public class Tblclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCliente")
    private Integer codCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomcliente")
    private String nomcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCliente")
    private List<Tblfactura> tblfacturaList;

    public Tblclientes() {
    }

    public Tblclientes(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Tblclientes(Integer codCliente, String nomcliente) {
        this.codCliente = codCliente;
        this.nomcliente = nomcliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
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
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblclientes)) {
            return false;
        }
        Tblclientes other = (Tblclientes) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.Tblclientes[ codCliente=" + codCliente + " ]";
    }
    
}
