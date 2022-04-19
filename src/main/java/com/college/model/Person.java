package com.college.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class Person extends BaseEntity{


    private String name;
    private String lastName;
    private String fatherName;
    private String email;
    private Date dob;
    private String address;



    @Lob
    private Byte[] image;

}
