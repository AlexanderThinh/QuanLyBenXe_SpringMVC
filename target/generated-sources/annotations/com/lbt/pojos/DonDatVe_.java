package com.lbt.pojos;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.LoaiVe;
import com.lbt.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(DonDatVe.class)
public class DonDatVe_ { 

    public static volatile SingularAttribute<DonDatVe, Integer> soGhe;
    public static volatile SingularAttribute<DonDatVe, Date> createdDate;
    public static volatile SingularAttribute<DonDatVe, ChuyenXe> chuyenXeId;
    public static volatile SingularAttribute<DonDatVe, Integer> id;
    public static volatile SingularAttribute<DonDatVe, LoaiVe> loaiVeId;
    public static volatile SingularAttribute<DonDatVe, User> userId;
    public static volatile SingularAttribute<DonDatVe, Long> gia;

}