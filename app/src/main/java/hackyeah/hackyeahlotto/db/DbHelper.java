package hackyeah.hackyeahlotto.db;

import javax.inject.Inject;

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
public class DbHelper {
    private LocalDB localDB;
    @Inject
   public DbHelper(LocalDB localDB){
        this.localDB = localDB;
    }
}
