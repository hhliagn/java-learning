package com.javalearning.demo.complex_pojo.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class NewsPojo extends ArrayList<New> implements Serializable {

    private String publicDepartment;

    public String getPublicDepartment() {
        return publicDepartment;
    }

    public void setPublicDepartment(String publicDepartment) {
        this.publicDepartment = publicDepartment;
    }

    @Override
    public String toString() {
        return "NewsPojo{" +
                "publicDepartment='" + publicDepartment + '\'' +
                '}' + super.toString();
    }
}
