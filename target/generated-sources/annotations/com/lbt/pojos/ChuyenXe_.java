package com.lbt.pojos;

import com.lbt.pojos.DonDatHang;
import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.LoaiXe;
import com.lbt.pojos.NhaXe;
import com.lbt.pojos.TuyenXe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(ChuyenXe.class)
public class ChuyenXe_ { 

    public static volatile SingularAttribute<ChuyenXe, Integer> soGhe;
    public static volatile SetAttribute<ChuyenXe, DonDatVe> donDatVeSet;
    public static volatile SingularAttribute<ChuyenXe, String> gioXeChay;
    public static volatile SingularAttribute<ChuyenXe, TuyenXe> tuyenXeId;
    public static volatile SingularAttribute<ChuyenXe, NhaXe> nhaXeId;
    public static volatile SetAttribute<ChuyenXe, DonDatHang> donDatHangSet;
    public static volatile SingularAttribute<ChuyenXe, Date> ngayVe;
    public static volatile SingularAttribute<ChuyenXe, String> dichVu;
    public static volatile SingularAttribute<ChuyenXe, Date> ngayDi;
    public static volatile SingularAttribute<ChuyenXe, LoaiXe> loaiXeId;
    public static volatile SingularAttribute<ChuyenXe, Integer> id;
    public static volatile SingularAttribute<ChuyenXe, String> bienSo;
    public static volatile SingularAttribute<ChuyenXe, Long> gia;

}