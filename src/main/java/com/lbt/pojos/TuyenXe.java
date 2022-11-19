/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tuyen_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TuyenXe.findAll", query = "SELECT t FROM TuyenXe t"),
    @NamedQuery(name = "TuyenXe.findById", query = "SELECT t FROM TuyenXe t WHERE t.id = :id"),
    @NamedQuery(name = "TuyenXe.findByDiemDi", query = "SELECT t FROM TuyenXe t WHERE t.diemDi = :diemDi"),
    @NamedQuery(name = "TuyenXe.findByDiemDen", query = "SELECT t FROM TuyenXe t WHERE t.diemDen = :diemDen"),
    @NamedQuery(name = "TuyenXe.findByLoTrinh", query = "SELECT t FROM TuyenXe t WHERE t.loTrinh = :loTrinh"),
    @NamedQuery(name = "TuyenXe.findByQuangDuong", query = "SELECT t FROM TuyenXe t WHERE t.quangDuong = :quangDuong"),
    @NamedQuery(name = "TuyenXe.findByTimeDiChuyen", query = "SELECT t FROM TuyenXe t WHERE t.timeDiChuyen = :timeDiChuyen")})
public class TuyenXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diem_di")
    private String diemDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diem_den")
    private String diemDen;
    @Size(max = 255)
    @Column(name = "lo_trinh")
    private String loTrinh;
    @Column(name = "quang_duong")
    private Integer quangDuong;
    @Size(max = 45)
    @Column(name = "time_di_chuyen")
    private String timeDiChuyen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuyenXeId", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"donDatVeSet", "loaiXeId", "nhaXeId", "tuyenXeId"})
    private Set<ChuyenXe> chuyenXeSet;
    
    private String image;
    
    @Transient
    @JsonIgnore
    private MultipartFile file;

    public TuyenXe() {
    }

    public TuyenXe(Integer id) {
        this.id = id;
    }

    public TuyenXe(Integer id, String diemDi, String diemDen) {
        this.id = id;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getLoTrinh() {
        return loTrinh;
    }

    public void setLoTrinh(String loTrinh) {
        this.loTrinh = loTrinh;
    }

    public Integer getQuangDuong() {
        return quangDuong;
    }

    public void setQuangDuong(Integer quangDuong) {
        this.quangDuong = quangDuong;
    }

    public String getTimeDiChuyen() {
        return timeDiChuyen;
    }

    public void setTimeDiChuyen(String timeDiChuyen) {
        this.timeDiChuyen = timeDiChuyen;
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
        if (!(object instanceof TuyenXe)) {
            return false;
        }
        TuyenXe other = (TuyenXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbt.pojos.TuyenXe[ id=" + id + " ]";
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
