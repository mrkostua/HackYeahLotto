package hackyeah.hackyeahlotto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Dateutils {

    static public String getFormattedDate(Long time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time);
    }
}
