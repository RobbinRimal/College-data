package com.college.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectCommand extends BaseEntityCommand {
    private String SubjectName;
}
