package hackyeah.hackyeahlotto.db;

import io.reactivex.Flowable
import io.reactivex.Single;

import javax.inject.Inject;

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */

class DbHelper @Inject
constructor(private val localDB: LocalDB) {
    fun addGPSData(gpsdDo: GPSDDo): Single<Long> = Single.fromCallable { localDB.gpsDao().insertGPSRow(gpsdDo) }

    fun getAllGPSData(): Flowable<List<GPSDDo>> = localDB.gpsDao().getAllGPSData().distinctUntilChanged()

}