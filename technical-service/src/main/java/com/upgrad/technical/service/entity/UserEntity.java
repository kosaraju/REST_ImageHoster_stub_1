package com.upgrad.technical.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;


//Note that the object of this class maps with database table "users"
//Examine the "users" table schema
/*
ID                   SERIAL(PK)
UUID                 VARCHAR(36) (Not null)
ROLE                 VARCHAR(36)
EMAIL                VARCHAR(200) (Not null)
PASSWORD             VARCHAR(200) (Not null)
SALT                 VARCHAR(200) (Not null)
FIRST_NAME           VARCHAR(50) (Not null)
LAST_NAME            VARCHAR(50) (Not null)
MOBILE_PHONE         VARCHAR(50) (Not null)
LAST_LOGIN_AT        TIMESTAMP (Null to make its default value as null)
*/

//Complete this class on the basis of above table schema

//Write the annotation which defines that a class can be mapped to a Table
//
@Table(name = "USERS", schema = "imagehoster")
public class UserEntity implements Serializable {

    //Write the annotation which specifies that id attribute is a primary key

    //The @Column annotation helps to specify the properties of the column to which this field or attribute will be matched.
    //This annotation has 4 attributes name, length, nullable and unique
    //In name attribute you can explicitly specify the name of the column
    //Here the name "ID" is explicitly specified
    @Column(name = "ID")
    //Write an annotation which is used to generate a primary key and choose the generation strategy as GenerationType.IDENTITY
    private long id;


    @Column(name = "UUID")
    @Size(max = 64)
    private String uuid;

    //Write an annotation with its corresponding attribute to explicitly specify the column name as "ROLE"
    private String role;

    @Column(name = "EMAIL")
    @NotNull
    @Size(max = 200)
    private String email;

    //Define a private attribute named "password" of type String and explicitly specify its column name as "PASSWORD"


    @Column(name = "FIRST_NAME")
    @NotNull
    //The max attribute in @Size annotation specifies that the firstName can have maximum size of 200 characters
    @Size(max = 200)
    private String firstName;


    //Define a private attibute named "lastName" of type String, explictly specify its column name as "LAST_NAME" with notnull constraint and its maximum size should be 200


    @Column(name = "MOBILE_PHONE")
    @NotNull
    @Size(max = 50)
    private String mobilePhone;

    @Column(name = "LAST_LOGIN_AT")
    private ZonedDateTime lastLoginAt;

    //Define a private attibute named "salt" of type String, explictly specify its column name as "SALT" with notnull constraint and its maximum size should be 200


    //After defining all the attributes with mentioned annotations generate getters and setters for all the attributes




    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
