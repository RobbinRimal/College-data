package com.college.converter;

import com.college.command.BaseEntityCommand;
import com.college.model.BaseEntity;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BaseEntityToBaseEntityCommand implements Converter<BaseEntity, BaseEntityCommand> {
    @Override
    @Synchronized
    @Nullable
    public BaseEntityCommand convert(BaseEntity source) {
        if (source==null){return null;}
        BaseEntityCommand baseEntityCommand =new BaseEntityCommand();
        baseEntityCommand.setID(source.getID());
        return baseEntityCommand;
    }
}
