package com.lbt.pojos;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(DonDatHang.class)
public class DonDatHang_ { 

    public static volatile SingularAttribute<DonDatHang, String> loaiMatHang;
    public static volatile SingularAttribute<DonDatHang, String> emailNguoiNhan;
    public static volatile SingularAttribute<DonDatHang, String> sdtNguoiGui;
    public static volatile SingularAttribute<DonDatHang, Date> thoiGianNhan;
    public static volatile SingularAttribute<DonDatHang, String> emailNguoiGui;
    public static volatile SingularAttribute<DonDatHang, String> nguoiNhan;
    public static volatile SingularAttribute<DonDatHang, User> userId;
    public static volatile SingularAttribute<DonDatHang, Integer> soKi;
    public static volatile SingularAttribute<DonDatHang, Long> donGia;
    public static volatile SingularAttribute<DonDatHang, Date> thoiGianGui;
    public static volatile SingularAttribute<DonDatHang, String> nguoiGui;
    public static volatile SingularAttribute<DonDatHang, String> sdtNguoiNhan;
    public static volatile SingularAttribute<DonDatHang, ChuyenXe> chuyenXeId;
    public static volatile SingularAttribute<DonDatHang, Integer> id;

}