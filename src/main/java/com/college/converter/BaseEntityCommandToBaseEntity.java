package com.college.converter;

import com.college.command.BaseEntityCommand;
import com.college.model.BaseEntity;
import org.springframework.core.convert.converter.Converter;

public class BaseEntityCommandToBaseEntity implements Converter<BaseEntityCommand, BaseEntity> {
    @Override
    public BaseEntity convert(BaseEntityCommand source) {
       if (source==null){ return null;}
       BaseEntity baseEntity=new BaseEntity();
       baseEntity.setID(source.getID());
       return baseEntity;
    }
}
