package com.college.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Personcommand extends BaseEntityCommand{
    private String name;
    private String lastName;
    private String fatherName;
    private String email;
    private LocalDate dob;
    private String address;
    @Lob
    private Byte[] image;

}
