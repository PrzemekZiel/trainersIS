package parsers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatters {

    public LocalDateTime setDateFormatBase(String date) {
        String dateFormatBase = "YYYY-mm-DD HH:mm:ss";
        DateTimeFormatter dateTimeFormatterBase = DateTimeFormatter.ofPattern(dateFormatBase, Locale.ENGLISH);
        return LocalDateTime.parse(date, dateTimeFormatterBase);
    }

    public static DateTimeFormatter setDateFormatPage(LocalDateTime date) {
        String dateFormatPage = "yyyy-MM-dd HH:mm";
        return DateTimeFormatter.ofPattern(dateFormatPage, Locale.ENGLISH);
    }

    public static String displayDate() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(setDateFormatPage(now));
    }

}
