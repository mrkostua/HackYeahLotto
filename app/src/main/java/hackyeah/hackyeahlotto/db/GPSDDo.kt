package hackyeah.hackyeahlotto.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
@Entity(tableName = "gps")
data class GPSDDo(
    @PrimaryKey(autoGenerate = true) var id: Int? = null, var latitutde: Double = 0.0,
    var longitude: Double = 0.0,
    var date: Date?)