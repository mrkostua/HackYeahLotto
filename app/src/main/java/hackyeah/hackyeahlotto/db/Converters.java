package hackyeah.hackyeahlotto.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}