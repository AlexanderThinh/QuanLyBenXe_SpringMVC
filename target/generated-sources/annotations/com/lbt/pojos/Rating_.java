package com.lbt.pojos;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Date> createdDate;
    public static volatile SingularAttribute<Rating, Integer> rate;
    public static volatile SingularAttribute<Rating, NhaXe> nhaXeId;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, Date> updatedDate;
    public static volatile SingularAttribute<Rating, User> userId;

}