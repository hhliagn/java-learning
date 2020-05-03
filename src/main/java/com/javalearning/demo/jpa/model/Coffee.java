package com.javalearning.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_coffee")
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer", "handler", "field_handler"})
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
