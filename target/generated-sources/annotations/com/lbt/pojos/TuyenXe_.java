package com.lbt.pojos;

import com.lbt.pojos.ChuyenXe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(TuyenXe.class)
public class TuyenXe_ { 

    public static volatile SingularAttribute<TuyenXe, String> timeDiChuyen;
    public static volatile SingularAttribute<TuyenXe, String> image;
    public static volatile SingularAttribute<TuyenXe, String> loTrinh;
    public static volatile SingularAttribute<TuyenXe, Integer> quangDuong;
    public static volatile SingularAttribute<TuyenXe, String> diemDi;
    public static volatile SingularAttribute<TuyenXe, Integer> id;
    public static volatile SingularAttribute<TuyenXe, String> diemDen;
    public static volatile SetAttribute<TuyenXe, ChuyenXe> chuyenXeSet;

}