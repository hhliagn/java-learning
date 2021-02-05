package com.javalearning.demo.login_demo.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming
public class User implements Serializable {

    private Integer companyId;
    private Integer rid;
    private String rname;
    private Integer isSuper;
    private String token;
}
