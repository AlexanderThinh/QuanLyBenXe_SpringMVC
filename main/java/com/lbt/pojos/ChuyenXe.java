/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.pojos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "chuyen_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChuyenXe.findAll", query = "SELECT c FROM ChuyenXe c"),
    @NamedQuery(name = "ChuyenXe.findById", query = "SELECT c FROM ChuyenXe c WHERE c.id = :id"),
    @NamedQuery(name = "ChuyenXe.findByBienSo", query = "SELECT c FROM ChuyenXe c WHERE c.bienSo = :bienSo"),
    @NamedQuery(name = "ChuyenXe.findByNgayDi", query = "SELECT c FROM ChuyenXe c WHERE c.ngayDi = :ngayDi"),
    @NamedQuery(name = "ChuyenXe.findByNgayVe", query = "SELECT c FROM ChuyenXe c WHERE c.ngayVe = :ngayVe"),
    @NamedQuery(name = "ChuyenXe.findBySoGhe", query = "SELECT c FROM ChuyenXe c WHERE c.soGhe = :soGhe"),
    @NamedQuery(name = "ChuyenXe.findByGia", query = "SELECT c FROM ChuyenXe c WHERE c.gia = :gia"),
    @NamedQuery(name = "ChuyenXe.findByDichVu", query = "SELECT c FROM ChuyenXe c WHERE c.dichVu = :dichVu")})
public class ChuyenXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bien_so")
    private String bienSo;
    @Column(name = "ngay_di")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDi;
    @Column(name = "ngay_ve")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayVe;
    @Column(name = "so_ghe")
    private Integer soGhe;
    @Column(name = "gia")
    private Long gia;
    @Size(max = 255)
    @Column(name = "dich_vu")
    private String dichVu;
    @Column(name = "gio_xe_chay")
    private String gioXeChay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chuyenXeId", fetch = FetchType.EAGER)
    private Set<DonDatVe> donDatVeSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chuyenXeId", fetch = FetchType.EAGER)
    private Set<DonDatHang> donDatHangSet;
    @JoinColumn(name = "loai_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoaiXe loaiXeId;
    @JoinColumn(name = "nha_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NhaXe nhaXeId;
    @JoinColumn(name = "tuyen_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TuyenXe tuyenXeId;

    public ChuyenXe() {
    }

    public ChuyenXe(Integer id) {
        this.id = id;
    }

    public ChuyenXe(Integer id, String bienSo) {
        this.id = id;
        this.bienSo = bienSo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public Date getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(Date ngayVe) {
        this.ngayVe = ngayVe;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    @XmlTransient
    public Set<DonDatVe> getDonDatVeSet() {
        return donDatVeSet;
    }

    public void setDonDatVeSet(Set<DonDatVe> donDatVeSet) {
        this.donDatVeSet = donDatVeSet;
    }

    public LoaiXe getLoaiXeId() {
        return loaiXeId;
    }

    public void setLoaiXeId(LoaiXe loaiXeId) {
        this.loaiXeId = loaiXeId;
    }

    public NhaXe getNhaXeId() {
        return nhaXeId;
    }

    public void setNhaXeId(NhaXe nhaXeId) {
        this.nhaXeId = nhaXeId;
    }

    public TuyenXe getTuyenXeId() {
        return tuyenXeId;
    }

    public void setTuyenXeId(TuyenXe tuyenXeId) {
        this.tuyenXeId = tuyenXeId;
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
        if (!(object instanceof ChuyenXe)) {
            return false;
        }
        ChuyenXe other = (ChuyenXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.ChuyenXe[ id=" + id + " ]";
    }

    /**
     * @return the gioXeChay
     */
    public String getGioXeChay() {
        return gioXeChay;
    }

    /**
     * @param gioXeChay the gioXeChay to set
     */
    public void setGioXeChay(String gioXeChay) {
        this.gioXeChay = gioXeChay;
    }

    /**
     * @return the donDatHangSet
     */
    @XmlTransient
    public Set<DonDatHang> getDonDatHangSet() {
        return donDatHangSet;
    }

    /**
     * @param donDatHangSet the donDatHangSet to set
     */
    public void setDonDatHangSet(Set<DonDatHang> donDatHangSet) {
        this.donDatHangSet = donDatHangSet;
    }
    
}
