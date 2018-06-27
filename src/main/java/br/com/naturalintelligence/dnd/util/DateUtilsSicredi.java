package br.com.naturalintelligence.dnd.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "recuperacao.regua-cobranca.date-utils-sicredi")
@Component
public class DateUtilsSicredi {
    
    @Value("${date-pattern:dd/MM/yyyy}")
    private String datePattern;
    
    public Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public Date todayPlus(long days) {
        return toDate(LocalDate.now().plusDays(days));
    }
    
    public String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
        return formatter.format(date);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
    
    

}
