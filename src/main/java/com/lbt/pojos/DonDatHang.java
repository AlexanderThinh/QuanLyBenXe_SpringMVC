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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "don_dat_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonDatHang.findAll", query = "SELECT d FROM DonDatHang d"),
    @NamedQuery(name = "DonDatHang.findById", query = "SELECT d FROM DonDatHang d WHERE d.id = :id"),
    @NamedQuery(name = "DonDatHang.findByNguoiGui", query = "SELECT d FROM DonDatHang d WHERE d.nguoiGui = :nguoiGui"),
    @NamedQuery(name = "DonDatHang.findBySdtNguoiGui", query = "SELECT d FROM DonDatHang d WHERE d.sdtNguoiGui = :sdtNguoiGui"),
    @NamedQuery(name = "DonDatHang.findByEmailNguoiGui", query = "SELECT d FROM DonDatHang d WHERE d.emailNguoiGui = :emailNguoiGui"),
    @NamedQuery(name = "DonDatHang.findByNguoiNhan", query = "SELECT d FROM DonDatHang d WHERE d.nguoiNhan = :nguoiNhan"),
    @NamedQuery(name = "DonDatHang.findBySdtNguoiNhan", query = "SELECT d FROM DonDatHang d WHERE d.sdtNguoiNhan = :sdtNguoiNhan"),
    @NamedQuery(name = "DonDatHang.findByEmailNguoiNhan", query = "SELECT d FROM DonDatHang d WHERE d.emailNguoiNhan = :emailNguoiNhan"),
    @NamedQuery(name = "DonDatHang.findByLoaiMatHang", query = "SELECT d FROM DonDatHang d WHERE d.loaiMatHang = :loaiMatHang"),
    @NamedQuery(name = "DonDatHang.findBySoKi", query = "SELECT d FROM DonDatHang d WHERE d.soKi = :soKi"),
    @NamedQuery(name = "DonDatHang.findByDonGia", query = "SELECT d FROM DonDatHang d WHERE d.donGia = :donGia"),
    @NamedQuery(name = "DonDatHang.findByThoiGianGui", query = "SELECT d FROM DonDatHang d WHERE d.thoiGianGui = :thoiGianGui"),
    @NamedQuery(name = "DonDatHang.findByThoiGianNhan", query = "SELECT d FROM DonDatHang d WHERE d.thoiGianNhan = :thoiGianNhan")})
public class DonDatHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nguoi_gui")
    private String nguoiGui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sdt_nguoi_gui")
    private String sdtNguoiGui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_nguoi_gui")
    private String emailNguoiGui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nguoi_nhan")
    private String nguoiNhan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sdt_nguoi_nhan")
    private String sdtNguoiNhan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_nguoi_nhan")
    private String emailNguoiNhan;
    @Size(max = 45)
    @Column(name = "loai_mat_hang")
    private String loaiMatHang;
    @Column(name = "so_ki")
    private Integer soKi;
    @Column(name = "don_gia")
    private Long donGia;
    @Column(name = "thoi_gian_gui")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianGui;
    @Column(name = "thoi_gian_nhan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianNhan;
    @JoinColumn(name = "chuyen_xe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"donDatVeSet", "donDatHangSet", "loaiXeId", "nhaXeId", "tuyenXeId"})
    private ChuyenXe chuyenXeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"donDatHangSet" ,"ratingSet", "commentSet", "donDatVeSet"})
    private User userId;

    public DonDatHang() {
    }

    public DonDatHang(Integer id) {
        this.id = id;
    }

    public DonDatHang(Integer id, String nguoiGui, String sdtNguoiGui, String emailNguoiGui, String nguoiNhan, String sdtNguoiNhan, String emailNguoiNhan) {
        this.id = id;
        this.nguoiGui = nguoiGui;
        this.sdtNguoiGui = sdtNguoiGui;
        this.emailNguoiGui = emailNguoiGui;
        this.nguoiNhan = nguoiNhan;
        this.sdtNguoiNhan = sdtNguoiNhan;
        this.emailNguoiNhan = emailNguoiNhan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public String getSdtNguoiGui() {
        return sdtNguoiGui;
    }

    public void setSdtNguoiGui(String sdtNguoiGui) {
        this.sdtNguoiGui = sdtNguoiGui;
    }

    public String getEmailNguoiGui() {
        return emailNguoiGui;
    }

    public void setEmailNguoiGui(String emailNguoiGui) {
        this.emailNguoiGui = emailNguoiGui;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public String getEmailNguoiNhan() {
        return emailNguoiNhan;
    }

    public void setEmailNguoiNhan(String emailNguoiNhan) {
        this.emailNguoiNhan = emailNguoiNhan;
    }

    public String getLoaiMatHang() {
        return loaiMatHang;
    }

    public void setLoaiMatHang(String loaiMatHang) {
        this.loaiMatHang = loaiMatHang;
    }

    public Integer getSoKi() {
        return soKi;
    }

    public void setSoKi(Integer soKi) {
        this.soKi = soKi;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public Date getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(Date thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public Date getThoiGianNhan() {
        return thoiGianNhan;
    }

    public void setThoiGianNhan(Date thoiGianNhan) {
        this.thoiGianNhan = thoiGianNhan;
    }

    public ChuyenXe getChuyenXeId() {
        return chuyenXeId;
    }

    public void setChuyenXeId(ChuyenXe chuyenXeId) {
        this.chuyenXeId = chuyenXeId;
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
        if (!(object instanceof DonDatHang)) {
            return false;
        }
        DonDatHang other = (DonDatHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.DonDatHang[ id=" + id + " ]";
    }
    
}
