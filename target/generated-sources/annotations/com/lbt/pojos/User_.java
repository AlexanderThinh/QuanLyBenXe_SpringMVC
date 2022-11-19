package com.lbt.pojos;

import com.lbt.pojos.Comment;
import com.lbt.pojos.DonDatHang;
import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.Rating;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T17:36:34")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SetAttribute<User, DonDatVe> donDatVeSet;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SetAttribute<User, DonDatHang> donDatHangSet;
    public static volatile SetAttribute<User, Rating> ratingSet;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Comment> commentSet;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}