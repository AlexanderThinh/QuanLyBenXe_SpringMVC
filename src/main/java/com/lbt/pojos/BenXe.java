/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.pojos;

import java.io.Serializable;
import java.util.Set;
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
 * @author DELL
 */
@Entity
@Table(name = "ben_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BenXe.findAll", query = "SELECT b FROM BenXe b"),
    @NamedQuery(name = "BenXe.findById", query = "SELECT b FROM BenXe b WHERE b.id = :id"),
    @NamedQuery(name = "BenXe.findByTenBenXe", query = "SELECT b FROM BenXe b WHERE b.tenBenXe = :tenBenXe"),
    @NamedQuery(name = "BenXe.findByDiaChi", query = "SELECT b FROM BenXe b WHERE b.diaChi = :diaChi"),
    @NamedQuery(name = "BenXe.findByActive", query = "SELECT b FROM BenXe b WHERE b.active = :active")})
public class BenXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_ben_xe")
    private String tenBenXe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "benXeId")
    private Set<NhaXe> nhaXeSet;

    public BenXe() {
    }

    public BenXe(Integer id) {
        this.id = id;
    }

    public BenXe(Integer id, String tenBenXe, String diaChi) {
        this.id = id;
        this.tenBenXe = tenBenXe;
        this.diaChi = diaChi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBenXe() {
        return tenBenXe;
    }

    public void setTenBenXe(String tenBenXe) {
        this.tenBenXe = tenBenXe;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<NhaXe> getNhaXeSet() {
        return nhaXeSet;
    }

    public void setNhaXeSet(Set<NhaXe> nhaXeSet) {
        this.nhaXeSet = nhaXeSet;
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
        if (!(object instanceof BenXe)) {
            return false;
        }
        BenXe other = (BenXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.BenXe[ id=" + id + " ]";
    }
    
}
