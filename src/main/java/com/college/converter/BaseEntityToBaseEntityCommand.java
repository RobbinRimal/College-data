package com.college.converter;

import com.college.command.BaseEntityCommand;
import com.college.model.BaseEntity;
import org.springframework.core.convert.converter.Converter;

public class BaseEntityToBaseEntityCommand implements Converter<BaseEntity, BaseEntityCommand> {
    @Override
    public BaseEntityCommand convert(BaseEntity source) {
        if (source==null){return null;}
        BaseEntityCommand baseEntityCommand =new BaseEntityCommand();
        baseEntityCommand.setID(source.getID());
        return baseEntityCommand;
    }
}
