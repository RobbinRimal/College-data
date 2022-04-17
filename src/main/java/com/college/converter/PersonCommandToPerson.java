package com.college.converter;

import com.college.command.Personcommand;
import com.college.model.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandToPerson implements Converter<Personcommand, Person> {
    @Override
    @Synchronized
    @Nullable
    public Person convert(Personcommand source) {
        if (source==null){return null;}
        final Person person= new Person();
        person.setName(source.getName());
        person.setLastName(source.getLastName());
        person.setFatherName(source.getFatherName());
        person.setEmail(source.getEmail());
        person.setDob(source.getDob());
        person.setAddress(source.getAddress());
        person.setImage(source.getImage());
        return person;
    }
}
