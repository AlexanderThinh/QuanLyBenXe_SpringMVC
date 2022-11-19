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
@Table(name = "loai_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiXe.findAll", query = "SELECT l FROM LoaiXe l"),
    @NamedQuery(name = "LoaiXe.findById", query = "SELECT l FROM LoaiXe l WHERE l.id = :id"),
    @NamedQuery(name = "LoaiXe.findByTenLoaiXe", query = "SELECT l FROM LoaiXe l WHERE l.tenLoaiXe = :tenLoaiXe")})
public class LoaiXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ten_loai_xe")
    private String tenLoaiXe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiXeId")
    private Set<ChuyenXe> chuyenXeSet;

    public LoaiXe() {
    }

    public LoaiXe(Integer id) {
        this.id = id;
    }

    public LoaiXe(Integer id, String tenLoaiXe) {
        this.id = id;
        this.tenLoaiXe = tenLoaiXe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    @XmlTransient
    public Set<ChuyenXe> getChuyenXeSet() {
        return chuyenXeSet;
    }

    public void setChuyenXeSet(Set<ChuyenXe> chuyenXeSet) {
        this.chuyenXeSet = chuyenXeSet;
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
        if (!(object instanceof LoaiXe)) {
            return false;
        }
        LoaiXe other = (LoaiXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.LoaiXe[ id=" + id + " ]";
    }
    
}
