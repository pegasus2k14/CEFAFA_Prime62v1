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
public class TblexistenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codSucursal")
    private int codSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private int codProducto;

    public TblexistenciaPK() {
    }

    public TblexistenciaPK(int codSucursal, int codProducto) {
        this.codSucursal = codSucursal;
        this.codProducto = codProducto;
    }

    public int getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(int codSucursal) {
        this.codSucursal = codSucursal;
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
        hash += (int) codSucursal;
        hash += (int) codProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblexistenciaPK)) {
            return false;
        }
        TblexistenciaPK other = (TblexistenciaPK) object;
        if (this.codSucursal != other.codSucursal) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cefafa.model.TblexistenciaPK[ codSucursal=" + codSucursal + ", codProducto=" + codProducto + " ]";
    }
    
}
