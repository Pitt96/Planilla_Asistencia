/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KARLA
 */
@Entity
@Table(name = "BOLETA_PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletaPago.findAll", query = "SELECT b FROM BoletaPago b")
    , @NamedQuery(name = "BoletaPago.findById", query = "SELECT b FROM BoletaPago b WHERE b.id = :id")
    , @NamedQuery(name = "BoletaPago.findBySueldobruto", query = "SELECT b FROM BoletaPago b WHERE b.sueldobruto = :sueldobruto")
    , @NamedQuery(name = "BoletaPago.findByDesob", query = "SELECT b FROM BoletaPago b WHERE b.desob = :desob")
    , @NamedQuery(name = "BoletaPago.findByDesafp", query = "SELECT b FROM BoletaPago b WHERE b.desafp = :desafp")
    , @NamedQuery(name = "BoletaPago.findByBonificacion", query = "SELECT b FROM BoletaPago b WHERE b.bonificacion = :bonificacion")
    , @NamedQuery(name = "BoletaPago.findBySueldoneto", query = "SELECT b FROM BoletaPago b WHERE b.sueldoneto = :sueldoneto")})
public class BoletaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUELDOBRUTO")
    private Double sueldobruto;
    @Column(name = "DESOB")
    private Double desob;
    @Column(name = "DESAFP")
    private Double desafp;
    @Column(name = "BONIFICACION")
    private Double bonificacion;
    @Column(name = "SUELDONETO")
    private Double sueldoneto;
    @JoinColumn(name = "IDEMP", referencedColumnName = "ID")
    @ManyToOne
    private Empleado idemp;

    public BoletaPago() {
    }

    public BoletaPago(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSueldobruto() {
        return sueldobruto;
    }

    public void setSueldobruto(Double sueldobruto) {
        this.sueldobruto = sueldobruto;
    }

    public Double getDesob() {
        return desob;
    }

    public void setDesob(Double desob) {
        this.desob = desob;
    }

    public Double getDesafp() {
        return desafp;
    }

    public void setDesafp(Double desafp) {
        this.desafp = desafp;
    }

    public Double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Double getSueldoneto() {
        return sueldoneto;
    }

    public void setSueldoneto(Double sueldoneto) {
        this.sueldoneto = sueldoneto;
    }

    public Empleado getIdemp() {
        return idemp;
    }

    public void setIdemp(Empleado idemp) {
        this.idemp = idemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoletaPago)) {
            return false;
        }
        BoletaPago other = (BoletaPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.BoletaPago[ id=" + id + " ]";
    }
    
}
