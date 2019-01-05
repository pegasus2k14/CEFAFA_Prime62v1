/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefafa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Programador4
 */
@Embeddable
public class TbldetfacturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nofactura")
    private int nofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private int codProducto;

    public TbldetfacturaPK() {
    }

    public TbldetfacturaPK(int nofactura, int codProducto) {
        this.nofactura = nofactura;
        this.codProducto = codProducto;
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nofactura;
        hash += (int) codProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbldetfacturaPK)) {
            return false;
        }
        TbldetfacturaPK other = (TbldetfacturaPK) object;
        if (this.nofactura != other.nofactura) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.TbldetfacturaPK[ nofactura=" + nofactura + ", codProducto=" + codProducto + " ]";
    }
    
}
