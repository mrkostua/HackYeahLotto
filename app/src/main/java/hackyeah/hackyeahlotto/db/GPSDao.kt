package hackyeah.hackyeahlotto.db

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
@Dao
interface GPSDao {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    fun insertGPSRow(gpsDo: GPSDDo): Long

    @Transaction
    @Query("SELECT * FROM gps ORDER BY id DESC")
    fun getAllGPSData(): Flowable<List<GPSDDo>>



}