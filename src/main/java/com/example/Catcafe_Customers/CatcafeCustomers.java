package com.example.Catcafe_Customers;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class CatcafeCustomers {

    @Id
    @SequenceGenerator(
            name = "catcafe_id",
            sequenceName = "catcafe_id",
            allocationSize = 1
    )
    @GeneratedValue( //これはデータベースによって生成された値を指定するためのものです。
            strategy = GenerationType.SEQUENCE,
            generator = "catcafe_id"
    )
    // @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public CatcafeCustomers(Integer id, String name, String email, Integer age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public CatcafeCustomers(){
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public boolean  equals(Object a){
        if(this == a)
            return true;
        if(a == null || getClass() != a.getClass())
            return false;
        CatcafeCustomers that = (CatcafeCustomers) a;
        return id.equals(that.id) &&
                name.equals(that.name)&&
                email.equals(that.email)&&
                age.equals(that.age);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, email, age);
    }

    @Override
    public String toString() {
        return "CatcafeCustomers{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", age =" + age +
       '}';
    }








}
