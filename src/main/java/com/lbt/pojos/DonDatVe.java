/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "don_dat_ve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonDatVe.findAll", query = "SELECT d FROM DonDatVe d"),
    @NamedQuery(name = "DonDatVe.findById", query = "SELECT d FROM DonDatVe d WHERE d.id = :id"),
    @NamedQuery(name = "DonDatVe.findByGia", query = "SELECT d FROM DonDatVe d WHERE d.gia = :gia"),
    @NamedQuery(name = "DonDatVe.findByCreatedDate", query = "SELECT d FROM DonDatVe d WHERE d.createdDate = :createdDate"),
    @NamedQuery(name = "DonDatVe.findBySoGhe", query = "SELECT d FROM DonDatVe d WHERE d.soGhe = :soGhe")})
public class DonDatVe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    private long gia;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "so_ghe")
    private Integer soGhe;
    @JoinColumn(name = "chuyen_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"donDatVeSet", "donDatHangSet", "loaiXeId", "nhaXeId", "tuyenXeId"})
    private ChuyenXe chuyenXeId;
    @JoinColumn(name = "loai_ve_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"donDatVeSet"})
    private LoaiVe loaiVeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"donDatHangSet" ,"ratingSet", "commentSet", "donDatVeSet"})
    private User userId;

    public DonDatVe() {
    }

    public DonDatVe(Integer id) {
        this.id = id;
    }

    public DonDatVe(Integer id, long gia) {
        this.id = id;
        this.gia = gia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public ChuyenXe getChuyenXeId() {
        return chuyenXeId;
    }

    public void setChuyenXeId(ChuyenXe chuyenXeId) {
        this.chuyenXeId = chuyenXeId;
    }

    public LoaiVe getLoaiVeId() {
        return loaiVeId;
    }

    public void setLoaiVeId(LoaiVe loaiVeId) {
        this.loaiVeId = loaiVeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof DonDatVe)) {
            return false;
        }
        DonDatVe other = (DonDatVe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.DonDatVe[ id=" + id + " ]";
    }
    
}
