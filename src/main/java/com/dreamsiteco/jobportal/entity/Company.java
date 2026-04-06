package com.dreamsiteco.jobportal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "COMPANIES")
@Getter  @Setter //This annotation is from the Lombok Library helps generate the Getter and setter for my Entity columns
public class Company
{
    @Id //Since this is our primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Using IDENTITY from the GenerationType enum tells JPA to generate primary key value
    @Column(name = "ID", nullable = false)//This is optional because my java name id is same as the naming I am doing here
    private long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "LOGO", length = 500)
    private String logo;

    @Column(name = "INDUSTRY", nullable = false, length = 100)
    private String industry;

    @Column(name = "SIZE", nullable = false, length = 50)
    private String Size;

    @Column(name = "RATING", nullable = false, precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(name = "LOCATIONS", length = 1000)
    private String locations;

    @Column(name = "FOUNDED", nullable = false)
    private Integer founded;

    @Lob  //This represents a large object
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EMPLOYEES")
    private Integer employees;

    @Column(name = "WEBSITE", nullable = false, length = 1000)
    private String website;

    @Column(name = "CREATED_AT", nullable = false)
    private Instant CreatedAt;

    @Column(name = "CREATED_BY" , nullable = false, length = 50)
    private String  createdBy;

    @Column(name = "updated_at")
    private Instant UpdatedAt;

    @Column(name = "UPDATED_BY",length = 50)
    private String UpdatedBy;
}
