package com.project.dasomapi.common.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    static public Integer DtToYear(LocalDate birthDt){
        if(birthDt==null){ return null; }
        LocalDate today = LocalDate.now();
        return Period.between(birthDt, today).getYears();
    }
}
