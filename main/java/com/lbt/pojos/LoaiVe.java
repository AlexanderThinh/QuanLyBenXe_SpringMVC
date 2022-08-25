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
import javax.persistence.FetchType;
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
@Table(name = "loai_ve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiVe.findAll", query = "SELECT l FROM LoaiVe l"),
    @NamedQuery(name = "LoaiVe.findById", query = "SELECT l FROM LoaiVe l WHERE l.id = :id"),
    @NamedQuery(name = "LoaiVe.findByTenLoaiVe", query = "SELECT l FROM LoaiVe l WHERE l.tenLoaiVe = :tenLoaiVe")})
public class LoaiVe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_loai_ve")
    private String tenLoaiVe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiVeId", fetch = FetchType.EAGER)
    private Set<DonDatVe> donDatVeSet;

    public LoaiVe() {
    }

    public LoaiVe(Integer id) {
        this.id = id;
    }

    public LoaiVe(Integer id, String tenLoaiVe) {
        this.id = id;
        this.tenLoaiVe = tenLoaiVe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    @XmlTransient
    public Set<DonDatVe> getDonDatVeSet() {
        return donDatVeSet;
    }

    public void setDonDatVeSet(Set<DonDatVe> donDatVeSet) {
        this.donDatVeSet = donDatVeSet;
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
        if (!(object instanceof LoaiVe)) {
            return false;
        }
        LoaiVe other = (LoaiVe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.LoaiVe[ id=" + id + " ]";
    }
    
}
