package com.college.converter;

import com.college.command.BaseEntityCommand;
import com.college.model.BaseEntity;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BaseEntityCommandToBaseEntity implements Converter<BaseEntityCommand, BaseEntity> {
    @Synchronized
    @Nullable
    @Override
    public BaseEntity convert(BaseEntityCommand source) {
       if (source==null){ return null;}
       BaseEntity baseEntity=new BaseEntity();
       baseEntity.setID(source.getID());
       return baseEntity;
    }
}
