package com.college.converter;

import com.college.command.Personcommand;
import com.college.model.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonCommand implements Converter<Person, Personcommand> {
    @Override
    @Nullable
    @Synchronized
    public Personcommand convert(Person source) {
        if (source==null){return null;}
        Personcommand personcommand=new Personcommand();
        personcommand.setName(source.getName());
        personcommand.setLastName(source.getLastName());
        personcommand.setFatherName(source.getFatherName());
        personcommand.setEmail(source.getEmail());
        personcommand.setDob(source.getDob());
        personcommand.setAddress(source.getAddress());
        personcommand.setImage(source.getImage());
        return personcommand;

    }
}
