/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @author DELL
 */
@Entity
@Table(name = "nha_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaXe.findAll", query = "SELECT n FROM NhaXe n"),
    @NamedQuery(name = "NhaXe.findById", query = "SELECT n FROM NhaXe n WHERE n.id = :id"),
    @NamedQuery(name = "NhaXe.findByTenNhaXe", query = "SELECT n FROM NhaXe n WHERE n.tenNhaXe = :tenNhaXe"),
    @NamedQuery(name = "NhaXe.findByActive", query = "SELECT n FROM NhaXe n WHERE n.active = :active"),
    @NamedQuery(name = "NhaXe.findByGiaoHang", query = "SELECT n FROM NhaXe n WHERE n.giaoHang = :giaoHang")})
public class NhaXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_nha_xe")
    private String tenNhaXe;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "giao_hang")
    private Boolean giaoHang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaXeId")
    @JsonIgnore
    private Set<Rating> ratingSet;
    @JoinColumn(name = "ben_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private BenXe benXeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaXeId", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaXeId")
    @JsonIgnore
    private Set<ChuyenXe> chuyenXeSet;

    public NhaXe() {
    }

    public NhaXe(Integer id) {
        this.id = id;
    }

    public NhaXe(Integer id, String tenNhaXe) {
        this.id = id;
        this.tenNhaXe = tenNhaXe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getGiaoHang() {
        return giaoHang;
    }

    public void setGiaoHang(Boolean giaoHang) {
        this.giaoHang = giaoHang;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    public BenXe getBenXeId() {
        return benXeId;
    }

    public void setBenXeId(BenXe benXeId) {
        this.benXeId = benXeId;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof NhaXe)) {
            return false;
        }
        NhaXe other = (NhaXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.NhaXe[ id=" + id + " ]";
    }
    
}
