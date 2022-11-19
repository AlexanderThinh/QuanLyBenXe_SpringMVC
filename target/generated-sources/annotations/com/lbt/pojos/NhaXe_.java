package com.lbt.pojos;

import com.lbt.pojos.BenXe;
import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.Comment;
import com.lbt.pojos.Rating;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(NhaXe.class)
public class NhaXe_ { 

    public static volatile SingularAttribute<NhaXe, BenXe> benXeId;
    public static volatile SetAttribute<NhaXe, Comment> commentSet;
    public static volatile SingularAttribute<NhaXe, String> tenNhaXe;
    public static volatile SingularAttribute<NhaXe, Boolean> active;
    public static volatile SingularAttribute<NhaXe, Boolean> giaoHang;
    public static volatile SingularAttribute<NhaXe, Integer> id;
    public static volatile SetAttribute<NhaXe, Rating> ratingSet;
    public static volatile SetAttribute<NhaXe, ChuyenXe> chuyenXeSet;

}